package com.example.immo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class EditInfoAgenceActivity extends AppCompatActivity {

    ImageView back , confirm ;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_info_agence);
        back = (ImageView) findViewById(R.id.baack);
        confirm = (ImageView) findViewById(R.id.confirm);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(EditInfoAgenceActivity.this , EntrepriseActivity.class);
                startActivity(intent);
            }
        });
        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(EditInfoAgenceActivity.this , EntrepriseActivity.class);
                startActivity(intent);
            }
        });

    }
}
