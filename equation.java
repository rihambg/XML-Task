package com.example.nihel;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class equation extends AppCompatActivity {

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
                    valeur.setError("Veuillez entrer un montant");
                    return;
                }

                double value;
                try {
                    value = Double.parseDouble(inputValue);
                } catch (NumberFormatException e) {
                    valeur.setError("Entrée invalide, veuillez entrer un nombre");
                    return;
                }

                double result = 0;

                if (radioEuroToDZD.isChecked()) {
                    result = value * 141;
                } else if (radioDZDToEuro.isChecked()) {
                    result = value / 141;
                } else {
                    Toast.makeText(equation.this, "Veuillez sélectionner une option", Toast.LENGTH_SHORT).show();
                    return;
                }

                
                valeur.setText(String.format("%.2f", result));
            }
        });
    }
}
