package com.example.spandi;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Second extends AppCompatActivity  implements View.OnClickListener{

    Button prev;
    TextView n,e;
    SharedPreferences sp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_second);
        prev = (Button) findViewById(R.id.prev);
        prev.setOnClickListener(this);
        sp = getSharedPreferences("MyData", MODE_PRIVATE);
        n = (TextView) findViewById(R.id.na);
        e = (TextView) findViewById(R.id.em);
        if (sp.contains("Name"))
            n.setText("Name : "+sp.getString("Name", ""));
        if (sp.contains("Email"))
            e.setText("Email : "+sp.getString("Email", ""));
    }
    @Override
    public void onClick(View view) {
        Intent i= new Intent(this, MainActivity.class);
        startActivity(i);
    }
}