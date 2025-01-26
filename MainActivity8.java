package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity8 extends AppCompatActivity {

    private EditText valeur;
    private TextView resultText;
    private RadioGroup radioGroup;
    private RadioButton radioEuroToDZD, radioDZDToEuro;
    private Button buttonConvert;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main8);


        valeur = findViewById(R.id.val);
        resultText = findViewById(R.id.resultat);
        radioGroup = findViewById(R.id.radioGroup);
        radioEuroToDZD = findViewById(R.id.radioEuroToDZD);
        radioDZDToEuro = findViewById(R.id.radioDZDToEuro);
        buttonConvert = findViewById(R.id.buttonConvert);


        buttonConvert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String inputValue = valeur.getText().toString();


                if (inputValue.isEmpty()) {
                    resultText.setText("Entrée invalide!!");
                    return;
                }

                double value = Double.parseDouble(inputValue);
                double result;


                if (radioEuroToDZD.isChecked()) {
                    result = value * 141;
                } else if (radioDZDToEuro.isChecked()) {
                    result = value / 141;
                } else {
                    resultText.setText("Sélectionnez une option :)");
                    return;
                }


                resultText.setText(String.format("%.2f", result));
            }
        });
    }
}
