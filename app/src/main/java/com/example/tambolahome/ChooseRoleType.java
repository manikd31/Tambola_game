package com.example.tambolahome;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.Typeface;
import android.media.AudioAttributes;
import android.media.SoundPool;
import android.os.Bundle;
import android.os.IBinder;
import android.os.PowerManager;
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
    int selected;
    boolean playSong;
    int buttonSound, backSound, clickSound;
    SoundPool soundPool;
    SharedPreferences songPrefs;

    HomeWatcher mHomeWatcher;
    private boolean mIsBound = false;
    private MusicService mServ;
    private ServiceConnection Scon = new ServiceConnection() {

        public void onServiceConnected(ComponentName name, IBinder
                binder) {
            mServ = ((MusicService.ServiceBinder) binder).getService();
        }

        public void onServiceDisconnected(ComponentName name) {
            mServ = null;
        }
    };

    void doBindService() {
        bindService(new Intent(this, MusicService.class),
                Scon, Context.BIND_AUTO_CREATE);
        mIsBound = true;
    }

    void doUnbindService() {
        if (mIsBound) {
            unbindService(Scon);
            mIsBound = false;
        }
    }

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

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_role);

        Intent music = new Intent();
        music.setClass(this, MusicService.class);

        mHomeWatcher = new HomeWatcher(this);
        mHomeWatcher.setOnHomePressedListener(new HomeWatcher.OnHomePressedListener() {
            @Override
            public void onHomePressed() {
                if (mServ != null) {
                    mServ.pauseMusic();
                }
            }

            @Override
            public void onHomeLongPressed() {
                if (mServ != null) {
                    mServ.pauseMusic();
                }
            }
        });
        mHomeWatcher.startWatch();

//        Intent intent = getIntent();
//        playSong = intent.getBooleanExtra("playSong", false);

        songPrefs = getSharedPreferences("MyPrefs", 0);
        String value = songPrefs.getString("playSong", null);
        if (value != null) {
            playSong = Boolean.parseBoolean(value);
        }
        if (playSong) {
            doBindService();
            startService(music);
        }

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
                iHome.putExtra("playSong", playSong);
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
                    Intent iHost = new Intent(ChooseRoleType.this, ChooseGameType.class);
                    iHost.putExtra("roleType", "HOST");
                    startActivity(iHost);
                } else if (selected == 2) {
//                    Add log-in features here to join room and play as guest
                    Intent iGuest = new Intent(ChooseRoleType.this, ChooseGameType.class);
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
        iHome.putExtra("playSong", playSong);
        startActivity(iHome);
    }

    @Override
    protected void onPause() {
        super.onPause();

        PowerManager pm = (PowerManager)
                getSystemService(Context.POWER_SERVICE);
        boolean isScreenOn = false;
        if (pm != null) {
            isScreenOn = pm.isInteractive();
        }

        if (!isScreenOn) {
            if (mServ != null) {
                mServ.pauseMusic();
            }
        }
    }

    @Override
    protected void onResume() {
        super.onResume();

        if (mServ != null) {
            mServ.resumeMusic();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        doUnbindService();
        Intent music = new Intent();
        music.setClass(this, MusicService.class);
        stopService(music);
    }
}
