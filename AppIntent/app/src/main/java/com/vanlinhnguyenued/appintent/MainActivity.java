package com.vanlinhnguyenued.appintent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText editTextUsername, editTextPassword;
    Button buttonDangky, buttonDangnhap;
    String username;
    String password;

    public void mapping(){
        editTextUsername = (EditText) findViewById(R.id.edtUsername2);
        editTextPassword = (EditText) findViewById(R.id.edtPassword2);
        buttonDangky = (Button) findViewById(R.id.btnXacNhan);
        buttonDangnhap = (Button) findViewById(R.id.btnDangnhap);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Dangnhap();
        DangKy();

    }

    private void Dangnhap(){
        mapping();

        buttonDangnhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent1 = getIntent();
                username = intent1.getStringExtra("username");
                password = intent1.getStringExtra("password");
                if((editTextUsername.getText().toString().equals("linhdeptrai")&&
                        editTextPassword.getText().toString().equals("123"))|| (
                        editTextUsername.getText().toString().equals(username)&&
                                editTextPassword.getText().toString().equals(password)
                        )){
                    Intent intent = new Intent(MainActivity.this, ListCourseActivity.class);
                    intent.putExtra("username", editTextUsername.getText().toString());
                    MainActivity.this.startActivity(intent);



                }
                else Toast.makeText(MainActivity.this, "Đăng nhập không thành công", Toast.LENGTH_SHORT).show();

            }
        });
    }
    public void DangKy(){
        mapping();
        buttonDangky.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SignUpActivity.class);
                MainActivity.this.startActivity(intent);
            }
        });
    }
}
