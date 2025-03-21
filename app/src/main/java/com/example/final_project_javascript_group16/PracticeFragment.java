package com.example.final_project_javascript_group16;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class PracticeFragment extends Fragment {


    public PracticeFragment () {}


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_practice, container, false);
        EditText codeInput = view.findViewById(R.id.code_input);
        Button runButton = view.findViewById(R.id.run_code);
        TextView resultOutput = new TextView(getActivity()); // ปัจจุบันยังไม่สามารถรันโค้ดได้จริง

        runButton.setOnClickListener(v -> {
            String userCode = codeInput.getText().toString();
            resultOutput.setText("โค้ดของคุณ: " + userCode);
        });

        return view;
    }
}