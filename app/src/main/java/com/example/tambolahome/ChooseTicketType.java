package com.example.tambolahome;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.media.AudioAttributes;
import android.media.SoundPool;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class ChooseTicketType extends AppCompatActivity {

    TextView randomTicket, customTicket, gameRole;
    ExtendedFloatingActionButton doneBtn;
    List<View> views = new ArrayList<View>();
    ImageView goBack, goHome;
    LinearLayout gameRoleLayout;

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
    String role, roleText;
    int buttonSound, backSound, clickSound;
    SoundPool soundPool;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_ticket);

        gameRole = findViewById(R.id.game_role);
        gameRoleLayout = findViewById(R.id.game_role_layout);

        gameRoleLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder b = new AlertDialog.Builder(ChooseTicketType.this);
                b.setTitle("Game Role");
                String showMsg;
                if (roleText.equals("Not logged in")) {
                    showMsg = "You are not logged in.";
                } else {
                    showMsg = "You are logged in as: " + roleText;
                }
                b.setMessage(showMsg);
                b.setPositiveButton("Change", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        AlertDialog.Builder b1 = new AlertDialog.Builder(ChooseTicketType.this);
                        b1.setTitle("Change Game Role");
                        b1.setMessage("Are you sure you want to change your game role?");
                        b1.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Intent iChange = new Intent(ChooseTicketType.this, ChooseRoleType.class);
                                startActivity(iChange);
                            }
                        });
                        b1.setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                dialogInterface.dismiss();
                            }
                        });
                        AlertDialog d1 = b1.create();
                        d1.show();
                    }
                });
                b.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                });
                AlertDialog d = b.create();
                d.show();
            }
        });

        Intent iRole = getIntent();
        if (iRole.hasExtra("roleType")) {
            role = iRole.getStringExtra("roleType");
        } else {
            role = "";
        }

        if (TextUtils.isEmpty(role)) {
            roleText = "Not logged in";
        } else {
            roleText = role;
        }

        gameRole.setText(roleText);

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
                if (TextUtils.isEmpty(role)) {
                    AlertDialog.Builder b = new AlertDialog.Builder(ChooseTicketType.this);
                    b.setTitle("Game Role Error");
                    b.setMessage("You need to choose a game role before starting.");
                    b.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            Intent intent = new Intent(ChooseTicketType.this, ChooseRoleType.class);
                            startActivity(intent);
                        }
                    });
                    AlertDialog d = b.create();
                    d.show();
                } else {
                    if (selected == 1) {
                        Intent iRandom = new Intent(ChooseTicketType.this, TicketList.class);
                        iRandom.putExtra("roleType", role);
                        startActivity(iRandom);
                    } else if (selected == 2) {
                        Intent iCreate = new Intent(ChooseTicketType.this, HomeActivity.class);
                        iCreate.putExtra("roleType", role);
                        startActivity(iCreate);
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
            }
        });
    }

    @Override
    public void onBackPressed() {
        Intent iBack = new Intent(ChooseTicketType.this, ChooseRoleType.class);
        startActivity(iBack);
    }
}
