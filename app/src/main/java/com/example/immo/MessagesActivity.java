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
    ListView liste ;
    String esemi[] ={"Kalboussi ilef","Youssef sana" , "Bouaouina ahmed" , "Drira yasmine"};
    String messaget[] ={"arf azert afkbe sdfkvzs","bbbbbbbb bbbbbbbbbb bbbbbbbbbbbbbb" ,
            "cccccccc cccccccccc ccccccc" , "iiiiiiiiiiiiiiiiiii iiiiiiiii iiiiiiiiii"};

    private  static final String TAG = "Message";
    private static final int ACTIVITY_NUM = 2;
    private Context mcontext = MessagesActivity.this ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_messages);
        Log.d(TAG,"onCreate: started!");
        setupBottonNavigationView();
        liste =  findViewById(R.id.listmessage);
        MyAdapter myAdapter = new MyAdapter(this , esemi,messaget);
        liste.setAdapter(myAdapter);

        }
    class MyAdapter extends ArrayAdapter<String> {
        Context context ;
        String mesnom[];
        String mesmess[];

        MyAdapter(Context c , String[] esemi , String[] messaget){
            super(c,R.layout.rowlistmessage,R.id.esm,esemi);
            this.context = c ;
            this.mesnom=esemi ;
            this.mesmess= messaget;
        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            LayoutInflater layoutInflater = (LayoutInflater)getApplicationContext()
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View row = layoutInflater.inflate(R.layout.rowlistmessage,parent,false);
            TextView textView = row.findViewById(R.id.esm);
            TextView textView2 = row.findViewById(R.id.message);
            textView.setText(esemi[position]);
            textView2.setText(messaget[position]);
            return row;
        }
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
