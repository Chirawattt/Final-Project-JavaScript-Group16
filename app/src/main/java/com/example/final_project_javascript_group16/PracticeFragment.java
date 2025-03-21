package com.example.final_project_javascript_group16;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;


public class PracticeFragment extends Fragment {

    private TextView practiceTitle, practiceQuestion, codeOutput;
    private EditText codeInput;
    private WebView webView;
    private Button runButton, checkButton, showSolutionButton, resetButton, btnPrevLesson, btnNextLesson;
    private Button btnEasy, btnMedium, btnHard;
    private LinearLayout navigationButtons;

    private int lessonNumber = 1;
    private int difficultyLevel = 0; // 0 = ง่าย, 1 = ปานกลาง, 2 = ยาก

    private String expectedOutput = "";
    private PracticeQuestion currentQuestion;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_practice, container, false);

        // Binding views
        practiceTitle = view.findViewById(R.id.practice_title);
        practiceQuestion = view.findViewById(R.id.practice_question);
        codeInput = view.findViewById(R.id.practice_code_input);
        codeOutput = view.findViewById(R.id.practice_output);
        runButton = view.findViewById(R.id.btn_run_code);
        checkButton = view.findViewById(R.id.btn_check);
        showSolutionButton = view.findViewById(R.id.btn_show_solution);
        resetButton = view.findViewById(R.id.btn_reset_practice);
        webView = view.findViewById(R.id.webview_runner);

        btnEasy = view.findViewById(R.id.btn_easy);
        btnMedium = view.findViewById(R.id.btn_medium);
        btnHard = view.findViewById(R.id.btn_hard);

        btnPrevLesson = view.findViewById(R.id.btn_prev_lesson);
        btnNextLesson = view.findViewById(R.id.btn_next_lesson);
        navigationButtons = view.findViewById(R.id.navigation_buttons);

        setupWebView();
        loadPracticeQuestion();
        updateDifficultyIcons(btnEasy, btnMedium, btnHard);
        highlightSelectedDifficulty(btnEasy, btnMedium, btnHard);

        // Difficulty button listeners
        btnEasy.setOnClickListener(v -> {
            difficultyLevel = 0;
            highlightSelectedDifficulty(btnEasy, btnMedium, btnHard);
            loadPracticeQuestion();
            updateDifficultyIcons(btnEasy, btnMedium, btnHard);
        });

        btnMedium.setOnClickListener(v -> {
            difficultyLevel = 1;
            highlightSelectedDifficulty(btnMedium, btnEasy, btnHard);
            loadPracticeQuestion();
            updateDifficultyIcons(btnEasy, btnMedium, btnHard);
        });

        btnHard.setOnClickListener(v -> {
            difficultyLevel = 2;
            highlightSelectedDifficulty(btnHard, btnEasy, btnMedium);
            loadPracticeQuestion();
            updateDifficultyIcons(btnEasy, btnMedium, btnHard);
        });

        // Run code
        runButton.setOnClickListener(v -> runCode());

        // Check answer
        checkButton.setOnClickListener(v -> checkAnswer());

        // Show solution button
        showSolutionButton.setOnClickListener(v -> {
            if (currentQuestion != null) {
                new AlertDialog.Builder(getContext())
                        .setTitle("💡 เฉลย")
                        .setMessage(currentQuestion.getSolutionHint())
                        .setPositiveButton("เข้าใจแล้ว", null)
                        .show();
            }
        });

        // Reset progress button
        resetButton.setOnClickListener(v -> {
            new AlertDialog.Builder(getContext())
                    .setTitle("รีเซ็ตความคืบหน้า")
                    .setMessage("คุณแน่ใจหรือไม่ว่าต้องการล้างความคืบหน้าในโหมดฝึกฝนทั้งหมด?")
                    .setPositiveButton("ตกลง", (dialog, which) -> resetPracticeProgress())
                    .setNegativeButton("ยกเลิก", null)
                    .show();
        });

        btnPrevLesson.setOnClickListener(v -> {
            if (lessonNumber > 1) {
                lessonNumber--;
                difficultyLevel = 0;
                loadPracticeQuestion();
                highlightSelectedDifficulty(btnEasy, btnMedium, btnHard);
                updateDifficultyIcons(btnEasy, btnMedium, btnHard);
            }
        });

        btnNextLesson.setOnClickListener(v -> {
            if (lessonNumber < 5) { // กำหนดไว้ 5 บท
                lessonNumber++;
                difficultyLevel = 0;
                loadPracticeQuestion();
                highlightSelectedDifficulty(btnEasy, btnMedium, btnHard);
                updateDifficultyIcons(btnEasy, btnMedium, btnHard);
            }
        });

        return view;
    }

    private void setupWebView() {
        webView.getSettings().setJavaScriptEnabled(true);
        webView.setWebChromeClient(new WebChromeClient());
        webView.loadDataWithBaseURL(null, "<html><body></body></html>", "text/html", "UTF-8", null);
    }

    private void loadPracticeQuestion() {
        currentQuestion = PracticeBank.getQuestion(lessonNumber, difficultyLevel);
        if (currentQuestion != null) {
            practiceTitle.setText("บทที่ " + lessonNumber + " (ระดับ: " + getDifficultyName(difficultyLevel) + ")");
            practiceQuestion.setText(currentQuestion.getQuestionText());
            expectedOutput = currentQuestion.getExpectedOutput();

            codeInput.setText("");
            codeOutput.setText("");
            codeOutput.setTextColor(Color.WHITE);
            showSolutionButton.setVisibility(View.GONE);

            SharedPreferences prefs = requireContext().getSharedPreferences("PracticeProgress", Context.MODE_PRIVATE);
            String key = "practice_passed_lesson_" + lessonNumber + "_level_" + difficultyLevel;
            boolean isPassed = prefs.getBoolean(key, false);
            if (isPassed) {
                codeOutput.setText("✅ ข้อนี้คุณเคยผ่านแล้ว!");
                codeOutput.setTextColor(Color.GREEN);
            }
        }
        // check ปุ่มบทถัดไป
        if (isLessonCompleted(lessonNumber)) {
            navigationButtons.setVisibility(View.VISIBLE);
        } else {
            navigationButtons.setVisibility(View.GONE);
        }
    }

    private void runCode() {
        String userCode = codeInput.getText().toString();
        String jsCode = "(function() {" + userCode + "})()";

        webView.evaluateJavascript(jsCode, value -> {
            String output = value.replaceAll("^\"|\"$", "");
            codeOutput.setText(output);
        });
    }

    private void checkAnswer() {
        String userCode = codeInput.getText().toString().trim();
        // ตรวจว่ามี return หรือไม่
        if (!userCode.contains("return")) {
            Toast.makeText(getContext(), "ควรใส่คำสั่งในการ return ค่าเข้าไปด้วย", Toast.LENGTH_SHORT).show();
        }
        String jsCode = "(function() {\n" + userCode + "\n})()";

        webView.evaluateJavascript(jsCode, value -> {
            String output = value.replaceAll("^\"|\"$", "");
            codeOutput.setText(output);

            if (output.equals(expectedOutput)) {
                Toast.makeText(getContext(), "✅ คำตอบถูกต้อง!", Toast.LENGTH_SHORT).show();
                showSolutionButton.setVisibility(View.GONE);

                SharedPreferences prefs = requireContext().getSharedPreferences("PracticeProgress", Context.MODE_PRIVATE);
                String key = "practice_passed_lesson_" + lessonNumber + "_level_" + difficultyLevel;
                prefs.edit().putBoolean(key, true).apply();
                updateDifficultyIcons(btnEasy, btnMedium, btnHard);

                // เพิ่มระดับอัตโนมัติ (ถ้ายังไม่ถึงยากสุด)
                if (difficultyLevel < 2) {
                    // ✅ ไปยังระดับถัดไป
                    difficultyLevel++;
                    highlightSelectedDifficulty(getButtonForLevel(difficultyLevel), btnEasy, btnMedium, btnHard);
                    loadPracticeQuestion();
                } else {
                    // ✅ ทำครบ 3 ระดับแล้ว
                    if (isLessonCompleted(lessonNumber)) {
                        if (lessonNumber < 5) {
                            Toast.makeText(getContext(), "🎉 ทำครบทั้งบทแล้ว! ไปบทถัดไป!", Toast.LENGTH_SHORT).show();
                            lessonNumber++;
                            difficultyLevel = 0;
                            highlightSelectedDifficulty(btnEasy, btnMedium, btnHard);
                            loadPracticeQuestion();
                            updateDifficultyIcons(btnEasy, btnMedium, btnHard);
                        } else {
                            Toast.makeText(getContext(), "🎉 ทำครบทุกบทแล้ว! เก่งมาก!", Toast.LENGTH_LONG).show();
                        }
                    }
                }
            } else {
                Toast.makeText(getContext(), "❌ คำตอบไม่ถูกต้อง", Toast.LENGTH_SHORT).show();
                showSolutionButton.setVisibility(View.VISIBLE);
            }
        });

    }

    private void highlightSelectedDifficulty(Button selected, Button... others) {
        selected.setBackgroundTintList(ContextCompat.getColorStateList(getContext(), R.color.js_yellow_dark));
        selected.setTextColor(ContextCompat.getColor(getContext(), android.R.color.black));

        for (Button other : others) {
            other.setBackgroundTintList(ContextCompat.getColorStateList(getContext(), R.color.js_yellow));
            other.setTextColor(ContextCompat.getColor(getContext(), android.R.color.black));
        }
    }

    private void updateDifficultyIcons(Button btnEasy, Button btnMedium, Button btnHard) {
        if (isPassed(lessonNumber, 0)) {
            btnEasy.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ic_check_circle, 0);
        } else {
            btnEasy.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
        }

        if (isPassed(lessonNumber, 1)) {
            btnMedium.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ic_check_circle, 0);
        } else {
            btnMedium.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
        }

        if (isPassed(lessonNumber, 2)) {
            btnHard.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ic_check_circle, 0);
        } else {
            btnHard.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
        }
    }

    private boolean isPassed(int lesson, int level) {
        SharedPreferences prefs = requireContext().getSharedPreferences("PracticeProgress", Context.MODE_PRIVATE);
        String key = "practice_passed_lesson_" + lesson + "_level_" + level;
        return prefs.getBoolean(key, false);
    }

    private boolean isLessonCompleted(int lesson) {
        return isPassed(lesson, 0) && isPassed(lesson, 1) && isPassed(lesson, 2);
    }

    private void resetPracticeProgress() {
        SharedPreferences prefs = requireContext().getSharedPreferences("PracticeProgress", Context.MODE_PRIVATE);
        prefs.edit().clear().apply();
        Toast.makeText(getContext(), "✅ ล้างความคืบหน้าเรียบร้อยแล้ว", Toast.LENGTH_SHORT).show();
        loadPracticeQuestion();
        updateDifficultyIcons(btnEasy, btnMedium, btnHard);
        lessonNumber = 1;
    }

    private String getDifficultyName(int level) {
        switch (level) {
            case 0: return "ง่าย";
            case 1: return "ปานกลาง";
            case 2: return "ยาก";
            default: return "ไม่ทราบ";
        }
    }

    private Button getButtonForLevel(int level) {
        switch (level) {
            case 0: return btnEasy;
            case 1: return btnMedium;
            case 2: return btnHard;
            default: return btnEasy;
        }
    }

}