package com.app.match_picture;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class Game_Activity extends AppCompatActivity
{
    RecyclerView recyclerView;
    Recycle_Adapter recycle_adapter;
    SeekBar seekBar;
    TextView time;
    List<Integer> list1=new ArrayList<>();
    List<Integer> list2=new ArrayList<>();
    List<Integer> imglist=new ArrayList<>();
    Handler handler;
    Runnable runnable;
    int i,l,max;
    public static final int[] IMAGES={R.drawable.a,R.drawable.b,R.drawable.c,R.drawable.d,R.drawable.e,R.drawable.f,R.drawable.g,R.drawable.h,R.drawable.i,R.drawable.j};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        time = findViewById(R.id.time);
        recyclerView = findViewById(R.id.recycal);

        l = getIntent().getIntExtra("pos", 0);
        i = getIntent().getIntExtra("level_type", 0);

        if (l <= 3) {
            for (int j = 0; j < 12; j++) {
                imglist.add(j);
            }
        } else if (l <= 6) {
            for (int j = 0; j < 16; j++) {
                imglist.add(j);
            }
        } else {
            for (int j = 0; j < 20; j++) {
                imglist.add(j);
            }
        }

        seekBar = findViewById(R.id.seekbar );

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



    }
}
