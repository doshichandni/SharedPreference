package com.example.sharedp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    EditText edtEmail,edtPassword;
    Button btnSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        init();
    }

    private void init(){
    edtEmail = (EditText)findViewById(R.id.edtEmail);
    edtPassword = (EditText)findViewById(R.id.edtPassword);
    btnSubmit = (Button)findViewById(R.id.btnSubmit);


        btnSubmit.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick (View view){
                String email = edtEmail.getText().toString();
                String password = edtPassword.getText().toString();

                if (TextUtils.isEmpty(email)) {
                    Toast.makeText(LoginActivity.this,"Please enter email", Toast.LENGTH_SHORT).show();
                    return;

                }
                if (TextUtils.isEmpty(password)) {
                    Toast.makeText(LoginActivity.this,"Please enter password", Toast.LENGTH_SHORT).show();
                    return;

                }
                SharedPreferences sharedPreferences= getSharedPreferences("login", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("email", email);
                editor.putString("password",password);
                editor.putBoolean("islogin", true);
                editor.putInt("number", 0);
                editor.commit();

                Intent i = new Intent(LoginActivity.this, HomeActivity.class);
                startActivity(i);
            }
        });
    }

}
