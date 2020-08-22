package com.example.tambolahome;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;

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
        for (int r = 0; r < 3; r++) {
            for (int c = 0; c < 9; c++) {
                if (!TextUtils.isEmpty(tv.get(r).get(c).getText().toString())) {
                    int n = Integer.parseInt(tv.get(r).get(c).getText().toString());
                    if (n == 0) {
                        Toast.makeText(this, "Missing number. 0 added.", Toast.LENGTH_SHORT).show();
                        tv.get(r).get(c).setBackgroundResource(R.drawable.done_red);
                        return false;
                    }
                }
            }
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
            if (numsInRow != 5) {
                Toast.makeText(this, "Incomplete ticket. Row = " + r, Toast.LENGTH_SHORT).show();
                for (int c = 0; c < 9; c++) {
                    tv.get(r).get(c).setBackgroundResource(R.drawable.done_red);
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
                Toast.makeText(this, "Column Error. Check Column = " + c, Toast.LENGTH_SHORT).show();
                for (int i = 0; i < 3; i++) {
                    tv.get(i).get(c).setBackgroundResource(R.drawable.done_red);
                }
                return false;
            }

//            Next to check if each column has numbers within its defined range...
            if (c == 0) {
                int minRange = 1;
                int maxRange = 9;
                if (num1 != 0 && (num1 > maxRange || num1 < minRange)) {
                    Toast.makeText(this, "Invalid number " + num1 + " in column = " + c, Toast.LENGTH_SHORT).show();
                    for (int i = 0; i < 3; i++) {
                        tv.get(i).get(c).setBackgroundResource(R.drawable.done_red);
                    }
                    return false;
                } else if (num2 != 0 && (num2 > maxRange || num2 < minRange)) {
                    Toast.makeText(this, "Invalid number " + num2 + " in column = " + c, Toast.LENGTH_SHORT).show();
                    for (int i = 0; i < 3; i++) {
                        tv.get(i).get(c).setBackgroundResource(R.drawable.done_red);
                    }
                    return false;
                } else if (num3 != 0 && (num3 > maxRange || num3 < minRange)) {
                    Toast.makeText(this, "Invalid number " + num3 + " in column = " + c, Toast.LENGTH_SHORT).show();
                    for (int i = 0; i < 3; i++) {
                        tv.get(i).get(c).setBackgroundResource(R.drawable.done_red);
                    }
                    return false;
                }
            } else if (c == 8) {
                int minRange = 80;
                int maxRange = 90;
                if (num1 != 0 && (num1 > maxRange || num1 < minRange)) {
                    Toast.makeText(this, "Invalid number " + num1 + " in column = " + c, Toast.LENGTH_SHORT).show();
                    for (int i = 0; i < 3; i++) {
                        tv.get(i).get(c).setBackgroundResource(R.drawable.done_red);
                    }
                    return false;
                } else if (num2 != 0 && (num2 > maxRange || num2 < minRange)) {
                    Toast.makeText(this, "Invalid number " + num2 + " in column = " + c, Toast.LENGTH_SHORT).show();
                    for (int i = 0; i < 3; i++) {
                        tv.get(i).get(c).setBackgroundResource(R.drawable.done_red);
                    }
                    return false;
                } else if (num3 != 0 && (num3 > maxRange || num3 < minRange)) {
                    Toast.makeText(this, "Invalid number " + num3 + " in column = " + c, Toast.LENGTH_SHORT).show();
                    for (int i = 0; i < 3; i++) {
                        tv.get(i).get(c).setBackgroundResource(R.drawable.done_red);
                    }
                    return false;
                }
            } else {
                int minRange = c * 10;
                int maxRange = minRange + 9;
                if (num1 != 0 && (num1 > maxRange || num1 < minRange)) {
                    Toast.makeText(this, "Invalid number " + num1 + " in column = " + c, Toast.LENGTH_SHORT).show();
                    for (int i = 0; i < 3; i++) {
                        tv.get(i).get(c).setBackgroundResource(R.drawable.done_red);
                    }
                    return false;
                } else if (num2 != 0 && (num2 > maxRange || num2 < minRange)) {
                    Toast.makeText(this, "Invalid number " + num2 + " in column = " + c, Toast.LENGTH_SHORT).show();
                    for (int i = 0; i < 3; i++) {
                        tv.get(i).get(c).setBackgroundResource(R.drawable.done_red);
                    }
                    return false;
                } else if (num3 != 0 && (num3 > maxRange || num3 < minRange)) {
                    Toast.makeText(this, "Invalid number " + num3 + " in column = " + c, Toast.LENGTH_SHORT).show();
                    for (int i = 0; i < 3; i++) {
                        tv.get(i).get(c).setBackgroundResource(R.drawable.done_red);
                    }
                    return false;
                }
            }

//            Finally, to check if the numbers are sorted in each column...
            if (num1 != 0 && num2 != 0 && num3 != 0) {
                if (num1 > num2 || num2 > num3) {
                    Toast.makeText(this, "Numbers are not sorted in column = " + c, Toast.LENGTH_SHORT).show();
                    for (int i = 0; i < 3; i++) {
                        tv.get(i).get(c).setBackgroundResource(R.drawable.done_red);
                    }
                    return false;
                }
            } else if (num1 == 0 && num2 != 0 && num3 != 0 && num2 > num3) {
                Toast.makeText(this, "Numbers are not sorted in column = " + c, Toast.LENGTH_SHORT).show();
                for (int i = 0; i < 3; i++) {
                    tv.get(i).get(c).setBackgroundResource(R.drawable.done_red);
                }
                return false;
            } else if (num2 == 0 && num1 != 0 && num3 != 0 && num1 > num3) {
                Toast.makeText(this, "Numbers are not sorted in column = " + c, Toast.LENGTH_SHORT).show();
                for (int i = 0; i < 3; i++) {
                    tv.get(i).get(c).setBackgroundResource(R.drawable.done_red);
                }
                return false;
            } else if (num3 == 0 && num1 != 0 && num2 != 0 && num1 > num2) {
                Toast.makeText(this, "Numbers are not sorted in column = " + c, Toast.LENGTH_SHORT).show();
                for (int i = 0; i < 3; i++) {
                    tv.get(i).get(c).setBackgroundResource(R.drawable.done_red);
                }
                return false;
            }
        }
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        initTicket();

        done = findViewById(R.id.done);

        done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
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
                        Intent iGame = new Intent(HomeActivity.this, MainActivity.class);

                        getExtras();

//                        if (count != 15) {
//                            Toast.makeText(HomeActivity.this, "Ticket incomplete. Numbers = " + count + ", Needed = 15", Toast.LENGTH_LONG).show();
//                        } else {
                        if (checkTicket()) {
                            iGame.putIntegerArrayListExtra("row1", (ArrayList<Integer>) tt.get(0));
                            iGame.putIntegerArrayListExtra("row2", (ArrayList<Integer>) tt.get(1));
                            iGame.putIntegerArrayListExtra("row3", (ArrayList<Integer>) tt.get(2));
                            startActivity(iGame);
                        }
//                            } else {
//                                Toast.makeText(HomeActivity.this, "Ticket incorrect. Check again.", Toast.LENGTH_SHORT).show();
//                            }
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
                HomeActivity.super.onBackPressed();
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
