package com.example.final_project_javascript_group16;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.Random;


public class HomeFragment extends Fragment {

    public HomeFragment() { }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        SharedPreferences prefs = getContext().getSharedPreferences("lesson_progress", Context.MODE_PRIVATE);
        prefs.edit().clear().apply(); // 🔁 เคลียร์ทุกบท
        prefs.edit().remove("all_lessons_complete_toast_shown").apply();

        // ปุ่มต่าง ๆ
        Button btnLesson = view.findViewById(R.id.btn_lesson);
        Button btnQuiz = view.findViewById(R.id.btn_quiz);
        Button btnPractice = view.findViewById(R.id.btn_practice);
        TextView tipText = view.findViewById(R.id.tip_text);

        // Progress Bar
        SharedPreferences lessonPrefs = requireContext().getSharedPreferences("lesson_progress", Context.MODE_PRIVATE);
        int lessonCount = 5;
        int lessonsCompleted = 0;

        for (int i = 0; i < lessonCount; i++) {
            if (lessonPrefs.getBoolean("lesson_read_" + i, false)) {
                lessonsCompleted++;
            }
        }

        TextView progressText = view.findViewById(R.id.overall_progress);
        ProgressBar progressBar = view.findViewById(R.id.overall_progress_bar);

        progressText.setText("ความคืบหน้า: " + lessonsCompleted + " / " + lessonCount + " บท");
        progressBar.setProgress((int)((lessonsCompleted / (float) lessonCount) * 100));


        // สุ่ม Tip
        String[] tips = {
                "💡 Tip: ใช้ const เมื่อค่าจะไม่เปลี่ยนแปลง",
                "💡 Tip: `===` จะเช็คทั้งค่าและชนิดข้อมูล!",
                "💡 Tip: Array เริ่มที่ index 0 เสมอ",
                "💡 Tip: ใช้ `let` แทน `var` เพื่อความปลอดภัย",
                "💡 Tip: undefined คือค่าที่ยังไม่ได้กำหนด"
        };
        int index = new Random().nextInt(tips.length);
        tipText.setText(tips[index]);

        // ปุ่มเริ่มเรียนบทเรียน
        btnLesson.setOnClickListener(v -> {
            requireActivity().getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragment_container, new LessonFragment())
                    .addToBackStack(null)
                    .commit();
        });

        // ปุ่มทำแบบทดสอบ
        btnQuiz.setOnClickListener(v -> {
            requireActivity().getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragment_container, new QuizFragment())
                    .addToBackStack(null)
                    .commit();
        });
        // ปุ่มฝึกเขียนโค้ด
        btnPractice.setOnClickListener(v -> {
            requireActivity().getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragment_container, new PracticeFragment())
                    .addToBackStack(null)
                    .commit();
        });

        return view;
    }
}