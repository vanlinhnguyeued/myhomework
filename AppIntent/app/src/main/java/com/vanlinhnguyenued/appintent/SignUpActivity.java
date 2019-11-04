package com.vanlinhnguyenued.appintent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SignUpActivity extends AppCompatActivity {
    EditText editTextUsername, editTextPassword, editTextConfirmPassword;
    Button buttonXacNhan;

    public void mapping (){
        editTextConfirmPassword = (EditText) findViewById(R.id.edtConfirmPassword);
        editTextPassword = (EditText) findViewById(R.id.edtPassword2);
        editTextUsername = (EditText) findViewById(R.id.edtUsername2);
        buttonXacNhan = (Button) findViewById(R.id.btnXacNhan);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        XacNhan();
    }

    public void XacNhan() {
        mapping();
        buttonXacNhan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(editTextPassword.getText().toString().equals(editTextConfirmPassword.getText().toString())){
                    Intent intent = new Intent(SignUpActivity.this, MainActivity.class);
                    intent.putExtra("username", editTextUsername.getText().toString());
                    intent.putExtra("password", editTextPassword.getText().toString());
                    SignUpActivity.this.startActivity(intent);

                }
                else Toast.makeText(SignUpActivity.this, "Fail", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
