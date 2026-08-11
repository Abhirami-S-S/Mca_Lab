package com.example.eventregistration;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class SummaryActivity extends AppCompatActivity {

    TextView tvName;
    TextView tvEmail;
    TextView tvCategory;
    TextView tvWorkshops;

    Button btnBack;
    Button btnConfirm;

    SharedPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_summary);

        // Connect XML views
        tvName = findViewById(R.id.tvName);
        tvEmail = findViewById(R.id.tvEmail);
        tvCategory = findViewById(R.id.tvCategory);
        tvWorkshops = findViewById(R.id.tvWorkshops);

        btnBack = findViewById(R.id.btnBack);
        btnConfirm = findViewById(R.id.btnConfirm);

        // Get SharedPreferences
        preferences = getSharedPreferences(
                "RegistrationData",
                MODE_PRIVATE
        );

        // Retrieve saved data
        String name =
                preferences.getString("name", "");

        String email =
                preferences.getString("email", "");

        String category =
                preferences.getString("category", "");

        String workshops =
                preferences.getString("workshops", "");

        // Display registration details
        tvName.setText("Name: " + name);

        tvEmail.setText("Email: " + email);

        tvCategory.setText(
                "Category: " + category
        );

        tvWorkshops.setText(
                "Workshops: " + workshops
        );

        // Back to Edit
        btnBack.setOnClickListener(v -> {

            Intent intent = new Intent(
                    SummaryActivity.this,
                    MainActivity.class
            );

            startActivity(intent);

            finish();
        });

        // Confirm Registration
        btnConfirm.setOnClickListener(v -> {

            LayoutInflater inflater =
                    getLayoutInflater();

            View toastView =
                    inflater.inflate(
                            R.layout.custom_toast,
                            null
                    );

            TextView toastText =
                    toastView.findViewById(
                            R.id.toastText
                    );

            toastText.setText(
                    "Registration Confirmed"
            );

            Toast toast =
                    new Toast(getApplicationContext());

            toast.setDuration(
                    Toast.LENGTH_LONG
            );

            toast.setGravity(
                    Gravity.CENTER,
                    0,
                    200
            );

            toast.setView(toastView);

            toast.show();
        });
    }
}