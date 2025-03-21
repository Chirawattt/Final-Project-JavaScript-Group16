package com.example.final_project_javascript_group16;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;

import androidx.core.content.res.ResourcesCompat;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;


public class LessonFragment extends Fragment {

    private String[] lessonTitles = {
            "1. ชนิดข้อมูล (Data Types)",
            "2. ตัวแปร (Variables)",
            "3. ตัวดำเนินการ (Operators)",
            "4. คำสั่งควบคุม (Control Structures)",
            "5. ฟังก์ชัน (Functions)"
    };

    public LessonFragment() {}


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_lesson, container, false);
        ListView lessonListView = view.findViewById(R.id.lesson_list);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(getActivity(), R.layout.list_item_lesson, R.id.lesson_text, lessonTitles);
        lessonListView.setAdapter(adapter);

        lessonListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getActivity(), LessonDetailActivity.class);
                intent.putExtra("lessonIndex", position); // ส่ง index ของบทเรียนไป
                startActivity(intent);
            }
        });


        return view;
    }
}