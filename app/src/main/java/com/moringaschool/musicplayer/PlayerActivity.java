package com.moringaschool.musicplayer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

public class PlayerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player);

        //Passing value in intent
        Intent intent=getIntent();

        String song = intent.getStringExtra("song");
        String link = intent.getStringExtra("link");
        String artist = intent.getStringExtra("artist");
        String cover_image = intent.getStringExtra("cover_image");

        Toast.makeText(this,artist,Toast.LENGTH_LONG).show();

    }
}