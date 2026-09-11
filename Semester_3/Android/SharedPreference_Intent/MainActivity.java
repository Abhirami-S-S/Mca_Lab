package com.example.spandi;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    EditText name;
    EditText email;
    Button next;
    String a;
    String b;
    SharedPreferences sp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        name=(EditText) findViewById(R.id.username);
        email=(EditText) findViewById(R.id.email);
        next=(Button) findViewById(R.id.next);
        next.setOnClickListener(this);
        sp=getSharedPreferences("MyData",MODE_PRIVATE);
        if (sp.contains("Name"))
            name.setText(sp.getString("Name",""));
        if (sp.contains("Email"))
            email.setText(sp.getString("Email",""));
    }

    @Override
    public void onClick(View view) {
        a=name.getText().toString();
        b=email.getText().toString();
        SharedPreferences.Editor editor=sp.edit();
        editor.putString("Name",a);
        editor.putString("Email",b);
        editor.apply();
        Intent i = new Intent(this,Second.class);
        startActivity(i);
    }
}