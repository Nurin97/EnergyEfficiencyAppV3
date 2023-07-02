package com.example.energyefficiencyappv3;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private ImageButton kitchenButton;
    private ImageButton livingroomButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Find ImageButtons by their IDs
        kitchenButton = findViewById(R.id.kitchen);
        livingroomButton = findViewById(R.id.livingroom);


        // Set click listeners for the ImageButtons
        kitchenButton.setOnClickListener(v -> {
            // Handle the kitchen button click
            openKitchenPage();
        });

        livingroomButton.setOnClickListener(v -> {
            // Handle the living room button click
            openLivingRoomPage();
        });

    }

    private void openKitchenPage() {
        // Start the KitchenActivity
        Intent intent = new Intent(MainActivity.this, ApplianceCalculator3.class);
        startActivity(intent);
    }

    private void openLivingRoomPage() {
        // Start the LivingRoomActivity
        Intent intent = new Intent(MainActivity.this, ApplianceCalculator2.class);
        startActivity(intent);
    }

}
