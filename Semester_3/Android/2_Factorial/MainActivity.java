package com.example.factorial;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    EditText n1;
    Button comp;
    TextView r;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        n1=(EditText)findViewById(R.id.num);
        comp=(Button)findViewById(R.id.computebutton);
        r=(TextView) findViewById(R.id.result);
        comp.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.computebutton){
            int n= Integer.parseInt(n1.getText().toString());
            long fact=1;
            for (int i=1;i<=n;i++){
                fact=fact*i;
            }
            r.setText("Factorial = "+fact);
        }
    }
}
