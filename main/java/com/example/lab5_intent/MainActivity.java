package com.example.lab5_intent;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

    EditText name, pass;
    Button submit;
    CheckBox check;
    Snackbar snackbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name= (EditText) findViewById(R.id.name);
        pass=(EditText) findViewById(R.id.pass);
        submit=(Button) findViewById(R.id.submit);
        check=(CheckBox) findViewById(R.id.checkbox);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    if(!name.getText().toString().isEmpty() && !pass.getText().toString().isEmpty())
                    {
                        Boolean checkBoxState = check.isChecked();
                        if (checkBoxState){
                        String forwel=name.getText().toString();
                        Toast.makeText(MainActivity.this, "Welcome, "+forwel, Toast.LENGTH_LONG).show();
                        Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                        intent.putExtra("keyname", forwel);
                        startActivity(intent);
                        }
                        else{

                            snackbar.make(findViewById(android.R.id.content),"Click the terms and conditions.",Snackbar.LENGTH_LONG).show();

                        }
                    }
                    else {
                        Toast.makeText(MainActivity.this, "Enter all details.", Toast.LENGTH_SHORT).show();
                    }
                }
        });
    }


}