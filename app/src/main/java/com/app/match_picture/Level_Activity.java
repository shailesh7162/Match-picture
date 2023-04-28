package com.app.match_picture;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class Level_Activity extends AppCompatActivity
{
    ImageView infobtn;
    RecyclerView levelRecycal;
    Level_Adpter level_adpter;
    int i=1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level);
        infobtn=findViewById(R.id.infobtn);
        levelRecycal=findViewById(R.id.levelRecycal);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Select level");
        int i=getIntent().getIntExtra("key",0);
        if (i==0)
        {
            getSupportActionBar().setSubtitle("NO TIME LIMIT");

        }

        infobtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }
}