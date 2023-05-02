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
    TextView time;
    Handler handler;
    Runnable runnable;
    int i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        seekBar=findViewById(R.id.seekbar);
        time=findViewById(R.id.time);

        Dialog dialog=new Dialog(Game_Activity.this);
        dialog.setContentView(R.layout.time_in_dialog);
        dialog.setCancelable(false);

        Button gobtn=dialog.findViewById(R.id.gobtn);
        TextView info_title=dialog.findViewById(R.id.info_title);

    }
}
