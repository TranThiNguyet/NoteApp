package com.aszqsc.dontforgeteverything;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.aszqsc.dontforgeteverything.model.MyDatabaseHelper;
import com.aszqsc.dontforgeteverything.model.User;

public class RegisterActivity extends AppCompatActivity {
    MyDatabaseHelper sqLiteDatabase;
    EditText editEmail, editPass, editCfPass;
    Button btnRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        sqLiteDatabase = new MyDatabaseHelper(this);
        editEmail = (EditText) findViewById(R.id.edttk);
        editPass = (EditText) findViewById(R.id.edtmk);
        editCfPass = (EditText) findViewById(R.id.edtcfmk);
        btnRegister = (Button) findViewById(R.id.buttondk);
//        btnRegister.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                Intent i = new Intent(RegisterActivity.this, LoginActivity.class);
//            }
//        });
        btnRegister.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                String s1 = editEmail.getText().toString();
                String s2 = editPass.getText().toString();
                String s3 = editCfPass.getText().toString();
                if (s1.equals("") || s2.equals("") || s3.equals("")) {
                    Toast.makeText(getApplicationContext(), "Vui lòng Không được để trống các trường", Toast.LENGTH_SHORT).show();
                } else {
                    if (s2.equals(s3)) {
                        Boolean checkEmail = sqLiteDatabase.chkEmail(s1);
                        if (checkEmail) {
                            User user = new User(s1, s2);
                            sqLiteDatabase.insert(user);
                            Toast.makeText(getApplicationContext(), "Đăng kí thành công", Toast.LENGTH_SHORT).show();
                            Intent i = new Intent(RegisterActivity.this, LoginActivity.class);
                            startActivity(i);
                        } else {
                            Toast.makeText(getApplicationContext(), "Email đã tồn tại. Vui lòng nhập lại", Toast.LENGTH_SHORT).show();
                        }
                    }
                    Toast.makeText(getApplicationContext(), "Password không trùng khớp. vui lòng nhập lại.", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}