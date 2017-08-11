package com.example.saif.myapplication3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.os.Bundle;
import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class WelcomeScreen extends AppCompatActivity {

      TextView txtuname,txtpass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome_screen);

        TextView txtuname = (TextView) findViewById(R.id.txtuname);
        TextView txtpass = (TextView) findViewById(R.id.txtupass);

        Intent intent = getIntent();

        String loginName = intent.getStringExtra("fullname");
        String loginEmail = intent.getStringExtra("email");
        txtuname.setText("Welcome user :: " +loginName);
        txtpass.setText("Your Password is :: " +loginEmail);


    }
}
