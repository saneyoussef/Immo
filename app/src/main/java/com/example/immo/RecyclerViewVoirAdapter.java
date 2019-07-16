package com.example.immo;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RecyclerViewVoirAdapter extends RecyclerView.Adapter<RecyclerViewVoirAdapter.MyViewHolder> {

    private Context mcontext ;
    private List<voirmesannonces> mDataa ;

    public RecyclerViewVoirAdapter(Context context , List<voirmesannonces> list){
        this.mcontext = context ;
        this.mDataa = list ;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view ;
        LayoutInflater mInflater = LayoutInflater.from(mcontext);
        view = mInflater.inflate(R.layout.item_voirannonce,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {
        holder.nom.setText(mDataa.get(position).getNom());
        holder.img.setImageResource(mDataa.get(position).getThumbnail());

        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mcontext,MonAnnonceActivity.class);
                intent.putExtra("nom",mDataa.get(position).getNom());
                intent.putExtra("thumbnail",mDataa.get(position).getThumbnail());
                mcontext.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mDataa.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        TextView nom;
        ImageView img ;
        CardView cardView ;

        public MyViewHolder(View itemView){
            super(itemView);
            nom = (TextView) itemView.findViewById(R.id.montext);
            img = (ImageView) itemView.findViewById(R.id.monimage);
            cardView = (CardView) itemView.findViewById(R.id.carviewvoir);
        }

    }


}
