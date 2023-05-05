package com.app.match_picture;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class Game_Activity extends AppCompatActivity
{
    RecyclerView recyclerView;
    Recycle_Adapter recycle_adapter;
    SeekBar seekBar;
    List<Integer> list1=new ArrayList<>();
    List<Integer> list2=new ArrayList<>();
    List<Integer> imglist=new ArrayList<>();
    public static final int[] IMAGE={R.drawable.a,R.drawable.b,R.drawable.c,R.drawable.d,R.drawable.e,R.drawable.f,R.drawable.g,R.drawable.h,R.drawable.i,R.drawable.j};
    TextView time;
    Handler handler;
    Runnable runnable;
    int i,l;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        time = findViewById(R.id.time);
        recyclerView = findViewById(R.id.recycal);
        l=getIntent().getIntExtra("pos",0);
        i=getIntent().getIntExtra("level_type",0);

        if (l<=3) {
            for (int j = 0; j < 12; j++) {
                imglist.add(j);
            }
        }
        else if (l<=6)
        {
            for (int j=0;j<16;j++)
            {
                imglist.add(j);
            }
        }else {
            for (int j=0;j<20;j++)
            {
                imglist.add(j);
            }
        }

        seekBar=findViewById(R.id.seekbar);
        if (i==1)
        {
            getSupportActionBar().setTitle("NO TIME LIMIT");
            seekBar.setVisibility(View.GONE);
        } else if (i==2)
        {
            getSupportActionBar().setTitle("NORMAL");
            seekBar.setVisibility(View.VISIBLE);
        }else if(i==3)
        {
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
            info_title.setText("TIME:NO TIME LIMIT");
            info_title.setText("NO TIME");
        } else if (i==2) {
            info_title.setText("TIME:30 s");
            info_title.setText("0/30");
        } else if (i==3) {
            info_title.setText("TIME:5 s");
            info_title.setText("0/5");
        }
        gobtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });

    }
}
