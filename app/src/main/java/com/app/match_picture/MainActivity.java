package com.app.match_picture;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity
{
    Button noTimeModeBtn,normalModBtn,hardModeBtn;
    int i=1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        noTimeModeBtn=findViewById(R.id.noTimeModebtn);
        normalModBtn=findViewById(R.id.normalModebtn);
        hardModeBtn=findViewById(R.id.hardModebtn);

        noTimeModeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,Level_Activity.class);
                intent.putExtra("key",1);
                startActivity(intent);
            }
        });
        normalModBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,Level_Activity.class);
                intent.putExtra("key",2);
                startActivity(intent);
            }
        });
        hardModeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,Level_Activity.class);
                intent.putExtra("key",3);
                startActivity(intent);
            }
        });
    }
}