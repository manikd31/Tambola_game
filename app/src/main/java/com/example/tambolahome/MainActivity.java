package com.example.tambolahome;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
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

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    List<TextView> tr1 = new ArrayList<TextView>();
    List<TextView> tr2 = new ArrayList<TextView>();
    List<TextView> tr3 = new ArrayList<TextView>();

    List<List<TextView>> tt = new ArrayList<List<TextView>>();

    List<List<Integer>> nums = new ArrayList<List<Integer>>();

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
                    tt.get(r).get(c).setBackgroundResource(R.drawable.ticket_number_done);
                } else {
                    tt.get(r).get(c).setClickable(false);
                    tt.get(r).get(c).setBackgroundResource(R.drawable.ticket_number_undone);
                }
            }
        }
    }

    LinearLayout changePen, newGame, undo;
    TextView undoText;
    ImageView imgpen, imgnew, goHome, goBack, undoImg;

//    int pen = 0;

    int stroke = 0;
    boolean showAgain;
    boolean undoClicked;
    int count;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        count = 0;
        showAgain = true;
        ids = new ArrayList<Integer>();

        RelativeLayout layout = findViewById(R.id.game_layout);
        AnimationDrawable animd = (AnimationDrawable) layout.getBackground();
        animd.setEnterFadeDuration(25);
        animd.setExitFadeDuration(2500);
        animd.start();

        Intent i = getIntent();

        List<Integer> row1 = i.getIntegerArrayListExtra("row1");
        List<Integer> row2 = i.getIntegerArrayListExtra("row2");
        List<Integer> row3 = i.getIntegerArrayListExtra("row3");

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
        undoClicked = false;
        goHome = findViewById(R.id.home_layout);
        goBack = findViewById(R.id.go_back);

        undo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!undoClicked) {
                    undoImg.setImageResource(R.drawable.ic_done_white_24);
                    undoText.setText("Done");
                    changePen.setClickable(false);
                    newGame.setClickable(false);
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
                }
                undoClicked = !undoClicked;
            }
        });

        goBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
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
//
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
                AlertDialog.Builder b = new AlertDialog.Builder(MainActivity.this);
                b.setTitle("Select ticket type");
                b.setPositiveButton("Random", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Intent inew = new Intent(MainActivity.this, TicketList.class);
                        startActivity(inew);
                    }
                });
                b.setNegativeButton("Custom", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Intent icreate = new Intent(MainActivity.this, HomeActivity.class);
                        startActivity(icreate);
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
                    item.setTextSize(TypedValue.COMPLEX_UNIT_SP, 24);

                    if (count == 15) {
                        AlertDialog.Builder b = new AlertDialog.Builder(this);
                        b.setTitle("Congratulations!");
                        b.setMessage("You got a Full House");
                        b.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
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
                view.setBackgroundResource(R.drawable.ticket_number_done);
                ids.remove((Integer) view.getId());
                TextView item = (TextView) view;
                item.setTextSize(TypedValue.COMPLEX_UNIT_SP, 36);
            }
        }
    }
}