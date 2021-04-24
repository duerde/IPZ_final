package com.example.ipz_final.ui.notifications;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import com.example.ipz_final.ui.home.HomeFragment;
import com.example.ipz_final.ui.dashboard.DashboardFragment;

//barcharts
import com.example.ipz_final.R;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;

public class NotificationsFragment<listakm> extends Fragment {

    BarChart barChartEko;
    BarChart barChartKm;
    BarData barDataEko;
    BarData barDataKm;
    BarDataSet barDataSetEko;
    BarDataSet barDataSetKm;
    ArrayList barEntriesRides;
    ArrayList barEntriesEko;




    private NotificationsViewModel notificationsViewModel;
    public DashboardFragment listakm;



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
        DashboardFragment df = new DashboardFragment();
        float zm1 = df.km1;
        float zm2 = df.km2;
        float zm3 = df.km3;
        float zm4 = df.km4;



        barEntriesRides.add(new BarEntry(1f,zm1));
        barEntriesRides.add(new BarEntry(2f,zm2));
        barEntriesRides.add(new BarEntry(3f,zm3));
        barEntriesRides.add(new BarEntry(4f,zm4));






    }


    private void SetDataEko(){
        barEntriesEko = new ArrayList<>();
        float emisja;

        //odwołanie do listy Karoliny
        DashboardFragment listakm;
        //odwołanie do listy Daniela
        HomeFragment paliwo;
        HomeFragment spalanie;   //czy w litrach/km ?


        //pętla z obliczeniami i dodawanie entries
        /*
        for(int i=0; i<4; i++){
            switch (paliwo) {
                case "Diesel":
                    emisja = spalanie * 2.6f * listakm[i];
                case "Gaz":
                    emisja = spalanie * 1.7f * listakm[i];
                case "Benzyna":
                    emisja = spalanie * 2.35f * listakm[i];
                case "Hybryda":
                    emisja = 0.142f * listakm[i];
                case "Elektyczny":
                    emisja = 0.033 * listakm[i];
            }
            barEntriesEko.add(new BarEntry(i+1, emisja));
*/
        }

    }

