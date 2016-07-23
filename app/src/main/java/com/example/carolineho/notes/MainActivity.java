package com.example.carolineho.notes;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText mName;
    private EditText mEmail;
    private EditText mPassword;
    private Button mSignUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mName = (EditText) findViewById(R.id.Name);
        mEmail = (EditText) findViewById(R.id.Email);
        mPassword = (EditText) findViewById(R.id.Password);
        mSignUp = (Button) findViewById(R.id.SignUp);

        View.OnClickListener signUpListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("App Permissions")
                    .setMessage("Notes will be able to send emails, permit in-app purchases, and access your soul.")
                    .setPositiveButton("Accept", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            Toast toast = Toast.makeText(MainActivity.this, "ERROR 666: UNABLE TO RETRIEVE SOUL", Toast.LENGTH_SHORT);
                            toast.show();
                            Toast toast2 = Toast.makeText(MainActivity.this, "FATAL ERROR: ACCESSING CORRUPTED FILES", Toast.LENGTH_SHORT);
                            toast2.show();
                            Intent intent = new Intent(MainActivity.this, HomeActivity.class);
                            intent.putExtra("name", mName.getText().toString());
                            intent.putExtra("email", mEmail.getText().toString());
                            intent.putExtra("password", mPassword.getText().toString());
                            startActivity(intent);
                        }
                    })
                    .setNegativeButton("Decline", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            Toast toast = Toast.makeText(MainActivity.this, "FATAL ERROR: ACCESSING CORRUPTED FILES", Toast.LENGTH_SHORT);
                            toast.show();
                            Intent intent = new Intent(MainActivity.this, HomeActivity.class);
                            intent.putExtra("name", mName.getText().toString());
                            intent.putExtra("email", mEmail.getText().toString());
                            intent.putExtra("password", mPassword.getText().toString());
                            startActivity(intent);
                        }
                    });
                AlertDialog alert = builder.create();
                alert.show();
            }
        };

        mSignUp.setOnClickListener(signUpListener);
    }
}
