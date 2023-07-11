package com.example.energyefficiencyappv3;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class LivingroomResult extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_livingroom_result);

        // Get the total power consumption from the intent
        int totalPowerConsumption = getIntent().getIntExtra("totalPowerConsumption", 0);

        // Calculate and display the saving tips based on the total power consumption
        String savingTips = calculateSavingTips(totalPowerConsumption);

        // Display the total power consumption and saving tips in TextViews
        TextView powerConsumptionTextView = findViewById(R.id.powerConsumptionTextView);
        TextView savingTipsTextView = findViewById(R.id.savingTipsTextView);

        powerConsumptionTextView.setText(getString(R.string.total_power_consumption, totalPowerConsumption));
        savingTipsTextView.setText(savingTips);
    }

    private String calculateSavingTips(int totalPowerConsumption) {
        // Calculate the saving tips based on the total power consumption
        // You can implement your own logic here to provide personalized saving tips
        // based on the power consumption values.

        // For example, you can use if-else statements or switch-case to provide different tips
        // for different power consumption ranges.

        // Here's a simple example:

        if (totalPowerConsumption <= 500) {
            return "You are using energy efficiently!";
        } else if (totalPowerConsumption <= 1000) {
            return "You can save energy by turning off appliances when not in use.";
        } else {
            return "Consider replacing old appliances with energy-efficient models to reduce power consumption.";
        }
    }
}
