package com.example.tambolahome;

import android.content.DialogInterface;
import android.content.Intent;
import android.media.AudioAttributes;
import android.media.SoundPool;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class HowToPlay extends AppCompatActivity {

    ImageView goBack;
    SoundPool soundPool;
    TextView click, select, back, win, cheer, error;
    int clickSound, selectSound, backSound, winSound, cheerSound, errorSound;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_howtoplay);

        click = findViewById(R.id.sound_button);
        select = findViewById(R.id.sound_click);
        back = findViewById(R.id.sound_back);
        win = findViewById(R.id.sound_win);
        cheer = findViewById(R.id.sound_cheer);
        error = findViewById(R.id.sound_error);

        AlertDialog.Builder b = new AlertDialog.Builder(HowToPlay.this);
        b.setTitle("Hello user!");
        b.setMessage("This page will be updated soon. You can check the sounds used in the game from here.");
        b.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });
        b.setNeutralButton("Go back", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                onBackPressed();
            }
        });
        AlertDialog d = b.create();
        d.show();

        AudioAttributes attr = new AudioAttributes.Builder()
                .setContentType(AudioAttributes.CONTENT_TYPE_MUSIC)
                .setUsage(AudioAttributes.USAGE_MEDIA)
                .build();

        soundPool = new SoundPool.Builder()
                .setAudioAttributes(attr)
                .setMaxStreams(5)
                .build();

        backSound = soundPool.load(this, R.raw.back_sound, 1);
        winSound = soundPool.load(this, R.raw.win_sound, 1);
        errorSound = soundPool.load(this, R.raw.wooden_error_sound, 1);
        cheerSound = soundPool.load(this, R.raw.cheer_sound, 1);
        clickSound = soundPool.load(this, R.raw.simple_error_sound, 1);
        selectSound = soundPool.load(this, R.raw.short_click_sound, 1);

        click.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                soundPool.play(clickSound, 1, 1, 1, 0, 1);
            }
        });

        error.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                soundPool.play(errorSound, 1, 1, 1, 0, 1);
            }
        });

        select.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                soundPool.play(selectSound, 1, 1, 1, 0, 1);
            }
        });

        win.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                soundPool.play(winSound, 1, 1, 1, 0, 1);
            }
        });

        cheer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                soundPool.play(cheerSound, 1, 1, 1, 0, 1);
            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                soundPool.play(backSound, 1, 1, 1, 0, 1);
            }
        });

        goBack = findViewById(R.id.go_back);

        goBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                soundPool.play(backSound, 1, 1, 1, 0, 1);
                Intent iBack = new Intent(HowToPlay.this, HomePage.class);
                startActivity(iBack);
            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}
