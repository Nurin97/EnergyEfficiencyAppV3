package com.example.energyefficiencyappv3;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import androidx.appcompat.widget.SearchView;

import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.LinearLayoutManager;


import java.util.ArrayList;
import java.util.List;

public class TipsActivity extends AppCompatActivity {

    private DatabaseReference tipsRef;
    private RecyclerView tipsRecyclerView;
    private TipsAdapter tipsAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tips);

        tipsRecyclerView = findViewById(R.id.tipsRecyclerView);
        tipsAdapter = new TipsAdapter(this, new ArrayList<>());
        tipsRecyclerView.setAdapter(tipsAdapter);
        tipsRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        tipsRef = FirebaseDatabase.getInstance().getReference("tips");

        // Fetch the tips from the Firebase Realtime Database
        fetchTips();
    }

    private void fetchTips() {
        tipsRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                List<Tips> tips = new ArrayList<>();
                for (DataSnapshot tipSnapshot : dataSnapshot.getChildren()) {
                    Tips tip = tipSnapshot.getValue(Tips.class);
                    tips.add(tip);
                }
                tipsAdapter.setTipsList(tips);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                // Handle any errors
            }
        });
    }



    private void addTipsToDatabase() {

        // Get a reference to the "tips" node in your Firebase Realtime Database
        DatabaseReference tipsRef = FirebaseDatabase.getInstance().getReference("tips");

        // Create a new tips object for each tip
        Tips tip1 = new Tips("1", "Turn off lights when not in use", "Make it a habit to turn off lights when leaving a room to save energy.", "General");
        Tips tip2 = new Tips("2", "Unplug electronics when not in use", "Unplug devices like chargers and gaming consoles when they're not actively being used.", "General");
        Tips tip3 = new Tips("3", "Use energy-efficient light bulbs", "Replace traditional incandescent light bulbs with energy-saving LED or CFL bulbs.", "Lighting");
        Tips tip4 = new Tips("4", "Wash only full loads of dishes and clothes", "Your clothes washer and dishwasher are designed to run most efficiently with full loads. And more than that, if you run them only when full, you run them less often, which really cuts energy use.", "Laundry");
        Tips tip5 = new Tips("5", "Wash clothes with cold water.", "Clothes washers and laundry detergents are designed to work efficiently with cold water. If you only wash with hot water when you need to disinfect, you could save $60 or more a year.", "Laundry");
        Tips tip6 = new Tips("6", "Keep your appliances clean.", "Every appliance runs more efficiently when filters are clear of dust and door seals are free of gunk.", "Maintenance");
        Tips tip7 = new Tips("7", "Keep the oven door closed while cooking.", "The temperature in your oven can drop 25 degrees or more every time you open the oven door.", "Kitchen");
        Tips tip8 = new Tips("8", "Don’t stand in front of an open refrigerator door.", "The longer the fridge door is open, the harder the appliance has to work to maintain a cool temperature. Decide what you want in advance to minimize the amount of time the fridge or freezer door is open.", "Kitchen");
        Tips tip9 = new Tips("9", "Air-dry clothes.", "There’s nothing quite like the smell of sheets, towels, and clothes that have been dried out in the fresh air. Consider air-drying clothes on an old-fashioned clothesline or even hanging them inside the house. Alternatively, use an energy-efficient dryer.", "Laundry");
        Tips tip10 = new Tips("10", "Air-dry dishes instead of using your dishwasher’s drying cycle.", "Select the air-dry option on your dishwasher. Crack it open after the rinse cycle, and your dishes will dry without a single kilowatt being used. You’ll also save energy by keeping your kitchen cooler.", "Kitchen");





        // Use the generated push ID as the key to add the tips to the database
        tipsRef.child("tip1").setValue(tip1);
        tipsRef.child("tip2").setValue(tip2);
        tipsRef.child("tip3").setValue(tip3);
        tipsRef.child("tip4").setValue(tip4);
        tipsRef.child("tip5").setValue(tip5);
        tipsRef.child("tip6").setValue(tip6);
        tipsRef.child("tip7").setValue(tip7);
        tipsRef.child("tip8").setValue(tip8);
        tipsRef.child("tip9").setValue(tip9);
        tipsRef.child("tip10").setValue(tip10);
    }

}
