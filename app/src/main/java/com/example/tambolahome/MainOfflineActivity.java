package com.example.tambolahome;

import android.annotation.SuppressLint;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.AnimationDrawable;
import android.media.AudioAttributes;
import android.media.SoundPool;
import android.os.Bundle;
import android.os.IBinder;
import android.os.PowerManager;
import android.text.TextUtils;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;
import com.larswerkman.holocolorpicker.ColorPicker;
import com.larswerkman.holocolorpicker.OpacityBar;
import com.larswerkman.holocolorpicker.SaturationBar;
import com.larswerkman.holocolorpicker.ValueBar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Random;

public class MainOfflineActivity extends AppCompatActivity implements View.OnClickListener {

    List<TextView> tr1 = new ArrayList<TextView>();
    List<TextView> tr2 = new ArrayList<TextView>();
    List<TextView> tr3 = new ArrayList<TextView>();

    List<List<TextView>> tt = new ArrayList<List<TextView>>();

    List<List<Integer>> nums = new ArrayList<List<Integer>>();

    List<TextView> boardNums;

    public void initBoard(View board) {
        boardNums = new ArrayList<TextView>();

        boardNums.add((TextView) board.findViewById(R.id.num1));
        boardNums.add((TextView) board.findViewById(R.id.num2));
        boardNums.add((TextView) board.findViewById(R.id.num3));
        boardNums.add((TextView) board.findViewById(R.id.num4));
        boardNums.add((TextView) board.findViewById(R.id.num5));
        boardNums.add((TextView) board.findViewById(R.id.num6));
        boardNums.add((TextView) board.findViewById(R.id.num7));
        boardNums.add((TextView) board.findViewById(R.id.num8));
        boardNums.add((TextView) board.findViewById(R.id.num9));
        boardNums.add((TextView) board.findViewById(R.id.num10));
        boardNums.add((TextView) board.findViewById(R.id.num11));
        boardNums.add((TextView) board.findViewById(R.id.num12));
        boardNums.add((TextView) board.findViewById(R.id.num13));
        boardNums.add((TextView) board.findViewById(R.id.num14));
        boardNums.add((TextView) board.findViewById(R.id.num15));
        boardNums.add((TextView) board.findViewById(R.id.num16));
        boardNums.add((TextView) board.findViewById(R.id.num17));
        boardNums.add((TextView) board.findViewById(R.id.num18));
        boardNums.add((TextView) board.findViewById(R.id.num19));
        boardNums.add((TextView) board.findViewById(R.id.num20));
        boardNums.add((TextView) board.findViewById(R.id.num21));
        boardNums.add((TextView) board.findViewById(R.id.num22));
        boardNums.add((TextView) board.findViewById(R.id.num23));
        boardNums.add((TextView) board.findViewById(R.id.num24));
        boardNums.add((TextView) board.findViewById(R.id.num25));
        boardNums.add((TextView) board.findViewById(R.id.num26));
        boardNums.add((TextView) board.findViewById(R.id.num27));
        boardNums.add((TextView) board.findViewById(R.id.num28));
        boardNums.add((TextView) board.findViewById(R.id.num29));
        boardNums.add((TextView) board.findViewById(R.id.num30));
        boardNums.add((TextView) board.findViewById(R.id.num31));
        boardNums.add((TextView) board.findViewById(R.id.num32));
        boardNums.add((TextView) board.findViewById(R.id.num33));
        boardNums.add((TextView) board.findViewById(R.id.num34));
        boardNums.add((TextView) board.findViewById(R.id.num35));
        boardNums.add((TextView) board.findViewById(R.id.num36));
        boardNums.add((TextView) board.findViewById(R.id.num37));
        boardNums.add((TextView) board.findViewById(R.id.num38));
        boardNums.add((TextView) board.findViewById(R.id.num39));
        boardNums.add((TextView) board.findViewById(R.id.num40));
        boardNums.add((TextView) board.findViewById(R.id.num41));
        boardNums.add((TextView) board.findViewById(R.id.num42));
        boardNums.add((TextView) board.findViewById(R.id.num43));
        boardNums.add((TextView) board.findViewById(R.id.num44));
        boardNums.add((TextView) board.findViewById(R.id.num45));
        boardNums.add((TextView) board.findViewById(R.id.num46));
        boardNums.add((TextView) board.findViewById(R.id.num47));
        boardNums.add((TextView) board.findViewById(R.id.num48));
        boardNums.add((TextView) board.findViewById(R.id.num49));
        boardNums.add((TextView) board.findViewById(R.id.num50));
        boardNums.add((TextView) board.findViewById(R.id.num51));
        boardNums.add((TextView) board.findViewById(R.id.num52));
        boardNums.add((TextView) board.findViewById(R.id.num53));
        boardNums.add((TextView) board.findViewById(R.id.num54));
        boardNums.add((TextView) board.findViewById(R.id.num55));
        boardNums.add((TextView) board.findViewById(R.id.num56));
        boardNums.add((TextView) board.findViewById(R.id.num57));
        boardNums.add((TextView) board.findViewById(R.id.num58));
        boardNums.add((TextView) board.findViewById(R.id.num59));
        boardNums.add((TextView) board.findViewById(R.id.num60));
        boardNums.add((TextView) board.findViewById(R.id.num61));
        boardNums.add((TextView) board.findViewById(R.id.num62));
        boardNums.add((TextView) board.findViewById(R.id.num63));
        boardNums.add((TextView) board.findViewById(R.id.num64));
        boardNums.add((TextView) board.findViewById(R.id.num65));
        boardNums.add((TextView) board.findViewById(R.id.num66));
        boardNums.add((TextView) board.findViewById(R.id.num67));
        boardNums.add((TextView) board.findViewById(R.id.num68));
        boardNums.add((TextView) board.findViewById(R.id.num69));
        boardNums.add((TextView) board.findViewById(R.id.num70));
        boardNums.add((TextView) board.findViewById(R.id.num71));
        boardNums.add((TextView) board.findViewById(R.id.num72));
        boardNums.add((TextView) board.findViewById(R.id.num73));
        boardNums.add((TextView) board.findViewById(R.id.num74));
        boardNums.add((TextView) board.findViewById(R.id.num75));
        boardNums.add((TextView) board.findViewById(R.id.num76));
        boardNums.add((TextView) board.findViewById(R.id.num77));
        boardNums.add((TextView) board.findViewById(R.id.num78));
        boardNums.add((TextView) board.findViewById(R.id.num79));
        boardNums.add((TextView) board.findViewById(R.id.num80));
        boardNums.add((TextView) board.findViewById(R.id.num81));
        boardNums.add((TextView) board.findViewById(R.id.num82));
        boardNums.add((TextView) board.findViewById(R.id.num83));
        boardNums.add((TextView) board.findViewById(R.id.num84));
        boardNums.add((TextView) board.findViewById(R.id.num85));
        boardNums.add((TextView) board.findViewById(R.id.num86));
        boardNums.add((TextView) board.findViewById(R.id.num87));
        boardNums.add((TextView) board.findViewById(R.id.num88));
        boardNums.add((TextView) board.findViewById(R.id.num89));
        boardNums.add((TextView) board.findViewById(R.id.num90));

        for (int i = 0; i < 90; i++) {
            boardNums.get(i).setBackgroundResource(R.drawable.number_circle_undone);
        }
    }

