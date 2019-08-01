package com.example.immo.Service;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.immo.Messageitem;
import com.example.immo.MessagesActivity;
import com.example.immo.MessangerInterface;
import com.example.immo.R;

import java.util.List;

public class MessagesAdapter extends RecyclerView.Adapter<MessagesAdapter.MessageHolder> {

    Context context ;
    List<Messageitem> mData ;

    public MessagesAdapter(Context context, List<Messageitem> mData) {
        this.context = context;
        this.mData = mData;
    }

    @NonNull
    @Override
    public MessageHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View layout ;
        layout = LayoutInflater.from(context).inflate(R.layout.message_item,parent,false);
        return  new MessageHolder(layout);

    }

    @Override
    public void onBindViewHolder(@NonNull MessageHolder holder, int position) {
        holder.promoteurimage.setImageResource(mData.get(position).getPromphoto());
        holder.prom.setText(mData.get(position).getName());
        holder.textt.setText(mData.get(position).getText());
        holder.date.setText(mData.get(position).getDate());
        holder.relative.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, MessangerInterface.class);
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return mData.size();
    }


    public class MessageHolder extends RecyclerView.ViewHolder{

        TextView textt,date,prom ;
        ImageView promoteurimage ;
        RelativeLayout relative ;

        public MessageHolder(@NonNull View itemView) {
            super(itemView);
            textt = itemView.findViewById(R.id.textt);
            date = itemView.findViewById(R.id.date);
            prom = itemView.findViewById(R.id.prom);
            promoteurimage = itemView.findViewById(R.id.promoteurimage);
            relative = itemView.findViewById(R.id.rellayout);

        }
    }
}
