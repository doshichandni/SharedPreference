package com.example.sharedp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;
import android.content.SharedPreferences;
import android.os.Handler;

public class HomeActivity extends AppCompatActivity {
    TextView tvEmail,tvPassword,tvIsLogin,tvNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        tvEmail = (TextView)tvEmail.findViewById(R.id.tvEmail);
        tvPassword  = (TextView)tvPassword.findViewById(R.id.tvPassword);
        tvIsLogin  = (TextView)tvIsLogin.findViewById(R.id.tvIsLogin);
        tvNumber = (TextView)tvNumber.findViewById(R.id.tvNumber);

        getData();
    }
    private void getData(){
        SharedPreferences sharedPreferences = getSharedPreferences("Login", MODE_PRIVATE);
        String email = sharedPreferences.getString("email", "abc@gmail.com");
        String password = sharedPreferences.getString("password", "123");
        boolean isLogin = sharedPreferences.getBoolean("islogin", false);
        int number = sharedPreferences.getInt("number", 0);


        tvEmail.setText(email);
        tvPassword.setText(password);
        tvIsLogin.setText(""+isLogin);
        tvNumber.setText(""+number);
    }
}