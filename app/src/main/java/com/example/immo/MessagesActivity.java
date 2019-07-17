package com.example.immo;

import android.content.Context;

import com.example.immo.Service.MessagesAdapter;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;


public class MessagesActivity extends AppCompatActivity {

    MessagesAdapter messagesAdapter ;
    List<Messageitem> mData ;
    TextView textView ;
    RecyclerView rv ;

    private  static final String TAG = "Message";
    private static final int ACTIVITY_NUM = 2;
    private Context mcontext = MessagesActivity.this ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_messages);
        Log.d(TAG,"onCreate: started!");
        setupBottonNavigationView();
        textView = (TextView) findViewById(R.id.textview);
        rv = (RecyclerView) findViewById(R.id.messagesrecycler);
        mData = new ArrayList<>();
        mData.add(new Messageitem("anna conda","je serais disponible le lundi","dim",R.drawable.photo1));
        mData.add(new Messageitem("james bolton","rendez_vous confirmé pour le 13/08","dim",R.drawable.ahmed));
        mData.add(new Messageitem("arslen dos","passez une bonne journée","dim",R.drawable.photo));

        messagesAdapter = new MessagesAdapter(this,mData);
        rv.setAdapter(messagesAdapter);
        rv.setLayoutManager(new LinearLayoutManager(this));

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
