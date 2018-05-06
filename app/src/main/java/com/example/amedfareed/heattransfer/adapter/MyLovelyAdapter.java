package com.example.amedfareed.heattransfer.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.amedfareed.heattransfer.DetailsActivity;
import com.example.amedfareed.heattransfer.R;
import com.example.amedfareed.heattransfer.model.Heat;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by amedfareed on 04/05/18.
 */

public class MyLovelyAdapter extends RecyclerView.Adapter<MyLovelyAdapter.MyViewHolder> {

    private List<Heat> heatList;
    private Context context;

    public MyLovelyAdapter(Context context, List<Heat> heatList) {
        this.context = context;
        this.heatList = heatList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.nameTextView.setText(heatList.get(position).getName());
        holder.descTextView.setText(heatList.get(position).getDesc());
        Picasso.with(context)
                .load(heatList.get(position).getImageId())
                .resize(512, 512)
                .into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return heatList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView nameTextView, descTextView;
        ImageView imageView;

        public MyViewHolder(final View itemView) {
            super(itemView);
            nameTextView = itemView.findViewById(R.id.name_tv);
            descTextView = itemView.findViewById(R.id.desc_tv);
            imageView = itemView.findViewById(R.id.heat_poster);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();
                    if(position != RecyclerView.NO_POSITION){
                        Intent intent = new Intent(context, DetailsActivity.class);
                        intent.putExtra("Heat_kind", heatList.get(position).getName());
                        intent.putExtra("heat_desc",heatList.get(position).getDesc());
                        intent.putExtra("image_id", heatList.get(position).getImageId());
                        intent.putExtra("desc_text", heatList.get(position).getDesc());
                        intent.putExtra("explain_text", heatList.get(position).getExplain());
                        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        context.startActivity(intent);
                    }
                }
            });

        }
    }
}
