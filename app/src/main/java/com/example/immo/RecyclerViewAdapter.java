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

import com.example.immo.Models.AnnonceResponse;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {

    private Context mcontext ;
    private List<AnnonceResponse> mData ;

    public RecyclerViewAdapter(Context context , List<AnnonceResponse> list){
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
        holder.type.setText(mData.get(position).getCategory().toString());
        holder.date.setText(mData.get(position).getDateDeLivraison().toString());
        holder.location.setText(mData.get(position).getLocation().getVille());
        holder.rating.setText(Integer.toString(mData.get(position).getRating()));
        holder.img.setImageResource(R.drawable.image1);


        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mcontext,BienActivity.class);
                intent.putExtra("nom",mData.get(position).getCategory());
                intent.putExtra("date",mData.get(position).getDateDeLivraison());
                intent.putExtra("location",mData.get(position).getLocation().getVille());
                intent.putExtra("rating",mData.get(position).getRating());
                //intent.putExtra("thumbnail",mData.get(position).getThumbnail());
                mcontext.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        TextView rating;
        TextView type ;
        TextView location ;
        TextView date ;
        ImageView img ;
        CardView cardView ;

        public MyViewHolder(View itemView){
            super(itemView);
            type = (TextView) itemView.findViewById(R.id.typeImmo);
            date = (TextView) itemView.findViewById(R.id.livraison);
            location = (TextView) itemView.findViewById(R.id.localisation);
            rating = (TextView) itemView.findViewById(R.id.rating);
            img = (ImageView) itemView.findViewById(R.id.imagebien);
            cardView = (CardView) itemView.findViewById(R.id.cardviewid);
        }

    }


}
