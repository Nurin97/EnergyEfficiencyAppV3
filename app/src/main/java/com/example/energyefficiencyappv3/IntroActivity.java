package com.example.energyefficiencyappv3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class IntroActivity extends AppCompatActivity {

    private Button swipeButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);

        swipeButton = findViewById(R.id.swipeButton);
        swipeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Start MainActivity
                Intent intent = new Intent(IntroActivity.this, MainActivity.class);
                startActivity(intent);
                finish(); // Finish IntroActivity to prevent going back to it
            }
        });
    }
}
