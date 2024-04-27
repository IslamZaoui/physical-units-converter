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

public class EnergyFragment extends Fragment {
    private EditText inputValue;
    private Spinner inputUnitSpinner;
    private Spinner outputUnitSpinner;
    private TextView resultTextView;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_do_conversion, container, false);

        ((TextView) view.findViewById(R.id.ctitle)).setText("Convert Energy Value");

        inputValue = view.findViewById(R.id.inputValue);
        inputUnitSpinner = view.findViewById(R.id.inputUnitSpinner);
        outputUnitSpinner = view.findViewById(R.id.outputUnitSpinner);
        resultTextView = view.findViewById(R.id.resultTextView);


        ArrayAdapter<CharSequence> inputAdapter = ArrayAdapter.createFromResource(requireContext(),
                R.array.energy_units, android.R.layout.simple_spinner_item);
        inputAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        inputUnitSpinner.setAdapter(inputAdapter);


        ArrayAdapter<CharSequence> outputAdapter = ArrayAdapter.createFromResource(requireContext(),
                R.array.energy_units, android.R.layout.simple_spinner_item);
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
        double result = convertEnergy(value, inputUnit, outputUnit);
        resultTextView.setText(String.format("%.2f %s", result, outputUnit));
    }

    private double convertEnergy(double value, String inputUnit, String outputUnit) {

        double joules;
        switch (inputUnit) {
            case "Kilojoule (kJ)":
                joules = value * 1000;
                break;
            case "Calorie (cal)":
                joules = value * 4.184;
                break;
            case "Kilocalorie (kcal)":
                joules = value * 4184;
                break;
            case "Watt-hour (Wh)":
                joules = value * 3600;
                break;
            case "Kilowatt-hour (kWh)":
                joules = value * 3600000;
                break;
            case "British thermal unit (BTU)":
                joules = value * 1055.06;
                break;
            case "Foot-pound (ft⋅lbf)":
                joules = value * 1.356;
                break;
            case "Joule (J)":
            default:
                joules = value;
                break;
        }


        switch (outputUnit) {
            case "Kilojoule (kJ)":
                return joules / 1000;
            case "Calorie (cal)":
                return joules / 4.184;
            case "Kilocalorie (kcal)":
                return joules / 4184;
            case "Watt-hour (Wh)":
                return joules / 3600;
            case "Kilowatt-hour (kWh)":
                return joules / 3600000;
            case "British thermal unit (BTU)":
                return joules / 1055.06;
            case "Foot-pound (ft⋅lbf)":
                return joules / 1.356;
            case "Joule (J)":
            default:
                return joules;
        }
    }
}
