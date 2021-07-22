package com.infycloud.wallpaperapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {
    int[] backImages;
    ConstraintLayout c;
    Button Changewall;
    Timer t;
    public static  int count =0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        backImages = new  int[]{R.drawable.wall1,R.drawable.wall2,R.drawable.wall3,R.drawable.wall4,R.drawable.wall5};
        Changewall = findViewById(R.id.button);
       c = findViewById(R.id.layout);


        Changewall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               c.setBackgroundResource(R.drawable.wall1);
               t = new Timer();
               t.scheduleAtFixedRate(new TimerTask() {
                   @Override
                   public void run() {
                       runOnUiThread(new Runnable() {
                           @Override
                           public void run() {
                               if(count < backImages.length){
                                   c.setBackgroundResource(backImages[count]);
                                   count = (count +1) % backImages.length;
                               }
                           }
                       });
                   }
               },3000,3000);
            }
        });


    }
   }