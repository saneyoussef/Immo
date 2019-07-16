package com.example.immo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class VoirannonceActivity extends AppCompatActivity {
    List<voirmesannonces> ls;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_voirannonce);
        getSupportActionBar().hide();
        ls = new ArrayList<>();
        ls.add(new voirmesannonces("les oliviers", R.drawable.image1));
        ls.add(new voirmesannonces("berbes des champs", R.drawable.image3));
        ls.add(new voirmesannonces("les champs", R.drawable.image4));
        ls.add(new voirmesannonces("les trois m", R.drawable.image1));
        ls.add(new voirmesannonces("Inferno", R.drawable.image3));
        ls.add(new voirmesannonces("paradice", R.drawable.image1));
        ls.add(new voirmesannonces("montécalo dram", R.drawable.image4));
        ls.add(new voirmesannonces("lueur d'espoir", R.drawable.image1));

        RecyclerView myrv = (RecyclerView) findViewById(R.id.recyclerviewvoir);
        RecyclerViewVoirAdapter myAdapter = new RecyclerViewVoirAdapter(this,ls);
        myrv.setLayoutManager(new GridLayoutManager(this,1));
        myrv.setAdapter(myAdapter);


    }
}
