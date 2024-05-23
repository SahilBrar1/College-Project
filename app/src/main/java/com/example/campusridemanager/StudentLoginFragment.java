package com.example.campusridemanager;

import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class StudentLoginFragment extends Fragment {

    public StudentLoginFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_student_login, container, false);

        Button student_login_button = view.findViewById(R.id.student_login_button);
        student_login_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent iNext = new Intent(getActivity(),  Student_Dashboard_Activity.class);
                startActivity(iNext);
            }
        });

        TextView forgot_password = view.findViewById(R.id.forgot_password);
        forgot_password.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent iforgot = new Intent(getActivity(), forgot_password.class);
                startActivity(iforgot);
            }
        });
        TextView new_registeration = view.findViewById(R.id.new_registeration);
        new_registeration.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent iRegister = new Intent(getActivity(), RegistrationActivity.class);
                startActivity(iRegister);
            }
        });
        return view;
    }
}
