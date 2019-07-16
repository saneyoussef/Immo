package com.example.immo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ViewFlipper;

import androidx.appcompat.app.AppCompatActivity;

public class MonAnnonceActivity extends AppCompatActivity {

    TextView nom ;
     GridView gditems ;
    String[] atout = {"climatisation","espace vert","haut standing","chauffage"};
    int[] atoutcheck ={R.drawable.ic_rowdata, R.drawable.ic_rowdata ,R.drawable.ic_rowdata,
            R.drawable.ic_rowdata};


    private ImageView thumbnail ;
    int photos[] = {R.drawable.image1 , R.drawable.image4 , R.drawable.image3 , R.drawable.image4};
    ViewFlipper viewFlipper ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mon_annonce);

        nom = (TextView) findViewById(R.id.text1);

        thumbnail = (ImageView)findViewById(R.id.bienthumbnail);
        viewFlipper = (ViewFlipper) findViewById(R.id.v_flipper);
        gditems = (GridView) findViewById(R.id.gridview);
        CustomAdapter customAdapter = new CustomAdapter();
        gditems.setAdapter(customAdapter);
        /**
        for(int i=0 ; i < photos.length ;i++){
             flipperImages(photos[i]);
        }*/
        for (int image:photos){
            flipperImages(image);
        }

        Intent intent = getIntent();
        String nomm = intent.getExtras().getString("nom");
        String datee = intent.getExtras().getString("date");
        String prixx = intent.getExtras().getString("prix");
        String villee = intent.getExtras().getString("ville");
        int thumbnaill = intent.getExtras().getInt("thumbnail");

      nom.setText(nomm);
      thumbnail.setImageResource(thumbnaill);

    }
    public void flipperImages(int image){
        ImageView imageView = new ImageView(this);
        imageView.setBackgroundResource(image);
        viewFlipper.addView(imageView);
        viewFlipper.setFlipInterval(4000);
        viewFlipper.setAutoStart(true);
        viewFlipper.setInAnimation(this, android.R.anim.slide_in_left);
        viewFlipper.setOutAnimation(this, android.R.anim.slide_out_right);


    }
    private class CustomAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return photos.length;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View view1 = getLayoutInflater().inflate(R.layout.row_data,null);
            TextView textt = view1.findViewById(R.id.atts);
            ImageView imgg = view1.findViewById(R.id.images);
            textt.setText(atout[position]);
            imgg.setBackgroundResource(atoutcheck[position]);
            imgg.setBackgroundResource(atoutcheck[position]);
            return view1;
        }
    }

}



