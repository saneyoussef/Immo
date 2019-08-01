package com.example.immo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class AccPromActivity extends AppCompatActivity {

    CardView messages, creer , mesannonce , favs , infoagence ;
    ImageView image ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acc_prom);
        messages = (CardView) findViewById(R.id.messages);
        infoagence = (CardView) findViewById(R.id.infoagence);
        creer = findViewById(R.id.creerannonce);
        mesannonce = findViewById(R.id.mesannonce);
        favs = findViewById(R.id.favs);
        image = (ImageView) findViewById(R.id.profil);

        messages.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AccPromActivity.this ,MessagesActivity.class);
                startActivity(intent);
            }
        });
        creer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AccPromActivity.this ,CreerAnnonceActivity.class);
                startActivity(intent);
            }
        });
        image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AccPromActivity.this , ProfilCommun.class);
                startActivity(intent);
            }
        });
        infoagence.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AccPromActivity.this , EntrepriseActivity.class);
                startActivity(intent);
            }
        });


    }
}
