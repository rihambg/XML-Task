package com.example.nihel;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import java.text.DecimalFormat;

public class equation2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_equation2);

        EditText etA = findViewById(R.id.et_a);
        EditText etB = findViewById(R.id.et_b);
        EditText etC = findViewById(R.id.et_c);
        Button btnResoudre = findViewById(R.id.btn_resoudre);
        Button btnReinitialiser = findViewById(R.id.btn_reinitialiser);
        TextView tvSolutions = findViewById(R.id.tv_solutions);

        btnResoudre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String aText = etA.getText().toString();
                String bText = etB.getText().toString();
                String cText = etC.getText().toString();


                if (TextUtils.isEmpty(aText) || TextUtils.isEmpty(bText) || TextUtils.isEmpty(cText)) {
                    tvSolutions.setText("Veuillez remplir tous les champs.");
                    return;
                }


                double a = Double.parseDouble(aText);
                double b = Double.parseDouble(bText);
                double c = Double.parseDouble(cText);


                if (a == 0) {
                    tvSolutions.setText("Ce n'est pas une équation quadratique.");
                    return;
                }

                double discriminant = b * b - 4 * a * c;
                DecimalFormat df = new DecimalFormat("#.##");


                if (discriminant > 0) {
                    double root1 = (-b + Math.sqrt(discriminant)) / (2 * a);
                    double root2 = (-b - Math.sqrt(discriminant)) / (2 * a);
                    tvSolutions.setText("Solutions: X1 = " + df.format(root1) + ", X2 = " + df.format(root2));
                } else if (discriminant == 0) {
                    double root = -b / (2 * a);
                    tvSolutions.setText("Solution unique: X = " + df.format(root));
                } else {
                    tvSolutions.setText("Pas de solutions réelles.");
                }
            }
        });


        btnReinitialiser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                etA.setText("");
                etB.setText("");
                etC.setText("");
                tvSolutions.setText("Solutions");
            }
        });
    }
}
