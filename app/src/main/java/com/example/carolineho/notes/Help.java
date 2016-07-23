package com.example.carolineho.notes;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class Help extends AppCompatActivity {

    private TextView mKeyArea;

    private String name;
    private String email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help);

        mKeyArea = (TextView) findViewById(R.id.KeyArea);

        Intent intent = getIntent();
        Bundle bd = intent.getExtras();
        if (bd != null) {
            name = (String) bd.get("name");
            email = (String) bd.get("email");
        }

        SpannableString key  = new SpannableString(mKeyArea.getText());
        ClickableSpan clickableSpan = new ClickableSpan() {
            @Override
            public void onClick(View textView) {
                AlertDialog.Builder builder = new AlertDialog.Builder(Help.this);
                builder.setTitle("LuciferTech Notification")
                    .setMessage("Oh? Did a human get into my CORRUPTED soul files?")
                    .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            AlertDialog.Builder builder = new AlertDialog.Builder(Help.this);
                            builder.setTitle("LuciferTech Notification")
                                    .setMessage("Of course that wasn't the real key. Did you think it would be that easy?")
                                    .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                                        public void onClick(DialogInterface dialog, int id) {
                                            AlertDialog.Builder builder = new AlertDialog.Builder(Help.this);
                                            builder.setTitle("LuciferTech Notification")
                                                    .setMessage("Nice try, " + name + ". Good luck finding the real key. Bye now.")
                                                    .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                                        public void onClick(DialogInterface dialog, int id) {
                                                            Intent intent = new Intent(Intent.ACTION_MAIN);
                                                            intent.addCategory(Intent.CATEGORY_HOME);
                                                            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                                                            startActivity(intent);
                                                        }
                                                    });
                                            AlertDialog alert = builder.create();
                                            alert.show();
                                        }
                                    })
                                    .setNegativeButton("No", new DialogInterface.OnClickListener() {
                                        public void onClick(DialogInterface dialog, int id) {
                                            AlertDialog.Builder builder = new AlertDialog.Builder(Help.this);
                                            builder.setTitle("LuciferTech Notification")
                                                    .setMessage("Well, you're right, " + name + ". Good luck finding the real key. Bye now.")
                                                    .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                                        public void onClick(DialogInterface dialog, int id) {
                                                            Intent intent = new Intent(Intent.ACTION_MAIN);
                                                            intent.addCategory(Intent.CATEGORY_HOME);
                                                            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                                                            startActivity(intent);
                                                        }
                                                    });
                                            AlertDialog alert = builder.create();
                                            alert.show();
                                        }
                                    });
                            AlertDialog alert = builder.create();
                            alert.show();
                        }
                    });
                AlertDialog alert = builder.create();
                alert.show();
            }
            @Override
            public void updateDrawState(TextPaint ds) {
                super.updateDrawState(ds);
                ds.setUnderlineText(false);
                ds.setColor(mKeyArea.getTextColors().getDefaultColor());
            }
        };
        key.setSpan(clickableSpan, 31, 33, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        mKeyArea.setText(key);
        mKeyArea.setHighlightColor(Color.TRANSPARENT);
        mKeyArea.setMovementMethod(LinkMovementMethod.getInstance());
    }
}
