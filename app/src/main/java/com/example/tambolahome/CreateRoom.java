package com.example.tambolahome;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.media.AudioAttributes;
import android.media.SoundPool;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;

public class CreateRoom extends AppCompatActivity {

    ImageView goBack, goHome;
    EditText roomNameView, roomPassView;
    ExtendedFloatingActionButton done;
    SoundPool soundPool;
    int buttonSound, backSound;

    String role;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_room);

        Intent intent = getIntent();
        role = intent.getStringExtra("roleType");

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

        goBack = findViewById(R.id.go_back);
        goHome = findViewById(R.id.go_home);
        roomNameView = findViewById(R.id.room_name_edit);
        roomPassView = findViewById(R.id.room_pass_edit);
        done = findViewById(R.id.done);

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
                AlertDialog.Builder b = new AlertDialog.Builder(CreateRoom.this);
                b.setTitle("Are you sure you want to go back to home page?");
                b.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Intent iHome = new Intent(CreateRoom.this, HomePage.class);
                        startActivity(iHome);
                    }
                });
                b.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                });
                AlertDialog d = b.create();
                d.show();
            }
        });

        done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String roomName = roomNameView.getText().toString().trim();
                String roomPass = roomPassView.getText().toString().trim();

                if (TextUtils.isEmpty(roomName) || TextUtils.isEmpty(roomPass)) {
                    AlertDialog.Builder b = new AlertDialog.Builder(CreateRoom.this);
                    b.setTitle("Error!");
                    b.setMessage("Room Name and/or Password cannot be empty.");
                    b.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.dismiss();
                        }
                    });
                    AlertDialog d = b.create();
                    d.show();
                } else {
                    if (roomName.length() > 20) {
                        AlertDialog.Builder b = new AlertDialog.Builder(CreateRoom.this);
                        b.setTitle("Error!");
                        b.setMessage("Room Name is too long (maximum 20 characters)");
                        b.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                dialogInterface.dismiss();
                            }
                        });
                        AlertDialog d = b.create();
                        d.show();
                    } else if (roomPass.length() != 4) {
                        AlertDialog.Builder b = new AlertDialog.Builder(CreateRoom.this);
                        b.setTitle("Error!");
                        b.setMessage("Password should be exactly 4 characters");
                        b.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                dialogInterface.dismiss();
                            }
                        });
                        AlertDialog d = b.create();
                        d.show();
                    } else if (roomName.split(" ").length != 1) {
                        AlertDialog.Builder b = new AlertDialog.Builder(CreateRoom.this);
                        b.setTitle("Error!");
                        b.setMessage("Room Name should not have any spaces.");
                        b.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                dialogInterface.dismiss();
                            }
                        });
                        AlertDialog d = b.create();
                        d.show();
                    } else {
                        AlertDialog.Builder b = new AlertDialog.Builder(CreateRoom.this);
                        b.setTitle("Confirm?");
                        b.setMessage("Room Name : " + roomName + "\nPassword : " + roomPass);
                        b.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Intent newIntent = new Intent(CreateRoom.this, ChooseTicketType.class);
                                newIntent.putExtra("roleType", role);
                                startActivity(newIntent);
                                Toast.makeText(CreateRoom.this, "Success!", Toast.LENGTH_SHORT).show();
                            }
                        });
                        b.setNegativeButton("No", new DialogInterface.OnClickListener() {
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
        });
    }

    @Override
    public void onBackPressed() {
        AlertDialog.Builder b = new AlertDialog.Builder(CreateRoom.this);
        b.setTitle("Unsaved changes will be lost. Confirm go back?");
        b.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Intent iBack = new Intent(CreateRoom.this, ChooseRoleType.class);
                startActivity(iBack);
            }
        });
        b.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });
        AlertDialog d = b.create();
        d.show();
    }
}