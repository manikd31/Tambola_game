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
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends AppCompatActivity {

    ExtendedFloatingActionButton done;
    TextView errorView;

    SoundPool soundPool;
    int buttonSound, backSound, errorSound, correctSound;
    int count;
    String role, game;
    boolean playSong;
    SharedPreferences songPrefs;

    List<List<Integer>> tt = new ArrayList<List<Integer>>();
    ImageView goBack;

    List<TextView> tr1 = new ArrayList<TextView>();
    List<TextView> tr2 = new ArrayList<TextView>();
    List<TextView> tr3 = new ArrayList<TextView>();

    List<List<TextView>> tv = new ArrayList<List<TextView>>();

    public void initTicket() {
        tr1.add((TextView) findViewById(R.id.t1a));
        tr1.add((TextView) findViewById(R.id.t2a));
        tr1.add((TextView) findViewById(R.id.t3a));
        tr1.add((TextView) findViewById(R.id.t4a));
        tr1.add((TextView) findViewById(R.id.t5a));
        tr1.add((TextView) findViewById(R.id.t6a));
        tr1.add((TextView) findViewById(R.id.t7a));
        tr1.add((TextView) findViewById(R.id.t8a));
        tr1.add((TextView) findViewById(R.id.t9a));

        tr2.add((TextView) findViewById(R.id.t1b));
        tr2.add((TextView) findViewById(R.id.t2b));
        tr2.add((TextView) findViewById(R.id.t3b));
        tr2.add((TextView) findViewById(R.id.t4b));
        tr2.add((TextView) findViewById(R.id.t5b));
        tr2.add((TextView) findViewById(R.id.t6b));
        tr2.add((TextView) findViewById(R.id.t7b));
        tr2.add((TextView) findViewById(R.id.t8b));
        tr2.add((TextView) findViewById(R.id.t9b));

        tr3.add((TextView) findViewById(R.id.t1c));
        tr3.add((TextView) findViewById(R.id.t2c));
        tr3.add((TextView) findViewById(R.id.t3c));
        tr3.add((TextView) findViewById(R.id.t4c));
        tr3.add((TextView) findViewById(R.id.t5c));
        tr3.add((TextView) findViewById(R.id.t6c));
        tr3.add((TextView) findViewById(R.id.t7c));
        tr3.add((TextView) findViewById(R.id.t8c));
        tr3.add((TextView) findViewById(R.id.t9c));

        tv.add(tr1);
        tv.add(tr2);
        tv.add(tr3);
    }

    public void getExtras() {
        count = 0;
        tt = new ArrayList<List<Integer>>();
        for (int r = 0; r < 3; r++) {
            List<Integer> tti = new ArrayList<Integer>();
            for (int c = 0; c < 9; c++) {
                String num = tv.get(r).get(c).getText().toString();
                Log.i("Make Ticket: ", r + "," + c + ":::::" + num);
                if (TextUtils.isEmpty(num)) {
                    tti.add(0);
                } else {
                    tti.add(Integer.parseInt(num));
                    count += 1;
                }
            }
            tt.add(tti);
        }
    }

    public boolean checkTicket() {
//        Check if any number is ZERO
        int flag = 0;
        for (int r = 0; r < 3; r++) {
            for (int c = 0; c < 9; c++) {
                if (!TextUtils.isEmpty(tv.get(r).get(c).getText().toString())) {
                    int n = Integer.parseInt(tv.get(r).get(c).getText().toString());
                    if (n == 0) {
                        tv.get(r).get(c).setBackgroundResource(R.drawable.ticket_number_error);
                        flag = 1;
                    }
                }
            }
        }
        if (flag == 1) {
            String errorMsg = "Missing number(s). 0's added.";
            errorView.setText(errorMsg);
            return false;
        }
//        Check if each row has exactly 5 numbers
        for (int r = 0; r < 3; r++) {
            int numsInRow = 0;
            for (int c = 0; c < 9; c++) {
                int n = tt.get(r).get(c);
                if (n != 0) {
                    numsInRow += 1;
                }
            }
            if (numsInRow == 0) {
                String errorMsg = "Row " + (r + 1) + " cannot be empty.";
                errorView.setText(errorMsg);
                for (int c = 0; c < 9; c++) {
                    tv.get(r).get(c).setBackgroundResource(R.drawable.ticket_number_error);
                }
                return false;
            } else if (numsInRow > 5) {
                String errorMsg = "Row " + (r + 1) + " contains more than 5 numbers.";
                errorView.setText(errorMsg);
                for (int c = 0; c < 9; c++) {
                    tv.get(r).get(c).setBackgroundResource(R.drawable.ticket_number_error);
                }
                return false;
            } else if (numsInRow < 5) {
                String errorMsg = "Row " + (r + 1) + " contains less than 5 numbers.";
                errorView.setText(errorMsg);
                for (int c = 0; c < 9; c++) {
                    tv.get(r).get(c).setBackgroundResource(R.drawable.ticket_number_error);
                }
                return false;
            }
        }

//        Check conditions for each column
        for (int c = 0; c < 9; c++) {
//            First to check if no column is left empty...
            int num1 = tt.get(0).get(c);
            int num2 = tt.get(1).get(c);
            int num3 = tt.get(2).get(c);
            if (num1 == 0 && num2 == 0 && num3 == 0) {
                String errorMsg = "Column " + (c + 1) + " cannot be empty.";
                errorView.setText(errorMsg);
                for (int i = 0; i < 3; i++) {
                    tv.get(i).get(c).setBackgroundResource(R.drawable.ticket_number_error);
                }
                return false;
            }

//            Next to check if each column has numbers within its defined range...
            if (c == 0) {
                int minRange = 1;
                int maxRange = 9;
                if (num1 != 0 && (num1 > maxRange || num1 < minRange)) {
                    String errorMsg = "Number " + num1 + " in column " + (c + 1) + " should be between " + minRange + "-" + maxRange + ".";
                    errorView.setText(errorMsg);
                    for (int i = 0; i < 3; i++) {
                        tv.get(i).get(c).setBackgroundResource(R.drawable.ticket_number_error);
                    }
                    return false;
                } else if (num2 != 0 && (num2 > maxRange || num2 < minRange)) {
                    String errorMsg = "Number " + num2 + " in column " + (c + 1) + " should be between " + minRange + "-" + maxRange + ".";
                    errorView.setText(errorMsg);
                    for (int i = 0; i < 3; i++) {
                        tv.get(i).get(c).setBackgroundResource(R.drawable.ticket_number_error);
                    }
                    return false;
                } else if (num3 != 0 && (num3 > maxRange || num3 < minRange)) {
                    String errorMsg = "Number " + num3 + " in column " + (c + 1) + " should be between " + minRange + "-" + maxRange + ".";
                    errorView.setText(errorMsg);
                    for (int i = 0; i < 3; i++) {
                        tv.get(i).get(c).setBackgroundResource(R.drawable.ticket_number_error);
                    }
                    return false;
                }
            } else if (c == 8) {
                int minRange = 80;
                int maxRange = 90;
                if (num1 != 0 && (num1 > maxRange || num1 < minRange)) {
                    String errorMsg = "Number " + num1 + " in column " + (c + 1) + " should be between " + minRange + "-" + maxRange + ".";
                    errorView.setText(errorMsg);
                    for (int i = 0; i < 3; i++) {
                        tv.get(i).get(c).setBackgroundResource(R.drawable.ticket_number_error);
                    }
                    return false;
                } else if (num2 != 0 && (num2 > maxRange || num2 < minRange)) {
                    String errorMsg = "Number " + num2 + " in column " + (c + 1) + " should be between " + minRange + "-" + maxRange + ".";
                    errorView.setText(errorMsg);
                    for (int i = 0; i < 3; i++) {
                        tv.get(i).get(c).setBackgroundResource(R.drawable.ticket_number_error);
                    }
                    return false;
                } else if (num3 != 0 && (num3 > maxRange || num3 < minRange)) {
                    String errorMsg = "Number " + num3 + " in column " + (c + 1) + " should be between " + minRange + "-" + maxRange + ".";
                    errorView.setText(errorMsg);
                    for (int i = 0; i < 3; i++) {
                        tv.get(i).get(c).setBackgroundResource(R.drawable.ticket_number_error);
                    }
                    return false;
                }
            } else {
                int minRange = c * 10;
                int maxRange = minRange + 9;
                if (num1 != 0 && (num1 > maxRange || num1 < minRange)) {
                    String errorMsg = "Number " + num1 + " in column " + (c + 1) + " should be between " + minRange + "-" + maxRange + ".";
                    errorView.setText(errorMsg);
                    for (int i = 0; i < 3; i++) {
                        tv.get(i).get(c).setBackgroundResource(R.drawable.ticket_number_error);
                    }
                    return false;
                } else if (num2 != 0 && (num2 > maxRange || num2 < minRange)) {
                    String errorMsg = "Number " + num2 + " in column " + (c + 1) + " should be between " + minRange + "-" + maxRange + ".";
                    errorView.setText(errorMsg);
                    for (int i = 0; i < 3; i++) {
                        tv.get(i).get(c).setBackgroundResource(R.drawable.ticket_number_error);
                    }
                    return false;
                } else if (num3 != 0 && (num3 > maxRange || num3 < minRange)) {
                    String errorMsg = "Number " + num3 + " in column " + (c + 1) + " should be between " + minRange + "-" + maxRange + ".";
                    errorView.setText(errorMsg);
                    for (int i = 0; i < 3; i++) {
                        tv.get(i).get(c).setBackgroundResource(R.drawable.ticket_number_error);
                    }
                    return false;
                }
            }

//            Finally, to check if the numbers are sorted in each column...
            if (num1 != 0 && num2 != 0 && num3 != 0) {
                if (num1 == num2 && num2 == num3) {
                    String errorMsg = "Duplicate numbers in column " + (c + 1);
                    errorView.setText(errorMsg);
                    for (int i = 0; i < 3; i++) {
                        tv.get(i).get(c).setBackgroundResource(R.drawable.ticket_number_error);
                    }
                    return false;
                } else if (num1 == num2) {
                    String errorMsg = "Duplicate numbers in column " + (c + 1);
                    errorView.setText(errorMsg);
                    tv.get(0).get(c).setBackgroundResource(R.drawable.ticket_number_error);
                    tv.get(1).get(c).setBackgroundResource(R.drawable.ticket_number_error);
                    return false;
                } else if (num2 == num3) {
                    String errorMsg = "Duplicate numbers in column " + (c + 1);
                    errorView.setText(errorMsg);
                    tv.get(1).get(c).setBackgroundResource(R.drawable.ticket_number_error);
                    tv.get(2).get(c).setBackgroundResource(R.drawable.ticket_number_error);
                    return false;
                } else if (num1 == num3) {
                    String errorMsg = "Duplicate numbers in column " + (c + 1);
                    errorView.setText(errorMsg);
                    tv.get(0).get(c).setBackgroundResource(R.drawable.ticket_number_error);
                    tv.get(2).get(c).setBackgroundResource(R.drawable.ticket_number_error);
                    return false;
                } else if (num1 > num2 || num2 > num3) {
                    String errorMsg = "Numbers are not sorted in column " + (c + 1);
                    errorView.setText(errorMsg);
                    for (int i = 0; i < 3; i++) {
                        tv.get(i).get(c).setBackgroundResource(R.drawable.ticket_number_error);
                    }
                    return false;
                }
            } else if (num1 == 0 && num2 != 0 && num3 != 0) {
                if (num2 == num3) {
                    String errorMsg = "Duplicate numbers in column " + (c + 1);
                    errorView.setText(errorMsg);
                    tv.get(1).get(c).setBackgroundResource(R.drawable.ticket_number_error);
                    tv.get(2).get(c).setBackgroundResource(R.drawable.ticket_number_error);
                    return false;
                } else if (num2 > num3) {
                    String errorMsg = "Numbers are not sorted in column " + (c + 1);
                    errorView.setText(errorMsg);
                    for (int i = 0; i < 3; i++) {
                        tv.get(i).get(c).setBackgroundResource(R.drawable.ticket_number_error);
                    }
                    return false;
                }
            } else if (num2 == 0 && num1 != 0 && num3 != 0) {
                if (num1 == num3) {
                    String errorMsg = "Duplicate numbers in column " + (c + 1);
                    errorView.setText(errorMsg);
                    tv.get(0).get(c).setBackgroundResource(R.drawable.ticket_number_error);
                    tv.get(2).get(c).setBackgroundResource(R.drawable.ticket_number_error);
                    return false;
                } else if (num1 > num3) {
                    String errorMsg = "Numbers are not sorted in column " + (c + 1);
                    errorView.setText(errorMsg);
                    for (int i = 0; i < 3; i++) {
                        tv.get(i).get(c).setBackgroundResource(R.drawable.ticket_number_error);
                    }
                    return false;
                }
            } else if (num3 == 0 && num1 != 0 && num2 != 0) {
                if (num1 == num2) {
                    String errorMsg = "Duplicate numbers in column " + (c + 1);
                    errorView.setText(errorMsg);
                    tv.get(0).get(c).setBackgroundResource(R.drawable.ticket_number_error);
                    tv.get(1).get(c).setBackgroundResource(R.drawable.ticket_number_error);
                    return false;
                } else if (num1 > num2) {
                    String errorMsg = "Numbers are not sorted in column " + (c + 1);
                    errorView.setText(errorMsg);
                    for (int i = 0; i < 3; i++) {
                        tv.get(i).get(c).setBackgroundResource(R.drawable.ticket_number_error);
                    }
                    return false;
                }
            }
        }
        return true;
    }

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

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

        backSound = soundPool.load(this, R.raw.back_sound, 1);
        buttonSound = soundPool.load(this, R.raw.simple_error_sound, 1);
        errorSound = soundPool.load(this, R.raw.wooden_error_sound, 1);
        correctSound = soundPool.load(this, R.raw.win_sound, 1);

        initTicket();
        Intent iRole = getIntent();
        role = iRole.getStringExtra("roleType");
        game = iRole.getStringExtra("gameType");

        done = findViewById(R.id.done);
        goBack = findViewById(R.id.go_back);
        errorView = findViewById(R.id.error_msg);

        goBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                soundPool.play(backSound, 1, 1, 1, 0, 1);
                onBackPressed();
            }
        });

        done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                soundPool.play(buttonSound, 1, 1, 1, 0, 1);
                for (int r = 0; r < 3; r++) {
                    for (int c = 0; c < 9; c++) {
                        tv.get(r).get(c).setBackgroundResource(R.drawable.ticket_number_undone);
                    }
                }
                AlertDialog.Builder b = new AlertDialog.Builder(HomeActivity.this);
                b.setTitle("Confirm ticket?");
                b.setPositiveButton("YES", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        getExtras();
                        if (checkTicket()) {
                            soundPool.play(correctSound, 1, 1, 1, 0, 1);
                            errorView.setText("");
                            AlertDialog.Builder b1 = new AlertDialog.Builder(HomeActivity.this);
                            b1.setTitle("Awesome!! Let's get to the game.");
                            b1.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    Intent iGame = new Intent(HomeActivity.this, MainActivity.class);
                                    iGame.putIntegerArrayListExtra("row1", (ArrayList<Integer>) tt.get(0));
                                    iGame.putIntegerArrayListExtra("row2", (ArrayList<Integer>) tt.get(1));
                                    iGame.putIntegerArrayListExtra("row3", (ArrayList<Integer>) tt.get(2));
                                    iGame.putExtra("roleType", role);
                                    iGame.putExtra("gameType", game);
                                    startActivity(iGame);
                                }
                            });
                            AlertDialog d1 = b1.create();
                            d1.show();
                        } else {
                            soundPool.play(errorSound, 1, 1, 1, 0, 1);
                        }
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
        });
    }

    @Override
    public void onBackPressed() {
        AlertDialog.Builder b = new AlertDialog.Builder(HomeActivity.this);
        b.setTitle("Are you sure you want to discard this ticket?");
        b.setPositiveButton("YES", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Intent iChoose = new Intent(HomeActivity.this, ChooseTicketType.class);
                iChoose.putExtra("roleType", role);
                iChoose.putExtra("gameType", game);
                startActivity(iChoose);
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
