package com.example.adapterdemo;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity
        implements AdapterView.OnItemClickListener {

    ListView l;
    Spinner s;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);

        setContentView(R.layout.activity_main);
        String[] months = {"January", "February", "March", "April", "May", "June",
                "July", "August", "September", "October", "November", "December"};
        String[] days = {
                "Sunday",
                "Monday",
                "Tuesday",
                "Wednesday",
                "Thursday",
                "Friday",
                "Saturday"
        };
        s=findViewById(R.id.spin);
        ArrayAdapter<String> adapters = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,months);
        s.setAdapter(adapters);
        l = findViewById(R.id.list);

        ArrayAdapter<String> adapter =
                new ArrayAdapter<>(
                        this,
                        android.R.layout.simple_list_item_1,
                        days
                );

        l.setAdapter(adapter);

        l.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(
            AdapterView<?> parent,
            View view,
            int i,
            long id)
    {
        TextView temp = (TextView) view;
        Toast.makeText(this,temp.getText().toString(),Toast.LENGTH_SHORT ).show();
    }
}