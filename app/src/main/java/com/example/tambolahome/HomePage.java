package com.example.tambolahome;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.media.AudioAttributes;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import java.io.IOException;

public class HomePage extends AppCompatActivity {

    SoundPool soundPool;
    MediaPlayer mPlayer;
    TextView newGame, howToPLay;
    ImageView exitApp;
    RelativeLayout layout, appLogo;
    int buttonSound, logoSound;
    boolean playSong;
    int streamId;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);

        playSong = false;

        AudioAttributes attr = new AudioAttributes.Builder()
                .setContentType(AudioAttributes.CONTENT_TYPE_MUSIC)
                .setUsage(AudioAttributes.USAGE_MEDIA)
                .build();

        soundPool = new SoundPool.Builder()
                .setAudioAttributes(attr)
                .setMaxStreams(5)
                .build();

        mPlayer = null;

        logoSound = soundPool.load(this, R.raw.background_beat, 1);
        buttonSound = soundPool.load(this, R.raw.simple_error_sound, 1);

        layout = findViewById(R.id.home_layout);
        appLogo = findViewById(R.id.app_logo);
        exitApp = findViewById(R.id.exit_app);
        newGame = findViewById(R.id.new_game);
        howToPLay = findViewById(R.id.how_to);

        exitApp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                soundPool.play(buttonSound, 1, 1, 1, 0, 1);
                onBackPressed();
            }
        });

        appLogo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i("SONG PLAYING", "Before PlaySong ==> " + playSong);
                playSong = !playSong;
                Log.i("SONG PLAYING", "After PlaySong ==> " + playSong);
//                if (playSong) {
//                    try {
//                        mPlayer.prepare();
//                    } catch (IOException e) {
//                        e.printStackTrace();
//                    }
//                    mPlayer.start();
////                    streamId = soundPool.play(logoSound, 0.5f, 0.5f, 1, -1, 1);
//                } else {
//                    mPlayer.stop();
////                    soundPool.stop(streamId);
//                }
                if (mPlayer != null && mPlayer.isPlaying()) {
                    mPlayer.stop();
                    mPlayer.release();
                    mPlayer = null;
                } else {
                    mPlayer = MediaPlayer.create(HomePage.this, R.raw.wii_background);
                    mPlayer.setLooping(true);
                    mPlayer.start();
                }
                Animation popupAnim = AnimationUtils.loadAnimation(HomePage.this, R.anim.popup);
                appLogo.startAnimation(popupAnim);
            }
        });

        newGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                soundPool.play(buttonSound, 1, 1, 1, 0, 1);
                Intent newGame = new Intent(HomePage.this, ChooseTicketType.class);
                startActivity(newGame);
            }
        });

        howToPLay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                soundPool.play(buttonSound, 1, 1, 1, 0, 1);
                Intent howToPlay = new Intent(HomePage.this, HowToPlay.class);
                startActivity(howToPlay);
            }
        });
    }

    @Override
    protected void onPause() {
        super.onPause();
//        soundPool.pause(streamId);
        if (playSong) {
            if (mPlayer.isPlaying() && mPlayer != null) {
                mPlayer.pause();
            }
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
//        soundPool.resume(streamId);
        if (playSong) {
            if (!mPlayer.isPlaying() && mPlayer != null) {
                mPlayer.start();
            }
        }
    }

    @Override
    public void onBackPressed() {
        AlertDialog.Builder b = new AlertDialog.Builder(HomePage.this);
        b.setTitle("Confirm exit?");
        b.setPositiveButton("YES", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                finishAffinity();
                mPlayer.stop();
                mPlayer.release();
                mPlayer = null;
            }
        });
        b.setNegativeButton("NO", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });

        AlertDialog d = b.create();
        d.show();
    }
}
