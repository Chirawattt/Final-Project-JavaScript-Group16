package com.example.final_project_javascript_group16;

import android.content.Intent;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;


public class LessonDetailActivity extends AppCompatActivity implements View.OnClickListener {

    // ข้อมูลของแต่ละบทเรียน
    private TextView lessonTitle, lessonIntro, lessonContent, codeOutput;
    private EditText codeInput;
    private Button runButton, prevButton, nextButton, backToMainButton;
    private LinearLayout exampleCodeButtons;
    private int currentLesson = 0;
    private final int lessonLength = LessonData.getLessonDataSize();

    private int selectedExampleIndex = -1; // เก็บ index ของตัวอย่างที่เลือก

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson_detail);

        // เชื่อมโยง UI
        lessonTitle = findViewById(R.id.lesson_title);
        lessonIntro = findViewById(R.id.lesson_intro);
        lessonContent = findViewById(R.id.lesson_content);
        exampleCodeButtons = findViewById(R.id.example_code_buttons);
        codeInput = findViewById(R.id.code_input);
        codeOutput = findViewById(R.id.code_output);
        runButton = findViewById(R.id.run_button);
        runButton.setOnClickListener(this);
        prevButton = findViewById(R.id.prev_button);
        prevButton.setOnClickListener(this);
        nextButton = findViewById(R.id.next_button);
        nextButton.setOnClickListener(this);
        backToMainButton = findViewById(R.id.back_to_main);
        backToMainButton.setOnClickListener(this);

        Intent i = getIntent();
        currentLesson = (i.getIntExtra("lessonIndex", 1) + 1);

        // โหลดข้อมูลบทเรียน
        updateLesson(currentLesson);


    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        if (id == R.id.run_button) {
            runMockCode();
        } else if (id == R.id.prev_button) {
            if (currentLesson > 1) {
                currentLesson--;
                updateLesson(currentLesson);
            }
        } else if (id == R.id.next_button) {
            if (currentLesson < lessonLength) {
                currentLesson++;
                updateLesson(currentLesson);
            }
        } else if (id == R.id.back_to_main) {
            Intent i = new Intent(LessonDetailActivity.this, MainActivity.class);
            startActivity(i);
            finish();
        }
    }

    // อัปเดตข้อมูลบทเรียนปัจจุบัน
    private void updateLesson(int lessonNumber) {
        String[] data = LessonData.getLessonData(lessonNumber);
        if (data != null) {
            lessonTitle.setText(Html.fromHtml(data[0]));
            lessonIntro.setText(Html.fromHtml(data[1]));
            lessonContent.setText(Html.fromHtml(data[2]));

            // ลบปุ่มตัวอย่างโค้ดเก่า
            exampleCodeButtons.removeAllViews();

            // รีเซ็ต code_input และ code_output
            codeInput.setText("");
            codeOutput.setText("");

            // รีเซ็ตตัวเลือกตัวอย่างโค้ด
            selectedExampleIndex = -1;

            // ดึงตัวอย่างโค้ดจาก LessonData
            String[] exampleCodes = LessonData.getLessonExamples(lessonNumber);

            // สร้างปุ่มตัวอย่างโค้ดใหม่
            if (exampleCodes != null) {
                for (int i = 0; i < exampleCodes.length; i++) {
                    Button exampleButton = new Button(this);
                    exampleButton.setText("ตัวอย่างที่ " + (i + 1));
                    // ตั้งค่าฟอนต์, ระยะห่าง, และขอบมน
                    exampleButton.setTypeface(getResources().getFont(R.font.sarabun_bold));
                    LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                            LinearLayout.LayoutParams.WRAP_CONTENT,
                            LinearLayout.LayoutParams.WRAP_CONTENT);
                    params.setMargins(10, 5, 10, 5); // ระยะห่างระหว่างปุ่ม
                    exampleButton.setLayoutParams(params);

                    // กำหนด background เป็นสีเหลืองและขอบมน
                    GradientDrawable shape = new GradientDrawable();
                    shape.setCornerRadius(30); // ทำให้ปุ่มโค้งมน
                    shape.setColor(getResources().getColor(R.color.js_yellow));
                    exampleButton.setBackground(shape);
                    exampleButton.setTextColor(getResources().getColor(R.color.black));

                    final int index = i;
                    exampleButton.setOnClickListener(v -> {
                        codeInput.setText(Html.fromHtml(exampleCodes[index])); // ใส่โค้ดในช่อง Input
                        selectedExampleIndex = index; // บันทึกตัวอย่างที่เลือก
                    });

                    exampleCodeButtons.addView(exampleButton);
                }
            }

            // **เลื่อน ScrollView ไปด้านบนสุด**
            ScrollView lessonScrollView = findViewById(R.id.lesson_scroll_view);
            lessonScrollView.post(() -> lessonScrollView.scrollTo(0, 0));

            // **ควบคุมการแสดงผลของปุ่ม Next และ Prev**
            Button prevButton = findViewById(R.id.prev_button);
            Button nextButton = findViewById(R.id.next_button);

            if (lessonNumber == 1) {
                prevButton.setVisibility(View.GONE);  // ซ่อนปุ่ม Previous
                nextButton.setVisibility(View.VISIBLE);  // แสดงปุ่ม Next
            } else if (lessonNumber == lessonLength) {
                prevButton.setVisibility(View.VISIBLE);  // แสดงปุ่ม Previous
                nextButton.setVisibility(View.GONE);  // ซ่อนปุ่ม Next
            } else {
                prevButton.setVisibility(View.VISIBLE);
                nextButton.setVisibility(View.VISIBLE);
            }
        }
    }

    // Mockup Output ตามตัวอย่างที่เลือก
    private void runMockCode() {
        String[] exampleOutputs =  LessonData.getLessonOutputs(currentLesson);
        if (selectedExampleIndex != -1 && exampleOutputs != null) {
            codeOutput.setText(exampleOutputs[selectedExampleIndex]);
        } else {
            codeOutput.setText("⚠️ กรุณาเลือกตัวอย่างโค้ดก่อนรัน");
        }
    }

}