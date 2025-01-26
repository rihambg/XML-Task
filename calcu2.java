package com.example.nihel;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class calcu2 extends AppCompatActivity {

    private EditText editTextNumber1, editTextNumber2;
    private TextView resultText;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calcu2);


        editTextNumber1 = findViewById(R.id.number1);
        editTextNumber2 = findViewById(R.id.number2);
        resultText = findViewById(R.id.result);

        Button buttonAdd = findViewById(R.id.add);
        Button buttonSubtract = findViewById(R.id.sub);
        Button buttonMultiply = findViewById(R.id.mult);
        Button buttonDivide = findViewById(R.id.div);


        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculate('+');
            }
        });

        buttonSubtract.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculate('-');
            }
        });

        buttonMultiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculate('*');
            }
        });

        buttonDivide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculate('/');
            }
        });
    }


    private void calculate(char operator) {
        String num1Str = editTextNumber1.getText().toString();
        String num2Str = editTextNumber2.getText().toString();


        if (num1Str.isEmpty() || num2Str.isEmpty()) {
            resultText.setText("Enter both values!");
            return;
        }

        try {

            double num1 = Double.parseDouble(num1Str);
            double num2 = Double.parseDouble(num2Str);
            double result = 0;


            switch (operator) {
                case '+':
                    result = num1 + num2;
                    break;
                case '-':
                    result = num1 - num2;
                    break;
                case '*':
                    result = num1 * num2;
                    break;
                case '/':
                    if (num2 == 0) {
                        resultText.setText("la division par 0 est impossible!");
                        return;
                    }
                    result = num1 / num2;
                    break;
            }


            resultText.setText(String.valueOf(result));
        } catch (NumberFormatException e) {

            resultText.setText("Invalid input!");
        }
    }
}