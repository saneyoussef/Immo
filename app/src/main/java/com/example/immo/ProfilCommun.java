package com.example.immo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class ProfilCommun extends AppCompatActivity {

    ImageView image , back ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profil_commun);
        image = (ImageView) findViewById(R.id.edit);
        back = (ImageView) findViewById(R.id.back);

        image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(ProfilCommun.this, ModifierProfilCommun.class);
                startActivity(in);
            }
        });
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ProfilCommun.this , AccPromActivity.class);
                startActivity(intent);
            }
        });

    }
}
