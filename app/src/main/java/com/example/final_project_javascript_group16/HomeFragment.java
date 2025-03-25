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

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        // ปุ่มต่าง ๆ
        Button btnLesson = view.findViewById(R.id.btn_lesson);
        Button btnQuiz = view.findViewById(R.id.btn_quiz);
        Button btnPractice = view.findViewById(R.id.btn_practice);
        TextView tipText = view.findViewById(R.id.tip_text);

        // Progress Bar
        SharedPreferences lessonPrefs = requireContext().getSharedPreferences("lesson_progress", Context.MODE_PRIVATE);
        int lessonCount = 5;
        int lessonsCompleted = getLessonsCompleted(lessonPrefs, lessonCount);

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

        // ให้ bottomNavigation เปลี่ยนเมนูที่เลือกตามปุ่มที่อยู่ใน fragment
        // navigationBottomView อยู่ใน MainActivity จึงต้องให้ fragment เรียกใช้ผ่าน MainActivity ที่ถือ bottomNavigationView ไว้
        btnLesson.setOnClickListener(v -> {
            ((MainActivity) requireActivity()).setBottomNavSelected(R.id.nav_lesson);
            navigateTo(new LessonFragment());
        });
        btnQuiz.setOnClickListener(v -> {
            ((MainActivity) requireActivity()).setBottomNavSelected(R.id.nav_quiz);
            navigateTo(new QuizFragment());
        });
        btnPractice.setOnClickListener(v -> {
            ((MainActivity) requireActivity()).setBottomNavSelected(R.id.nav_practice);
            navigateTo(new PracticeFragment());
        });

        return view;
    }

    private void navigateTo(Fragment fragment) {
        requireActivity().getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment_container, fragment)
                .addToBackStack(null)
                .commit();
    }

    private int getLessonsCompleted(SharedPreferences prefs, int lessonCount) {
        int lessonsCompleted = 0;
        for (int i = 0; i < lessonCount; i++) {
            if (prefs.getBoolean("lesson_read_" + i, false)) {
                lessonsCompleted++;
            }
        }
        return lessonsCompleted;
    }

}