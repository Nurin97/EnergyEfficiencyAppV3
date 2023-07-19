package com.example.energyefficiencyappv3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class RegisterActivity extends AppCompatActivity {

    private DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        // Initialize the Firebase database reference
        databaseReference = FirebaseDatabase.getInstance().getReference("users");

        // Get references to the EditText fields
        EditText usernameEditText = findViewById(R.id.editTextText10);
        EditText emailEditText = findViewById(R.id.editTextText7);
        EditText passwordEditText = findViewById(R.id.editTextText8);
        EditText confirmPasswordEditText = findViewById(R.id.editTextText9);

        // Get the register button reference
        Button registerButton = findViewById(R.id.btnRegister);

        // Set click listener for the register button
        registerButton.setOnClickListener(v -> {
            // Get the input values
            String username = usernameEditText.getText().toString().trim();
            String email = emailEditText.getText().toString().trim();
            String password = passwordEditText.getText().toString().trim();
            String confirmPassword = confirmPasswordEditText.getText().toString().trim();

            // Perform input validation

            if (TextUtils.isEmpty(username)) {
                usernameEditText.setError("Username is required");
                return;
            }

            if (TextUtils.isEmpty(email)) {
                emailEditText.setError("Email is required");
                return;
            }

            if (!isValidEmail(email)) {
                emailEditText.setError("Invalid email format");
                return;
            }

            if (TextUtils.isEmpty(password)) {
                passwordEditText.setError("Password is required");
                return;
            }

            if (!isValidPassword(password)) {
                passwordEditText.setError("Password must be at least 6 characters long");
                return;
            }
            Log.d("RegisterActivity", "Password: " + password);
            Log.d("RegisterActivity", "Confirm Password: " + confirmPassword);

            if (!confirmPassword.equals(password)) {
                confirmPasswordEditText.setError("Passwords do not match");
                return;
            }


            // Use the Firebase authentication API to create a new user
            FirebaseAuth.getInstance().createUserWithEmailAndPassword(email, password)
                    .addOnCompleteListener(task -> {
                        if (task.isSuccessful()) {
                            // Registration successful
                            // Check if the user is logged in and navigate accordingly
                            FirebaseUser currentUser = FirebaseAuth.getInstance().getCurrentUser();
                            if (currentUser != null) {
                                // Get the user ID
                                String userId = currentUser.getUid();

                                // Create a new User object
                                User user = new User(userId, username, email, password);

                                // Store the user in the Firebase Realtime Database
                                databaseReference.child(userId).setValue(user)
                                        .addOnCompleteListener(databaseTask -> {
                                            if (databaseTask.isSuccessful()) {
                                                // Registration successful, navigate to the login page
                                                Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                                                startActivity(intent);
                                                finish();
                                            } else {
                                                // Registration failed
                                                Toast.makeText(RegisterActivity.this, "Registration failed", Toast.LENGTH_SHORT).show();
                                            }
                                        });
                            }
                        } else {
                            // Registration failed
                            Toast.makeText(RegisterActivity.this, "Registration failed", Toast.LENGTH_SHORT).show();
                        }
                    });
        });

        // Get the "Already have an account?" TextView reference
        TextView alreadyHaveAccountTextView = findViewById(R.id.alreadyHaveAccount);

        // Set click listener for the "Already have an account?" TextView
        alreadyHaveAccountTextView.setOnClickListener(v -> {
            Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
            startActivity(intent);
            finish();
        });
    }

    private boolean isValidEmail(String email) {
        // Implement your own email validation logic here
        // For example, you can use regular expressions or other validation methods
        return email.contains("@");
    }

    private boolean isValidPassword(String password) {
        // Implement your own password validation logic here
        // For example, you can check if the password length is at least 6 characters
        return password.length() >= 6;
    }
}

