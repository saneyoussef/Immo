package com.example.immo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class ModifierProfilCommun extends AppCompatActivity {

    ImageView back , ok ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modifier_profil_commun);
        back = (ImageView) findViewById(R.id.backbb);
        ok = (ImageView) findViewById(R.id.okbb);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ModifierProfilCommun.this , ProfilCommun.class);
                startActivity(intent);
            }
        });
        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ModifierProfilCommun.this , ProfilCommun.class);
                startActivity(intent);
            }
        });
    }
}
