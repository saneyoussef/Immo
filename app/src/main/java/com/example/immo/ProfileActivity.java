package com.example.immo;

import android.content.Context;
import android.content.Intent;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;


public class ProfileActivity extends AppCompatActivity {

    TextView create , note , prom , voir;
    private  static final String TAG = "Profile";
    private static final int ACTIVITY_NUM = 3;
    private Context mcontext = ProfileActivity.this ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        Log.d(TAG,"onCreate: started!");
        setupBottonNavigationView();
        voir = (TextView) findViewById(R.id.voirannonce);
        prom = (TextView) findViewById(R.id.promoteur);
        note = (TextView) findViewById(R.id.notee);
        create = (TextView) findViewById(R.id.creerannonce);
        create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ProfileActivity.this,CreerAnnonceActivity.class);
                startActivity(intent);
            }
        });
        note.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ProfileActivity.this,VoirNoteActivity.class);
                startActivity(intent);
            }
        });
        prom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ProfileActivity.this,PromoteurFavActivity.class);
                startActivity(intent);
            }
        });
        voir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ProfileActivity.this,VoirannonceActivity.class);
                startActivity(intent);
            }
        });

    }


    private void setupBottonNavigationView(){
        Log.d(TAG , "setupBottonNavigationView: setting up BottomNavigationView");
        BottomNavigationView bottomNavigationView =(BottomNavigationView) findViewById(R.id.bottomNavViewBar);
        BottomNavigationViewHelpar.enableNavigation(mcontext , bottomNavigationView);
        Menu menu = bottomNavigationView.getMenu();
        MenuItem menuItem = menu.getItem(ACTIVITY_NUM);
        menuItem.setChecked(true);
    }

}
