package com.example.ipz_final.ui.notifications;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

//barcharts
import com.example.ipz_final.R;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;

public class NotificationsFragment extends Fragment {

    BarChart barChartEko;
    BarChart barChartKm;
    BarData barDataEko;
    BarData barDataKm;
    BarDataSet barDataSetEko;
    BarDataSet barDataSetKm;
    ArrayList barEntriesRides;

    private NotificationsViewModel notificationsViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        notificationsViewModel =
                new ViewModelProvider(this).get(NotificationsViewModel.class);
        View root = inflater.inflate(R.layout.fragment_notifications, container, false);
        final TextView textView = root.findViewById(R.id.textView);
        /*
        notificationsViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        }
        );
        */

        //preparing data
        SetData();

        //barChart Kilometry
        barChartKm=root.findViewById(R.id.BarChart1);
        barDataSetKm = new BarDataSet(barEntriesRides, "labelkaKm");
        barDataKm = new BarData(barDataSetKm);
        barChartKm.setData(barDataKm);
        barDataSetKm.setColors(ColorTemplate.LIBERTY_COLORS);
        barDataSetKm.setValueTextColor(Color.BLACK);
        barDataSetKm.setValueTextSize(12f);

        //barChart Eko
        barChartEko=root.findViewById(R.id.BarChart2);
        barDataSetEko = new BarDataSet(barEntriesRides, "labelkaEko");
        barDataEko = new BarData(barDataSetEko);
        barChartEko.setData(barDataEko);
        barDataSetEko.setColors(ColorTemplate.PASTEL_COLORS);
        barDataSetEko.setValueTextColor(Color.BLACK);
        barDataSetEko.setValueTextSize(12f);

        return root;
    }

    private void SetData(){
        barEntriesRides = new ArrayList<>();
        barEntriesRides.add(new BarEntry(2f,0));
        barEntriesRides.add(new BarEntry(4f,1));
        barEntriesRides.add(new BarEntry(7f,2));
        barEntriesRides.add(new BarEntry(8f,3));

    }

}