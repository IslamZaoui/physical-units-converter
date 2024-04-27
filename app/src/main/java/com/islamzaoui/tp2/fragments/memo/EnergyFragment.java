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

public class EnergyFragment extends Fragment {

    private ListView energyUnitsList;
    private ArrayList<String> energyUnits;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_display_memo, container, false);

        ((TextView) view.findViewById(R.id.title)).setText("Energy Units");

        energyUnitsList = view.findViewById(R.id.UnitsList);
        energyUnits = new ArrayList<>();

        energyUnits.add("Joule (J) - Base SI unit");
        energyUnits.add("Kilojoule (kJ) = 1000 J");
        energyUnits.add("Calorie (cal) = 4.184 J");
        energyUnits.add("Kilocalorie (kcal) = 4184 J");
        energyUnits.add("Watt-hour (Wh) = 3600 J");
        energyUnits.add("Kilowatt-hour (kWh) = 3,600,000 J");
        energyUnits.add("British thermal unit (BTU) = 1055.06 J");
        energyUnits.add("Foot-pound (ft⋅lbf) = 1.356 J");

        ArrayAdapter<String> adapter = new ArrayAdapter<>(requireContext(), android.R.layout.simple_list_item_1, energyUnits);
        energyUnitsList.setAdapter(adapter);

        return view;
    }
}
