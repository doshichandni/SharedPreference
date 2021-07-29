package com.example.sharedp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.content.Intent;
import android.widget.TextView;
import android.content.SharedPreferences;
import android.os.Handler;

public class HomeActivity extends AppCompatActivity {
    TextView tvEmail,tvPassword,tvIsLogin,tvNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Intent i = getIntent();
        tvEmail = (TextView)findViewById(R.id.tvEmail);
        tvPassword  = (TextView)findViewById(R.id.tvPassword);
//        tvIsLogin  = (TextView)findViewById(R.id.tvIsLogin);
//        tvNumber = (TextView)findViewById(R.id.tvNumber);

        SharedPreferences sharedPreferences = getSharedPreferences("login", Context.MODE_PRIVATE);
        String email = sharedPreferences.getString("email", "");
        String password = sharedPreferences.getString("password", "");
//        boolean isLogin = sharedPreferences.getBoolean("islogin", false);
//        int number = sharedPreferences.getInt("number", 0);


        tvEmail.setText(email);
        tvPassword.setText(password);
//        tvIsLogin.setText(""+isLogin);
//        tvNumber.setText(""+number);
    }
}