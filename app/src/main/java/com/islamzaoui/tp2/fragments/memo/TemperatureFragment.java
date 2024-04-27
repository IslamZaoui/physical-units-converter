package com.islamzaoui.tp2.fragments.memo;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.islamzaoui.tp2.R;

import java.util.ArrayList;

public class TemperatureFragment extends Fragment {

    private ListView temperatureUnitsList;
    private ArrayList<String> temperatureUnits;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_display_memo, container, false);

        ((TextView) view.findViewById(R.id.title)).setText("Temperature Units");

        temperatureUnitsList = view.findViewById(R.id.UnitsList);
        temperatureUnits = new ArrayList<>();

        temperatureUnits.add("Celsius (°C)");
        temperatureUnits.add("Fahrenheit (°F)");
        temperatureUnits.add("Kelvin (K)");

        ArrayAdapter<String> adapter = new ArrayAdapter<>(requireContext(), android.R.layout.simple_list_item_1, temperatureUnits);
        temperatureUnitsList.setAdapter(adapter);

        return view;
    }
}
