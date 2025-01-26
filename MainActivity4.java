package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity4 extends AppCompatActivity {

    private EditText coefficientA;
    private EditText coefficientB;
    private EditText coefficientC;
    private TextView solutions;
    private Button buttonSolve;
    private Button buttonReset;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);


        coefficientA = findViewById(R.id.coefficientA);
        coefficientB = findViewById(R.id.coefficientB);
        coefficientC = findViewById(R.id.coefficientC);
        solutions = findViewById(R.id.solutions);
        buttonSolve = findViewById(R.id.buttonSolve);
        buttonReset = findViewById(R.id.buttonReset);


        buttonSolve.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                solveEquation();
            }
        });


        buttonReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resetFields();
            }
        });
    }

    private void solveEquation() {
        String aText = coefficientA.getText().toString().trim();
        String bText = coefficientB.getText().toString().trim();
        String cText = coefficientC.getText().toString().trim();

        
        if (aText.isEmpty() || bText.isEmpty() || cText.isEmpty()) {
            solutions.setText("Veuillez remplir tous les champs.");
            return;
        }

        try {
            double a = Double.parseDouble(aText);
            double b = Double.parseDouble(bText);
            double c = Double.parseDouble(cText);

            //za3ma bch ya3ref beli machi katir hodod !
            if (a == 0) {
                solutions.setText("Ce n'est pas une équation quadratique (a ≠ 0).");
                return;
            }


            double discriminant = b * b - 4 * a * c;

            if (discriminant > 0) {

                double x1 = (-b + Math.sqrt(discriminant)) / (2 * a);
                double x2 = (-b - Math.sqrt(discriminant)) / (2 * a);
                solutions.setText("x₁ = " + x1 + "\nx₂ = " + x2);
            } else if (discriminant == 0) {

                double x = -b / (2 * a);
                solutions.setText("x = " + x);
            } else {
                //heda ta3 el a3dad el mourakaba
                double realPart = -b / (2 * a);
                double imaginaryPart = Math.sqrt(-discriminant) / (2 * a);
                solutions.setText("x₁ = " + realPart + " + " + imaginaryPart + "i\n" +
                        "x₂ = " + realPart + " - " + imaginaryPart + "i");
            }
        } catch (NumberFormatException e) {
            solutions.setText("Veuillez entrer des nombres valides.");
        }
    }

    private void resetFields() {
        coefficientA.setText("");
        coefficientB.setText("");
        coefficientC.setText("");
        solutions.setText("");
    }
}
