package com.example.final_project_javascript_group16;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.google.android.material.bottomnavigation.BottomNavigationView;


public class MainActivity extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationView = findViewById(R.id.bottom_navigation);

        // โหลดหน้า Home เป็นหน้าแรก
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new HomeFragment()).commit();

        // Handle navigation item clicks
        bottomNavigationView.setOnNavigationItemSelectedListener(item -> {
            Fragment selectedFragment = null;
            int id = item.getItemId();
            if (id == R.id.nav_home) selectedFragment = new HomeFragment();
            else if (id == R.id.nav_lesson) selectedFragment = new LessonFragment();
            else if (id == R.id.nav_quiz) selectedFragment = new QuizFragment();
            else if (id == R.id.nav_practice) selectedFragment = new PracticeFragment();
            else if (id == R.id.nav_team) selectedFragment = new TeamFragment();

            // ป้องกันการ โหลด Fragment เดิมซ้ำโดยไม่จำเป็น หากผู้ใช้กด Tab เดิมซ้ำๆ
            Fragment currentFragment = getSupportFragmentManager().findFragmentById(R.id.fragment_container);
            if (currentFragment == null || !currentFragment.getClass().equals(selectedFragment.getClass())) {
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragment_container, selectedFragment)
                        .commit();
            }

            return true;
        });
    }
    public void setBottomNavSelected(int itemId) {
        BottomNavigationView nav = findViewById(R.id.bottom_navigation);
        nav.setSelectedItemId(itemId);
    }
}