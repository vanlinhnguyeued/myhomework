package com.gmail.vantri.bignumbergame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private  int i = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void buttonClick(View v){
        Button bt1 = findViewById(R.id.button);
        Button bt2 = findViewById(R.id.button2);
        int value_1 = Integer.parseInt(bt1.getText().toString());
        int value_2 = Integer.parseInt(bt2.getText().toString());
        TextView point = findViewById(R.id.textView3);
        Context context = getApplicationContext();
        CharSequence text_s = "Success", text_f = "Fail";
        Random rd = new Random();
        boolean check;

        if(R.id.button == v.getId()) {
            if (checkValue(value_1, value_2)) {
                check = true;
            } else {
                check = false;
            }
        }else{
            if(checkValue(value_2, value_1)){
                check = true;
            }else{
                check = false;
            }
        }
        if(check){
            i++;
            point.setText("Point: " + i);
            Toast.makeText(context, text_s, Toast.LENGTH_SHORT).show();

        }else{
            i--;
            point.setText("Point: " + i);
            Toast.makeText(context, text_f, Toast.LENGTH_SHORT).show();
        }
        bt1.setText(String.valueOf(rd.nextInt(200)));
        bt2.setText(String.valueOf(rd.nextInt(200)));
    }

    private  boolean checkValue(int a, int b){
        if(a >=b ) return true;
        else return false;
    }


}
