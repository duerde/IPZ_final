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
import com.example.ipz_final.ui.home.HomeFragment;
import com.example.ipz_final.ui.dashboard.DashboardFragment;

//barcharts
import com.example.ipz_final.R;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;
import java.util.List;

public class NotificationsFragment extends Fragment {

    BarChart barChartEko;
    BarChart barChartKm;
    BarData barDataEko;
    BarData barDataKm;
    BarDataSet barDataSetEko;
    BarDataSet barDataSetKm;
    ArrayList barEntriesRides;
    ArrayList barEntriesEko;

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
        SetDataKm();
        SetDataEko();
        ArrayList<String> labels= new ArrayList<String>();
        labels.add("I");
        labels.add("II");
        labels.add("III");
        labels.add("IV");

        //barChart Kilometry
        barChartKm=root.findViewById(R.id.BarChart1);
        barDataSetKm = new BarDataSet(barEntriesRides, "labels");
        barDataKm = new BarData(barDataSetKm);
        barDataSetKm.setColors(ColorTemplate.COLORFUL_COLORS);
        barDataSetKm.setValueTextColor(Color.BLACK);
        barDataSetKm.setValueTextSize(12f);
        barDataKm = new BarData(barDataSetKm);
        barChartKm.setData(barDataKm);
        barChartKm.animateY(5000);

        //barChart Eko
        barChartEko=root.findViewById(R.id.BarChart2);
        barDataSetEko = new BarDataSet(barEntriesEko, "labels");
        barDataEko = new BarData(barDataSetEko);
        barDataSetEko.setColors(ColorTemplate.PASTEL_COLORS);
        barDataSetEko.setValueTextColor(Color.BLACK);
        barDataSetEko.setValueTextSize(12f);
        barChartEko.setData(barDataEko);
        barChartEko.animateY(5000);

        return root;
    }

    private void SetDataKm(){
        barEntriesRides = new ArrayList<>();
        barEntriesRides.add(new BarEntry(1,50));
        barEntriesRides.add(new BarEntry(2,100));
        barEntriesRides.add(new BarEntry(3,250));
        barEntriesRides.add(new BarEntry(4,30));
    }


    private void SetDataEko(){
        barEntriesEko = new ArrayList<>();
        float emisja;

        //odwołanie do listy Karoliny
        DashboardFragment listakm;
        //odwołanie do listy Daniela
        HomeFragment paliwo;
        HomeFragment spalanie;   //czy w litrach/km ?

        /*
        //pętla z obliczeniami i dodawanie entries
        for(int i=0; i<4; i++){
            switch (paliwo) {
                case "Diesel":
                    emisja = spalanie * 2.6 * listakm[i];
                case "Gaz":
                    emisja = spalanie * 1.7 * listakm[i];
                case "Benzyna":
                    emisja = spalanie * 2.35 * listakm[i];
                case "Hybryda":
                    emisja = 0.142 * listakm[i];
                case "Elektyczny":
                    emisja = 0.033 * listakm[i];
            }
            barEntriesEko.add(new BarEntry(i+1, emisja));
         */
        }

    }

