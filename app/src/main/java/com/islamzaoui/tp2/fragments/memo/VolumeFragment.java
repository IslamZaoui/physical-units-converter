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

public class VolumeFragment extends Fragment {

    private ListView volumeUnitsList;
    private ArrayList<String> volumeUnits;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_display_memo, container, false);

        ((TextView) view.findViewById(R.id.title)).setText("Volume Units");

        volumeUnitsList = view.findViewById(R.id.UnitsList);
        volumeUnits = new ArrayList<>();

        volumeUnits.add("Liter (L) - Base SI unit");
        volumeUnits.add("Milliliter (mL) = 0.001 L");
        volumeUnits.add("Cubic meter (m³) = 1000 L");
        volumeUnits.add("Cubic centimeter (cm³) = 0.001 L");
        volumeUnits.add("Cubic inch (in³) = 0.016387 L");
        volumeUnits.add("Fluid ounce (fl oz) = 0.029574 L");
        volumeUnits.add("Cup (cup) = 0.24 L");
        volumeUnits.add("Pint (pt) = 0.473 L");
        volumeUnits.add("Quart (qt) = 0.946 L");
        volumeUnits.add("Gallon (gal) = 3.785 L");

        ArrayAdapter<String> adapter = new ArrayAdapter<>(requireContext(), android.R.layout.simple_list_item_1, volumeUnits);
        volumeUnitsList.setAdapter(adapter);

        return view;
    }
}
