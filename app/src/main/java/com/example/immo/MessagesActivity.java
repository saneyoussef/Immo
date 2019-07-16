package com.example.immo;

import android.content.Context;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;


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
