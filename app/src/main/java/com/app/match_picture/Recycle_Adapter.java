package com.app.match_picture;

import android.app.Activity;
import android.app.Dialog;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class Recycle_Adapter extends RecyclerView.Adapter<Recycle_Adapter.ViewHolder>
{
    Activity activity;
    List<Integer> img;
    int click = 1;
    View view1;
    int pos1, pos2;
    int check;

    public Recycle_Adapter(Activity activity,List<Integer> img)
    {
        this.activity=activity;
        this.img=img;
    }

    @NonNull
    @Override
    public Recycle_Adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(activity).inflate(R.layout.recycel_itam,parent,false));

    }

    @Override
    public void onBindViewHolder(@NonNull Recycle_Adapter.ViewHolder holder, int position) {
        holder.img.setImageResource(img.get(position));
        holder.cover.setVisibility(View.INVISIBLE);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                holder.cover.setVisibility(View.VISIBLE);
            }
        }, 4000);

        holder.cover.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (click==1)
                {
                    holder.cover.setVisibility(View.INVISIBLE);
                    click=3;
                    view1=holder.cover;
                    pos1=holder.getAdapterPosition();
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            click = 2;
                        }
                    }, 100);
                }else if (click==2)
                {
                    holder.cover.setVisibility(View.INVISIBLE);
                    click=3;
                    pos2=holder.getAdapterPosition();

                    if (img.get(pos1).equals(img.get(pos2)))
                    {
                        holder.cover.setClickable(false);
                        view1.setClickable(false);
                        click=1;
                        check++;
                        if (check==(img.size()/2))
                        {
                            Dialog dialog=new Dialog(activity);
                            dialog.setCancelable(false);
                            dialog.setContentView(R.layout.win_dialog);

                            Button win_okbtn=dialog.findViewById(R.id.okbtn);
                            win_okbtn.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    dialog.dismiss();
                                    activity.finish();
                                }
                            });
                            dialog.show();
                        }
                    }else
                    {
                        new Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                holder.cover.setVisibility(View.VISIBLE);
                                view1.setVisibility(View.VISIBLE);
                                click = 1;
                            }
                        }, 500);
                    }
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return img.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder
    {
        ImageView img,cover;
        public ViewHolder(View itemViwe) {
            super(itemViwe);
            img=itemViwe.findViewById(R.id.img);
            cover=itemViwe.findViewById(R.id.cover);
        }
    }
}
