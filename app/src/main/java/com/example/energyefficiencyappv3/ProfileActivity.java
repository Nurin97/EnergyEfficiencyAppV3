package com.example.energyefficiencyappv3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import com.google.android.material.bottomnavigation.BottomNavigationView;


public class ProfileActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigationView);
        bottomNavigationView.setSelectedItemId(R.id.bottom_profile);

        bottomNavigationView.setOnItemSelectedListener(item -> {
            // Handle navigation item clicks here
            int itemId = item.getItemId();
            if (itemId == R.id.bottom_profile) {
                // Already on the profile page, do nothing
                return true;
            } else if (itemId == R.id.bottom_home) {
                // Handle the home menu item click
                openHomePage();
                return true;
            } else if (itemId == R.id.bottom_tips) {
                // Handle the tips menu item click
                openTipsPage();
                return true;
            } else if (itemId == R.id.bottom_chart) {
                // Handle the chart menu item click
                openChartPage();
                return true;
            }
            return false;
        });
    }

    // Methods for handling navigation item clicks
    private void openHomePage() {
        // Start the HomeActivity
        Intent intent = new Intent(ProfileActivity.this, MainActivity.class);
        startActivity(intent);
    }

    private void openTipsPage() {
        // Start the TipsActivity
        Intent intent = new Intent(ProfileActivity.this, TipsActivity.class);
        startActivity(intent);
    }

    private void openChartPage() {
        // Start the ChartActivity
        Intent intent = new Intent(ProfileActivity.this, ChartActivity.class);
        startActivity(intent);
    }
}
