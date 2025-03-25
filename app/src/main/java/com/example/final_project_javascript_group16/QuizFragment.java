package com.example.final_project_javascript_group16;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.core.content.ContextCompat;
import androidx.core.content.res.ResourcesCompat;
import androidx.fragment.app.Fragment;


import java.util.concurrent.atomic.AtomicReference;

public class QuizFragment extends Fragment {
    private LinearLayout quizLayout;
    private String[] lessonTitles = LessonManager.TITLES;
    private TextView progressText;
    private ProgressBar progressBar;
    private SharedPreferences prefs;
    private Button resetButton;

    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_quiz, container, false);
        quizLayout = view.findViewById(R.id.quizLayout);

        resetButton = view.findViewById(R.id.reset_button);
        resetButton.setOnClickListener(v -> showResetConfirmation());

        progressText = view.findViewById(R.id.overall_progress_text);
        progressBar = view.findViewById(R.id.overall_progress_bar);

        prefs = requireContext().getSharedPreferences("quiz_scores", Context.MODE_PRIVATE);

        generateLessonCards();
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        checkAndShowToastOnReturn();
        reloadLessonCardsWithAnimation();
    }

    private void checkAndShowToastOnReturn() {
        prefs = requireContext().getSharedPreferences("quiz_scores", Context.MODE_PRIVATE);

        for (int lesson = 1; lesson <= 5; lesson++) {
            int highestScore = prefs.getInt("score_lesson_" + lesson, 0);
            boolean justFinished = prefs.getBoolean("just_finished_lesson_" + lesson, false);

            if (highestScore > 0 && justFinished) {
                showFeedbackForLesson(highestScore);
                markToastShown(lesson);

                // ✅ เคลียร์ flag การจบแบบทดสอบเพื่อไม่ให้แสดง toast ซ้ำ
                prefs.edit().putBoolean("just_finished_lesson_" + lesson, false).apply();
                break;
            }
        }
    }

    private void reloadLessonCardsWithAnimation() {
        if (quizLayout != null) quizLayout.removeAllViews();
        Context context = getContext();
        LayoutAnimationController controller = AnimationUtils.loadLayoutAnimation(context, R.anim.layout_animation_slide_up);
        quizLayout.setLayoutAnimation(controller);
        quizLayout.scheduleLayoutAnimation();
        generateLessonCards();
    }

    private void generateLessonCards() {
        Context context = getContext();
        int passedCount = 0;
        AtomicReference<SharedPreferences> prefs = new AtomicReference<>(context.getSharedPreferences("quiz_scores", Context.MODE_PRIVATE));

        for (int i = 1; i <= lessonTitles.length; i++) {
            int score = prefs.get().getInt("score_lesson_" + i, 0);
            if (score >= 5) passedCount++;
        }

        progressText.setText("ความคืบหน้า: " + passedCount + " / " + lessonTitles.length + " บท");
        progressBar.setProgress(passedCount);

        for (int i = 0; i < lessonTitles.length; i++) {
            int lessonNumber = i + 1;
            int score = prefs.get().getInt("score_lesson_" + lessonNumber, 0);
            TextView card = new TextView(context);
            card.setText(lessonTitles[i] + "\nคะแนน: " + score + "/10");
            card.setTextColor(ContextCompat.getColor(context, android.R.color.black));
            card.setTypeface(ResourcesCompat.getFont(context, R.font.sarabun_bold));
            card.setTextSize(18);
            card.setPadding(40, 50, 40, 50);
            card.setClickable(true);
            card.setFocusable(true);
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
            );
            params.setMargins(0, 0, 0, 32);
            card.setLayoutParams(params);

            boolean isLocked = isLessonLocked(lessonNumber);

            applyCardStyle(context, card, lessonNumber, score, isLocked);

            if (!isLocked) {
                int finalI = i;
                card.setOnClickListener(v -> {
                    // 🧼 เคลียร์ flag การแสดง toast ของบทนั้นก่อน
                    prefs.set(context.getSharedPreferences("quiz_scores", Context.MODE_PRIVATE));
                    prefs.get().edit().remove("toast_shown_lesson_" + lessonNumber).apply();

                    Intent intent = new Intent(getActivity(), QuizActivity.class);
                    intent.putExtra("lessonNumber", lessonNumber);
                    intent.putExtra("lessonName", lessonTitles[finalI].replace("บทที่ " + lessonNumber + ": ", ""));
                    startActivity(intent);
                });
            }

            quizLayout.addView(card);
        }
    }

    private void showResetConfirmation() {
        DialogUtil.showCustomDialog(
                getContext(),
                "รีเซ็ตข้อมูล",
                "คุณต้องการล้างคะแนนทั้งหมดใช่หรือไม่?",
                "ใช่",
                "ยกเลิก",
                R.color.red,
                android.R.color.black,
                () -> {
                    // โค้ดเมื่อกด "ใช่"
                    SharedPreferences prefs = getContext().getSharedPreferences("quiz_scores", Context.MODE_PRIVATE);
                    prefs.edit().clear().apply();
                    quizLayout.removeAllViews();
                    generateLessonCards();
                }
        );

    }

    private void markToastShown(int lesson) {
        SharedPreferences prefs = requireContext().getSharedPreferences("quiz_scores", Context.MODE_PRIVATE);
        prefs.edit().putBoolean("toast_shown_lesson_" + lesson, true).apply();
    }

    private void showFeedbackForLesson(int score) {
        if (score >= 8) {
            CustomToastUtil.show(
                    requireContext(),
                    requireActivity(),
                    "🎉 ยินดีด้วย! คุณทำได้ดีมาก\nระบบเปิดบทถัดไปให้แล้ว",
                    R.drawable.toast_background_sccess,
                    R.drawable.ic_check_circle,
                    R.raw.levelup,
                    "celebration2.json"
            );
        } else if (score >= 5) {
            CustomToastUtil.show(
                    requireContext(),
                    requireActivity(),
                    "😊 ผ่านแล้ว! ทำได้ไม่เลว\nระบบเปิดบทถัดไปให้แล้ว",
                    R.drawable.toast_background_medium,
                    R.drawable.ic_passed,
                    R.raw.correct_sound,
                    null
            );
        } else {
            CustomToastUtil.show(
                    requireContext(),
                    requireActivity(),
                    "😅 เกือบผ่านแล้ว! พยายามอีกนิดนึงนะ\nต้องได้ 5 คะแนนขึ้นไป\nถึงจะสามารถไปบทต่อไปได้ สู้ๆ!",
                    R.drawable.toast_background_fail,
                    R.drawable.ic_warning,
                    R.raw.cheerup,
                    "cheerup.json"
            );
        }
    }

    private boolean isLessonLocked(int lessonNumber) {
        return (lessonNumber > 1) && (prefs.getInt("score_lesson_" + (lessonNumber - 1), 0) < 5);
    }
    private void applyCardStyle(Context context,TextView card, int lessonNumber, int score, boolean isLocked) {
        if (lessonNumber == 1 && score == 0) {
            card.setBackground(ContextCompat.getDrawable(context, R.drawable.card_quiz_background));
        }else if (score >= 8) {
            card.setBackground(ContextCompat.getDrawable(context, R.drawable.card_quiz_pass_background));
            card.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ic_passed, 0);
        }else if (score >= 5) {
            card.setBackground(ContextCompat.getDrawable(context, R.drawable.card_quiz_medium_pass_background));
        }else if (isLocked) {
            card.setBackground(ContextCompat.getDrawable(context, R.drawable.card_quiz_locked_background));
            card.setAlpha(0.5f);
            card.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ic_locked, 0);
            card.setClickable(false);
        }else {
            card.setBackground(ContextCompat.getDrawable(context, R.drawable.card_quiz_background));
        }
    }
}
