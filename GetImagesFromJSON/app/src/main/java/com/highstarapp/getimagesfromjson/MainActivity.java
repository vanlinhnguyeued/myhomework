package com.highstarapp.getimagesfromjson;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button getButton = findViewById(R.id.getBtn);
        getButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(MainActivity.this,AlbulmActivity.class);
                EditText urlET = findViewById(R.id.urlEditText);
                String url = urlET.getText().toString();
                intent.putExtra("albulmURL",url);
                startActivity(intent);
            }
        });
    }
}
