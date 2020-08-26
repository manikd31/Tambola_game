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

public class ChooseRoleType extends AppCompatActivity {

    TextView roleHost, roleGuest;
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
        setContentView(R.layout.activity_choose_role);

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
                Intent iHome = new Intent(ChooseRoleType.this, HomePage.class);
                startActivity(iHome);
            }
        });

        roleHost = findViewById(R.id.random_ticket);
        roleGuest = findViewById(R.id.custom_ticket);

        doneBtn = findViewById(R.id.done);

        views.add(roleHost);
        views.add(roleGuest);

        selected = 0;

        roleHost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                soundPool.play(clickSound, 1, 1, 1, 0, 1);
                selected = 1;
                roleHost.setTypeface(roleHost.getTypeface(), Typeface.BOLD);
                roleHost.setTextSize(TypedValue.COMPLEX_UNIT_SP, 36);
                roleHost.setTextColor(Color.parseColor("#272929"));
                roleGuest.setTypeface(roleHost.getTypeface(), Typeface.NORMAL);
                roleGuest.setTextSize(TypedValue.COMPLEX_UNIT_SP, 28);
                roleGuest.setTextColor(Color.WHITE);
                changeSelected(view);
            }
        });

        roleGuest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                soundPool.play(clickSound, 1, 1, 1, 0, 1);
                selected = 2;
                roleGuest.setTypeface(roleHost.getTypeface(), Typeface.BOLD);
                roleGuest.setTextSize(TypedValue.COMPLEX_UNIT_SP, 36);
                roleGuest.setTextColor(Color.parseColor("#272929"));
                roleHost.setTypeface(roleHost.getTypeface(), Typeface.NORMAL);
                roleHost.setTextSize(TypedValue.COMPLEX_UNIT_SP, 28);
                roleHost.setTextColor(Color.WHITE);
                changeSelected(view);
            }
        });

        doneBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                soundPool.play(buttonSound, 1, 1, 1, 0, 1);
                if (selected == 1) {
//                    Add log-in features here to create room and play as host
                    Intent iHost = new Intent(ChooseRoleType.this, CreateRoom.class);
                    iHost.putExtra("roleType", "HOST");
                    startActivity(iHost);
                } else if (selected == 2) {
//                    Add log-in features here to join room and play as guest
                    Intent iGuest = new Intent(ChooseRoleType.this, ChooseTicketType.class);
                    iGuest.putExtra("roleType", "GUEST");
                    startActivity(iGuest);
                }
                doneBtn.setClickable(false);
                selected = 0;
                changeSelected(view);
                roleHost.setTypeface(roleHost.getTypeface(), Typeface.NORMAL);
                roleHost.setTextSize(TypedValue.COMPLEX_UNIT_SP, 28);
                roleHost.setTextColor(Color.WHITE);
                roleGuest.setTypeface(roleHost.getTypeface(), Typeface.NORMAL);
                roleGuest.setTextSize(TypedValue.COMPLEX_UNIT_SP, 28);
                roleGuest.setTextColor(Color.WHITE);
            }
        });
    }

    @Override
    public void onBackPressed() {
        Intent iHome = new Intent(ChooseRoleType.this, HomePage.class);
        startActivity(iHome);
    }
}
