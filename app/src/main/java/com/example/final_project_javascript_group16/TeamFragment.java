package com.example.final_project_javascript_group16;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;


public class TeamFragment extends Fragment {

    private String[] teamMembers = {
            "หัวหน้ากลุ่ม | Developer,6506021611017,นาย จีรวัฒน์ ญานะ",
            "UX/UI Designer,6506021611076,นาย นฤนาท คามวารี",
            "จัดทำเอกสาร,6506021611068,นาย ธนพนธ์ แจ้งสนธิ์ ",
            "สีบค้นข้อมูล JavaScript,6506021621080,นาย ปรินทร สุทธิคุณ ",
    };

    private Integer[] teamPictures = {
            R.drawable.chrwyn_profile,
            R.drawable.supa,
            R.drawable.supa,
            R.drawable.supa
    };

    public TeamFragment () {}

    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_team, container, false);
        GridView grid_team;

        CustomAdapter adapter = new CustomAdapter(getContext(), teamMembers, teamPictures);
        grid_team = (GridView) view.findViewById(R.id.grid_team);
        grid_team.setAdapter(adapter);

        return view;
    }
}

class CustomAdapter extends ArrayAdapter<String> {
    TextView positionText, sidAndName_Team;
    ImageView imgTeam;
    private final Context context;
    private final String [] items;
    private final Integer [] logos;
    public CustomAdapter(Context ctx, String []items, Integer [] logos) {
        super(ctx,R.layout.grid_team, items);
        this.context = ctx;
        this.items = items;
        this.logos = logos;
    }
    @SuppressLint("MissingInflatedId")
    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.grid_team,null,true);
        positionText = rowView.findViewById(R.id.positionText_team);
        sidAndName_Team = rowView.findViewById(R.id.sidAndName_Team);
        imgTeam = rowView.findViewById(R.id.img_team);
        positionText.setText(items[position].split(",")[0] + "");
        sidAndName_Team.setText(items[position].split(",")[1] + "\n" + items[position].split(",")[2]);
        imgTeam.setImageResource(logos[position]);
        return rowView;
    }
}
