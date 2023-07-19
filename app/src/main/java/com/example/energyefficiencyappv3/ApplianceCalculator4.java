package com.example.energyefficiencyappv3;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ApplianceCalculator4 extends AppCompatActivity implements View.OnClickListener {

    private final int[] quantities = new int[3];
    private final ImageButton[] addButtons = new ImageButton[3];
    private final ImageButton[] removeButtons = new ImageButton[3];
    private final TextView[] quantityTextViews = new TextView[3];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_appliance_calculator);

        // Find views
        addButtons[0] = findViewById(R.id.add1);
        addButtons[1] = findViewById(R.id.add2);
        addButtons[2] = findViewById(R.id.add3);

        removeButtons[0] = findViewById(R.id.remove1);
        removeButtons[1] = findViewById(R.id.remove2);
        removeButtons[2] = findViewById(R.id.remove3);

        quantityTextViews[0] = findViewById(R.id.quantity1);
        quantityTextViews[1] = findViewById(R.id.quantity2);
        quantityTextViews[2] = findViewById(R.id.quantity3);

        // Set click listeners
        for (int i = 0; i < 3; i++) {
            addButtons[i].setOnClickListener(this);
            removeButtons[i].setOnClickListener(this);
        }
    }


    @Override
    public void onClick(View v) {
        int id = v.getId();
        if (id == R.id.add1) {
            quantities[0]++;
        } else if (id == R.id.add2) {
            quantities[1]++;
        } else if (id == R.id.add3) {
            quantities[2]++;
        } else if (id == R.id.remove1) {
            if (quantities[0] > 0) {
                quantities[0]--;
            }
        } else if (id == R.id.remove2) {
            if (quantities[1] > 0) {
                quantities[1]--;
            }
        } else if (id == R.id.remove3) {
            if (quantities[2] > 0) {
                quantities[2]--;
            }
        }
        updateQuantities();
    }

    private void updateQuantities() {
        for (int i = 0; i < 3; i++) {
            quantityTextViews[i].setText(String.valueOf(quantities[i]));
        }
    }


    public void calculateTotalPowerConsumption(View view) {
        Spinner spinner = findViewById(R.id.spinner);
        String selectedAppliance = spinner.getSelectedItem().toString();

        int quantity1 = getQuantity(R.id.quantity1);
        int quantity2 = getQuantity(R.id.quantity2);
        int quantity3 = getQuantity(R.id.quantity3);

        // Calculate the total power consumption based on the selected appliance and quantities
        int totalPowerConsumption = 0;
        switch (selectedAppliance) {
            case "Washing Machine":
                totalPowerConsumption = quantity1 * 100; // Assuming each refrigerator consumes 100 watts

                break;
            case "Hair Dryer":
                totalPowerConsumption = quantity2 * 50; // Assuming each toaster consumes 50 watts

                break;
            case "Water Heater":
                totalPowerConsumption = quantity3 * 200; // Assuming each rice cooker consumes 200 watts

                break;
        }

        // Display the total power consumption in the TextView
        TextView totalPowerTextView = findViewById(R.id.totalPowerTextView);
        String totalPowerString = getString(R.string.total_power_consumption, totalPowerConsumption);
        totalPowerTextView.setText(totalPowerString);

    }

    private int getQuantity(int quantityTextViewId) {
        TextView quantityTextView = findViewById(quantityTextViewId);
        String quantityString = quantityTextView.getText().toString();
        return Integer.parseInt(quantityString);
    }
}