    public void initTicket() {

        tr1.add((TextView) findViewById(R.id.col1a));
        tr1.add((TextView) findViewById(R.id.col2a));
        tr1.add((TextView) findViewById(R.id.col3a));
        tr1.add((TextView) findViewById(R.id.col4a));
        tr1.add((TextView) findViewById(R.id.col5a));
        tr1.add((TextView) findViewById(R.id.col6a));
        tr1.add((TextView) findViewById(R.id.col7a));
        tr1.add((TextView) findViewById(R.id.col8a));
        tr1.add((TextView) findViewById(R.id.col9a));

        tr2.add((TextView) findViewById(R.id.col1b));
        tr2.add((TextView) findViewById(R.id.col2b));
        tr2.add((TextView) findViewById(R.id.col3b));
        tr2.add((TextView) findViewById(R.id.col4b));
        tr2.add((TextView) findViewById(R.id.col5b));
        tr2.add((TextView) findViewById(R.id.col6b));
        tr2.add((TextView) findViewById(R.id.col7b));
        tr2.add((TextView) findViewById(R.id.col8b));
        tr2.add((TextView) findViewById(R.id.col9b));

        tr3.add((TextView) findViewById(R.id.col1c));
        tr3.add((TextView) findViewById(R.id.col2c));
        tr3.add((TextView) findViewById(R.id.col3c));
        tr3.add((TextView) findViewById(R.id.col4c));
        tr3.add((TextView) findViewById(R.id.col5c));
        tr3.add((TextView) findViewById(R.id.col6c));
        tr3.add((TextView) findViewById(R.id.col7c));
        tr3.add((TextView) findViewById(R.id.col8c));
        tr3.add((TextView) findViewById(R.id.col9c));

        tt.add(tr1);
        tt.add(tr2);
        tt.add(tr3);

    }

