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

public class RecyclerViewFavAdapter extends RecyclerView.Adapter<RecyclerViewFavAdapter.MyViewHolder> {

    private Context mcontext ;
    private List<favoris> mData ;

    public RecyclerViewFavAdapter(Context context , List<favoris> list){
        this.mcontext = context ;
        this.mData = list ;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view ;
        LayoutInflater mInflater = LayoutInflater.from(mcontext);
        view = mInflater.inflate(R.layout.item_fav,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {
        holder.nom.setText(mData.get(position).getNom());
        holder.img.setImageResource(mData.get(position).getThumbnail());

        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mcontext,BienActivity.class);
                intent.putExtra("nom",mData.get(position).getNom());
                intent.putExtra("thumbnail",mData.get(position).getThumbnail());
                mcontext.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        TextView nom;
        ImageView img ;
        CardView cardView ;

        public MyViewHolder(View itemView){
            super(itemView);
            nom = (TextView) itemView.findViewById(R.id.text);
            img = (ImageView) itemView.findViewById(R.id.image);
            cardView = (CardView) itemView.findViewById(R.id.carviewfav);
        }

    }


}
