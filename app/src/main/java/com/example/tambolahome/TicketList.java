package com.example.tambolahome;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class TicketList extends AppCompatActivity {

    NumberGenerator numgen = new NumberGenerator();

    List<List<List<Integer>>> nums;

    LinearLayout t1, t2, t3, t4, t5, t6;
    TextView t_num;
    FloatingActionButton play;

    int selected = 1;

    List<TextView> t1r1 = new ArrayList<TextView>();
    List<TextView> t1r2 = new ArrayList<TextView>();
    List<TextView> t1r3 = new ArrayList<TextView>();

    List<TextView> t2r1 = new ArrayList<TextView>();
    List<TextView> t2r2 = new ArrayList<TextView>();
    List<TextView> t2r3 = new ArrayList<TextView>();

    List<TextView> t3r1 = new ArrayList<TextView>();
    List<TextView> t3r2 = new ArrayList<TextView>();
    List<TextView> t3r3 = new ArrayList<TextView>();

    List<TextView> t4r1 = new ArrayList<TextView>();
    List<TextView> t4r2 = new ArrayList<TextView>();
    List<TextView> t4r3 = new ArrayList<TextView>();

    List<TextView> t5r1 = new ArrayList<TextView>();
    List<TextView> t5r2 = new ArrayList<TextView>();
    List<TextView> t5r3 = new ArrayList<TextView>();

    List<TextView> t6r1 = new ArrayList<TextView>();
    List<TextView> t6r2 = new ArrayList<TextView>();
    List<TextView> t6r3 = new ArrayList<TextView>();

    List<List<TextView>> tt1 = new ArrayList<List<TextView>>();
    List<List<TextView>> tt2 = new ArrayList<List<TextView>>();
    List<List<TextView>> tt3 = new ArrayList<List<TextView>>();
    List<List<TextView>> tt4 = new ArrayList<List<TextView>>();
    List<List<TextView>> tt5 = new ArrayList<List<TextView>>();
    List<List<TextView>> tt6 = new ArrayList<List<TextView>>();

    List<List<List<TextView>>> tts = new ArrayList<List<List<TextView>>>();

    public void initT1() {
        t1r1.add((TextView) findViewById(R.id.t1col1a));
        t1r1.add((TextView) findViewById(R.id.t1col2a));
        t1r1.add((TextView) findViewById(R.id.t1col3a));
        t1r1.add((TextView) findViewById(R.id.t1col4a));
        t1r1.add((TextView) findViewById(R.id.t1col5a));
        t1r1.add((TextView) findViewById(R.id.t1col6a));
        t1r1.add((TextView) findViewById(R.id.t1col7a));
        t1r1.add((TextView) findViewById(R.id.t1col8a));
        t1r1.add((TextView) findViewById(R.id.t1col9a));

        t1r2.add((TextView) findViewById(R.id.t1col1b));
        t1r2.add((TextView) findViewById(R.id.t1col2b));
        t1r2.add((TextView) findViewById(R.id.t1col3b));
        t1r2.add((TextView) findViewById(R.id.t1col4b));
        t1r2.add((TextView) findViewById(R.id.t1col5b));
        t1r2.add((TextView) findViewById(R.id.t1col6b));
        t1r2.add((TextView) findViewById(R.id.t1col7b));
        t1r2.add((TextView) findViewById(R.id.t1col8b));
        t1r2.add((TextView) findViewById(R.id.t1col9b));

        t1r3.add((TextView) findViewById(R.id.t1col1c));
        t1r3.add((TextView) findViewById(R.id.t1col2c));
        t1r3.add((TextView) findViewById(R.id.t1col3c));
        t1r3.add((TextView) findViewById(R.id.t1col4c));
        t1r3.add((TextView) findViewById(R.id.t1col5c));
        t1r3.add((TextView) findViewById(R.id.t1col6c));
        t1r3.add((TextView) findViewById(R.id.t1col7c));
        t1r3.add((TextView) findViewById(R.id.t1col8c));
        t1r3.add((TextView) findViewById(R.id.t1col9c));

        tt1.add(t1r1);
        tt1.add(t1r2);
        tt1.add(t1r3);
    }

    public void initT2() {
        t2r1.add((TextView) findViewById(R.id.t2col1a));
        t2r1.add((TextView) findViewById(R.id.t2col2a));
        t2r1.add((TextView) findViewById(R.id.t2col3a));
        t2r1.add((TextView) findViewById(R.id.t2col4a));
        t2r1.add((TextView) findViewById(R.id.t2col5a));
        t2r1.add((TextView) findViewById(R.id.t2col6a));
        t2r1.add((TextView) findViewById(R.id.t2col7a));
        t2r1.add((TextView) findViewById(R.id.t2col8a));
        t2r1.add((TextView) findViewById(R.id.t2col9a));

        t2r2.add((TextView) findViewById(R.id.t2col1b));
        t2r2.add((TextView) findViewById(R.id.t2col2b));
        t2r2.add((TextView) findViewById(R.id.t2col3b));
        t2r2.add((TextView) findViewById(R.id.t2col4b));
        t2r2.add((TextView) findViewById(R.id.t2col5b));
        t2r2.add((TextView) findViewById(R.id.t2col6b));
        t2r2.add((TextView) findViewById(R.id.t2col7b));
        t2r2.add((TextView) findViewById(R.id.t2col8b));
        t2r2.add((TextView) findViewById(R.id.t2col9b));

        t2r3.add((TextView) findViewById(R.id.t2col1c));
        t2r3.add((TextView) findViewById(R.id.t2col2c));
        t2r3.add((TextView) findViewById(R.id.t2col3c));
        t2r3.add((TextView) findViewById(R.id.t2col4c));
        t2r3.add((TextView) findViewById(R.id.t2col5c));
        t2r3.add((TextView) findViewById(R.id.t2col6c));
        t2r3.add((TextView) findViewById(R.id.t2col7c));
        t2r3.add((TextView) findViewById(R.id.t2col8c));
        t2r3.add((TextView) findViewById(R.id.t2col9c));

        tt2.add(t2r1);
        tt2.add(t2r2);
        tt2.add(t2r3);
    }

    public void initT3() {
        t3r1.add((TextView) findViewById(R.id.t3col1a));
        t3r1.add((TextView) findViewById(R.id.t3col2a));
        t3r1.add((TextView) findViewById(R.id.t3col3a));
        t3r1.add((TextView) findViewById(R.id.t3col4a));
        t3r1.add((TextView) findViewById(R.id.t3col5a));
        t3r1.add((TextView) findViewById(R.id.t3col6a));
        t3r1.add((TextView) findViewById(R.id.t3col7a));
        t3r1.add((TextView) findViewById(R.id.t3col8a));
        t3r1.add((TextView) findViewById(R.id.t3col9a));

        t3r2.add((TextView) findViewById(R.id.t3col1b));
        t3r2.add((TextView) findViewById(R.id.t3col2b));
        t3r2.add((TextView) findViewById(R.id.t3col3b));
        t3r2.add((TextView) findViewById(R.id.t3col4b));
        t3r2.add((TextView) findViewById(R.id.t3col5b));
        t3r2.add((TextView) findViewById(R.id.t3col6b));
        t3r2.add((TextView) findViewById(R.id.t3col7b));
        t3r2.add((TextView) findViewById(R.id.t3col8b));
        t3r2.add((TextView) findViewById(R.id.t3col9b));

        t3r3.add((TextView) findViewById(R.id.t3col1c));
        t3r3.add((TextView) findViewById(R.id.t3col2c));
        t3r3.add((TextView) findViewById(R.id.t3col3c));
        t3r3.add((TextView) findViewById(R.id.t3col4c));
        t3r3.add((TextView) findViewById(R.id.t3col5c));
        t3r3.add((TextView) findViewById(R.id.t3col6c));
        t3r3.add((TextView) findViewById(R.id.t3col7c));
        t3r3.add((TextView) findViewById(R.id.t3col8c));
        t3r3.add((TextView) findViewById(R.id.t3col9c));

        tt3.add(t3r1);
        tt3.add(t3r2);
        tt3.add(t3r3);
    }

    public void initT4() {
        t4r1.add((TextView) findViewById(R.id.t4col1a));
        t4r1.add((TextView) findViewById(R.id.t4col2a));
        t4r1.add((TextView) findViewById(R.id.t4col3a));
        t4r1.add((TextView) findViewById(R.id.t4col4a));
        t4r1.add((TextView) findViewById(R.id.t4col5a));
        t4r1.add((TextView) findViewById(R.id.t4col6a));
        t4r1.add((TextView) findViewById(R.id.t4col7a));
        t4r1.add((TextView) findViewById(R.id.t4col8a));
        t4r1.add((TextView) findViewById(R.id.t4col9a));

        t4r2.add((TextView) findViewById(R.id.t4col1b));
        t4r2.add((TextView) findViewById(R.id.t4col2b));
        t4r2.add((TextView) findViewById(R.id.t4col3b));
        t4r2.add((TextView) findViewById(R.id.t4col4b));
        t4r2.add((TextView) findViewById(R.id.t4col5b));
        t4r2.add((TextView) findViewById(R.id.t4col6b));
        t4r2.add((TextView) findViewById(R.id.t4col7b));
        t4r2.add((TextView) findViewById(R.id.t4col8b));
        t4r2.add((TextView) findViewById(R.id.t4col9b));

        t4r3.add((TextView) findViewById(R.id.t4col1c));
        t4r3.add((TextView) findViewById(R.id.t4col2c));
        t4r3.add((TextView) findViewById(R.id.t4col3c));
        t4r3.add((TextView) findViewById(R.id.t4col4c));
        t4r3.add((TextView) findViewById(R.id.t4col5c));
        t4r3.add((TextView) findViewById(R.id.t4col6c));
        t4r3.add((TextView) findViewById(R.id.t4col7c));
        t4r3.add((TextView) findViewById(R.id.t4col8c));
        t4r3.add((TextView) findViewById(R.id.t4col9c));

        tt4.add(t4r1);
        tt4.add(t4r2);
        tt4.add(t4r3);
    }

    public void initT5() {
        t5r1.add((TextView) findViewById(R.id.t5col1a));
        t5r1.add((TextView) findViewById(R.id.t5col2a));
        t5r1.add((TextView) findViewById(R.id.t5col3a));
        t5r1.add((TextView) findViewById(R.id.t5col4a));
        t5r1.add((TextView) findViewById(R.id.t5col5a));
        t5r1.add((TextView) findViewById(R.id.t5col6a));
        t5r1.add((TextView) findViewById(R.id.t5col7a));
        t5r1.add((TextView) findViewById(R.id.t5col8a));
        t5r1.add((TextView) findViewById(R.id.t5col9a));

        t5r2.add((TextView) findViewById(R.id.t5col1b));
        t5r2.add((TextView) findViewById(R.id.t5col2b));
        t5r2.add((TextView) findViewById(R.id.t5col3b));
        t5r2.add((TextView) findViewById(R.id.t5col4b));
        t5r2.add((TextView) findViewById(R.id.t5col5b));
        t5r2.add((TextView) findViewById(R.id.t5col6b));
        t5r2.add((TextView) findViewById(R.id.t5col7b));
        t5r2.add((TextView) findViewById(R.id.t5col8b));
        t5r2.add((TextView) findViewById(R.id.t5col9b));

        t5r3.add((TextView) findViewById(R.id.t5col1c));
        t5r3.add((TextView) findViewById(R.id.t5col2c));
        t5r3.add((TextView) findViewById(R.id.t5col3c));
        t5r3.add((TextView) findViewById(R.id.t5col4c));
        t5r3.add((TextView) findViewById(R.id.t5col5c));
        t5r3.add((TextView) findViewById(R.id.t5col6c));
        t5r3.add((TextView) findViewById(R.id.t5col7c));
        t5r3.add((TextView) findViewById(R.id.t5col8c));
        t5r3.add((TextView) findViewById(R.id.t5col9c));

        tt5.add(t5r1);
        tt5.add(t5r2);
        tt5.add(t5r3);
    }

    public void initT6() {
        t6r1.add((TextView) findViewById(R.id.t6col1a));
        t6r1.add((TextView) findViewById(R.id.t6col2a));
        t6r1.add((TextView) findViewById(R.id.t6col3a));
        t6r1.add((TextView) findViewById(R.id.t6col4a));
        t6r1.add((TextView) findViewById(R.id.t6col5a));
        t6r1.add((TextView) findViewById(R.id.t6col6a));
        t6r1.add((TextView) findViewById(R.id.t6col7a));
        t6r1.add((TextView) findViewById(R.id.t6col8a));
        t6r1.add((TextView) findViewById(R.id.t6col9a));

        t6r2.add((TextView) findViewById(R.id.t6col1b));
        t6r2.add((TextView) findViewById(R.id.t6col2b));
        t6r2.add((TextView) findViewById(R.id.t6col3b));
        t6r2.add((TextView) findViewById(R.id.t6col4b));
        t6r2.add((TextView) findViewById(R.id.t6col5b));
        t6r2.add((TextView) findViewById(R.id.t6col6b));
        t6r2.add((TextView) findViewById(R.id.t6col7b));
        t6r2.add((TextView) findViewById(R.id.t6col8b));
        t6r2.add((TextView) findViewById(R.id.t6col9b));

        t6r3.add((TextView) findViewById(R.id.t6col1c));
        t6r3.add((TextView) findViewById(R.id.t6col2c));
        t6r3.add((TextView) findViewById(R.id.t6col3c));
        t6r3.add((TextView) findViewById(R.id.t6col4c));
        t6r3.add((TextView) findViewById(R.id.t6col5c));
        t6r3.add((TextView) findViewById(R.id.t6col6c));
        t6r3.add((TextView) findViewById(R.id.t6col7c));
        t6r3.add((TextView) findViewById(R.id.t6col8c));
        t6r3.add((TextView) findViewById(R.id.t6col9c));

        tt6.add(t6r1);
        tt6.add(t6r2);
        tt6.add(t6r3);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_tickets);

        t1 = findViewById(R.id.ticket_1);
        t2 = findViewById(R.id.ticket_2);
        t3 = findViewById(R.id.ticket_3);
        t4 = findViewById(R.id.ticket_4);
        t5 = findViewById(R.id.ticket_5);
        t6 = findViewById(R.id.ticket_6);

        t_num = findViewById(R.id.ticket_display);

        play = findViewById(R.id.play);

        t1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                t_num.setText("Ticket 1");
                selected = 1;
            }
        });

        t2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                t_num.setText("Ticket 2");
                selected = 2;
            }
        });

        t3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                t_num.setText("Ticket 3");
                selected = 3;
            }
        });

        t4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                t_num.setText("Ticket 4");
                 selected = 4;
            }
        });

        t5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                t_num.setText("Ticket 5");
                selected = 5;
            }
        });

        t6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                t_num.setText("Ticket 6");
                selected = 6;
            }
        });

        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String toast = "";
                switch (selected) {
                    case 1: toast = "Playing with ticket 1";
                            break;
                    case 2: toast = "Playing with ticket 2";
                        break;
                    case 3: toast = "Playing with ticket 3";
                        break;
                    case 4: toast = "Playing with ticket 4";
                        break;
                    case 5: toast = "Playing with ticket 5";
                        break;
                    case 6: toast = "Playing with ticket 6";
                        break;
                }
                Toast.makeText(TicketList.this, toast, Toast.LENGTH_SHORT).show();

                Intent igame = new Intent(TicketList.this, MainActivity.class);
                igame.putIntegerArrayListExtra("row1", (ArrayList<Integer>) nums.get(selected-1).get(0));
                igame.putIntegerArrayListExtra("row2", (ArrayList<Integer>) nums.get(selected-1).get(1));
                igame.putIntegerArrayListExtra("row3", (ArrayList<Integer>) nums.get(selected-1).get(2));
                startActivity(igame);
            }
        });

        initT1();
        initT2();
        initT3();
        initT4();
        initT5();
        initT6();

        tts.add(tt1);
        tts.add(tt2);
        tts.add(tt3);
        tts.add(tt4);
        tts.add(tt5);
        tts.add(tt6);

        nums = numgen.getNumbers();

        assignNums();

    }

    public void assignNums() {
        for (int t = 0; t < 6; t++) {
            for (int r = 0; r < 3; r++) {
                for (int c = 0; c < 9; c++) {
                    int num = nums.get(t).get(r).get(c);
                    Log.i("Assign Nums: ", t + "," + r + "," + c + ":::::" + num);
                    if (num != 0) {
                        String n = String.valueOf(num);
                        tts.get(t).get(r).get(c).setText(n);
//                        tts.get(t).get(r).get(c).setBackgroundResource(R.drawable.ticket_number_done);
                    } else {
                        tts.get(t).get(r).get(c).setBackgroundResource(R.drawable.ticket_number_undone);
                    }
                }
            }
        }
    }
}
