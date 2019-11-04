package com.vanlinhnguyenued.myfriends2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SignUp extends AppCompatActivity {
    private Button btnCancel;
    protected void Mapping(){
        btnCancel = (Button) findViewById(R.id.btnCancel);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        Mapping();
        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handleBtnCancle();
            }
        });
    }

    private void handleBtnCancle() {
        Intent cancelIntent = new Intent(SignUp.this, MainActivity.class);
        SignUp.this.startActivity(cancelIntent);
    }
}
