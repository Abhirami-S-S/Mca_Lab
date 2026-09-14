package com.example.adapterdemo3;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity
        implements AdapterView.OnItemClickListener {

    ListView li;
    ImageView clickedImage;

    String[] t = {"Tiger", "Pandas", "Squirrel"};

    int[] images = {
            R.drawable.tiger,
            R.drawable.panda,
            R.drawable.squirrel
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        li = findViewById(R.id.lv);
        clickedImage = findViewById(R.id.clicked);

        BaseAdapter adapter = new BaseAdapter() {

            @Override
            public int getCount() {
                return t.length;
            }

            @Override
            public Object getItem(int position) {
                return t[position];
            }

            @Override
            public long getItemId(int position) {
                return position;
            }

            @Override
            public View getView(int position, View convertView, ViewGroup parent) {

                if (convertView == null) {
                    convertView = LayoutInflater.from(MainActivity.this)
                            .inflate(R.layout.single_row, parent, false);
                }

                ImageView rowImage = convertView.findViewById(R.id.img);
                TextView tv = convertView.findViewById(R.id.Tv);

                tv.setText(t[position]);
                rowImage.setImageResource(images[position]);

                return convertView;
            }
        };

        li.setAdapter(adapter);
        li.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view,
                            int position, long id) {

        clickedImage.setImageResource(images[position]);
    }
}