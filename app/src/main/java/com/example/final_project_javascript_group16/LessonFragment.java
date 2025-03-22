package com.example.final_project_javascript_group16;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;


public class LessonFragment extends Fragment {

    private ListView lessonListView;

    private String[] lessonTitles = {
            "1. ชนิดข้อมูล (Data Types)",
            "2. ตัวแปร (Variables)",
            "3. ตัวดำเนินการ (Operators)",
            "4. คำสั่งควบคุม (Control Structures)",
            "5. ฟังก์ชัน (Functions)"
    };

    public LessonFragment() {}

    @Override
    public void onResume() {
        super.onResume();
        ListView lessonListView = requireView().findViewById(R.id.lesson_list);
        loadLesson(lessonListView); // โหลดใหม่ทุกครั้งที่กลับมาหน้านี้
        updateProgressUI();

        // 🌀 แสดงแอนิเมชัน
        Context context = getContext();
        LayoutAnimationController animation = AnimationUtils.loadLayoutAnimation(context, R.anim.layout_animation_slide_up);
        lessonListView.setLayoutAnimation(animation);
        lessonListView.scheduleLayoutAnimation();

        if (isAllLessonsCompleted() && !alreadyShownCompleteToast()) {
            CustomToastUtil.show(
                    requireContext(),
                    requireActivity(),
                    "🎉 ยินดีด้วย! คุณเรียนครบทุกบทแล้ว",
                    R.drawable.toast_background_sccess,
                    R.drawable.ic_check_circle,
                    R.raw.endall,
                    "celebration3.json"
            );
            markCompleteToastShown();
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_lesson, container, false);
        lessonListView = view.findViewById(R.id.lesson_list);

        loadLesson(lessonListView); // โหลดบทเรียนครั้งแรก

        lessonListView.setOnItemClickListener((parent, itemView, position, id) -> {
            SharedPreferences prefs = requireContext().getSharedPreferences("lesson_progress", Context.MODE_PRIVATE);
            prefs.edit()
                    .putBoolean("lesson_read_" + position, true)
                    .putBoolean("ref_lesson_" + (position + 1), true) // 👈 สำคัญ!
                    .apply();

            Intent intent = new Intent(getActivity(), LessonDetailActivity.class);
            intent.putExtra("lessonIndex", position);
            startActivity(intent);
        });

        return view;
    }

    private void loadLesson(ListView listView) {
        LessonAdapter adapter = new LessonAdapter(requireContext(), lessonTitles);
        listView.setAdapter(adapter);
    }

    private void updateProgressUI() {
        SharedPreferences prefs = requireContext().getSharedPreferences("lesson_progress", Context.MODE_PRIVATE);
        int total = lessonTitles.length;
        int readCount = 0;

        for (int i = 0; i < total; i++) {
            if (prefs.getBoolean("lesson_read_" + i, false)) {
                readCount++;
            }
        }

        TextView progressText = requireView().findViewById(R.id.overall_progress_text);
        ProgressBar progressBar = requireView().findViewById(R.id.overall_progress_bar);

        progressText.setText("ความคืบหน้า: " + readCount + " / " + total + " บท");
        progressBar.setProgress(readCount);
    }

    private boolean alreadyShownCompleteToast() {
        SharedPreferences prefs = requireContext().getSharedPreferences("lesson_progress", Context.MODE_PRIVATE);
        return prefs.getBoolean("all_lessons_complete_toast_shown", false);
    }

    private void markCompleteToastShown() {
        SharedPreferences prefs = requireContext().getSharedPreferences("lesson_progress", Context.MODE_PRIVATE);
        prefs.edit().putBoolean("all_lessons_complete_toast_shown", true).apply();
    }

    private boolean isAllLessonsCompleted() {
        SharedPreferences prefs = requireContext().getSharedPreferences("lesson_progress", Context.MODE_PRIVATE);
        return prefs.getBoolean("ref_lesson_1", false) &&
                prefs.getBoolean("ref_lesson_2", false) &&
                prefs.getBoolean("ref_lesson_3", false) &&
                prefs.getBoolean("ref_lesson_4", false) &&
                prefs.getBoolean("ref_lesson_5", false);
    }



}