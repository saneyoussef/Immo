package com.example.immo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class CustomAdapter extends BaseAdapter {
    Context c ;
    ArrayList<Spaceraft> spacerafts ;

    public CustomAdapter ( Context c , ArrayList<Spaceraft> spacerafts){
        this.c = c ;
        this.spacerafts = spacerafts ;
    }

    @Override
    public int getCount() {
        return spacerafts.size();
    }

    @Override
    public Object getItem(int position) {
        return spacerafts.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null){
            convertView = LayoutInflater.from(c).inflate(R.layout.model,parent,false);
        }
        final Spaceraft s = (Spaceraft) this.getItem(position);
        ImageView im = (ImageView) convertView.findViewById(R.id.imagee);
        Picasso.with(c).load(s.getUri()).placeholder(R.drawable.placeholder).into(im);
        return convertView;
    }
}
