package com.example.tambolahome;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class HomePage extends AppCompatActivity {

    TextView newGame, createGame, howToPLay;
    RelativeLayout layout, appLogo;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);

        layout = findViewById(R.id.home_layout);
        appLogo = findViewById(R.id.app_logo);
        AnimationDrawable animd = (AnimationDrawable) layout.getBackground();
        animd.setEnterFadeDuration(25);
        animd.setExitFadeDuration(2000);
        animd.start();

        newGame = findViewById(R.id.new_game);
//        createGame = findViewById(R.id.create_game);
        howToPLay = findViewById(R.id.how_to);

        appLogo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Animation popupAnim = AnimationUtils.loadAnimation(HomePage.this, R.anim.popup);
                appLogo.startAnimation(popupAnim);
            }
        });

        newGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent newGame = new Intent(HomePage.this, ChooseTicketType.class);
                startActivity(newGame);
            }
        });

//        createGame.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent icreate = new Intent(HomePage.this, HomeActivity.class);
//                startActivity(icreate);
//            }
//        });

        howToPLay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent howToPlay = new Intent(HomePage.this, HowToPlay.class);
                startActivity(howToPlay);
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