    List<Integer> ids;

    public void makeTicket() {
        for (int r = 0; r < 3; r++) {
            for (int c = 0; c < 9; c++) {
                tt.get(r).get(c).setOnClickListener(this);
                int num = nums.get(r).get(c);
                Log.i("Make Ticket: ", r + "," + c + ":::::" + num);
                if (num != 0 && !TextUtils.isEmpty(String.valueOf(num))) {
                    String n = String.valueOf(num);
                    tt.get(r).get(c).setText(n);
                    tt.get(r).get(c).setClickable(true);
                    tt.get(r).get(c).setBackgroundResource(R.drawable.ticket_number_effect);
                } else {
                    tt.get(r).get(c).setClickable(false);
                    tt.get(r).get(c).setBackgroundResource(R.drawable.ticket_number_undone);
                }
            }
        }
    }

    LinearLayout changePen, newGame, undo, gameBoard, roleDisplay;
    TextView undoText, numberGen, roleView;
    ExtendedFloatingActionButton pickNumber;
    ImageView imgpen, imgnew, goHome, goBack, undoImg;
    SoundPool soundPool;
    SharedPreferences songPrefs;
    int initColorForPalette, opac, val, sat, finalColor;
    List<Integer> hexColors = new ArrayList<>();
    String[] codes = {"#ffa589", "#ff3700", "#f10000", "#d70060", "#f700ff", "#ff4f98", "#00ffff", "#00b1b4", "#ff8d00", "#ffb640",
            "#ffdc26", "#fff16e", "#009900", "#00d400", "#a3ff96", "#0000f1", "#0089ff", "#5bb7ff", "#7600ff", "#a76bff"};

    GridView colorGrid;
    int ALPHA = 255;
    int RED = 0;
    int BLUE = 0;
    int GREEN = 0;
    int colorHexCode;

    int stroke = 0;
    boolean showAgain;
    boolean undoClicked, playSong;
    int count;
    boolean[] numsDone;
    Random random = new Random();
    int buttonSound, backSound, clickSound, errorSound, winSound, cheerSound;
    String roomPlayerRole, game;

    List<String> colorValues = new ArrayList<String>();

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

    private void roomDetailsAlert() {
        AlertDialog.Builder b = new AlertDialog.Builder(MainOfflineActivity.this);
        b.setTitle("Game Room Details");
//        String line1 = "Host : " + roomHost;
//        String line2 = "\nPassword : " + roomPass;
//        String line3 = "\n\n\nYou are: " + roomPlayerRole;
//        b.setMessage(line1 + line2 + line3);
        b.setMessage("You are playing an " + game + " game as " + roomPlayerRole);
        b.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });
        AlertDialog d = b.create();
        d.show();
    }

    @SuppressLint("UseCompatLoadingForDrawables")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_offline);

        String[] colVals = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9",
                "a", "A", "b", "B", "c", "C", "d", "D", "e", "E", "f", "F"};
        colorValues.addAll(Arrays.asList(colVals));

        for (String code : codes) {
            hexColors.add(Color.parseColor(code));
        }

        initColorForPalette = hexColors.get(0);

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

        Intent intent = getIntent();
        roomPlayerRole = intent.getStringExtra("roleType");
        game = intent.getStringExtra("gameType");
        songPrefs = getSharedPreferences("MyPrefs", 0);
        String value = songPrefs.getString("playSong", null);
        if (value != null) {
            playSong = Boolean.parseBoolean(value);
        }
        if (playSong) {
            doBindService();
            startService(music);
        }

        List<Integer> row1 = intent.getIntegerArrayListExtra("row1");
        List<Integer> row2 = intent.getIntegerArrayListExtra("row2");
        List<Integer> row3 = intent.getIntegerArrayListExtra("row3");

        roleView = findViewById(R.id.role_name);
        roleView.setText(roomPlayerRole);
        roleDisplay = findViewById(R.id.role_display);
        roleDisplay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                roomDetailsAlert();
            }
        });

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
        errorSound = soundPool.load(this, R.raw.wooden_error_sound, 1);
        winSound = soundPool.load(this, R.raw.win_sound, 1);
        cheerSound = soundPool.load(this, R.raw.cheer_sound, 1);

        count = 0;
        showAgain = true;
        numsDone = new boolean[90];
        for (int i = 0; i < 90; i++) {
            numsDone[i] = false;
        }
        ids = new ArrayList<>();

        RelativeLayout layout = findViewById(R.id.game_layout);
        AnimationDrawable animd = (AnimationDrawable) layout.getBackground();
        animd.setEnterFadeDuration(25);
        animd.setExitFadeDuration(2500);
        animd.start();

        nums.add(row1);
        nums.add(row2);
        nums.add(row3);

        initTicket();
        makeTicket();

        changePen = findViewById(R.id.change_pen_layout);
        newGame = findViewById(R.id.new_game_layout);
        undo = findViewById(R.id.undo_layout);
        undoImg = findViewById(R.id.img_undo);
        undoText = findViewById(R.id.undo);
        gameBoard = findViewById(R.id.game_board);
        undoClicked = false;
        goHome = findViewById(R.id.home_layout);
        goBack = findViewById(R.id.go_back);
        pickNumber = findViewById(R.id.pick_number);
        numberGen = findViewById(R.id.random_number);

        if (roomPlayerRole.equals("GUEST")) {
            pickNumber.setBackgroundColor(Color.parseColor("#979797"));
            pickNumber.setClickable(false);
            pickNumber.setFocusable(false);
            pickNumber.setEnabled(false);
        } else {
            pickNumber.setClickable(true);
            pickNumber.setFocusable(true);
            pickNumber.setEnabled(true);
        }

        pickNumber.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int count = 0;
                for (int i = 0; i < 90; i++) {
                    if (numsDone[i]) {
                        count += 1;
                    }
                }
                if (count == 90) {
                    soundPool.play(errorSound, 1, 1, 1, 0, 1);
                    AlertDialog.Builder b = new AlertDialog.Builder(MainOfflineActivity.this);
                    b.setTitle("Game Over");
                    b.setMessage("All numbers are picked. Go for a new game.");
                    b.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.dismiss();
                        }
                    });
                    AlertDialog d = b.create();
                    d.show();
