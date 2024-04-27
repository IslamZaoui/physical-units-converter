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

public class MassFragment extends Fragment {
    private EditText inputValue;
    private Spinner inputUnitSpinner;
    private Spinner outputUnitSpinner;
    private TextView resultTextView;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_do_conversion, container, false);

        ((TextView) view.findViewById(R.id.ctitle)).setText("Convert Mass Value");

        inputValue = view.findViewById(R.id.inputValue);
        inputUnitSpinner = view.findViewById(R.id.inputUnitSpinner);
        outputUnitSpinner = view.findViewById(R.id.outputUnitSpinner);
        resultTextView = view.findViewById(R.id.resultTextView);


        ArrayAdapter<CharSequence> inputAdapter = ArrayAdapter.createFromResource(requireContext(),
                R.array.mass_units, android.R.layout.simple_spinner_item);
        inputAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        inputUnitSpinner.setAdapter(inputAdapter);


        ArrayAdapter<CharSequence> outputAdapter = ArrayAdapter.createFromResource(requireContext(),
                R.array.mass_units, android.R.layout.simple_spinner_item);
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
        double result = convertMass(value, inputUnit, outputUnit);
        resultTextView.setText(String.format("%.2f %s", result, outputUnit));
    }

    private double convertMass(double value, String inputUnit, String outputUnit) {

        double kilograms;
        switch (inputUnit) {
            case "Gram (g)":
                kilograms = value / 1000;
                break;
            case "Milligram (mg)":
                kilograms = value / 1000000;
                break;
            case "Tonne (t)":
                kilograms = value * 1000;
                break;
            case "Pound (lb)":
                kilograms = value * 0.453592;
                break;
            case "Ounce (oz)":
                kilograms = value * 0.0283495;
                break;
            case "Kilogram (kg)":
            default:
                kilograms = value;
                break;
        }


        switch (outputUnit) {
            case "Gram (g)":
                return kilograms * 1000;
            case "Milligram (mg)":
                return kilograms * 1000000;
            case "Tonne (t)":
                return kilograms / 1000;
            case "Pound (lb)":
                return kilograms / 0.453592;
            case "Ounce (oz)":
                return kilograms / 0.0283495;
            case "Kilogram (kg)":
            default:
                return kilograms;
        }
    }
}
