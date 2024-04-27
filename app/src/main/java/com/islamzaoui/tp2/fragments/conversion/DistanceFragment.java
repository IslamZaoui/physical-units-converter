package com.islamzaoui.tp2.fragments.conversion;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.islamzaoui.tp2.R;

public class DistanceFragment extends Fragment {
    private EditText inputValue;
    private Spinner inputUnitSpinner;
    private Spinner outputUnitSpinner;
    private TextView resultTextView;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_do_conversion, container, false);

        ((TextView) view.findViewById(R.id.ctitle)).setText("Convert Distance Value");

        inputValue = view.findViewById(R.id.inputValue);
        inputUnitSpinner = view.findViewById(R.id.inputUnitSpinner);
        outputUnitSpinner = view.findViewById(R.id.outputUnitSpinner);
        resultTextView = view.findViewById(R.id.resultTextView);


        ArrayAdapter<CharSequence> inputAdapter = ArrayAdapter.createFromResource(requireContext(),
                R.array.distance_units, android.R.layout.simple_spinner_item);
        inputAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        inputUnitSpinner.setAdapter(inputAdapter);


        ArrayAdapter<CharSequence> outputAdapter = ArrayAdapter.createFromResource(requireContext(),
                R.array.distance_units, android.R.layout.simple_spinner_item);
        outputAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        outputUnitSpinner.setAdapter(outputAdapter);


        view.findViewById(R.id.convertButton).setOnClickListener(v -> performConversion());

        return view;
    }

    private void performConversion() {

        String inputValueString = inputValue.getText().toString().trim();

        if (inputValueString.isEmpty()) {

            Toast.makeText(getContext(), "Please enter a value to convert.", Toast.LENGTH_SHORT).show();
            return;
        }

        double value;
        try {
            value = Double.parseDouble(inputValueString);
        } catch (NumberFormatException e) {

            Toast.makeText(getContext(), "Invalid input. Please enter a number.", Toast.LENGTH_SHORT).show();
            return;
        }

        String inputUnit = inputUnitSpinner.getSelectedItem().toString();
        String outputUnit = outputUnitSpinner.getSelectedItem().toString();
        double result = convertDistance(value, inputUnit, outputUnit);
        resultTextView.setText(String.format("%.2f %s", result, outputUnit));
    }


    private double convertDistance(double value, String inputUnit, String outputUnit) {

        double meters;
        switch (inputUnit) {
            case "Centimeter (cm)":
            case "Millimeter (mm)":
                meters = value / 100;
                break;
            case "Kilometer (km)":
                meters = value * 1000;
                break;
            case "Inch (in)":
                meters = value * 0.0254;
                break;
            case "Foot (ft)":
                meters = value * 0.3048;
                break;
            case "Yard (yd)":
                meters = value * 0.9144;
                break;
            case "Mile (mi)":
                meters = value * 1609.34;
                break;
            case "Nautical mile (nmi)":
                meters = value * 1852;
                break;
            case "Meter (m)":
            default:
                meters = value;
                break;
        }


        switch (outputUnit) {
            case "Centimeter (cm)":
            case "Millimeter (mm)":
                return meters * 100;
            case "Kilometer (km)":
                return meters / 1000;
            case "Inch (in)":
                return meters / 0.0254;
            case "Foot (ft)":
                return meters / 0.3048;
            case "Yard (yd)":
                return meters / 0.9144;
            case "Mile (mi)":
                return meters / 1609.34;
            case "Nautical mile (nmi)":
                return meters / 1852;
            case "Meter (m)":
            default:
                return meters;
        }
    }
}
