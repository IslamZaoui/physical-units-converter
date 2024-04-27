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

public class TemperatureFragment extends Fragment {
    private EditText inputValue;
    private Spinner inputUnitSpinner;
    private Spinner outputUnitSpinner;
    private TextView resultTextView;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_do_conversion, container, false);

        ((TextView) view.findViewById(R.id.ctitle)).setText("Convert Temperature Value");

        inputValue = view.findViewById(R.id.inputValue);
        inputUnitSpinner = view.findViewById(R.id.inputUnitSpinner);
        outputUnitSpinner = view.findViewById(R.id.outputUnitSpinner);
        resultTextView = view.findViewById(R.id.resultTextView);


        ArrayAdapter<CharSequence> inputAdapter = ArrayAdapter.createFromResource(requireContext(),
                R.array.temperature_units, android.R.layout.simple_spinner_item);
        inputAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        inputUnitSpinner.setAdapter(inputAdapter);


        ArrayAdapter<CharSequence> outputAdapter = ArrayAdapter.createFromResource(requireContext(),
                R.array.temperature_units, android.R.layout.simple_spinner_item);
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
        double result = convertTemperature(value, inputUnit, outputUnit);
        resultTextView.setText(String.format("%.2f %s", result, outputUnit));
    }

    private double convertTemperature(double value, String inputUnit, String outputUnit) {
        double celsius;


        switch (inputUnit) {
            case "Fahrenheit (°F)":
                celsius = (value - 32) * 5 / 9;
                break;
            case "Kelvin (K)":
                celsius = value - 273.15;
                break;
            case "Celsius (°C)":
            default:
                celsius = value;
                break;
        }


        switch (outputUnit) {
            case "Fahrenheit (°F)":
                return celsius * 9 / 5 + 32;
            case "Kelvin (K)":
                return celsius + 273.15;
            case "Celsius (°C)":
            default:
                return celsius;
        }
    }
}
