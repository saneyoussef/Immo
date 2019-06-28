package com.example.immo;


import android.content.Context;
import android.content.Intent;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.TextView;

import com.example.immo.BottomNavigationViewHelpar;

import java.util.ArrayList;


public class AcceuilActivity extends AppCompatActivity {

    private  static final String TAG = "HomeActivity";
    private static final int ACTIVITY_NUM = 0;
    private Context mcontext = AcceuilActivity.this ;

    private GridView gridView;
    private GridViewAdapter gridAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acceuil);
        getSupportActionBar().hide();
        Log.d(TAG , "onCreate : starting.");
        setupBottonNavigationView();

        gridView = (GridView) findViewById(R.id.gridView);
        gridAdapter = new GridViewAdapter(this, R.layout.grid_item_layout, getData());
        gridView.setAdapter(gridAdapter);


            }




    private ArrayList<ImageItem> getData(){
        final ArrayList<ImageItem> imageItems = new ArrayList<>();
        TypedArray imgs = getResources().obtainTypedArray(R.array.random_imgs);
        for (int i = 0; i < imgs.length(); i++) {
            BitmapFactory.Options options=new BitmapFactory.Options();
            options.inSampleSize = 8;
            Bitmap bitmap = (Bitmap) BitmapFactory.decodeResource(getResources(),imgs.getResourceId(i,-1));


            //Bitmap bitmap = BitmapFactory.decodeResource(getResources(), imgs.getResourceId(i, -1));
            imageItems.add(new ImageItem(bitmap, "Image#" + i));
        }
        return imageItems;

    }

    private void setupBottonNavigationView(){
        Log.d(TAG , "setupBottonNavigationView: setting up BottomNavigationView");
        BottomNavigationView bottomNavigationView =(BottomNavigationView) findViewById(R.id.bottomNavViewBar);
        BottomNavigationViewHelpar.enableNavigation(mcontext , bottomNavigationView);
        Menu menu = bottomNavigationView.getMenu();
        MenuItem menuItem = menu.getItem(ACTIVITY_NUM);
        menuItem.setChecked(true);
    }


    public void perform_action(View v){
        TextView tv= (TextView) findViewById(R.id.text_view);
        Intent i=new Intent(AcceuilActivity.this,SearchActivity.class);
        startActivity(i);
    }


}
