package com.app.match_picture;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Game_Activity extends AppCompatActivity
{
    RecyclerView recyclerView;
    Recycle_Adapter recycle_adapter;
    SeekBar seekBar;
    TextView time;
    List<Integer> list1=new ArrayList<>();
    List<Integer> list2=new ArrayList<>();
    List<Integer> imglist=new ArrayList<>();
    public  static final int[]IMAGES={R.drawable.a,R.drawable.b,R.drawable.c,R.drawable.d,R.drawable.e,R.drawable.f,R.drawable.g,R.drawable.h,R.drawable.i,R.drawable.j,};
    Handler handler;
    Runnable runnable;
    public static boolean win=false;
    public static boolean plus=false;
    int i,L,max;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        time=findViewById(R.id.time);
        recyclerView=findViewById(R.id.recycle);
        L=getIntent().getIntExtra("pos",0);
        i=getIntent().getIntExtra("level_type",0);

        if (L <= 3) {
            for (int j = 0; j < 12; j++) {
                imglist.add(j);
            }
        } else if (L <= 6) {
            for (int j = 0; j < 16; j++) {
                imglist.add(j);
            }
        } else {
            for (int j = 0; j < 20; j++) {
                imglist.add(j);
            }
        }

        seekBar=findViewById(R.id.seekbar);
        if (i == 1) {
            getSupportActionBar().setTitle("NO TIME LIMIT");
            seekBar.setVisibility(View.GONE);
        } else if (i == 2) {
            getSupportActionBar().setTitle("NORMAL");
            seekBar.setVisibility(View.VISIBLE);
        } else if (i == 3) {
            getSupportActionBar().setTitle("HARD");
            seekBar.setVisibility(View.VISIBLE);
        }

        Dialog dialog=new Dialog(Game_Activity.this);
        dialog.setContentView(R.layout.time_in_dialog);
        dialog.setCancelable(false);

        Button gobtn=dialog.findViewById(R.id.gobtn);
        TextView info_title=dialog.findViewById(R.id.info_title);

        if (i==1)
        {
            info_title.setText("TIME: NO TIME LIMIT");
            time.setText("No time");
        }else if (i==2)
        {
            info_title.setText("TIME: 30 s");
            time.setText("0/30");
        }else if (i==3)
        {
            info_title.setText("TIME:5 s");
            time.setText("0/5");
        }
        gobtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
                while (true)
                {
                    if (L<=3)
                    {
                        int i=new Random().nextInt(IMAGES.length);
                        int j=new Random().nextInt(6);
                        int k=new Random().nextInt(12-6)+6;
                        if (!list1.contains(j) && !list1.contains(k) && !list2.contains(i))
                        {
                            list2.add(i);
                            imglist.set(j,IMAGES[i]);
                            list1.add(j);
                            imglist.set(k,IMAGES[i]);
                            list1.add(k);
                            if (list2.size()>=6)
                            {
                                break;
                            }
                        }
                    }
                    else if(L<=6)
                    {
                        int i=new Random().nextInt(IMAGES.length);
                        int j=new Random().nextInt(8);
                        int k=new Random().nextInt(16-8)+8;
                        if (!list1.contains(j) && !list1.contains(k) && !list2.contains(i))
                        {
                            list2.add(i);
                            imglist.set(j,IMAGES[i]);
                            list1.add(j);
                            imglist.set(k,IMAGES[i]);
                            list1.add(k);
                            if (list2.size()>=8)
                            {
                                break;
                            }
                        }
                    }
                    else
                    {
                        int i=new Random().nextInt(IMAGES.length);
                        int j=new Random().nextInt(10);
                        int k=new Random().nextInt(20-10)+10;
                        if (!list1.contains(j) && !list1.contains(k) && !list2.contains(i))
                        {
                            list2.add(i);
                            imglist.set(j,IMAGES[i]);
                            list1.add(j);
                            imglist.set(k,IMAGES[i]);
                            list1.add(k);
                            if (list2.size()>=10)
                            {
                                break;
                            }
                        }
                    }
                }
                if (L<=3)
                {
                    recycle_adapter=new Recycle_Adapter(Game_Activity.this,imglist);
                    recyclerView.setLayoutManager(new GridLayoutManager(Game_Activity.this,3));
                    recyclerView.setAdapter(recycle_adapter);
                }
                else if (L<=6)
                {
                    recycle_adapter=new Recycle_Adapter(Game_Activity.this,imglist);
                    recyclerView.setLayoutManager(new GridLayoutManager(Game_Activity.this,4));
                    recyclerView.setAdapter(recycle_adapter);
                }
                else
                {
                    recycle_adapter=new Recycle_Adapter(Game_Activity.this,imglist);
                    recyclerView.setLayoutManager(new GridLayoutManager(Game_Activity.this,4));
                    recyclerView.setAdapter(recycle_adapter);
                }
                if (i==2)
                {
                    max=30;
                    seekBar.setMax(max);
                }
                else if (i==3)
                {
                    max=5;
                    seekBar.setMax(max);
                }
                handler=new Handler();
                runnable=new Runnable() {
                    int j=5;
                    int k=-1;
                    @Override
                    public void run() {
                        if (j>0)
                        {
                            j--;
                            seekBar.setProgress(j);
                        }
                        if (j==0 && !win)
                        {
                            k++;
                            if (i==2)
                            {
                                if (k<=max)
                                {
                                    if (plus)
                                    {
                                        plus=false;
                                        max=max+5;
                                        seekBar.setMax(max);
                                    }
                                    time.setText(k + "/" + max);
                                }
                            }
                            else if (i==3)
                            {
                                if (k<=max)
                                {
                                    if (plus)
                                    {
                                        plus=false;
                                        max=max+5;
                                        seekBar.setMax(max);
                                    }
                                    time.setText(k + "/" + max);
                                }
                            }
                            seekBar.setProgress(k);
                        }
                        if (i==2)
                        {
                            if (k==max)
                            {
                                Dialog dialog1=new Dialog(Game_Activity.this);
                                dialog1.setCancelable(false);
                                dialog1.setContentView(R.layout.time_out_dialog);

                                ((Button) dialog1.findViewById(R.id.cancelbtn)).setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View view) {
                                        dialog1.dismiss();
                                        finish();
                                    }
                                });
                                ((Button) dialog1.findViewById(R.id.okbtn)).setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View view) {
                                        dialog1.dismiss();
                                        recreate();
                                    }
                                });
                                if (!isFinishing() && !win) {
                                    dialog1.show();
                                }
                            }
                        }
                        handler.postDelayed(this::run, 1000);
                    }
                };
                handler.post(runnable);
            }
        });
        dialog.show();

    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            this.finish();
        }

        return true;
    }
}
