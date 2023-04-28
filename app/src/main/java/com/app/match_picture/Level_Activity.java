package com.app.match_picture;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
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
        if (i==1)
        {
            getSupportActionBar().setSubtitle("NO TIME LIMIT");
            levelRecycal.setLayoutManager(new LinearLayoutManager(Level_Activity.this));
            level_adpter=new Level_Adpter(Level_Activity.this,1);
            levelRecycal.setAdapter(level_adpter);
        }
       else if (i==2)
        {
            getSupportActionBar().setSubtitle("NORMAL");
            levelRecycal.setLayoutManager(new LinearLayoutManager(Level_Activity.this));
            level_adpter=new Level_Adpter(Level_Activity.this,2);
            levelRecycal.setAdapter(level_adpter);
        }
        else if (i==3)
        {
            getSupportActionBar().setSubtitle("HARD");
            levelRecycal.setLayoutManager(new LinearLayoutManager(Level_Activity.this));
            level_adpter=new Level_Adpter(Level_Activity.this,3);
            levelRecycal.setAdapter(level_adpter);
        }

    }
}