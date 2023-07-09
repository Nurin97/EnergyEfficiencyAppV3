package com.example.energyefficiencyappv3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class EnergyCalculator extends AppCompatActivity {

    private EditText powerUsageEditText;
    private EditText timeEditText;
    private TextView resultTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_energy_calculator);

        powerUsageEditText = findViewById(R.id.power_usage);
        timeEditText = findViewById(R.id.time);
        resultTextView = findViewById(R.id.result_text);

        Button calculateButton = findViewById(R.id.calculate_button);
        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculateEnergyUsage();
            }
        });
    }

    private void calculateEnergyUsage() {
        String powerUsageStr = powerUsageEditText.getText().toString();
        String timeStr = timeEditText.getText().toString();

        if (!powerUsageStr.isEmpty() && !timeStr.isEmpty()) {
            double powerUsage = Double.parseDouble(powerUsageStr);
            double time = Double.parseDouble(timeStr);

            double energyUsage = powerUsage * time;
            String resultMessage = "Energy Usage: /n " + energyUsage + " Watt-hours";

            resultTextView.setText(resultMessage);
        } else {
            resultTextView.setText("Please enter valid values for power usage and time.");
        }
    }
}
