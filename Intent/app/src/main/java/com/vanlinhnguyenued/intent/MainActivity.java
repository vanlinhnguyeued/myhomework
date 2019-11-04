package com.vanlinhnguyenued.intent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button btnLogin;
    Intent intent;
    EditText username, password;
    public void  Anhxa(){
        btnLogin = (Button) findViewById(R.id.button);
        username = (EditText) findViewById(R.id.username1);
        password = (EditText) findViewById(R.id.password);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Anhxa();
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(username.getText().toString().equals("linh")&&password.getText().toString().equals("123")){
                    intent = new Intent(MainActivity.this, Main2Activity.class);
                    intent.putExtra("ten", username.getText().toString());
                    MainActivity.this.startActivity(MainActivity.this.intent);


                }
                else {
                    Toast.makeText(MainActivity.this, "Ten dang nhap hoac mat khau bi sai", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
