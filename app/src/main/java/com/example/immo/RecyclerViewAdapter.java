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

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {

    private Context mcontext ;
    private List<bien> mData ;

    public RecyclerViewAdapter(Context context , List<bien> list){
        this.mcontext = context ;
        this.mData = list ;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view ;
        LayoutInflater mInflater = LayoutInflater.from(mcontext);
        view = mInflater.inflate(R.layout.cardview_item,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {
        holder.nom.setText(mData.get(position).getNom());
        holder.date.setText(mData.get(position).getDatee());
        holder.prix.setText(mData.get(position).getPrice());
        holder.ville.setText(mData.get(position).getVillee());
        holder.img.setImageResource(mData.get(position).getThumbnail());

        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mcontext,BienActivity.class);
                intent.putExtra("nom",mData.get(position).getNom());
                intent.putExtra("date",mData.get(position).getDatee());
                intent.putExtra("prix",mData.get(position).getPrice());
                intent.putExtra("ville",mData.get(position).getVillee());
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
        TextView date ;
        TextView prix ;
        TextView ville ;
        ImageView img ;
        CardView cardView ;

        public MyViewHolder(View itemView){
            super(itemView);
            nom = (TextView) itemView.findViewById(R.id.nompduprojet);
            date = (TextView) itemView.findViewById(R.id.date);
            prix = (TextView) itemView.findViewById(R.id.prix);
            ville = (TextView) itemView.findViewById(R.id.ville);
            img = (ImageView) itemView.findViewById(R.id.imagebien);
            cardView = (CardView) itemView.findViewById(R.id.cardviewid);
        }

    }


}
