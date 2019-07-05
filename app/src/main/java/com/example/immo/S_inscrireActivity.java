package com.example.immo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;


public class S_inscrireActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_s_inscrire);
        getSupportActionBar().hide();

        Button indiv= (Button) findViewById(R.id.indiv_btn);
        Button comp= (Button) findViewById(R.id.comp_btn);

        indiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(S_inscrireActivity.this,Indivi_inscrip.class);
                startActivity(i);
            }
        });
        comp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(S_inscrireActivity.this, Company_inscrip.class);
                startActivity(i);
            }
        });
    }
}
