package com.moringaschool.musicplayer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.io.IOException;

import butterknife.BindView;
import butterknife.ButterKnife;

public class PlayerActivity extends AppCompatActivity {

    @BindView(R.id.coverImageView) ImageView mCoverImage;
    @BindView(R.id.song_name) TextView mSongsName;
    @BindView(R.id.song_title) TextView mSongTittle;

    @BindView(R.id.play) Button mPlay;
    @BindView(R.id.pause) Button mPause;
    @BindView(R.id.seekBar) SeekBar mSeekBar;
    @BindView(R.id.textView_pass) TextView mPass; // elepsed time duration
    @BindView(R.id.textView_due) TextView mDue; // remaining time

    MediaPlayer mediaPlayer;//play song

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player);
        ButterKnife.bind(this);

        mediaPlayer = new MediaPlayer();




        //Passing value in intent
        Intent intent=getIntent();

        String song = intent.getStringExtra("song");
        String link = intent.getStringExtra("link");
        String artist = intent.getStringExtra("artist");
        String cover_image = intent.getStringExtra("cover_image");

        Toast.makeText(this,artist,Toast.LENGTH_LONG).show();

        // set the music to star automatically
        try {
            mediaPlayer.setDataSource(artist);
            mediaPlayer.prepare();
        } catch (IOException e) {
            e.printStackTrace();
        }
        mediaPlayer.start();


        mPause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                pause();

            }
        });


        mPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                play();
            }
        });

        //setting text to display on the ui
        mSongTittle.setText(song);
        mSongsName.setText(artist);

        //Loading image from url and set into mCoverImage using glide

        Glide.with(this)
                .load(cover_image)
                .override(300,200)
                .into(mCoverImage);



    }

    private void play() {

        //when the user click on play button and pause button should visible
        //add media player will start

        mediaPlayer.start();
        mPlay.setVisibility(View.INVISIBLE);
        mPause.setVisibility(View.VISIBLE);



    }

    private void pause() {
        // when the user will click pause button media player will apuse
        //and the play button will be possible

        mediaPlayer.pause();
        mPlay.setVisibility(View.VISIBLE);
        mPause.setVisibility(View.INVISIBLE);


    }
}