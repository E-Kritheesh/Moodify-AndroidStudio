package com.example.moodify;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.Drawable;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity
        extends AppCompatActivity {

    // Instantiating the MediaPlayer class
    MediaPlayer music;

    @Override
    protected void onCreate(
            Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_main);

        // Adding the music file to our
        // newly created object music
        music = MediaPlayer.create(
                this, R.raw.sound);
    }



    // Playing the music
    public void musicplaypause(View v)
    {
        if(music.isPlaying()){
            music.pause();
        } else {
            music.start();
        }
    }

    // Pausing the music
    public void musicrewind(View v)
    {
        music.stop();
        music
                = MediaPlayer.create(
                this, R.raw.sound);
        music.start();
    }

    // Stopping the music
    public void musicstop(View v)
    {
        music.stop();
        music
                = MediaPlayer.create(
                this, R.raw.sound);
    }
}