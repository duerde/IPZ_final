package com.example.ipz_final.ui.dashboard;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.ipz_final.R;

import java.util.ArrayList;
import java.util.List;

public class DashboardFragment extends Fragment {
    EditText editTextNumber, editTextNumber2;
    TextView textView, textView2;
    String kwartal, km;
    //List listakm = new ArrayList(4);
    Float[] listakm = new Float[4];
    public static float km1=0;
    public static float km2=0;
    public static float km3=0;
    public static float km4=0;

    private DashboardViewModel dashboardViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        dashboardViewModel =
                new ViewModelProvider(this).get(DashboardViewModel.class);
        View root = inflater.inflate(R.layout.fragment_dashboard, container, false);
        final TextView textView = root.findViewById(R.id.textView);
        editTextNumber = root.findViewById(R.id.editTextNumber);
        editTextNumber2 = root.findViewById(R.id.editTextNumber2);
        dashboardViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }

        });

        final Button button = root.findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                kwartal = editTextNumber.getText().toString();
                km = editTextNumber2.getText().toString();
                float kmValue = Float.parseFloat(km);
                if(kwartal.equals("1")) {
                     km1+= kmValue;
                } else if (kwartal.equals("2")) {
                    km2 += kmValue;
                } else if (kwartal.equals("3")) {
                    km3 += kmValue;
                } else if (kwartal.equals("4")) {
                    km4 += kmValue;
                }
            }
        });

        return root;
    }



}