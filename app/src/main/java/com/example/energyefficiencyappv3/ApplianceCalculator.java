package com.example.energyefficiencyappv3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class ApplianceCalculator extends AppCompatActivity {

    private TextView[] quantityTextViews;
    private int[] quantities;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_appliance_calculator);

        quantityTextViews = new TextView[]{
                findViewById(R.id.quantity1),
                findViewById(R.id.quantity2),
                findViewById(R.id.quantity3),
                findViewById(R.id.quantity4),
                findViewById(R.id.quantity5),
                // Add more TextViews for other quantities if needed
        };

        // Add more TextViews for other remove buttons if needed
        TextView[] removeTextViews = new TextView[]{
                findViewById(R.id.remove1),
                findViewById(R.id.remove2),
                findViewById(R.id.remove3),
                findViewById(R.id.remove4),
                findViewById(R.id.remove5),
                // Add more TextViews for other remove buttons if needed
        };

        // Add more TextViews for other add buttons if needed
        TextView[] addTextViews = new TextView[]{
                findViewById(R.id.add1),
                findViewById(R.id.add2),
                findViewById(R.id.add3),
                findViewById(R.id.add4),
                findViewById(R.id.add5),
                // Add more TextViews for other add buttons if needed
        };

        quantities = new int[quantityTextViews.length];

        for (int i = 0; i < quantityTextViews.length; i++) {
            final int index = i;
            quantityTextViews[i].setText(String.valueOf(quantities[i]));

            removeTextViews[i].setOnClickListener(v -> {
                if (quantities[index] > 0) {
                    quantities[index]--;
                    quantityTextViews[index].setText(String.valueOf(quantities[index]));
                }
            });

            addTextViews[i].setOnClickListener(v -> {
                quantities[index]++;
                quantityTextViews[index].setText(String.valueOf(quantities[index]));
            });
        }
    }
}
