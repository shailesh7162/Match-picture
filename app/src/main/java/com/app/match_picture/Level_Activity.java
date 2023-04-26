package com.app.match_picture;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class Level_Activity extends AppCompatActivity
{
    ImageView infobtn;
    RecyclerView levelRecycal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level);
        infobtn=findViewById(R.id.infobtn);
        levelRecycal=findViewById(R.id.levelRecycal);

        infobtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }
}