package com.example.campusridemanager;

import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class FacultyLoginFragment extends Fragment {

    public FacultyLoginFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_faculty_login, container, false);
        Button faculty_login_button = view.findViewById(R.id.faculty_login_button);
        faculty_login_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent iLogin = new Intent(getActivity(), Faculty_Dashboard_Activity.class);
                startActivity(iLogin);
            }
        });
        return view;
    }
}
