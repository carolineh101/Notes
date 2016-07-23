package com.example.carolineho.notes;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class HomeActivity extends AppCompatActivity {

    private TextView mWelcomeNote;
    private TextView mHelpNote;
    private TextView mNewNote;

    private String name;
    private String email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        mWelcomeNote = (TextView) findViewById(R.id.WelcomeNote);
        mHelpNote = (TextView) findViewById(R.id.HelpNote);
        mNewNote = (TextView) findViewById(R.id.NewNote);

        Intent intent = getIntent();
        Bundle bd = intent.getExtras();
        if (bd != null) {
            name = (String) bd.get("name");
            email = (String) bd.get("email");
        }

        View.OnClickListener toWelcomeListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, Welcome.class);
                startActivity(intent);
            }
        };

        mWelcomeNote.setOnClickListener(toWelcomeListener);

        View.OnClickListener toHelpListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, Help.class);
                intent.putExtra("name", name);
                intent.putExtra("email", email);
                startActivity(intent);
            }
        };

        mHelpNote.setOnClickListener(toHelpListener);

        View.OnClickListener newNoteListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(HomeActivity.this);
                builder.setTitle("In-App Purchase")
                    .setMessage("Please purchase more storage using your SOUL credits to add more notes!")
                    .setPositiveButton("Accept", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            Toast toast = Toast.makeText(HomeActivity.this, "ERROR 666: UNABLE TO RETRIEVE SOUL", Toast.LENGTH_SHORT);
                            toast.show();
                        }
                    })
                    .setNegativeButton("Decline", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            Toast toast = Toast.makeText(HomeActivity.this, "You can change your mind anytime...", Toast.LENGTH_SHORT);
                            toast.show();
                        }
                    });
                AlertDialog alert = builder.create();
                alert.show();
            }
        };

        mNewNote.setOnClickListener(newNoteListener);
    }
}
