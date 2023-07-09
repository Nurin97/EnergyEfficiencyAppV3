package com.example.energyefficiencyappv3;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageButton;


import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private ImageButton energycalculatorButton;
    private ImageButton kitchenButton;
    private ImageButton livingroomButton;
    private ImageButton bedroomButton;
    private ImageButton bathroomButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Find ImageButtons by their IDs
        energycalculatorButton = findViewById(R.id.energycalculator);
        kitchenButton = findViewById(R.id.kitchen);
        livingroomButton = findViewById(R.id.livingroom);
        bedroomButton = findViewById(R.id.bedroom);
        bathroomButton = findViewById(R.id.bathroom);


        // Set click listeners for the ImageButtons
        energycalculatorButton.setOnClickListener(v -> {
            // Handle the energycalculator button click
            opnEnergycalculatorPage();
        });

        // Set click listeners for the ImageButtons
        kitchenButton.setOnClickListener(v -> {
            // Handle the kitchen button click
            openKitchenPage();
        });

        livingroomButton.setOnClickListener(v -> {
            // Handle the living room button click
            openLivingRoomPage();
        });

        bedroomButton.setOnClickListener(v -> {
            // Handle the living room button click
            openBedroomPage();
        });

        bathroomButton.setOnClickListener(v -> {
            // Handle the living room button click
            openBathroomPage();
        });

    }

    private void opnEnergycalculatorPage() {
        // Start the openEnergycalculatorPage
        Intent intent = new Intent(MainActivity.this, EnergyCalculator.class);
        startActivity(intent);
    }

    private void openKitchenPage() {
        // Start the KitchenActivity
        Intent intent = new Intent(MainActivity.this, ApplianceCalculator2.class);
        startActivity(intent);
    }

    private void openLivingRoomPage() {
        // Start the LivingRoomActivity
        Intent intent = new Intent(MainActivity.this, ApplianceCalculator.class);
        startActivity(intent);
    }

    private void openBedroomPage() {
        // Start the LivingRoomActivity
        Intent intent = new Intent(MainActivity.this, ApplianceCalculator3.class);
        startActivity(intent);
    }

    private void openBathroomPage() {
        // Start the LivingRoomActivity
        Intent intent = new Intent(MainActivity.this, ApplianceCalculator4.class);
        startActivity(intent);
    }

}