//                    Toast.makeText(MainOfflineActivity.this, "All numbers are picked. Go for a new game.", Toast.LENGTH_LONG).show();
                } else {
                    soundPool.play(clickSound, 1, 1, 1, 0, 1);
                    int randomNumber = random.nextInt(90);
                    while (numsDone[randomNumber]) {
                        randomNumber = random.nextInt(90);
                    }
                    numsDone[randomNumber] = true;
                    numberGen.setText(String.valueOf(randomNumber + 1));
                }
            }
        });

        gameBoard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                soundPool.play(buttonSound, 1, 1, 1, 0, 1);
                AlertDialog.Builder b = new AlertDialog.Builder(MainOfflineActivity.this);
                b.setTitle("Game Board");
                View board = getLayoutInflater().inflate(R.layout.game_board, null);
                initBoard(board);
                b.setView(board);
                b.setPositiveButton("DONE", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                });
                b.setNeutralButton("Missing numbers?", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        AlertDialog.Builder b1 = new AlertDialog.Builder(MainOfflineActivity.this);
                        b1.setTitle("Can't see some of the numbers?");
                        b1.setMessage("Scroll down on the Game Board to see all the numbers.");
                        b1.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface1, int i) {
                                dialogInterface1.dismiss();
                            }
                        });
                        AlertDialog d1 = b1.create();
                        d1.show();
                    }
                });
                for (int i = 0; i < 90; i++) {
                    if (numsDone[i]) {
                        boardNums.get(i).setBackgroundResource(R.drawable.number_circle_done);
                        boardNums.get(i).setTextColor(getColor(android.R.color.white));
                    }
                }
                AlertDialog d = b.create();
                d.show();
            }
        });

        undo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                soundPool.play(buttonSound, 1, 1, 1, 0, 1);
                if (!undoClicked) {
                    undoImg.setImageResource(R.drawable.ic_done_white_24);
                    undoText.setText("Done");
                    changePen.setClickable(false);
                    newGame.setClickable(false);
                    pickNumber.setClickable(false);
                    if (showAgain) {
                        AlertDialog.Builder b = new AlertDialog.Builder(MainOfflineActivity.this);
                        b.setTitle("Select the numbers you want to UNDO. Once you're done, click on DONE (top-right of the screen).");
                        b.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                dialogInterface.dismiss();
                            }
                        });
                        b.setNeutralButton("Don't show again", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                showAgain = false;
                                dialogInterface.dismiss();
                            }
                        });
                        AlertDialog d = b.create();
                        d.show();
                    }
                } else {
                    undoImg.setImageResource(R.drawable.ic_undo_24);
                    undoText.setText("Undo");
                    changePen.setClickable(true);
                    newGame.setClickable(true);
                    pickNumber.setClickable(true);
                }
                undoClicked = !undoClicked;
            }
        });

        goBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                soundPool.play(backSound, 1, 1, 1, 0, 1);
                AlertDialog.Builder b = new AlertDialog.Builder(MainOfflineActivity.this);
                b.setTitle("You will lose any unsaved changes. Confirm?");
                b.setPositiveButton("YES", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        MainOfflineActivity.super.onBackPressed();
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

        imgpen = findViewById(R.id.img_pen);
        imgnew = findViewById(R.id.img_new);

        stroke = R.drawable.done_red;
        Objects.requireNonNull(getDrawable(stroke)).setTint(initColorForPalette);

        changePen.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("UseCompatLoadingForDrawables")
            @Override
            public void onClick(View view) {
                soundPool.play(buttonSound, 1, 1, 1, 0, 1);
                AlertDialog.Builder b = new AlertDialog.Builder(MainOfflineActivity.this);
                b.setTitle("Color Selection");
                b.setIcon(imgpen.getDrawable());
                b.setMessage("Choose how you want to change the pen-color");
                b.setNeutralButton("IN-BUILT", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        AlertDialog.Builder b = new AlertDialog.Builder(MainOfflineActivity.this);
                        b.setTitle("Choose Your Color");
                        b.setIcon(imgpen.getDrawable());
                        View layout = getLayoutInflater().inflate(R.layout.custom_dialog_view, null);
                        colorGrid = layout.findViewById(R.id.grid_view);
                        ColorAdapter adapter = new ColorAdapter();
                        colorGrid.setAdapter(adapter);
                        colorGrid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                            @Override
                            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                                finalColor = hexColors.get(i);
                                Objects.requireNonNull(getDrawable(R.drawable.color_selected)).setTint(finalColor);
                                for (int child = 0; child < adapterView.getChildCount(); child++) {
                                    ImageView v = adapterView.getChildAt(child).findViewById(R.id.grid_view_image);
                                    if (i != child) {
                                        Objects.requireNonNull(getDrawable(R.drawable.color_default)).setTint(hexColors.get(child));
                                        v.setImageResource(R.drawable.color_default);
//                                        v.getDrawable().setTint(hexColors.get(child));
                                    } else {
                                        v.setImageResource(R.drawable.ic_round_black_check_24);
                                        v.setBackground(getDrawable(R.drawable.color_selected));
                                    }
                                }
                            }
                        });
                        b.setView(layout);
                        b.setPositiveButton("DONE", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                initColorForPalette = finalColor;
                                imgpen.setColorFilter(finalColor);
                                Objects.requireNonNull(getDrawable(stroke)).setTint(finalColor);
                            }
                        });
                        b.setNegativeButton("CANCEL", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                dialogInterface.dismiss();
                            }
                        });
                        AlertDialog d = b.create();
                        d.show();
                    }
                });
                b.setNegativeButton("Palette", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        AlertDialog.Builder b = new AlertDialog.Builder(MainOfflineActivity.this);
                        b.setTitle("Choose Color");
                        b.setIcon(imgpen.getDrawable());
                        View palette = getLayoutInflater().inflate(R.layout.palette_layout, null);
                        b.setView(palette);

                        final ColorPicker colorPicker = palette.findViewById(R.id.color_picker);
                        OpacityBar opacityBar = palette.findViewById(R.id.opacity_bar);
                        final SaturationBar saturationBar = palette.findViewById(R.id.saturation_bar);
                        ValueBar valueBar = palette.findViewById(R.id.value_bar);
                        colorPicker.addOpacityBar(opacityBar);
                        colorPicker.addSaturationBar(saturationBar);
                        colorPicker.addValueBar(valueBar);

                        colorPicker.setShowOldCenterColor(false);
                        colorPicker.setOnColorChangedListener(new ColorPicker.OnColorChangedListener() {
                            @Override
                            public void onColorChanged(int color) {
                                finalColor = color;
                            }
                        });
                        opacityBar.setOnOpacityChangedListener(new OpacityBar.OnOpacityChangedListener() {
                            @Override
                            public void onOpacityChanged(int opacity) {
                                opac = opacity;
                            }
                        });
                        saturationBar.setOnSaturationChangedListener(new SaturationBar.OnSaturationChangedListener() {
                            @Override
                            public void onSaturationChanged(int saturation) {
                                sat = saturation;
                            }
                        });
                        valueBar.setOnValueChangedListener(new ValueBar.OnValueChangedListener() {
                            @Override
                            public void onValueChanged(int value) {
                                val = value;
                            }
                        });
                        b.setPositiveButton("DONE", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                finalColor = colorPicker.getColor();
                                initColorForPalette = finalColor;
                                imgpen.setColorFilter(finalColor);
                                Objects.requireNonNull(getDrawable(stroke)).setTint(finalColor);
                            }
                        });
                        b.setNegativeButton("CANCEL", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Toast.makeText(MainOfflineActivity.this, "Cancelled.", Toast.LENGTH_SHORT).show();
                            }
                        });
                        AlertDialog d = b.create();
                        d.show();


