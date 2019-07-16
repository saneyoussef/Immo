package com.example.immo;

import android.content.Context;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;


public class FavorisActivity extends AppCompatActivity {

    List<favoris> lsfav;

    private  static final String TAG = "Favoris";
    private static final int ACTIVITY_NUM = 1;
    private Context mcontext = FavorisActivity.this ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favoris);
        getSupportActionBar().hide();
        Log.d(TAG , "onCreate : starting.");
        setupBottonNavigationView();
        lsfav = new ArrayList<>();
        lsfav.add(new favoris("les oliviers", R.drawable.image1));
        lsfav.add(new favoris("berbes des champs", R.drawable.image3));
        lsfav.add(new favoris("les champs", R.drawable.image4));
        lsfav.add(new favoris("les trois m", R.drawable.image1));
        lsfav.add(new favoris("Inferno", R.drawable.image3));
        lsfav.add(new favoris("paradice", R.drawable.image1));
        lsfav.add(new favoris("montécalo dram", R.drawable.image4));
        lsfav.add(new favoris("lueur d'espoir", R.drawable.image1));
        RecyclerView myrv = (RecyclerView) findViewById(R.id.recyclerviewfav);
        RecyclerViewFavAdapter myAdapter = new RecyclerViewFavAdapter(this,lsfav);
        myrv.setLayoutManager(new GridLayoutManager(this,1));
        myrv.setAdapter(myAdapter);
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
