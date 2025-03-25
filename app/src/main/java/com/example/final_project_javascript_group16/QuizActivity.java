package com.example.final_project_javascript_group16;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

public class QuizActivity extends AppCompatActivity {

    private TextView questionText, questionNumberText, lessonTitleText;
    private RadioGroup optionGroup;
    private RadioButton optionA, optionB, optionC, optionD;
    private Button nextButton, btnPreviousQuestion;
    private ProgressBar progressBar;

    private List<Question> questions;
    private int currentIndex = 0;
    private int score = 0;
    private int lessonNumber;
    private String lessonName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        // รับข้อมูลจาก Intent
        lessonNumber = getIntent().getIntExtra("lessonNumber", 1);
        lessonName = getIntent().getStringExtra("lessonName");

        // ผูกกับ View
        questionText = findViewById(R.id.question_text);
        questionNumberText = findViewById(R.id.question_number);
        lessonTitleText = findViewById(R.id.lesson_title);
        optionGroup = findViewById(R.id.option_group);
        optionA = findViewById(R.id.option_a);
        optionB = findViewById(R.id.option_b);
        optionC = findViewById(R.id.option_c);
        optionD = findViewById(R.id.option_d);
        nextButton = findViewById(R.id.next_question_button);
        btnPreviousQuestion = findViewById(R.id.btn_previous_question);
        progressBar = findViewById(R.id.progress_bar);

        // ตั้งชื่อบท
        lessonTitleText.setText("บทที่ " + lessonNumber + ": " + lessonName);

        // โหลดคำถาม
        questions = QuestionBank.getQuestions(lessonNumber);

        // ตั้งค่าแรก
        showQuestion();

        // เมื่อเลือกตัวเลือก
        optionGroup.setOnCheckedChangeListener((group, checkedId) -> {
            nextButton.setVisibility(View.VISIBLE);
        });

        // เมื่อกดปุ่มถัดไป
        nextButton.setOnClickListener(v -> {
            checkAnswer();
            currentIndex++;

            if (currentIndex < questions.size()) {
                showQuestion();
            } else {
                showScore();
            }
        });

        btnPreviousQuestion.setOnClickListener(v -> {
            if (currentIndex > 0) {
                currentIndex--;
                showQuestion();
            } else {
                showConfirmationDialog();
            }
        });

    }

    private void showQuestion() {
        Question q = questions.get(currentIndex);

        questionText.setText(q.getQuestionText());
        String[] opts = q.getOptions();
        optionA.setText("A. " + opts[0]);
        optionB.setText("B. " + opts[1]);
        optionC.setText("C. " + opts[2]);
        optionD.setText("D. " + opts[3]);

        questionNumberText.setText("ข้อที่ " + (currentIndex + 1) + " / " + questions.size());
        progressBar.setProgress((int) (((currentIndex + 1.0) / questions.size()) * 100));

        optionGroup.clearCheck();
        nextButton.setVisibility(View.GONE);

        // Animation
        Animation fadeIn = AnimationUtils.loadAnimation(this, android.R.anim.fade_in);
        questionText.startAnimation(fadeIn);
        optionGroup.startAnimation(fadeIn);
    }

    private void checkAnswer() {
        int selectedIndex = -1;
        int checkedId = optionGroup.getCheckedRadioButtonId();

        if (checkedId == R.id.option_a) selectedIndex = 0;
        else if (checkedId == R.id.option_b) selectedIndex = 1;
        else if (checkedId == R.id.option_c) selectedIndex = 2;
        else if (checkedId == R.id.option_d) selectedIndex = 3;

        if (selectedIndex == questions.get(currentIndex).getCorrectIndex()) {
            score++;
        }
    }

    private void showScore() {
        SharedPreferences prefs = getSharedPreferences("quiz_scores", MODE_PRIVATE);
        int oldScore = prefs.getInt("score_lesson_" + lessonNumber, 0);
        if (score > oldScore) {
            prefs.edit().putInt("score_lesson_" + lessonNumber, score).apply();
        }
        prefs.edit().putBoolean("just_finished_lesson_" + lessonNumber, true).apply();
        showScoreDialog(score);
    }

    private void showConfirmationDialog() {
        DialogUtil.showCustomDialog(
                this,
                "ออกจากแบบทดสอบ",
                "คุณต้องการออกจากแบบทดสอบใช่หรือไม่?",
                "ใช่",
                "ยกเลิก",
                R.color.red,
                android.R.color.black,
                () -> {
                    // โค้ดเมื่อกด "ใช่"
                    finish();
                }
        );
    }
    private void showScoreDialog(int score) {
        DialogUtil.showCustomDialog(
                this,
                "คะแนนของคุณ",
                "คุณได้คะแนน " + score + " จาก " + questions.size(),
                "กลับไปยัง Quiz",
                null,
                R.color.green,
                android.R.color.black,
                () -> {
                    // โค้ดเมื่อกด "ใช่"
                    finish();
                }
        );
    }

}