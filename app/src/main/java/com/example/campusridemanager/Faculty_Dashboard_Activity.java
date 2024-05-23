package com.example.campusridemanager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;


public class Faculty_Dashboard_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_faculty_dashboard);
        EditText editText = findViewById(R.id.editText);
        Button button = findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Perform empty validation on EditText
                String text = editText.getText().toString().trim();
                if (text.isEmpty()) {
                    editText.setError("Please enter text");
                } else {
                    Intent intent = new Intent(Faculty_Dashboard_Activity.this, FacultyResultActivity.class);
                    intent.putExtra("text", text);
                    startActivity(intent);
                }
            }
        });
    }
}