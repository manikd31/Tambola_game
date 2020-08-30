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

public class HomePage extends AppCompatActivity {

    SoundPool soundPool;
    TextView newGame, howToPLay;
    ImageView exitApp;
    RelativeLayout layout, appLogo;
    int buttonSound, logoSound;
    boolean playSong;

    private boolean mIsBound;
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
        Intent i = new Intent(this, MusicService.class);
        if (bindService(i, Scon, Context.BIND_AUTO_CREATE)) {
            mIsBound = true;
        }
        SharedPreferences.Editor editor = songPrefs.edit();
        editor.putString("mBound", String.valueOf(mIsBound));
        editor.putString("intent", String.valueOf(i));
        editor.apply();
    }

    void doUnbindService() {
        if (mIsBound) {
            unbindService(Scon);
            mIsBound = false;
            SharedPreferences.Editor editor = songPrefs.edit();
            editor.putString("mBound", String.valueOf(mIsBound));
            editor.apply();
        }
    }

    HomeWatcher mHomeWatcher;
    SharedPreferences songPrefs;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);

//        Intent playMusic = getIntent();

        songPrefs = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
        String value = songPrefs.getString("playSong", null);
        String mValue = songPrefs.getString("mBound", null);
        if (mValue != null) {
            mIsBound = Boolean.parseBoolean(mValue);
        } else {
            mIsBound = false;
            SharedPreferences.Editor editor = songPrefs.edit();
            editor.putString("mBound", String.valueOf(mIsBound));
            editor.apply();
        }
        Log.i("SharedPrefs HOME ---> ", String.valueOf(value));
        if (value != null) {
            playSong = Boolean.parseBoolean(value);
            Log.i("SP (Not Null) ---> ", String.valueOf(playSong));
            if (playSong) {
                doBindService();
                Intent music = new Intent();
                music.setClass(this, MusicService.class);
                startService(music);
            }
        } else {
            playSong = false;
            SharedPreferences.Editor editor = songPrefs.edit();
            editor.putString("playSong", String.valueOf(playSong));
            editor.apply();
        }

//        if (playMusic.hasExtra("playSong")) {
//            playSong = playMusic.getBooleanExtra("playSong", false);
//            if (playSong) {
//                doBindService();
//                startService(music);
//            }
//        }

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

        AudioAttributes attr = new AudioAttributes.Builder()
                .setContentType(AudioAttributes.CONTENT_TYPE_MUSIC)
                .setUsage(AudioAttributes.USAGE_MEDIA)
                .build();

        soundPool = new SoundPool.Builder()
                .setAudioAttributes(attr)
                .setMaxStreams(5)
                .build();

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
//                if (mPlayer != null && mPlayer.isPlaying()) {
//                    mPlayer.stop();
//                    mPlayer.release();
//                    mPlayer = null;
//                } else {
//                    mPlayer = MediaPlayer.create(HomePage.this, R.raw.wii_background);
//                    mPlayer.setLooping(true);
//                    mPlayer.start();
//                }
                if (playSong) {
                    doBindService();
                    Intent music = new Intent();
                    music.setClass(HomePage.this, MusicService.class);
                    startService(music);
//                    bindService(new Intent(HomePage.this, MusicService.class), Scon, Context.BIND_AUTO_CREATE);
                } else {
                    doUnbindService();
                    Intent music = new Intent();
                    music.setClass(HomePage.this, MusicService.class);
                    stopService(music);
//                    mServ.stopSelf();
//                    mServ.stopMusic();
                }
                Animation popupAnim = AnimationUtils.loadAnimation(HomePage.this, R.anim.popup);
                appLogo.startAnimation(popupAnim);
            }
        });

        newGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                soundPool.play(buttonSound, 1, 1, 1, 0, 1);
                Intent newGame = new Intent(HomePage.this, ChooseRoleType.class);
                newGame.putExtra("playSong", playSong);
                SharedPreferences.Editor editor = songPrefs.edit();
                editor.putString("playSong", String.valueOf(playSong));
                editor.apply();
                startActivity(newGame);
            }
        });

        howToPLay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                soundPool.play(buttonSound, 1, 1, 1, 0, 1);
                Intent howToPlay = new Intent(HomePage.this, HowToPlay.class);
                howToPlay.putExtra("playSong", playSong);
                SharedPreferences.Editor editor = songPrefs.edit();
                editor.putString("playSong", String.valueOf(playSong));
                editor.apply();
                startActivity(howToPlay);
            }
        });
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

        SharedPreferences.Editor editor = songPrefs.edit();
        editor.putString("playSong", "false");
        editor.apply();
    }

    @Override
    public void onBackPressed() {
        AlertDialog.Builder b = new AlertDialog.Builder(HomePage.this);
        b.setTitle("Confirm exit?");
        b.setPositiveButton("YES", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                SharedPreferences.Editor editor = songPrefs.edit();
                editor.putString("playSong", "false");
                editor.apply();
                finishAffinity();
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

    @Override
    public boolean stopService(Intent name) {
        return super.stopService(name);
    }
}