//                        Log.i("Palette -----> ", String.valueOf(initColorForPalette));
//                        AmbilWarnaDialog d = new AmbilWarnaDialog(MainOfflineActivity.this, initColorForPalette, true, new AmbilWarnaDialog.OnAmbilWarnaListener() {
//                            @Override
//                            public void onCancel(AmbilWarnaDialog dialog) {}
//
//                            @Override
//                            public void onOk(AmbilWarnaDialog dialog, int color) {
//                                finalColorForPalette = color;
//                                finalColor = finalColorForPalette;
//                                initColorForPalette = finalColor;
//                                imgpen.setColorFilter(finalColor);
//                                Objects.requireNonNull(getDrawable(stroke)).setTint(finalColor);
//                            }
//                        });
//                        d.show();


//                        AlertDialog.Builder b = new AlertDialog.Builder(MainOfflineActivity.this);
//                        b.setTitle("Choose pen colour");
//                        b.setIcon(imgpen.getDrawable());
//                        View colorPicker = getLayoutInflater().inflate(R.layout.color_picker_layout, null);
//                        b.setView(colorPicker);
//
//                        final EditText colorCodeView = colorPicker.findViewById(R.id.color_code);
//                        colorCodeView.setText(defaultColorHexCode);
//                        final TextView colorBlock = colorPicker.findViewById(R.id.color_block);
//                        colorBlock.setBackgroundColor(Color.parseColor(colorHash + defaultColorHexCode));
//                        Button checkColor = colorPicker.findViewById(R.id.checkColor);
//                        checkColor.setOnClickListener(new View.OnClickListener() {
//                            @Override
//                            public void onClick(View view) {
//                                String colorCodeText = colorCodeView.getText().toString().trim();
//                                Log.i("Color Code Length --> ", String.valueOf(colorCodeText.length()));
//                                if (colorCodeText.length() != 6) {
//                                    Toast.makeText(MainOfflineActivity.this, "Invalid Color Code", Toast.LENGTH_SHORT).show();
//                                } else {
//                                    int flag = 0;
//                                    String[] codeValues = colorCodeText.split("");
//                                    for (String cv : codeValues) {
//                                        if (!colorValues.contains(cv)) {
//                                            flag = 1;
//                                            Log.i("Color Code Value --> ", String.valueOf(cv));
//                                            break;
//                                        }
//                                    }
//                                    if (flag == 1) {
//                                        Toast.makeText(MainOfflineActivity.this, "Invalid Color Code", Toast.LENGTH_SHORT).show();
//                                    } else {
//                                        defaultColorHexCode = colorCodeText;
//                                        colorBlock.setBackgroundColor(Color.parseColor(colorHash + defaultColorHexCode));
//                                    }
//                                }
//                            }
//                        });
//
//                        b.setPositiveButton("DONE", new DialogInterface.OnClickListener() {
//                            @SuppressLint("UseCompatLoadingForDrawables")
//                            @Override
//                            public void onClick(DialogInterface dialogInterface1, int i) {
//                                String colorCodeText = colorCodeView.getText().toString().trim();
//                                if (colorCodeText.length() != 6) {
//                                    Toast.makeText(MainOfflineActivity.this, "Invalid Color Code", Toast.LENGTH_SHORT).show();
//                                    dialogInterface1.dismiss();
//                                } else {
//                                    int flag = 0;
//                                    String[] codeValues = colorCodeText.split("");
//                                    for (String cv : codeValues) {
//                                        if (!colorValues.contains(cv)) {
//                                            flag = 1;
//                                        }
//                                    }
//                                    if (flag == 0) {
//                                        Toast.makeText(MainOfflineActivity.this, "Invalid Color Code", Toast.LENGTH_SHORT).show();
//                                    } else {
//                                        defaultColorHexCode = colorCodeText;
//                                        imgpen.setColorFilter(Color.parseColor(colorHash + defaultColorHexCode));
//                                        colorBlock.setBackgroundColor(Color.parseColor(colorHash + defaultColorHexCode));
//                                        Objects.requireNonNull(getDrawable(stroke)).setTint(Color.parseColor(colorHash + defaultColorHexCode));
//                                    }
//                                }
//                            }
//                        });
//
//                        b.setNeutralButton("Default", new DialogInterface.OnClickListener() {
//                            @SuppressLint("UseCompatLoadingForDrawables")
//                            @Override
//                            public void onClick(DialogInterface dialogInterface, int i) {
//                                defaultColorHexCode = "272929";
//                                imgpen.setColorFilter(Color.parseColor(colorHash + defaultColorHexCode));
//                                colorBlock.setBackgroundColor(Color.parseColor(colorHash + defaultColorHexCode));
//                                Objects.requireNonNull(getDrawable(stroke)).setTint(Color.parseColor(colorHash + defaultColorHexCode));
//                            }
//                        });
//
//                        b.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
//                            @Override
//                            public void onClick(DialogInterface dialogInterface, int i) {
//                                dialogInterface.dismiss();
//                            }
//                        });
//
//                        AlertDialog d = b.create();
//                        d.show();
                    }
                }).setPositiveButton("MIXER", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
//                        Toast.makeText(MainOfflineActivity.this, "Color Picker!", Toast.LENGTH_SHORT).show();
                        AlertDialog.Builder b = new AlertDialog.Builder(MainOfflineActivity.this);
                        b.setTitle("Set your own color");
                        b.setIcon(imgpen.getDrawable());
                        View seekBarView = getLayoutInflater().inflate(R.layout.color_seekbar, null);
                        b.setView(seekBarView);

                        final TextView colorBlock = seekBarView.findViewById(R.id.color_block);
                        SeekBar seekRed = seekBarView.findViewById(R.id.seekbar_red);
                        SeekBar seekGreen = seekBarView.findViewById(R.id.seekbar_green);
                        SeekBar seekBlue = seekBarView.findViewById(R.id.seekbar_blue);
                        SeekBar seekAlpha = seekBarView.findViewById(R.id.seekbar_alpha);

                        seekRed.setMax(255);
                        seekRed.setProgress(RED);
                        seekGreen.setMax(255);
                        seekGreen.setProgress(GREEN);
                        seekBlue.setMax(255);
                        seekBlue.setProgress(BLUE);
                        seekAlpha.setMax(255);
                        seekAlpha.setProgress(ALPHA);

                        colorHexCode = Color.argb(ALPHA, RED, GREEN, BLUE);
                        colorBlock.setBackgroundColor(colorHexCode);

                        seekRed.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
                            @Override
                            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                                RED = i;
                                colorHexCode = Color.argb(ALPHA, RED, GREEN, BLUE);
                                colorBlock.setBackgroundColor(colorHexCode);
                            }

                            @Override
                            public void onStartTrackingTouch(SeekBar seekBar) {

                            }

                            @Override
                            public void onStopTrackingTouch(SeekBar seekBar) {

                            }
                        });

                        seekGreen.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
                            @Override
                            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                                GREEN = i;
                                colorHexCode = Color.argb(ALPHA, RED, GREEN, BLUE);
                                colorBlock.setBackgroundColor(colorHexCode);
                            }

                            @Override
                            public void onStartTrackingTouch(SeekBar seekBar) {

                            }

                            @Override
                            public void onStopTrackingTouch(SeekBar seekBar) {

                            }
                        });

                        seekBlue.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
                            @Override
                            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                                BLUE = i;
                                colorHexCode = Color.argb(ALPHA, RED, GREEN, BLUE);
                                colorBlock.setBackgroundColor(colorHexCode);
                            }

                            @Override
                            public void onStartTrackingTouch(SeekBar seekBar) {

                            }

                            @Override
                            public void onStopTrackingTouch(SeekBar seekBar) {

                            }
                        });

                        seekAlpha.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
                            @Override
                            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                                ALPHA = i;
                                colorHexCode = Color.argb(ALPHA, RED, GREEN, BLUE);
                                colorBlock.setBackgroundColor(colorHexCode);
                            }

                            @Override
                            public void onStartTrackingTouch(SeekBar seekBar) {

                            }

                            @Override
                            public void onStopTrackingTouch(SeekBar seekBar) {

                            }
                        });

                        b.setPositiveButton("Done", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                imgpen.setColorFilter(colorHexCode);
                                Objects.requireNonNull(getDrawable(stroke)).setTint(colorHexCode);
                                finalColor = colorHexCode;
                                initColorForPalette = finalColor;
                            }
                        });
                        b.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                dialogInterface.dismiss();
                            }
                        });
                        b.setNeutralButton("Default", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                ALPHA = 255;
                                RED = 39;
                                GREEN = 41;
                                BLUE = 41;
                                colorHexCode = Color.argb(ALPHA, RED, GREEN, BLUE);
                                imgpen.setColorFilter(colorHexCode);
                                Objects.requireNonNull(getDrawable(stroke)).setTint(colorHexCode);
                                finalColor = colorHexCode;
                                initColorForPalette = finalColor;
                            }
                        });

                        AlertDialog d = b.create();
                        d.show();
                    }
                });

                AlertDialog d = b.create();
                d.show();
            }
        });

        goHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                soundPool.play(buttonSound, 1, 1, 1, 0, 1);
                AlertDialog.Builder b = new AlertDialog.Builder(MainOfflineActivity.this);
                b.setTitle("You will lose any unsaved changes. Confirm?");
                b.setPositiveButton("YES", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Intent iHome = new Intent(MainOfflineActivity.this, HomePage.class);
                        iHome.putExtra("playSong", playSong);
                        startActivity(iHome);
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

        newGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                soundPool.play(buttonSound, 1, 1, 1, 0, 1);
                AlertDialog.Builder b = new AlertDialog.Builder(MainOfflineActivity.this);
                b.setTitle("Select ticket type");
                b.setPositiveButton("Random", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Intent iRandom = new Intent(MainOfflineActivity.this, TicketList.class);
                        iRandom.putExtra("roleType", roomPlayerRole);
                        iRandom.putExtra("gameType", game);
                        iRandom.putExtra("playSong", playSong);
                        startActivity(iRandom);
                    }
                });
                b.setNegativeButton("Custom", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Intent iCreate = new Intent(MainOfflineActivity.this, HomeActivity.class);
                        iCreate.putExtra("roleType", roomPlayerRole);
                        iCreate.putExtra("gameType", game);
                        iCreate.putExtra("playSong", playSong);
                        startActivity(iCreate);
                    }
                });
                AlertDialog d = b.create();
                d.show();
            }
        });

    }

    @Override
    public void onBackPressed() {
        AlertDialog.Builder b = new AlertDialog.Builder(MainOfflineActivity.this);
        b.setTitle("You will lose any unsaved changes. Confirm?");
        b.setPositiveButton("YES", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Intent iRole = new Intent(MainOfflineActivity.this, ChooseRoleType.class);
                iRole.putExtra("playSong", playSong);
                startActivity(iRole);
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
    public void onClick(View view) {
        Log.i("Ticket VIEW ::: ", "onClick--" + view.getId());

        if (!undoClicked) {
            if (view.getId() != changePen.getId() && view.getId() != newGame.getId() &&
                    view.getId() != goHome.getId() && view.getId() != undo.getId() &&
                    view.getId() != undoImg.getId() && view.getId() != undoText.getId()) {

                if (!ids.contains(view.getId())) {
                    count += 1;
                    Log.i("Ticket CUT count ---> ", String.valueOf(count));
                    view.setBackgroundResource(stroke);
                    ids.add(view.getId());
                    TextView item = (TextView) view;
                    item.setTextSize(TypedValue.COMPLEX_UNIT_SP, 20);
                    if (count == 15) {
                        soundPool.play(winSound, 1, 1, 1, 0, 1);
                        final int cheerId = soundPool.play(cheerSound, 0.3f, 0.3f, 1, 0, 1);
                        AlertDialog.Builder b = new AlertDialog.Builder(this);
                        b.setTitle("Congratulations!");
                        b.setMessage("You got a Full House");
                        b.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                soundPool.stop(cheerId);
                                dialogInterface.dismiss();
                            }
                        });
                        AlertDialog d = b.create();
                        d.show();
                    }
                }
            }
        } else {
            if (ids.contains(view.getId())) {
                count -= 1;
                Log.i("Ticket UNDO count ---> ", String.valueOf(count));
                view.setBackgroundResource(R.drawable.ticket_number_effect);
                ids.remove((Integer) view.getId());
                TextView item = (TextView) view;
                item.setTextSize(TypedValue.COMPLEX_UNIT_SP, 24);
            }
        }
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

    private class ColorAdapter extends BaseAdapter {
        @Override
        public int getCount() {
            return hexColors.size();
        }

        @Override
        public Object getItem(int i) {
            return i;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @SuppressLint({"UseCompatLoadingForDrawables", "InflateParams"})
        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            View v = view;
            if (view == null) {
                v = getLayoutInflater().inflate(R.layout.custom_grid_layout, null);
            }
            ImageView colImg = v.findViewById(R.id.grid_view_image);
//            colImg.setBackgroundColor(hexColors.get(i));
//            colImg.setColorFilter(hexColors.get(i));
            colImg.setImageResource(R.drawable.color_default);
            colImg.getDrawable().setTint(hexColors.get(i));
//            Objects.requireNonNull(getDrawable(R.drawable.blank_solid)).setTint(hexColors.get(i));
            return v;
        }
    }
}