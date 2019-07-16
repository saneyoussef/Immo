package com.example.immo;


import android.content.Context;
import android.content.Intent;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;


public class AcceuilActivity extends AppCompatActivity {

    List<bien> lsBien;

    private  static final String TAG = "HomeActivity";
    private static final int ACTIVITY_NUM = 0;
    private Context mcontext = AcceuilActivity.this ;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acceuil);
        getSupportActionBar().hide();
        Log.d(TAG , "onCreate : starting.");
        setupBottonNavigationView();
        lsBien = new ArrayList<>();
        lsBien.add(new bien("les oliviers","03/2020","9590DT","Tunis",
                R.drawable.image1));
        lsBien.add(new bien("berbes des champs","08/2022","100000DT","Monastir",
                R.drawable.image3));
        lsBien.add(new bien("les champs","01/2023","80900DT","Sousse",
                R.drawable.image4));
        lsBien.add(new bien("les trois m","05/2025","70920DT","Mahdia",
                R.drawable.image1));
        lsBien.add(new bien("Inferno","12/2023","99888DT","Gabes",
                R.drawable.image3));
        lsBien.add(new bien("paradice","07/2026","1000000DT","Sidibouzid",
                R.drawable.image1));
        lsBien.add(new bien("montécalo dram","09/2029","700500DT","Ariana",
                R.drawable.image4));
        lsBien.add(new bien("lueur d'espoir","09/2021","200500DT","Sfax",
                R.drawable.image1));

        RecyclerView myrv = (RecyclerView) findViewById(R.id.recyclerviewid);
        RecyclerViewAdapter myAdapter = new RecyclerViewAdapter(this,lsBien);
        myrv.setLayoutManager(new GridLayoutManager(this,2));
        myrv.setAdapter(myAdapter);
}

/**

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

    }**/

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
