package com.app.match_picture;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class Level_Adpter extends RecyclerView.Adapter<Level_Adpter.ViewHolder>
{
    Context context;
    String[] number={"1","2","3","4","5","6","7","8","9","10"};
    int i;

    public Level_Adpter(Context context,int i)
    {
        this.context=context;
        this.i=i;
    }

    @NonNull
    @Override
    public Level_Adpter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        return new
         ViewHolder(LayoutInflater.from(context).inflate(R.layout.level_iteam,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull Level_Adpter.ViewHolder holder, int position)
    {
        holder.level_btn.setText("LEVEL"+number[position]);
        holder.level_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(context,Game_Activity.class);
                intent.putExtra("Level_type",i);
                intent.putExtra("pos",(holder.getAdapterPosition()+1));
            }
        });
    }

    @Override
    public int getItemCount() {
        return number.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder
    {
        Button level_btn;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            level_btn=itemView.findViewById(R.id.level_btn);
        }
    }
}
