package com.example.immo;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.view.MenuItem;

import com.example.immo.AcceuilActivity;
import com.example.immo.FavorisActivity;
import com.example.immo.MessagesActivity;
import com.example.immo.ProfileActivity;
import com.example.immo.R;

class BottomNavigationViewHelpar {
    private static final String TAG="BottomNavigationViewHelper" ;

    public static void enableNavigation(final Context context , BottomNavigationView view){
        view.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case  R.id.navigation_home :
                        Intent intent1 = new Intent(context , AcceuilActivity.class);
                        context.startActivity(intent1);
                        break;
                    case R.id.navigation_fav :
                        Intent intent2 = new Intent(context , FavorisActivity.class);
                        context.startActivity(intent2);
                        break;
                    case R.id.navigation_inbox :
                        Intent intent3 = new Intent(context , MessagesActivity.class);
                        context.startActivity(intent3);
                        break;
                    case R.id.navigation_profil :
                        Intent intent4 = new Intent(context , ProfileActivity.class);
                        context.startActivity(intent4);
                        break;
                }
                return false;
            }
        });
    }
}
