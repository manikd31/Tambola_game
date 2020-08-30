package com.example.tambolahome;

import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.SharedPreferences;
import android.media.AudioAttributes;
import android.media.SoundPool;
import android.os.Bundle;
import android.os.IBinder;
import android.os.PowerManager;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class HowToPlay extends AppCompatActivity {

    ImageView goBack;
    SoundPool soundPool;
    TextView click, select, back, win, cheer, error;
    int clickSound, selectSound, backSound, winSound, cheerSound, errorSound;
    boolean playSong;

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

    HomeWatcher mHomeWatcher;
    SharedPreferences songPrefs;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_howtoplay);

//        playSong = getIntent().getBooleanExtra("playSong", false);
        songPrefs = getSharedPreferences("MyPrefs", 0);
        String value = songPrefs.getString("playSong", null);
        if (value != null) {
            playSong = Boolean.parseBoolean(value);
        }

        Intent music = new Intent();
        music.setClass(this, MusicService.class);

        if (playSong) {
            doBindService();
            startService(music);
        }

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
                iBack.putExtra("playSong", playSong);
                startActivity(iBack);
            }
        });
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
    public void onBackPressed() {
        super.onBackPressed();
    }
}
