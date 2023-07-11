package com.example.energyefficiencyappv3;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;


public class ApplianceCalculator2 extends AppCompatActivity implements View.OnClickListener {

    private final int[] quantities = new int[5];
    private final ImageButton[] addButtons = new ImageButton[5];
    private final ImageButton[] removeButtons = new ImageButton[5];
    private final TextView[] quantityTextViews = new TextView[5];

    private String selectedAppliance;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_appliance_calculator2);

        // Find views
        addButtons[0] = findViewById(R.id.add1);
        addButtons[1] = findViewById(R.id.add2);
        addButtons[2] = findViewById(R.id.add3);
        addButtons[3] = findViewById(R.id.add4);
        addButtons[4] = findViewById(R.id.add5);

        removeButtons[0] = findViewById(R.id.remove1);
        removeButtons[1] = findViewById(R.id.remove2);
        removeButtons[2] = findViewById(R.id.remove3);
        removeButtons[3] = findViewById(R.id.remove4);
        removeButtons[4] = findViewById(R.id.remove5);

        quantityTextViews[0] = findViewById(R.id.quantity1);
        quantityTextViews[1] = findViewById(R.id.quantity2);
        quantityTextViews[2] = findViewById(R.id.quantity3);
        quantityTextViews[3] = findViewById(R.id.quantity4);
        quantityTextViews[4] = findViewById(R.id.quantity5);

        // Set click listeners
        for (int i = 0; i < 5; i++) {
            addButtons[i].setOnClickListener(this);
            removeButtons[i].setOnClickListener(this);
        }

        Button calculateButton = findViewById(R.id.calculateButton);
        calculateButton.setOnClickListener(this);
    }



    @Override
    public void onClick(View v) {
        int id = v.getId();
        int index = -1;
        if (id == R.id.add1) {
            index = 0;
            selectedAppliance = "Computer";
        } else if (id == R.id.add2) {
            index = 1;
            selectedAppliance = "Air Conditioner";
        } else if (id == R.id.add3) {
            index = 2;
            selectedAppliance = "TV";
        } else if (id == R.id.add4) {
            index = 3;
            selectedAppliance = "Vacuum";
        } else if (id == R.id.add5) {
            index = 4;
            selectedAppliance = "Printer";
        } else if (id == R.id.remove1) {
            selectedAppliance = "Computer";
            index = 0;
        } else if (id == R.id.remove2) {
            index = 1;
            selectedAppliance = "Air Conditioner";
        } else if (id == R.id.remove3) {
            index = 2;
            selectedAppliance = "TV";
        } else if (id == R.id.remove4) {
            index = 3;
            selectedAppliance = "Vacuum";
        } else if (id == R.id.remove5) {
            index = 4;
            selectedAppliance = "Printer";
        } else if (id == R.id.calculateButton) {
            calculateTotalPowerConsumption();
        }

        if (index != -1) {
            updateQuantity(index, id);
        }
    }

    private void updateQuantity(int index, int buttonId) {
        if (buttonId == R.id.add1 || buttonId == R.id.add2 || buttonId == R.id.add3 || buttonId == R.id.add4 || buttonId == R.id.add5) {
            quantities[index]++;
        } else if (buttonId == R.id.remove1 || buttonId == R.id.remove2 || buttonId == R.id.remove3 || buttonId == R.id.remove4 || buttonId == R.id.remove5) {
            if (quantities[index] > 0) {
                quantities[index]--;
            }
        }
        quantityTextViews[index].setText(String.valueOf(quantities[index]));
    }

    public void calculateTotalPowerConsumption() {
        // Calculate the total power consumption based on the selected appliances and quantities
        int totalPowerConsumption = calculatePowerConsumption();

        // Create an intent to start the LivingroomResult activity
        Intent intent = new Intent(ApplianceCalculator2.this, LivingroomResult.class);
        intent.putExtra("totalPowerConsumption", totalPowerConsumption);
        startActivity(intent);
    }

    private int calculatePowerConsumption() {
        int totalPowerConsumption = 0;
        // Calculate the total power consumption based on the quantities and appliance types
        // Implement your logic here to calculate the power consumption for each appliance
        switch (selectedAppliance) {
            case "Computer":
                totalPowerConsumption = quantities[0] * 100; // Assuming each refrigerator consumes 100 watts
                break;
            case "Air Conditioner":
                totalPowerConsumption = quantities[1] * 50; // Assuming each toaster consumes 50 watts
                break;
            case "TV":
                totalPowerConsumption = quantities[2] * 200; // Assuming each rice cooker consumes 200 watts
                break;
            case "Vacuum":
                totalPowerConsumption = quantities[3] * 800; // Assuming each microwave consumes 800 watts
                break;
            case "Printer":
                totalPowerConsumption = quantities[4] * 800; // Assuming each printer consumes 800 watts
                break;
        }
        return totalPowerConsumption;
    }
}
