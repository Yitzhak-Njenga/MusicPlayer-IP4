package com.moringaschool.musicplayer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import butterknife.BindView;
import butterknife.ButterKnife;

public class PlayerActivity extends AppCompatActivity {

    @BindView(R.id.coverImageView) ImageView mCoverImage;
    @BindView(R.id.song_name) TextView mSongsName;
    @BindView(R.id.song_title) TextView mSongTittle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player);
        ButterKnife.bind(this);

        //Passing value in intent
        Intent intent=getIntent();

        String song = intent.getStringExtra("song");
        String link = intent.getStringExtra("link");
        String artist = intent.getStringExtra("artist");
        String cover_image = intent.getStringExtra("cover_image");

        Toast.makeText(this,artist,Toast.LENGTH_LONG).show();

        //setting text to display on the ui
        mSongTittle.setText(song);
        mSongsName.setText(artist);

        //Loading image from url and set into mCoverImage using glide

        Glide.with(this)
                .load(cover_image)
                .override(300,200)
                .into(mCoverImage);



    }
}