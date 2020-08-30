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
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class ChooseGameType extends AppCompatActivity {

    TextView offlineGame, onlineGame;
    ImageView goBack, goHome;
    ExtendedFloatingActionButton done;
    int buttonSound, backSound, clickSound, errorSound;
    SoundPool soundPool;
    Intent intent;
    String role, game;
    int selected;
    List<View> views = new ArrayList<>();
    SharedPreferences songPrefs;
    boolean playSong;

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
            done.setClickable(true);
        } else {
            done.setClickable(false);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_game_type);

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

        selected = 0;

        intent = getIntent();
        role = intent.getStringExtra("roleType");

        songPrefs = getSharedPreferences("MyPrefs", 0);
        String value = songPrefs.getString("playSong", null);
        if (value != null) {
            playSong = Boolean.parseBoolean(value);
        }
        if (playSong) {
            doBindService();
            startService(music);
        }

        offlineGame = findViewById(R.id.offline_game);
        onlineGame = findViewById(R.id.online_game);
        goBack = findViewById(R.id.go_back);
        goHome = findViewById(R.id.go_home);
        done = findViewById(R.id.done);

        views.add(offlineGame);
        views.add(onlineGame);

        AudioAttributes attr = new AudioAttributes.Builder()
                .setContentType(AudioAttributes.CONTENT_TYPE_MUSIC)
                .setUsage(AudioAttributes.USAGE_MEDIA)
                .build();

        soundPool = new SoundPool.Builder()
                .setAudioAttributes(attr)
                .setMaxStreams(5)
                .build();

        backSound = soundPool.load(this, R.raw.back_sound, 1);
        buttonSound = soundPool.load(this, R.raw.simple_error_sound, 1);
        errorSound = soundPool.load(this, R.raw.wooden_error_sound, 1);
        clickSound = soundPool.load(this, R.raw.short_click_sound, 1);

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
                Intent iHome = new Intent(ChooseGameType.this, HomePage.class);
                startActivity(iHome);
            }
        });

        offlineGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                soundPool.play(clickSound, 1, 1, 1, 0, 1);
                selected = 1;
                game = "OFFLINE";
                offlineGame.setTypeface(offlineGame.getTypeface(), Typeface.BOLD);
                offlineGame.setTextSize(TypedValue.COMPLEX_UNIT_SP, 36);
                offlineGame.setTextColor(Color.parseColor("#272929"));
                onlineGame.setTypeface(offlineGame.getTypeface(), Typeface.NORMAL);
                onlineGame.setTextSize(TypedValue.COMPLEX_UNIT_SP, 28);
                onlineGame.setTextColor(Color.WHITE);
                changeSelected(view);
            }
        });

        onlineGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                soundPool.play(clickSound, 1, 1, 1, 0, 1);
                selected = 2;
                game = "ONLINE";
                onlineGame.setTypeface(offlineGame.getTypeface(), Typeface.BOLD);
                onlineGame.setTextSize(TypedValue.COMPLEX_UNIT_SP, 36);
                onlineGame.setTextColor(Color.parseColor("#272929"));
                offlineGame.setTypeface(offlineGame.getTypeface(), Typeface.NORMAL);
                offlineGame.setTextSize(TypedValue.COMPLEX_UNIT_SP, 28);
                offlineGame.setTextColor(Color.WHITE);
                changeSelected(view);
            }
        });

        done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                soundPool.play(buttonSound, 1, 1, 1, 0, 1);
                if (selected == 1) {
                    Intent iOffline = new Intent(ChooseGameType.this, ChooseTicketType.class);
                    iOffline.putExtra("roleType", role);
                    iOffline.putExtra("gameType", game);
                    startActivity(iOffline);
                } else if (selected == 2) {
                    Toast.makeText(ChooseGameType.this, "Dialog Box to get password from GUEST and check in the list of rooms.", Toast.LENGTH_SHORT).show();
                    Intent iOnline;
                    if (role.equals("HOST")) {
                        iOnline = new Intent(ChooseGameType.this, CreateRoom.class);
                    } else {
                        iOnline = new Intent(ChooseGameType.this, ChooseTicketType.class);
                    }
                    iOnline.putExtra("roleType", role);
                    iOnline.putExtra("gameType", game);
                    startActivity(iOnline);
                }
                done.setClickable(false);
                selected = 0;
                changeSelected(view);
                offlineGame.setTypeface(offlineGame.getTypeface(), Typeface.NORMAL);
                offlineGame.setTextSize(TypedValue.COMPLEX_UNIT_SP, 28);
                offlineGame.setTextColor(Color.WHITE);
                onlineGame.setTypeface(offlineGame.getTypeface(), Typeface.NORMAL);
                onlineGame.setTextSize(TypedValue.COMPLEX_UNIT_SP, 28);
                onlineGame.setTextColor(Color.WHITE);
            }
        });
    }

    @Override
    public void onBackPressed() {
        Intent iBack = new Intent(ChooseGameType.this, ChooseRoleType.class);
        startActivity(iBack);
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