package com.example.immo;

import android.content.Context;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.example.immo.BottomNavigationViewHelpar;


public class MessagesActivity extends AppCompatActivity {

    private  static final String TAG = "Message";
    private static final int ACTIVITY_NUM = 2;
    private Context mcontext = MessagesActivity.this ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_messages);
        Log.d(TAG,"onCreate: started!");
        setupBottonNavigationView();

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
