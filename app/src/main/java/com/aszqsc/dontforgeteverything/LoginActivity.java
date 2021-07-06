package com.aszqsc.dontforgeteverything;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.aszqsc.dontforgeteverything.model.MyDatabaseHelper;

public class LoginActivity extends AppCompatActivity {

    MyDatabaseHelper sqLiteDatabase;
    EditText editTk, editMk;
    Button btnLogin, btnRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        sqLiteDatabase = new MyDatabaseHelper(this);
        editTk = (EditText)findViewById(R.id.edittk);
        editMk = (EditText)findViewById(R.id.editmk);
        btnLogin = (Button)findViewById(R.id.buttondn);
        btnRegister = (Button)findViewById(R.id.buttondk);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = editTk.getText(). toString();
                String password = editMk.getText(). toString();
                Boolean checkEmailPassword = sqLiteDatabase.emailPassword(email, password);
                if(checkEmailPassword){
                    Toast.makeText(getApplicationContext(), "Đăng nhập thành công", Toast.LENGTH_SHORT).show();
                    Intent MainIntent = new Intent(LoginActivity.this, MainActivity.class);
                    startActivity(MainIntent);
                }else{
                    Toast.makeText(getApplicationContext(), "Sai email hoặc password.", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent registerIntent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(registerIntent);
            }
        });
    }
}