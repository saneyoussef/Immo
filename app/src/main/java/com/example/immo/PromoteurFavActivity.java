package com.example.immo;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class PromoteurFavActivity extends AppCompatActivity {

    ListView listt ;
    String noms[] ={"Kalboussi ilef","Youssef sana" , "Bouaouina ahmed" , "Drira yasmine"};
    String compagnie[] ={"les kalboussi","les youssef" ,
            " laaayoun" , "lesdrira"};
    int imgs[] ={R.drawable.profile, R.drawable.villa,R.drawable.login , R.drawable.villa};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_promoteur_fav);
        listt =  findViewById(R.id.list2);
        MyAdapter myAdapter = new MyAdapter(this , noms,imgs,compagnie);
        listt.setAdapter(myAdapter);
    }

    class MyAdapter extends ArrayAdapter<String> {
        Context context ;
        String mesnoms[];
        String mescomp[];
        int imges[];

        MyAdapter(Context c , String[] nom , int[] image , String[] compagnie){
            super(c,R.layout.rowlistview,R.id.text2,noms);
            this.context = c ;
            this.imges = image ;
            this.mesnoms=nom ;
            this.mescomp= compagnie;
        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            LayoutInflater layoutInflater = (LayoutInflater)getApplicationContext()
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View row = layoutInflater.inflate(R.layout.rowprom,parent,false);
            TextView textView = row.findViewById(R.id.textt1);
            TextView textView2 = row.findViewById(R.id.textt2);
            ImageView imageView = row.findViewById(R.id.imagee);
            textView.setText(noms[position]);
            textView2.setText(compagnie[position]);
            imageView.setImageResource(imgs[position]);
            return row;
        }
    }

}
