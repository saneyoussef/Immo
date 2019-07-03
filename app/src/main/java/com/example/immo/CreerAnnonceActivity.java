package com.example.immo;

import android.app.DatePickerDialog;
import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import java.util.Calendar;


public class CreerAnnonceActivity extends AppCompatActivity {


    private static final String TAG = "CreerAnnonceActivity";
    EditText text;
    DatePickerDialog datePickerDialog;
    Spinner spinner;
    Button  bouton2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_creer_annonce);
        text = (EditText) findViewById(R.id.date);
        spinner = (Spinner) findViewById(R.id.spinnerville);
        bouton2 = findViewById(R.id.mybutton);
        bouton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(CreerAnnonceActivity.this, ImagesActivity.class);
                startActivity(i);
            }
        });



        text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar cal = Calendar.getInstance();
                int year = cal.get(Calendar.YEAR);
                int month = cal.get(Calendar.MONTH);
                int day = cal.get(Calendar.DAY_OF_MONTH);
                datePickerDialog = new DatePickerDialog(CreerAnnonceActivity.this,
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                                text.setText(dayOfMonth + "/" + (month + 1) + "/" + year);
                            }
                        }
                        , year, month, day);
                datePickerDialog.show();
            }
        });
        Spinner spinner = findViewById(R.id.pays);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.pays,
                android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        spinner.setAdapter(adapter);

    }



}


