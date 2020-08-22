package com.example.tambolahome;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
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

    TextView randomTicket, customTicket;
    ExtendedFloatingActionButton doneBtn;
    List<View> views = new ArrayList<View>();
    ImageView goBack, goHome;

    public void changeSelected(View view) {
        for (View v : views) {
            v.setBackgroundResource(R.drawable.ticket_unselected);
        }
        if (selected != 0) {
            view.setBackgroundResource(R.drawable.ticket_selected);
            doneBtn.setClickable(true);
        } else {
            doneBtn.setClickable(false);
        }
    }

    int selected;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_ticket);

        goBack = findViewById(R.id.go_back);
        goHome = findViewById(R.id.go_home);

        goBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ChooseTicketType.super.onBackPressed();
            }
        });

        goHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
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
                selected = 1;
                randomTicket.setTypeface(randomTicket.getTypeface(), Typeface.BOLD);
                randomTicket.setTextSize(TypedValue.COMPLEX_UNIT_SP, 36);
                customTicket.setTypeface(randomTicket.getTypeface(), Typeface.NORMAL);
                customTicket.setTextSize(TypedValue.COMPLEX_UNIT_SP, 28);
                changeSelected(view);
            }
        });

        customTicket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selected = 2;
                customTicket.setTypeface(randomTicket.getTypeface(), Typeface.BOLD);
                customTicket.setTextSize(TypedValue.COMPLEX_UNIT_SP, 36);
                randomTicket.setTypeface(randomTicket.getTypeface(), Typeface.NORMAL);
                randomTicket.setTextSize(TypedValue.COMPLEX_UNIT_SP, 28);
                changeSelected(view);
            }
        });

        doneBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (selected == 1) {
                    Intent randomIntent = new Intent(ChooseTicketType.this, TicketList.class);
                    startActivity(randomIntent);
                } else if (selected == 2) {
                    Intent randomIntent = new Intent(ChooseTicketType.this, HomeActivity.class);
                    startActivity(randomIntent);
                }
                doneBtn.setClickable(false);
                selected = 0;
                changeSelected(view);
                randomTicket.setTypeface(randomTicket.getTypeface(), Typeface.NORMAL);
                randomTicket.setTextSize(TypedValue.COMPLEX_UNIT_SP, 28);
                customTicket.setTypeface(randomTicket.getTypeface(), Typeface.NORMAL);
                customTicket.setTextSize(TypedValue.COMPLEX_UNIT_SP, 28);
            }
        });
    }
}
