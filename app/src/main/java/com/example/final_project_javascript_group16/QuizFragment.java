package com.example.final_project_javascript_group16;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.core.content.ContextCompat;
import androidx.core.content.res.ResourcesCompat;
import androidx.fragment.app.Fragment;

import com.airbnb.lottie.LottieAnimationView;

import java.util.concurrent.atomic.AtomicReference;

public class QuizFragment extends Fragment {

    private LinearLayout quizLayout;
    private String[] lessonTitles = {
            "บทที่ 1: ชนิดข้อมูลใน JavaScript",
            "บทที่ 2: ตัวแปรใน JavaScript",
            "บทที่ 3: ตัวดำเนินการ",
            "บทที่ 4: คำสั่งควบคุม",
            "บทที่ 5: ฟังก์ชัน"
    };

    private TextView progressText;
    private ProgressBar progressBar;

    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_quiz, container, false);
        quizLayout = view.findViewById(R.id.quizLayout);

        Button resetButton = view.findViewById(R.id.reset_button);
        resetButton.setOnClickListener(v -> showResetConfirmation());

        progressText = view.findViewById(R.id.overall_progress_text);
        progressBar = view.findViewById(R.id.overall_progress_bar);

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
        SharedPreferences prefs = requireContext().getSharedPreferences("quiz_scores", Context.MODE_PRIVATE);

        for (int lesson = 1; lesson <= 5; lesson++) {
            int highestScore = prefs.getInt("score_lesson_" + lesson, 0);
            boolean justFinished = prefs.getBoolean("just_finished_lesson_" + lesson, false);

            if (highestScore > 0 && justFinished) {
                showFeedbackForLesson(lesson, highestScore);
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

            boolean isLocked = (lessonNumber > 1 && prefs.get().getInt("score_lesson_" + (lessonNumber - 1), 0) < 5);

            if (lessonNumber == 1 && score == 0) {
                card.setBackground(ContextCompat.getDrawable(context, R.drawable.card_quiz_background));
                card.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
            } else if (score >= 8) {
                card.setBackground(ContextCompat.getDrawable(context, R.drawable.card_quiz_pass_background));
                card.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ic_passed, 0);
            } else if (score >= 5) {
                card.setBackground(ContextCompat.getDrawable(context, R.drawable.card_quiz_medium_pass_background));
                card.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
            } else if (isLocked) {
                card.setBackground(ContextCompat.getDrawable(context, R.drawable.card_quiz_locked_background));
                card.setAlpha(0.5f);
                card.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ic_locked, 0);
                card.setClickable(false);
            } else {
                card.setBackground(ContextCompat.getDrawable(context, R.drawable.card_quiz_background));
                card.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
            }

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
        new AlertDialog.Builder(getContext())
                .setTitle("ยืนยันการรีเซต")
                .setMessage("คุณต้องการล้างคะแนนทั้งหมดใช่หรือไม่?")
                .setPositiveButton("ใช่", (dialog, which) -> {
                    SharedPreferences prefs = getContext().getSharedPreferences("quiz_scores", Context.MODE_PRIVATE);
                    prefs.edit().clear().apply();
                    quizLayout.removeAllViews();
                    generateLessonCards();
                })
                .setNegativeButton("ยกเลิก", null)
                .show();
    }

    private boolean alreadyShownToastForLesson(int lesson) {
        SharedPreferences prefs = requireContext().getSharedPreferences("quiz_scores", Context.MODE_PRIVATE);
        return prefs.getBoolean("toast_shown_lesson_" + lesson, false);
    }

    private void markToastShown(int lesson) {
        SharedPreferences prefs = requireContext().getSharedPreferences("quiz_scores", Context.MODE_PRIVATE);
        prefs.edit().putBoolean("toast_shown_lesson_" + lesson, true).apply();
    }

    private void showFeedbackForLesson(int lesson, int score) {
        if (score >= 8) {
            showCustomToast("🎉 ยินดีด้วย! คุณทำได้ดีมาก\nระบบเปิดบทถัดไปให้แล้ว",
                    R.drawable.toast_background_sccess, R.drawable.ic_check_circle, R.raw.levelup, "celebration2.json");
        } else if (score >= 5) {
            showCustomToast("😊 ผ่านแล้ว! ทำได้ไม่เลว\nระบบเปิดบทถัดไปให้แล้ว",
                    R.drawable.toast_background_medium, R.drawable.ic_passed, R.raw.correct_sound, null);
        } else {
            showCustomToast("😅 เกือบผ่านแล้ว! พยายามอีกนิดนึงนะ\nต้องได้ 5 คะแนนขึ้นไป\nถึงจะสามารถไปบทต่อไปได้ สู้ๆ!",
                    R.drawable.toast_background_fail, R.drawable.ic_warning, R.raw.cheerup, "cheerup.json");
        }
    }

    private void showCustomToast(String message, int backgroundRes, int iconRes, int soundRes, @Nullable String animationFile) {
        LayoutInflater inflater = getLayoutInflater();
        View layout = inflater.inflate(R.layout.custom_quiz_result_toast, null);
        LinearLayout container = layout.findViewById(R.id.toast_container);
        TextView text = layout.findViewById(R.id.toast_text);
        ImageView icon = layout.findViewById(R.id.toast_icon);

        container.setBackgroundResource(backgroundRes);
        text.setText(message);
        icon.setImageResource(iconRes);

        Toast toast = new Toast(requireContext());
        toast.setDuration(Toast.LENGTH_LONG);
        toast.setView(layout);
        toast.setGravity(Gravity.CENTER, 0, 0);
        toast.show();

        MediaPlayer mp = MediaPlayer.create(getContext(), soundRes);
        mp.start();

        if (animationFile != null) {
            LottieAnimationView anim = new LottieAnimationView(getContext());
            anim.setAnimation(animationFile);
            anim.loop(false);
            anim.playAnimation();

            FrameLayout root = (FrameLayout) requireActivity().getWindow().getDecorView().getRootView();
            FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(500, 500);

            if (animationFile.equals("cheerup.json")) {
                // แสดงกลางล่างจอ
                params.gravity = Gravity.BOTTOM | Gravity.CENTER_HORIZONTAL;
                params.bottomMargin = 100; // ขยับขึ้นนิดหน่อย
            } else {
                // แสดงกลางบนจอ
                params.gravity = Gravity.TOP | Gravity.CENTER_HORIZONTAL;
                params.topMargin = 100; // ขยับลงมาหน่อย
            }

            anim.setLayoutParams(params);
            root.addView(anim);

            new Handler().postDelayed(() -> root.removeView(anim), 3500);
        }

    }
}
