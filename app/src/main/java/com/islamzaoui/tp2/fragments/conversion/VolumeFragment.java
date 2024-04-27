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

public class VolumeFragment extends Fragment {
    private EditText inputValue;
    private Spinner inputUnitSpinner;
    private Spinner outputUnitSpinner;
    private TextView resultTextView;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_do_conversion, container, false);

        ((TextView) view.findViewById(R.id.ctitle)).setText("Convert Volume Value");

        inputValue = view.findViewById(R.id.inputValue);
        inputUnitSpinner = view.findViewById(R.id.inputUnitSpinner);
        outputUnitSpinner = view.findViewById(R.id.outputUnitSpinner);
        resultTextView = view.findViewById(R.id.resultTextView);


        ArrayAdapter<CharSequence> inputAdapter = ArrayAdapter.createFromResource(requireContext(),
                R.array.volume_units, android.R.layout.simple_spinner_item);
        inputAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        inputUnitSpinner.setAdapter(inputAdapter);


        ArrayAdapter<CharSequence> outputAdapter = ArrayAdapter.createFromResource(requireContext(),
                R.array.volume_units, android.R.layout.simple_spinner_item);
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
        double result = convertVolume(value, inputUnit, outputUnit);
        resultTextView.setText(String.format("%.2f %s", result, outputUnit));
    }

    private double convertVolume(double value, String inputUnit, String outputUnit) {

        double liters;
        switch (inputUnit) {
            case "Milliliter (mL)":
            case "Cubic centimeter (cm³)":
                liters = value / 1000;
                break;
            case "Cubic meter (m³)":
                liters = value * 1000;
                break;
            case "Cubic inch (in³)":
                liters = value * 0.016387;
                break;
            case "Fluid ounce (fl oz)":
                liters = value * 0.029574;
                break;
            case "Cup (cup)":
                liters = value * 0.24;
                break;
            case "Pint (pt)":
                liters = value * 0.473;
                break;
            case "Quart (qt)":
                liters = value * 0.946;
                break;
            case "Gallon (gal)":
                liters = value * 3.785;
                break;
            case "Liter (L)":
            default:
                liters = value;
                break;
        }


        switch (outputUnit) {
            case "Milliliter (mL)":
            case "Cubic centimeter (cm³)":
                return liters * 1000;
            case "Cubic meter (m³)":
                return liters / 1000;
            case "Cubic inch (in³)":
                return liters / 0.016387;
            case "Fluid ounce (fl oz)":
                return liters / 0.029574;
            case "Cup (cup)":
                return liters / 0.24;
            case "Pint (pt)":
                return liters / 0.473;
            case "Quart (qt)":
                return liters / 0.946;
            case "Gallon (gal)":
                return liters / 3.785;
            case "Liter (L)":
            default:
                return liters;
        }
    }
}
