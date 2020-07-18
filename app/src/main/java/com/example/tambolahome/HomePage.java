package com.example.tambolahome;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class HomePage extends AppCompatActivity {

    TextView newGame, createGame, howToPLay;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);

        RelativeLayout layout = findViewById(R.id.home_layout);
        AnimationDrawable animd = (AnimationDrawable) layout.getBackground();
        animd.setEnterFadeDuration(25);
        animd.setExitFadeDuration(2000);
        animd.start();

        newGame = findViewById(R.id.new_game);
        createGame = findViewById(R.id.create_game);
        howToPLay = findViewById(R.id.how_to);

        newGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent inew = new Intent(HomePage.this, TicketList.class);
                startActivity(inew);
            }
        });

        createGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent icreate = new Intent(HomePage.this, HomeActivity.class);
                startActivity(icreate);
            }
        });

        howToPLay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ihow = new Intent(HomePage.this, HowToPlay.class);
                startActivity(ihow);
            }
        });
    }

    @Override
    public void onBackPressed() {
        AlertDialog.Builder b = new AlertDialog.Builder(HomePage.this);
        b.setTitle("Confirm exit?");
        b.setPositiveButton("YES", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
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
}
