package com.example.nihel;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

import androidx.appcompat.app.AppCompatActivity;

public class conversion extends AppCompatActivity {

    private EditText valeur;
    private RadioButton radioEuroToDZD, radioDZDToEuro;
    private Button buttonConvert;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conversion);

        valeur = findViewById(R.id.valeur);
        radioEuroToDZD = findViewById(R.id.eurodz);
        radioDZDToEuro = findViewById(R.id.dzeuro);
        buttonConvert = findViewById(R.id.convertir);

        buttonConvert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String inputValue = valeur.getText().toString();

                if (inputValue.isEmpty()) {
                    valeur.setError("Entrée invalide!!");
                    return;
                }

                double value = Double.parseDouble(inputValue);
                double result;

                if (radioEuroToDZD.isChecked()) {
                    result = value * 141;
                } else if (radioDZDToEuro.isChecked()) {
                    result = value / 141;
                } else {
                    valeur.setError("Sélectionnez une option :)");
                    return;
                }

                valeur.setText(String.format("%.2f", result));
            }
        });
    }
}