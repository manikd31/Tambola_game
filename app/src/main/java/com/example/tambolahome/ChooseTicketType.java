package com.example.tambolahome;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.media.AudioAttributes;
import android.media.SoundPool;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class ChooseTicketType extends AppCompatActivity {

    TextView randomTicket, customTicket;
    ExtendedFloatingActionButton doneBtn;
    List<View> views = new ArrayList<View>();
    ImageView goBack, goHome;

    public void changeSelected(View view) {
        for (View v : views) {
            v.setBackgroundResource(R.drawable.ticket_unselected);
        }
        if (selected != 0) {
            view.setBackgroundResource(R.drawable.ticket_type_selected);
            doneBtn.setClickable(true);
        } else {
            doneBtn.setClickable(false);
        }
    }

    int selected;
    int buttonSound, backSound, clickSound;
    SoundPool soundPool;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_ticket);

        AudioAttributes attr = new AudioAttributes.Builder()
                .setContentType(AudioAttributes.CONTENT_TYPE_MUSIC)
                .setUsage(AudioAttributes.USAGE_MEDIA)
                .build();

        soundPool = new SoundPool.Builder()
                .setAudioAttributes(attr)
                .setMaxStreams(5)
                .build();

        buttonSound = soundPool.load(this, R.raw.simple_error_sound, 1);
        backSound = soundPool.load(this, R.raw.back_sound, 1);
        clickSound = soundPool.load(this, R.raw.short_click_sound, 1);

        goBack = findViewById(R.id.go_back);
        goHome = findViewById(R.id.go_home);

        goBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                soundPool.play(backSound, 1, 1, 1, 0, 1);
                onBackPressed();
            }
        });

        goHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                soundPool.play(buttonSound, 1, 1, 1, 0, 1);
                Intent iHome = new Intent(ChooseTicketType.this, HomePage.class);
                startActivity(iHome);
            }
        });

        randomTicket = findViewById(R.id.random_ticket);
        customTicket = findViewById(R.id.custom_ticket);

        doneBtn = findViewById(R.id.done);

        views.add(randomTicket);
        views.add(customTicket);

        selected = 0;

        randomTicket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                soundPool.play(clickSound, 1, 1, 1, 0, 1);
                selected = 1;
                randomTicket.setTypeface(randomTicket.getTypeface(), Typeface.BOLD);
                randomTicket.setTextSize(TypedValue.COMPLEX_UNIT_SP, 36);
                randomTicket.setTextColor(Color.parseColor("#272929"));
                customTicket.setTypeface(randomTicket.getTypeface(), Typeface.NORMAL);
                customTicket.setTextSize(TypedValue.COMPLEX_UNIT_SP, 28);
                customTicket.setTextColor(Color.WHITE);
                changeSelected(view);
            }
        });

        customTicket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                soundPool.play(clickSound, 1, 1, 1, 0, 1);
                selected = 2;
                customTicket.setTypeface(randomTicket.getTypeface(), Typeface.BOLD);
                customTicket.setTextSize(TypedValue.COMPLEX_UNIT_SP, 36);
                customTicket.setTextColor(Color.parseColor("#272929"));
                randomTicket.setTypeface(randomTicket.getTypeface(), Typeface.NORMAL);
                randomTicket.setTextSize(TypedValue.COMPLEX_UNIT_SP, 28);
                randomTicket.setTextColor(Color.WHITE);
                changeSelected(view);
            }
        });

        doneBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                soundPool.play(buttonSound, 1, 1, 1, 0, 1);
                if (selected == 1) {
                    Intent randomIntent = new Intent(ChooseTicketType.this, TicketList.class);
                    startActivity(randomIntent);
                } else if (selected == 2) {
                    Intent randomIntent = new Intent(ChooseTicketType.this, HomeActivity.class);
                    startActivity(randomIntent);
                }
                doneBtn.setClickable(false);
                selected = 0;
                changeSelected(view);
                randomTicket.setTypeface(randomTicket.getTypeface(), Typeface.NORMAL);
                randomTicket.setTextSize(TypedValue.COMPLEX_UNIT_SP, 28);
                randomTicket.setTextColor(Color.WHITE);
                customTicket.setTypeface(randomTicket.getTypeface(), Typeface.NORMAL);
                customTicket.setTextSize(TypedValue.COMPLEX_UNIT_SP, 28);
                customTicket.setTextColor(Color.WHITE);
            }
        });
    }

    @Override
    public void onBackPressed() {
        Intent iHome = new Intent(ChooseTicketType.this, HomePage.class);
        startActivity(iHome);
    }
}
