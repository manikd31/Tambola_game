package com.example.tambolahome;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends AppCompatActivity {

    ExtendedFloatingActionButton done;

    List<List<Integer>> tt = new ArrayList<List<Integer>>();

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

    int count;

    public void getExtras() {
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        count = 0;

        initTicket();

        done = findViewById(R.id.done);

        done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder b = new AlertDialog.Builder(HomeActivity.this);
                b.setTitle("Confirm ticket?");
                b.setPositiveButton("YES", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Intent igame = new Intent(HomeActivity.this, MainActivity.class);

                        getExtras();

                        if (count != 15) {
                            Toast.makeText(HomeActivity.this, "Ticket incomplete.", Toast.LENGTH_LONG).show();
                        } else {
                            igame.putIntegerArrayListExtra("row1", (ArrayList<Integer>) tt.get(0));
                            igame.putIntegerArrayListExtra("row2", (ArrayList<Integer>) tt.get(1));
                            igame.putIntegerArrayListExtra("row3", (ArrayList<Integer>) tt.get(2));

                            startActivity(igame);
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

}
