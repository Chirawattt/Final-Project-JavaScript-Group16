package com.example.final_project_javascript_group16;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;

import androidx.appcompat.app.AlertDialog;
import androidx.core.content.ContextCompat;
import androidx.core.content.res.ResourcesCompat;
import androidx.fragment.app.Fragment;

import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;


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
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

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
        // เคลียร์ layout เดิมก่อน
        if (quizLayout != null) {
            quizLayout.removeAllViews(); // ← สำคัญมาก!
        }

        Context context = getContext();
        LayoutAnimationController controller = AnimationUtils.loadLayoutAnimation(context, R.anim.layout_animation_slide_up);
        quizLayout.setLayoutAnimation(controller);
        quizLayout.scheduleLayoutAnimation();

        // แล้วค่อย generate ใหม่
        generateLessonCards();
    }

    private void generateLessonCards() {
        Context context = getContext();
        int passedCount = 0;
        SharedPreferences prefs = context.getSharedPreferences("quiz_scores", Context.MODE_PRIVATE);

        // นับจำนวนบทที่ผ่าน
        for (int i = 1; i <= lessonTitles.length; i++) {
            int score = prefs.getInt("score_lesson_" + i, 0);
            if (score >= 5) passedCount++;
        }

        // อัปเดต Progress bar และข้อความ
        progressText.setText("ความคืบหน้า: " + passedCount + " / " + lessonTitles.length + " บท");
        progressBar.setProgress(passedCount);

        for (int i = 0; i < lessonTitles.length; i++) {
            int lessonNumber = i + 1;
            int score = prefs.getInt("score_lesson_" + lessonNumber, 0);

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

            // ตรวจสอบว่าถูกล็อกหรือไม่
            boolean isLocked = false;
            if (lessonNumber > 1) {
                int prevScore = prefs.getInt("score_lesson_" + (lessonNumber - 1), 0);
                if (prevScore < 5) {
                    isLocked = true;
                }
            }

            if (lessonNumber == 1 && score == 0) {
                // ยังไม่เคยทำบทที่ 1 → ใช้สีเหลืองเริ่มต้น
                card.setBackground(ContextCompat.getDrawable(context, R.drawable.card_quiz_background));
                card.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
            } else if (score >= 8) {
                card.setBackground(ContextCompat.getDrawable(context, R.drawable.card_quiz_pass_background));
                card.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ic_passed, 0);
            } else if (score >= 5) {
                card.setBackground(ContextCompat.getDrawable(context, R.drawable.card_quiz_medium_pass_background));
                card.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
            } else if (lessonNumber > 1 && isLocked) {
                card.setBackground(ContextCompat.getDrawable(context, R.drawable.card_quiz_locked_background));
                card.setAlpha(0.5f);
                card.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ic_locked, 0);
                card.setClickable(false);
            } else {
                card.setBackground(ContextCompat.getDrawable(context, R.drawable.card_quiz_background));
                card.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
            }

            // เปิด quiz เฉพาะที่ไม่ถูกล็อก
            if (!isLocked) {
                int finalI = i;
                card.setOnClickListener(v -> {
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

                    // รีโหลดการ์ด
                    quizLayout.removeAllViews();
                    generateLessonCards();
                })
                .setNegativeButton("ยกเลิก", null)
                .show();
    }

}