package com.example.regi_form;

import android.os.Bundle;



import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText nameIn;
    EditText emailIn;
    EditText passwordIn;

    RadioGroup genderGroup;

    Button signup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        // Connect XML components
        nameIn = findViewById(R.id.name_in);
        emailIn = findViewById(R.id.email_in);
        passwordIn = findViewById(R.id.pwd_in);

        genderGroup = findViewById(R.id.gendergroup);

        signup = findViewById(R.id.signup);


        // Register button
        signup.setOnClickListener(v -> {

            // Get entered values
            String name = nameIn.getText().toString().trim();
            String email = emailIn.getText().toString().trim();
            String password = passwordIn.getText().toString().trim();


            // Validate name
            if (name.isEmpty()) {

                nameIn.setError("Please enter your name");
                nameIn.requestFocus();

                return;
            }


            // Validate email
            if (email.isEmpty()) {

                emailIn.setError("Please enter your email");
                emailIn.requestFocus();

                return;
            }


            // Validate password
            if (password.isEmpty()) {

                passwordIn.setError("Please enter your password");
                passwordIn.requestFocus();

                return;
            }


            // Get selected RadioButton
            int selectedGenderId =
                    genderGroup.getCheckedRadioButtonId();


            // Check gender
            if (selectedGenderId == -1) {

                Toast.makeText(
                        MainActivity.this,
                        "Please select your gender",
                        Toast.LENGTH_SHORT
                ).show();

                return;
            }


            // Get selected RadioButton object
            RadioButton selectedGender =
                    findViewById(selectedGenderId);


            // Get Male/Female text
            String gender =
                    selectedGender.getText().toString();


            // Navigate to SecondActivity
            Intent intent =
                    new Intent(
                            MainActivity.this,
                            secondActivity.class
                    );


            // Send data to SecondActivity
            intent.putExtra("name", name);
            intent.putExtra("email", email);
            intent.putExtra("gender", gender);


            // Open SecondActivity
            startActivity(intent);

        });
    }
}