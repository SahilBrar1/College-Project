package com.example.campusridemanager;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class RegistrationActivity extends AppCompatActivity {
    private EditText nameEditText, hostelEditText, vehicleNumberEditText, hologramNumberEditText, passwordEditText;
    private Button registerButton;
    private DatabaseHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        nameEditText = findViewById(R.id.name_edit_text);
        hostelEditText = findViewById(R.id.hostel_edit_text);
        vehicleNumberEditText = findViewById(R.id.vehicle_number_edit_text);
        hologramNumberEditText = findViewById(R.id.hologram_number_edit_text);
        passwordEditText = findViewById(R.id.password_edit_text);
        registerButton = findViewById(R.id.register_button);

        dbHelper = new DatabaseHelper(this);

        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = nameEditText.getText().toString();
                String hostel = hostelEditText.getText().toString();
                String vehicleNumber = vehicleNumberEditText.getText().toString();
                String hologramNumber = hologramNumberEditText.getText().toString();
                String password = passwordEditText.getText().toString();

                Student student = new Student(name, hostel, vehicleNumber, hologramNumber, password);
                dbHelper.addStudent(student);

                Toast.makeText(RegistrationActivity.this, "Registration successful", Toast.LENGTH_SHORT).show();
                finish();
            }
        });
    }
}
