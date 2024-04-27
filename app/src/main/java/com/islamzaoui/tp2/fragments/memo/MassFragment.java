package com.islamzaoui.tp2.fragments.memo;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.islamzaoui.tp2.R;

import java.util.ArrayList;

public class MassFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_display_memo, container, false);

        ((TextView) view.findViewById(R.id.title)).setText("Mass Units");

        ListView massUnitsList = view.findViewById(R.id.UnitsList);
        ArrayList<String> massUnits = new ArrayList<>();

        massUnits.add("Kilogram (kg) - Base SI unit");
        massUnits.add("Gram (g) = 0.001 kg");
        massUnits.add("Milligram (mg) = 0.000001 kg");
        massUnits.add("Tonne (t) = 1000 kg");
        massUnits.add("Pound (lb) = 0.453592 kg");
        massUnits.add("Ounce (oz) = 0.0283495 kg");

        ArrayAdapter<String> adapter = new ArrayAdapter<>(requireContext(), android.R.layout.simple_list_item_1, massUnits);
        massUnitsList.setAdapter(adapter);

        return view;
    }
}
