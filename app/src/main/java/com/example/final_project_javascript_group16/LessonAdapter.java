package com.example.final_project_javascript_group16;

import android.content.Context;
import android.content.SharedPreferences;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;

public class LessonAdapter extends ArrayAdapter<String> {
    private Context context;
    private String[] titles;

    public LessonAdapter(Context context, String[] titles) {
        super(context, R.layout.list_item_lesson, titles);
        this.context = context;
        this.titles = titles;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, @NonNull ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.list_item_lesson, parent, false);
        }

        TextView title = convertView.findViewById(R.id.lesson_text);
        ImageView checkIcon = convertView.findViewById(R.id.check_icon);

        title.setText(titles[position]);

        SharedPreferences prefs = context.getSharedPreferences("lesson_progress", Context.MODE_PRIVATE);
        boolean isRead = prefs.getBoolean("lesson_read_" + position, false);

        if (isRead) {
            convertView.setBackground(ContextCompat.getDrawable(context, R.drawable.card_quiz_pass_background));
            checkIcon.setVisibility(View.VISIBLE);
        } else {
            convertView.setBackground(ContextCompat.getDrawable(context, R.drawable.card_quiz_background));
            checkIcon.setVisibility(View.GONE);
        }

        return convertView;
    }
}
