package com.example.final_project_javascript_group16;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;


public class TeamFragment extends Fragment {

    private String[] teamMembers = {
            "[หัวหน้ากลุ่ม | Developer]\n  1. 6506021611017 นาย จีรวัฒน์ ญานะ",
            "[UI Designer]\n  2. 6506021611076 นาย นฤนาท คามวารี",
            "[จัดทำเอกสาร]\n  3. 6506021611068 นาย ธนพนธ์ แจ้งสนธิ์ ",
            "[สีบค้นข้อมูล JavaScript]\n  4. 6506021621080 นาย ปรินทร สุทธิคุณ ",
    };

    public TeamFragment () {}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_team, container, false);
        ListView teamListView = view.findViewById(R.id.team_list);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(getActivity(), R.layout.list_item_lesson, R.id.lesson_text, teamMembers);
        teamListView.setAdapter(adapter);

        return view;
    }
}