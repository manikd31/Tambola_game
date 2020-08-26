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

    ImageView goBack, goHome, infoHost, infoRoom, infoPass;
    EditText roomNameView, roomPassView, roomHostView;
    ExtendedFloatingActionButton done;
    SoundPool soundPool;
    int buttonSound, backSound, clickSound, errorSound, winSound;

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
        clickSound = soundPool.load(this, R.raw.short_click_sound, 1);
        errorSound = soundPool.load(this, R.raw.wooden_error_sound, 1);
        winSound = soundPool.load(this, R.raw.win_sound, 1);

        goBack = findViewById(R.id.go_back);
        goHome = findViewById(R.id.go_home);
        roomNameView = findViewById(R.id.room_name_edit);
        roomPassView = findViewById(R.id.room_pass_edit);
        roomHostView = findViewById(R.id.host_name_edit);
        done = findViewById(R.id.done);

        infoHost = findViewById(R.id.host_name_info);
        infoRoom = findViewById(R.id.room_name_info);
        infoPass = findViewById(R.id.room_pass_info);

        infoHost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                soundPool.play(clickSound, 1, 1, 1, 0, 1);
                AlertDialog.Builder b = new AlertDialog.Builder(CreateRoom.this);
                b.setTitle("Host Name Info");
                b.setMessage("The name of the HOST of the game. It will be displayed to all guests. The host-name should be of max. 10 characters.");
                b.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                });
                AlertDialog d = b.create();
                d.show();
            }
        });

        infoRoom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                soundPool.play(clickSound, 1, 1, 1, 0, 1);
                AlertDialog.Builder b = new AlertDialog.Builder(CreateRoom.this);
                b.setTitle("Room Name Info");
                b.setMessage("The name of the room created by the HOST. The room-name should be of max. 20 characters.");
                b.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                });
                AlertDialog d = b.create();
                d.show();
            }
        });

        infoPass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                soundPool.play(clickSound, 1, 1, 1, 0, 1);
                AlertDialog.Builder b = new AlertDialog.Builder(CreateRoom.this);
                b.setTitle("Password Info");
                b.setMessage("The password for the current game set by the HOST. The password should be a 4-digit number.");
                b.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                });
                AlertDialog d = b.create();
                d.show();
            }
        });

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
                String hostName = roomHostView.getText().toString().trim();
                String roomName = roomNameView.getText().toString().trim();
                String roomPass = roomPassView.getText().toString().trim();

                roomHostView.setBackgroundResource(R.drawable.ticket_layout);
                roomNameView.setBackgroundResource(R.drawable.ticket_layout);
                roomPassView.setBackgroundResource(R.drawable.ticket_layout);

                boolean errorRoom = false, errorPass = false, errorHost = false;

                if (TextUtils.isEmpty(roomName) || TextUtils.isEmpty(roomPass) || TextUtils.isEmpty(hostName)) {
                    String msg = "";
                    if (TextUtils.isEmpty(roomName) && TextUtils.isEmpty(roomPass) && TextUtils.isEmpty(hostName)) {
                        msg = "The following field(s) have error(s):\n\n\t1. Host Name cannot be empty.\n\t2. Room Name cannot be empty.\n\t3. Password cannot be empty.";
                        errorHost = true;
                        errorPass = true;
                        errorRoom = true;
                    } else if (TextUtils.isEmpty(roomName) && TextUtils.isEmpty(roomPass)) {
                        msg = "The following field(s) have error(s):\n\n\t1. Room Name cannot be empty.\n\t2. Password cannot be empty.";
                        errorPass = true;
                        errorRoom = true;
                    } else if (TextUtils.isEmpty(roomPass) && TextUtils.isEmpty(hostName)) {
                        msg = "The following field(s) have error(s):\n\n\t1. Host Name cannot be empty.\n\t2. Password cannot be empty.";
                        errorHost = true;
                        errorPass = true;
                    } else if (TextUtils.isEmpty(roomName) && TextUtils.isEmpty(hostName)) {
                        msg = "The following field(s) have error(s):\n\n\t1. Host Name cannot be empty.\n\t2. Room Name cannot be empty.";
                        errorHost = true;
                        errorRoom = true;
                    } else if (TextUtils.isEmpty(roomName)) {
                        msg = "The following field(s) have error(s):\n\n\t1. Room Name cannot be empty.";
                        errorRoom = true;
                    } else if (TextUtils.isEmpty(roomPass)) {
                        msg = "The following field(s) have error(s):\n\n\t1. Password cannot be empty.";
                        errorPass = true;
                    } else if (TextUtils.isEmpty(hostName)) {
                        msg = "The following field(s) have error(s):\n\n\t1. Host Name cannot be empty.";
                        errorHost = true;
                    }

                    if (errorHost) {
                        roomHostView.setBackgroundResource(R.drawable.ticket_layout_error);
                    }
                    if (errorPass) {
                        roomPassView.setBackgroundResource(R.drawable.ticket_layout_error);
                    }
                    if (errorRoom) {
                        roomNameView.setBackgroundResource(R.drawable.ticket_layout_error);
                    }
                    AlertDialog.Builder b = new AlertDialog.Builder(CreateRoom.this);
                    b.setTitle("Error!");
                    b.setMessage(msg);
                    b.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.dismiss();
                        }
                    });
                    AlertDialog d = b.create();
                    d.show();
                    soundPool.play(errorSound, 1, 1, 1, 0, 1);
                } else {
                    if (roomName.length() > 20) {
                        roomNameView.setBackgroundResource(R.drawable.ticket_layout_error);
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
                        soundPool.play(errorSound, 1, 1, 1, 0, 1);
                    } else if (hostName.length() > 10) {
                        roomHostView.setBackgroundResource(R.drawable.ticket_layout_error);
                        AlertDialog.Builder b = new AlertDialog.Builder(CreateRoom.this);
                        b.setTitle("Error!");
                        b.setMessage("Host Name is too long (maximum 10 characters)");
                        b.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                dialogInterface.dismiss();
                            }
                        });
                        AlertDialog d = b.create();
                        d.show();
                        soundPool.play(errorSound, 1, 1, 1, 0, 1);
                    } else if (roomPass.length() != 4) {
                        roomPassView.setBackgroundResource(R.drawable.ticket_layout_error);
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
                        soundPool.play(errorSound, 1, 1, 1, 0, 1);
                    } else if (roomName.split(" ").length != 1) {
                        roomNameView.setBackgroundResource(R.drawable.ticket_layout_error);
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
                        soundPool.play(errorSound, 1, 1, 1, 0, 1);
                    } else if (hostName.split(" ").length != 1) {
                        roomHostView.setBackgroundResource(R.drawable.ticket_layout_error);
                        AlertDialog.Builder b = new AlertDialog.Builder(CreateRoom.this);
                        b.setTitle("Error!");
                        b.setMessage("Host Name should not have any spaces.");
                        b.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                dialogInterface.dismiss();
                            }
                        });
                        AlertDialog d = b.create();
                        d.show();
                        soundPool.play(errorSound, 1, 1, 1, 0, 1);
                    } else {
                        roomHostView.setBackgroundResource(R.drawable.ticket_layout_success);
                        roomNameView.setBackgroundResource(R.drawable.ticket_layout_success);
                        roomPassView.setBackgroundResource(R.drawable.ticket_layout_success);
                        AlertDialog.Builder b = new AlertDialog.Builder(CreateRoom.this);
                        b.setTitle("Confirm Details?");
                        b.setMessage("Host Name\t: " + hostName + "\nRoom Name\t: " + roomName + "\nPassword\t: " + roomPass);
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
                        soundPool.play(winSound, 1, 1, 1, 0, 1);
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