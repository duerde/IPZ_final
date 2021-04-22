package com.example.ipz_final.ui.home;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.NumberPicker;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.ipz_final.R;

import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HomeFragment extends Fragment {
    Context thiscontext;
    private HomeViewModel homeViewModel;
    ArrayList<String[ ] > samochodylista = new ArrayList<String[ ] >();
    private void SpinnerHeight(Spinner spinner) {
        try {
            Field popup = Spinner.class.getDeclaredField("mPopup");
            popup.setAccessible(true);

            // Get private mPopup member variable and try cast to ListPopupWindow
            android.widget.ListPopupWindow popupWindow = (android.widget.ListPopupWindow) popup.get(spinner);

            // Set popupWindow height to 140dp


            int altoSpinner = (int) getResources().getDimension(R.dimen.my_dimen);
            popupWindow.setHeight(altoSpinner);


        } catch (NoClassDefFoundError | ClassCastException | NoSuchFieldException | IllegalAccessException e) {
            // silently fail...
        }
    }
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);
        Spinner spinner = (Spinner) root.findViewById(R.id.spinner);

// Create an ArrayAdapter using the string array and a default spinner layout
        thiscontext = container.getContext();
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(thiscontext,
                R.array.paliwo, android.R.layout.simple_spinner_item);
// Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
// Apply the adapter to the spinner
        spinner.setAdapter(adapter);
        String[] arraySpinner = new String[] {
                "Abarth",
                "Alfa Romeo",
                "Aston Martin",
                "Audi",
                "Bentley",
                "BMW",
                "Bugatti",
                "Cadillac",
                "Chevrolet",
                "Chrysler",
                "Citroën",
                "Dacia",
                "Daewoo",
                "Daihatsu",
                "Dodge",
                "Donkervoort",
                "DS",
                "Ferrari",
                "Fiat",
                "Fisker",
                "Ford",
                "Honda",
                "Hummer",
                "Hyundai",
                "Infiniti",
                "Iveco",
                "Jaguar",
                "Jeep",
                "Kia",
                "KTM",
                "Lada",
                "Lamborghini",
                "Lancia",
                "Land Rover",
                "Landwind",
                "Lexus",
                "Lotus",
                "Maserati",
                "Maybach",
                "Mazda",
                "McLaren",
                "Mercedes-Benz",
                "MG",
                "Mini",
                "Mitsubishi",
                "Morgan",
                "Nissan",
                "Opel",
                "Peugeot",
                "Porsche",
                "Renault",
                "Rolls-Royce",
                "Rover",
                "Saab",
                "Seat",
                "Skoda",
                "Smart",
                "SsangYong",
                "Subaru",
                "Suzuki",
                "Tesla",
                "Toyota",
                "Volkswagen",
                "Volvo"
        };
        Spinner spinnermarki = (Spinner) root.findViewById(R.id.Spinner01);
        ArrayAdapter<String> adaptermarki = new ArrayAdapter<String>(thiscontext, android.R.layout.simple_spinner_item, arraySpinner);
        adaptermarki.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);


        spinnermarki.setAdapter(adaptermarki);
        SpinnerHeight(spinnermarki);

        final Button button = root.findViewById(R.id.button2);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String marka = (String) spinnermarki.getSelectedItem();
                EditText modeltext = root.findViewById(R.id.modeltext);
                String model = modeltext.getText().toString();
                String paliwo = (String) spinner.getSelectedItem();
                EditText rok = root.findViewById(R.id.picker_year);
                String year = rok.getText().toString();
                String dane[] = {marka,model,paliwo,year};
                samochodylista.add(dane);
                for (String i[] : samochodylista) {
                    System.out.println(Arrays.toString(i));
                }
            }
        });
        return root;
    }

}