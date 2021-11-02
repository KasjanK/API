package com.example.loginapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class DataForm extends AppCompatActivity {
    public static final String EXTRA_NAME = "com.example.loginapp.EXTRA_NAME";
    public static final String EXTRA_LENGTH = "com.example.loginapp.EXTRA_LENGTH";
    public static final String EXTRA_AGE = "com.example.loginapp.EXTRA_AGE";
    public static final String EXTRA_WAGE = "com.example.loginapp.EXTRA_WAGE";
    public static final String EXTRA_LETTER = "com.example.loginapp.EXTRA_LETTER";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_form);
        Button sendBtn = findViewById(R.id.sendBtn);

        TextView name = findViewById(R.id.name);
        TextView length = findViewById(R.id.length);
        TextView age = findViewById(R.id.age);
        TextView wage = findViewById(R.id.wage);
        TextView letter = findViewById(R.id.letter);

        sendBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                if (!name.getText().toString().equals("") && !length.getText().toString().equals("") && !age.getText().toString().equals("") && !wage.getText().toString().equals("") && !letter.getText().toString().equals("")) {
                    Toast.makeText(DataForm.this, "Welcome, " + name.getText().toString(), Toast.LENGTH_LONG).show();
                    activity3();
                } else {
                    Toast.makeText(DataForm.this, "please fill in all criteria", Toast.LENGTH_SHORT).show();
                }
            }

        });
    }
    public void activity3() {
        EditText name = (EditText) findViewById(R.id.name);
        String strName = name.getText().toString();
        EditText length = (EditText) findViewById(R.id.length);
        float fLength = Float.parseFloat(length.getText().toString());
        EditText age = (EditText) findViewById(R.id.age);
        int iAge = Integer.parseInt(age.getText().toString());
        EditText wage = (EditText) findViewById(R.id.wage);
        double dWage = Double.parseDouble(wage.getText().toString());
        EditText letter = (EditText) findViewById(R.id.letter);
        String strLetter = letter.getText().toString();

        Intent intent = new Intent(this, ShowData.class);
        intent.putExtra(EXTRA_NAME, strName);
        intent.putExtra(EXTRA_LENGTH, fLength);
        intent.putExtra(EXTRA_AGE, iAge);
        intent.putExtra(EXTRA_WAGE, dWage);
        intent.putExtra(EXTRA_LETTER, strLetter);
        startActivity(intent);
    }
}