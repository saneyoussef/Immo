package com.example.immo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class EntrepriseActivity extends AppCompatActivity {

    ImageView image , back ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_entreprise);
        image = (ImageView) findViewById(R.id.edite);
        back =(ImageView)findViewById(R.id.backk);
        image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(EntrepriseActivity.this , EditInfoAgenceActivity.class);
                startActivity(intent);
            }
        });
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(EntrepriseActivity.this , AccPromActivity.class);
                startActivity(intent);
            }
        });

    }
}
