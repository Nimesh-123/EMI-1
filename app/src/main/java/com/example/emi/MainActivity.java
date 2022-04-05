package com.example.emi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView result;
    EditText e1, e2, e3;
    Button b1, b2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        e1 = findViewById(R.id.e1);
        e2 = findViewById(R.id.e2);
        e3 = findViewById(R.id.e3);
        b1 = findViewById(R.id.b1);
        b2 = findViewById(R.id.b2);
        result = findViewById(R.id.result);

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Float P = Float.valueOf(e1.getText().toString());
                Float a = Float.valueOf(e2.getText().toString());
                Float n = Float.valueOf(e3.getText().toString());

                a = a / (12 * 100);

                float final_r = 1.0f;

                for (int i = 0; i < n * 12; i++) {
                    final_r = final_r * (1 + a);
                }

                float f_ans = P * a * (final_r / (final_r - 1));

                result.setText("Your Payable Amount With Intrest : " + (f_ans + P) + "\n\n" + "Your Intrest is : " + f_ans);
            }
        });
        result.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                e1.setText("");
                e2.setText("");
                e3.setText("");
                result.setText("");
            }
        });
    }

}