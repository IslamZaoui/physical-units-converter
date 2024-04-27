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

public class PowerFragment extends Fragment {

    private ListView powerUnitsList;
    private ArrayList<String> powerUnits;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_display_memo, container, false);

        ((TextView) view.findViewById(R.id.title)).setText("Power Units");

        powerUnitsList = view.findViewById(R.id.UnitsList);
        powerUnits = new ArrayList<>();

        powerUnits.add("Watt (W) - Base SI unit");
        powerUnits.add("Kilowatt (kW) = 1000 W");
        powerUnits.add("Megawatt (MW) = 1,000,000 W");
        powerUnits.add("Gigawatt (GW) = 1,000,000,000 W");
        powerUnits.add("Milliwatt (mW) = 0.001 W");
        powerUnits.add("Horsepower (hp) = 745.7 W");
        powerUnits.add("Foot-pound per second (ft⋅lbf/s) = 1.356 W");
        powerUnits.add("BTU per hour (BTU/h) = 0.2928 W");

        ArrayAdapter<String> adapter = new ArrayAdapter<>(requireContext(), android.R.layout.simple_list_item_1, powerUnits);
        powerUnitsList.setAdapter(adapter);

        return view;
    }
}
