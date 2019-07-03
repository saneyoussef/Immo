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

public class VoirNoteActivity extends AppCompatActivity {

    ListView list ;
    String titles[] ={"les berges du lac","residance sana" , "les palmiers" , "skanes palace"};
    String notes[] ={"aaaaaaaaaaaaaaaaaaaaaaaaaaaaaa","bbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbb" ,
            "ccccccccccccccccccccccccc" , "iiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiii"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_voir_note);

        list =  findViewById(R.id.list1);
        MyAdapter myAdapter = new MyAdapter(this , titles,notes);
        list.setAdapter(myAdapter);

    }

    class MyAdapter extends ArrayAdapter<String>{
        Context context ;
        String myTitles[];
        String myNotes[];

        MyAdapter(Context c , String[] titles , String[] notes){
            super(c,R.layout.rowlistview,R.id.text1,titles);
            this.context = c ;
            this.myTitles=titles ;
            this.myNotes= notes;
        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            LayoutInflater layoutInflater = (LayoutInflater)getApplicationContext()
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View row = layoutInflater.inflate(R.layout.rowlistview,parent,false);
            TextView textView = row.findViewById(R.id.text1);
            TextView textView2 = row.findViewById(R.id.text2);
            textView.setText(titles[position]);
            textView2.setText(myNotes[position]);
            return row;
        }
    }

}
