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

public class DistanceFragment extends Fragment {

    private ListView distanceUnitsList;
    private ArrayList<String> distanceUnits;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_display_memo, container, false);

        ((TextView) view.findViewById(R.id.title)).setText("Distance Units");

        distanceUnitsList = view.findViewById(R.id.UnitsList);
        distanceUnits = new ArrayList<>();

        distanceUnits.add("Meter (m) - Base SI unit");
        distanceUnits.add("Centimeter (cm) = 0.01 m");
        distanceUnits.add("Kilometer (km) = 1000 m");
        distanceUnits.add("Millimeter (mm) = 0.001 m");
        distanceUnits.add("Inch (in) = 0.0254 m");
        distanceUnits.add("Foot (ft) = 0.3048 m");
        distanceUnits.add("Yard (yd) = 0.9144 m");
        distanceUnits.add("Mile (mi) = 1609.34 m");
        distanceUnits.add("Nautical mile (nmi) = 1852 m");

        ArrayAdapter<String> adapter = new ArrayAdapter<>(requireContext(), android.R.layout.simple_list_item_1, distanceUnits);
        distanceUnitsList.setAdapter(adapter);

        return view;
    }
}
