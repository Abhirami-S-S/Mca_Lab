package com.example.eventregistration;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;
import  android.content.Intent;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    EditText etName, etEmail;

    RadioGroup radioGroup;
    RadioButton rbStudent, rbProfessional;

    CheckBox cbAndroid, cbAI, cbCyber;

    Button btnSubmit;

    SharedPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        // Connect XML components
        etName = findViewById(R.id.etName);
        etEmail = findViewById(R.id.etEmail);

        radioGroup = findViewById(R.id.radioGroup);

        rbStudent = findViewById(R.id.rbStudent);
        rbProfessional = findViewById(R.id.rbProfessional);

        cbAndroid = findViewById(R.id.cbAndroid);
        cbAI = findViewById(R.id.cbAI);
        cbCyber = findViewById(R.id.cbCyber);

        btnSubmit = findViewById(R.id.btnSubmit);

        // SharedPreferences
        preferences = getSharedPreferences(
                "RegistrationData",
                MODE_PRIVATE
        );

        // Load previously saved data
        loadData();

        // Submit button
        btnSubmit.setOnClickListener(v -> {

            String name = etName.getText().toString().trim();

            String email = etEmail.getText().toString().trim();

            // Validate name
            if (name.isEmpty()) {
                etName.setError("Enter your name");
                etName.requestFocus();
                return;
            }

            // Validate email
            if (email.isEmpty()) {
                etEmail.setError("Enter your email");
                etEmail.requestFocus();
                return;
            }

            // Get selected RadioButton
            int selectedId =
                    radioGroup.getCheckedRadioButtonId();

            if (selectedId == -1) {

                Toast.makeText(
                        MainActivity.this,
                        "Select registration category",
                        Toast.LENGTH_SHORT
                ).show();

                return;
            }

            RadioButton selectedRadio =
                    findViewById(selectedId);

            String category =
                    selectedRadio.getText().toString();

            // Get selected workshops
            StringBuilder workshops =
                    new StringBuilder();

            if (cbAndroid.isChecked()) {
                workshops.append("Android Development, ");
            }

            if (cbAI.isChecked()) {
                workshops.append("AI & ML, ");
            }

            if (cbCyber.isChecked()) {
                workshops.append("Cybersecurity, ");
            }

            if (workshops.length() == 0) {

                Toast.makeText(
                        MainActivity.this,
                        "Select at least one workshop",
                        Toast.LENGTH_SHORT
                ).show();

                return;
            }

            // Remove last comma
            workshops.setLength(
                    workshops.length() - 2
            );

            // Save data
            SharedPreferences.Editor editor =
                    preferences.edit();

            editor.putString("name", name);

            editor.putString("email", email);

            editor.putString(
                    "category",
                    category
            );

            editor.putString(
                    "workshops",
                    workshops.toString()
            );

            editor.apply();

            // Open SummaryActivity
            Intent intent = new Intent(
                    MainActivity.this,
                    SummaryActivity.class
            );

            startActivity(intent);
        });
    }

    // Load saved data
    private void loadData() {

        String name =
                preferences.getString("name", "");

        String email =
                preferences.getString("email", "");

        String category =
                preferences.getString("category", "");

        String workshops =
                preferences.getString("workshops", "");

        etName.setText(name);

        etEmail.setText(email);

        // Restore category
        if (category.equals("Student")) {

            rbStudent.setChecked(true);

        } else if (category.equals("Professional")) {

            rbProfessional.setChecked(true);
        }

        // Restore workshops
        if (workshops.contains(
                "Android Development")) {

            cbAndroid.setChecked(true);
        }

        if (workshops.contains("AI & ML")) {

            cbAI.setChecked(true);
        }

        if (workshops.contains("Cybersecurity")) {

            cbCyber.setChecked(true);
        }
    }
}