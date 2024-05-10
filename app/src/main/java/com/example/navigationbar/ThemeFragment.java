package com.example.navigationbar;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

public class ThemeFragment extends Fragment {
    private ImageButton btnTheme1;
    private ImageButton btnTheme2;
    private ImageButton btnTheme3;
    private ImageButton btnTheme4;
    private MainActivity mainActivity;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_theme, container, false);

        btnTheme1 = view.findViewById(R.id.btnTheme1);
        btnTheme2 = view.findViewById(R.id.btnTheme2);
        btnTheme3 = view.findViewById(R.id.btnTheme3);
        btnTheme4 = view.findViewById(R.id.btnTheme4);

        // Get a reference to MainActivity
        mainActivity = (MainActivity) getActivity();

        btnTheme1.setOnClickListener(v -> changeThemeColor(getResources().getColor(R.color.theme1colorPrimary)));
        btnTheme2.setOnClickListener(v -> changeThemeColor(getResources().getColor(R.color.theme2colorPrimary)));
        btnTheme3.setOnClickListener(v -> changeThemeColor(getResources().getColor(R.color.theme3colorPrimary)));
        btnTheme4.setOnClickListener(v -> changeThemeColor(getResources().getColor(R.color.theme4colorPrimary)));
        
        return view;
    }

    private void changeThemeColor(int color) {
        if (mainActivity != null) {
            mainActivity.setThemeColors(color);
        }
    }
}