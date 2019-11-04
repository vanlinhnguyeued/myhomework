package com.vanlinhnguyenued.intent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Toast.makeText(Main2Activity.this, "Dang nhap thanh cong", Toast.LENGTH_SHORT).show();

        Intent intent = getIntent();
        TextView username = (TextView) findViewById(R.id.username1);
        username.setText(intent.getStringExtra("ten"));
    }
}
