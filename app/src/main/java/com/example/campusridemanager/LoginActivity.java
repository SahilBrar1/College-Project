package com.example.campusridemanager;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class LoginActivity extends AppCompatActivity {

    Button studentLoginButton, facultyLoginButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        studentLoginButton = findViewById(R.id.studentLoginButton);
        facultyLoginButton = findViewById(R.id.facultyLoginButton);

        studentLoginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadFragment(new StudentLoginFragment(), 1);
            }
        });

        facultyLoginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadFragment(new FacultyLoginFragment(), 1);
            }
        });

        // Load student login fragment by default
        loadFragment(new StudentLoginFragment(), 0);
    }

    private void loadFragment(Fragment fragment, int flag) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction ft = fragmentManager.beginTransaction();
        if (flag == 0) {
            ft.add(R.id.fragment_container, fragment);
        } else {
            ft.replace(R.id.fragment_container, fragment);
        }
        ft.commit();
    }
}

