package com.aszqsc.dontforgeteverything;
import android.animation.Animator;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.aszqsc.dontforgeteverything.Notify.AlarmReceiver_SendOn;
import com.aszqsc.dontforgeteverything.customdialog.DatePickerFragment;
import com.aszqsc.dontforgeteverything.customdialog.TimePickerDialogFragment;
import com.aszqsc.dontforgeteverything.model.MyDatabaseHelper;
import com.aszqsc.dontforgeteverything.model.Note;
public class Login extends AppCompatActivity{
    MyDatabaseHelper sqLiteDatabase;
    EditText edittk, editmk;
    Button btndangnhap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        sqLiteDatabase = new MyDatabaseHelper(this);
        edittk = (EditText)findViewById(R.id.edittk);
        editmk = (EditText)findViewById(R.id.editmk);
        btndangnhap = (Button)findViewById(R.id.buttondn);
        btndangnhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = edittk.getText(). toString();
                String password = editmk.getText(). toString();
                Boolean chkemailpass = sqLiteDatabase.emailPassword(email, password);
                if(chkemailpass == true){
                    Toast.makeText(getApplicationContext(), "Đăng nhập thành công", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(getApplicationContext(), "Sai email hoặc password.", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
