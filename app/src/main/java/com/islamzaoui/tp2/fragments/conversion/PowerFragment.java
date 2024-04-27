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

public class PowerFragment extends Fragment {
    private EditText inputValue;
    private Spinner inputUnitSpinner;
    private Spinner outputUnitSpinner;
    private TextView resultTextView;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_do_conversion, container, false);

        ((TextView) view.findViewById(R.id.ctitle)).setText("Convert Power Value");

        inputValue = view.findViewById(R.id.inputValue);
        inputUnitSpinner = view.findViewById(R.id.inputUnitSpinner);
        outputUnitSpinner = view.findViewById(R.id.outputUnitSpinner);
        resultTextView = view.findViewById(R.id.resultTextView);


        ArrayAdapter<CharSequence> inputAdapter = ArrayAdapter.createFromResource(requireContext(),
                R.array.power_units, android.R.layout.simple_spinner_item);
        inputAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        inputUnitSpinner.setAdapter(inputAdapter);


        ArrayAdapter<CharSequence> outputAdapter = ArrayAdapter.createFromResource(requireContext(),
                R.array.power_units, android.R.layout.simple_spinner_item);
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
        double result = convertPower(value, inputUnit, outputUnit);
        resultTextView.setText(String.format("%.2f %s", result, outputUnit));
    }

    private double convertPower(double value, String inputUnit, String outputUnit) {

        double watts;
        switch (inputUnit) {
            case "Kilowatt (kW)":
                watts = value * 1000;
                break;
            case "Megawatt (MW)":
                watts = value * 1000000;
                break;
            case "Gigawatt (GW)":
                watts = value * 1000000000;
                break;
            case "Milliwatt (mW)":
                watts = value / 1000;
                break;
            case "Horsepower (hp)":
                watts = value * 745.7;
                break;
            case "Foot-pound per second (ft⋅lbf/s)":
                watts = value * 1.356;
                break;
            case "BTU per hour (BTU/h)":
                watts = value * 0.2928;
                break;
            case "Watt (W)":
            default:
                watts = value;
                break;
        }


        switch (outputUnit) {
            case "Kilowatt (kW)":
                return watts / 1000;
            case "Megawatt (MW)":
                return watts / 1000000;
            case "Gigawatt (GW)":
                return watts / 1000000000;
            case "Milliwatt (mW)":
                return watts * 1000;
            case "Horsepower (hp)":
                return watts / 745.7;
            case "Foot-pound per second (ft⋅lbf/s)":
                return watts / 1.356;
            case "BTU per hour (BTU/h)":
                return watts / 0.2928;
            case "Watt (W)":
            default:
                return watts;
        }
    }
}
