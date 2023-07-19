package  com.example.energyefficiencyappv3;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.FirebaseApp;

public class MainActivity extends AppCompatActivity {

    private BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FirebaseApp.initializeApp(this);

        // Find ImageButtons by their IDs
        ImageButton energycalculatorButton = findViewById(R.id.energycalculator);
        ImageButton kitchenButton = findViewById(R.id.kitchen);
        ImageButton livingroomButton = findViewById(R.id.livingroom);
        ImageButton bedroomButton = findViewById(R.id.bedroom);
        ImageButton bathroomButton = findViewById(R.id.bathroom);
        bottomNavigationView = findViewById(R.id.bottomNavigationView);

        // Set click listeners for the ImageButtons
        energycalculatorButton.setOnClickListener(v -> {
            // Handle the energycalculator button click
            openEnergyCalculatorPage();
        });

        kitchenButton.setOnClickListener(v -> {
            // Handle the kitchen button click
            openKitchenPage();
        });

        livingroomButton.setOnClickListener(v -> {
            // Handle the living room button click
            openLivingRoomPage();
        });

        bedroomButton.setOnClickListener(v -> {
            // Handle the bedroom button click
            openBedroomPage();
        });

        bathroomButton.setOnClickListener(v -> {
            // Handle the bathroom button click
            openBathroomPage();
        });

        // Set click listener for the bottom navigation items
        bottomNavigationView.setOnItemSelectedListener(this::onNavigationItemSelected);
    }

    @Override
    protected void onResume() {
        super.onResume();
        // Set the selected item on resume to highlight the "Home" icon
        bottomNavigationView.getMenu().findItem(R.id.bottom_home).setChecked(true);
    }

    private boolean onNavigationItemSelected(MenuItem item) {
        int itemId = item.getItemId();
        if (itemId == R.id.bottom_home) {
            // Already on the home page, do nothing
            return true;
        } else if (itemId == R.id.bottom_tips) {
            openTipsPage();
            return true;
        } else if (itemId == R.id.bottom_chart) {
            openChartPage();
            return true;
        } else if (itemId == R.id.bottom_profile) {
            openProfilePage();
            return true;
        }
        return false;
    }

    private void openEnergyCalculatorPage() {
        // Start the EnergyCalculator activity
        Intent intent = new Intent(MainActivity.this, EnergyCalculator.class);
        startActivity(intent);
    }

    private void openKitchenPage() {
        // Start the KitchenActivity
        Intent intent = new Intent(MainActivity.this, ApplianceCalculator.class);
        startActivity(intent);
    }

    private void openLivingRoomPage() {
        // Start the LivingRoomActivity
        Intent intent = new Intent(MainActivity.this, ApplianceCalculator2.class);
        startActivity(intent);
    }

    private void openBedroomPage() {
        // Start the BedroomActivity
        Intent intent = new Intent(MainActivity.this, ApplianceCalculator3.class);
        startActivity(intent);
    }

    private void openBathroomPage() {
        // Start the BathroomActivity
        Intent intent = new Intent(MainActivity.this, ApplianceCalculator4.class);
        startActivity(intent);
    }


    private void openTipsPage() {
        // Start the TipsActivity
        Intent intent = new Intent(MainActivity.this, TipsActivity.class);
        startActivity(intent);
    }

    private void openChartPage() {
        // Start the ChartActivity
        Intent intent = new Intent(MainActivity.this, ChartActivity.class);
        startActivity(intent);
    }

    private void openProfilePage() {
        // Start the ProfileActivity
        Intent intent = new Intent(MainActivity.this, ProfileActivity.class);
        startActivity(intent);
    }

}
