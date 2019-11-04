package com.vanlinhnguyenued.myfriends2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button btnSignIn, btnSignUp;
    private EditText edtUsername, edtPassword;

    private void Mapping(){
        btnSignIn = (Button) findViewById(R.id.btnConfirm);
        btnSignUp = (Button) findViewById(R.id.btnCancel);
        edtPassword = (EditText) findViewById(R.id.edtPasswordSU);
        edtUsername = (EditText) findViewById(R.id.edtUsernameSU);

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Mapping();

        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handleBtnSignUp();
            }
        });
        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handleBtnSignIn();
            }
        });
    }

    private void handleBtnSignUp() {
        Intent signUpIntent = new Intent(MainActivity.this, SignUp.class);
        MainActivity.this.startActivity(signUpIntent);
    }
    private void handleBtnSignIn() {
        Mapping();
        if(edtUsername.getText().toString().equals("linh")&&edtPassword.getText().toString().equals("123")){
            Intent signInIntent = new Intent(MainActivity.this, NewsFeeds.class);
            MainActivity.this.startActivity(signInIntent);
            edtUsername.setText("");
            edtPassword.setText("");
        }
        else {
            Toast.makeText(MainActivity.this, "Đăng nhập không thành công!", Toast.LENGTH_SHORT).show();
        }
    }
}

