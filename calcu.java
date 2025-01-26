package com.example.nihel;


import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class calcu extends AppCompatActivity implements View.OnClickListener {

   Button btadd , btsub , btmult , btdiv ;
   EditText nbr1,nbr2;
   TextView textView;
   int num1 , num2;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_calcu);

        btadd = findViewById(R.id.addi);
        btsub = findViewById(R.id.sub);
        btmult = findViewById(R.id.mult);
        btdiv = findViewById(R.id.div);
        nbr1 = findViewById(R.id.number1);
        nbr2 = findViewById(R.id.number2);
        textView = findViewById(R.id.result);

        btadd.setOnClickListener(this);
        btsub.setOnClickListener(this);
        btmult.setOnClickListener(this);
        btdiv.setOnClickListener(this);

    }

    public int getIntFromEditText(EditText editText){
        if (editText.getText().toString().equals("")){
            Toast.makeText(this, "enter the number",Toast.LENGTH_SHORT).show();
            return 0;
        } else
        return Integer.parseInt(editText.getText().toString());
    }


    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View v) {
       num1 = getIntFromEditText(nbr1);
       num2 = getIntFromEditText(nbr2);

        Thread view = null;
        switch (view.getId()){
           case R.id.addi:
               textView.setText("result = " +(num1 + num2));
               break;
           case R.id.sub:
               textView.setText("result = " +(num1 - num2));
               break;
           case R.id.mult:
               textView.setText("result = " +(num1 * num2));
               break;
           case R.id.div:
               textView.setText("result = " +((float)num1 / (float) num2));
               break;
       }
    }
}
