package com.example.immo;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

public class company_inscrip extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_company_inscrip);
        getSupportActionBar().hide();
        Spinner dropdown = (Spinner) findViewById(R.id.spinner1);
        String[] items= new String[]{"Promoteeur immobilier","Agence immobiliére"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,android.R.layout.simple_spinner_dropdown_item, items);
        dropdown.setAdapter(adapter);

        TextView t1=(TextView) findViewById(R.id.details1);
        t1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i= new Intent(company_inscrip.this,DetailsBasicActivity.class);
                startActivity(i);
            }
        });
        TextView t2= (TextView) findViewById(R.id.details2);
        t2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i= new Intent(company_inscrip.this,DetailsGoldActivity.class);
                startActivity(i);
            }
        });
        TextView t3=(TextView) findViewById(R.id.details3);
        t3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i= new Intent(company_inscrip.this,DetailsPartnerActivity.class);
                startActivity(i);
            }
        });
    }
}
