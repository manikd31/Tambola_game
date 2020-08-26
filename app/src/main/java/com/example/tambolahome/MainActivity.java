package com.example.tambolahome;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.media.AudioAttributes;
import android.media.SoundPool;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.graphics.drawable.DrawableCompat;

import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

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

    LinearLayout changePen, newGame, undo, gameBoard, roomDisplay, hostDisplay, roleDisplay;
    TextView undoText, numberGen, roleView, passView, hostView;
    ExtendedFloatingActionButton pickNumber;
    ImageView imgpen, imgnew, goHome, goBack, undoImg;
    SoundPool soundPool;

    int stroke = 0;
    boolean showAgain;
    boolean undoClicked;
    int count;
    boolean[] numsDone;
    Random random = new Random();

    int buttonSound, backSound, clickSound, errorSound, winSound, cheerSound;
    String roomHost, roomPlayerRole, roomPass;

    private void roomDetailsAlert() {
        AlertDialog.Builder b = new AlertDialog.Builder(MainActivity.this);
        b.setTitle("Game Room Details");
        String line1 = "Host : " + roomHost;
        String line2 = "\nPassword : " + roomPass;
        String line3 = "\n\n\nYou are: " + roomPlayerRole;
        b.setMessage(line1 + line2 + line3);
        b.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });
        AlertDialog d = b.create();
        d.show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent intent = getIntent();
        roomPlayerRole = intent.getStringExtra("roleType");
        List<Integer> row1 = intent.getIntegerArrayListExtra("row1");
        List<Integer> row2 = intent.getIntegerArrayListExtra("row2");
        List<Integer> row3 = intent.getIntegerArrayListExtra("row3");

        roleView = findViewById(R.id.role_name);
        passView = findViewById(R.id.room_pass);
        hostView = findViewById(R.id.host_name);

        roleDisplay = findViewById(R.id.role_display);
        roomDisplay = findViewById(R.id.room_display);
        hostDisplay = findViewById(R.id.host_display);

        roleDisplay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                roomDetailsAlert();
            }
        });

        roomDisplay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                roomDetailsAlert();
            }
        });

        hostDisplay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                roomDetailsAlert();
            }
        });

        roomPass = "12345";
        roomHost = "Manik";

        roleView.setText(roomPlayerRole);
        hostView.setText(roomHost);
        passView.setText(roomPass);

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
        ids = new ArrayList<Integer>();

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
                    AlertDialog.Builder b = new AlertDialog.Builder(MainActivity.this);
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
//                    Toast.makeText(MainActivity.this, "All numbers are picked. Go for a new game.", Toast.LENGTH_LONG).show();
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
                AlertDialog.Builder b = new AlertDialog.Builder(MainActivity.this);
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
                        AlertDialog.Builder b1 = new AlertDialog.Builder(MainActivity.this);
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
                        AlertDialog.Builder b = new AlertDialog.Builder(MainActivity.this);
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
                AlertDialog.Builder b = new AlertDialog.Builder(MainActivity.this);
                b.setTitle("You will lose any unsaved changes. Confirm?");
                b.setPositiveButton("YES", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        MainActivity.super.onBackPressed();
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

        final int[] pens = {R.drawable.ic_pen_red, R.drawable.ic_pen_blue, R.drawable.ic_pen_green,
                R.drawable.ic_pen_orange, R.drawable.ic_pen_pink, R.drawable.ic_pen_purple};

        final String[] colors = {"Red", "Blue", "Green", "Orange", "Pink", "Purple"};

        final int[] strokes = {R.drawable.done_red, R.drawable.done_blue, R.drawable.done_green,
                R.drawable.done_orange, R.drawable.done_pink, R.drawable.done_purple};

        stroke = strokes[0];

        final int[] penColor = {0};

        changePen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                soundPool.play(buttonSound, 1, 1, 1, 0, 1);
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
//
                builder.setTitle("Choose a color");
                builder.setIcon(imgpen.getDrawable());

                builder.setSingleChoiceItems(colors, 0, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
//                        imgpen.setImageResource(pens[i]);
                        penColor[0] = pens[i];
                        stroke = strokes[i];
                    }
                });

                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                        imgpen.setImageResource(penColor[0]);
                    }
                });

                AlertDialog dialog = builder.create();
                dialog.show();
            }
        });

        goHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                soundPool.play(buttonSound, 1, 1, 1, 0, 1);
                AlertDialog.Builder b = new AlertDialog.Builder(MainActivity.this);
                b.setTitle("You will lose any unsaved changes. Confirm?");
                b.setPositiveButton("YES", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Intent iHome = new Intent(MainActivity.this, HomePage.class);
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
                AlertDialog.Builder b = new AlertDialog.Builder(MainActivity.this);
                b.setTitle("Select ticket type");
                b.setPositiveButton("Random", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Intent iRandom = new Intent(MainActivity.this, TicketList.class);
                        iRandom.putExtra("roleType", roomPlayerRole);
                        startActivity(iRandom);
                    }
                });
                b.setNegativeButton("Custom", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Intent iCreate = new Intent(MainActivity.this, HomeActivity.class);
                        iCreate.putExtra("roleType", roomPlayerRole);
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
        AlertDialog.Builder b = new AlertDialog.Builder(MainActivity.this);
        b.setTitle("You will lose any unsaved changes. Confirm?");
        b.setPositiveButton("YES", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                MainActivity.super.onBackPressed();
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
}