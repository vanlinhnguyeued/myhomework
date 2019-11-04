package com.vanlinhnguyenued.ninjar;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void RadioB (View view){
        ImageView img = findViewById(R.id.imageView);
        TextView textView = findViewById(R.id.tennv);

        switch (view.getId()){
            case R.id.radioButton5:
                img.setImageDrawable(getResources().getDrawable(R.drawable.ninjarua1));
                textView.setText("Rùa bé tý 1");
                break;
            case R.id.radioButton6:
                img.setImageDrawable(getResources().getDrawable(R.drawable.ninjarua2));
                textView.setText("Rùa bé tý 2");
                break;
            case R.id.radioButton7:
                img.setImageDrawable(getResources().getDrawable(R.drawable.ninjarua3));
                textView.setText("Rùa bé tý 3");
                break;
            case R.id.radioButton8:
                img.setImageDrawable(getResources().getDrawable(R.drawable.ninjarua4));
                textView.setText("Rùa bé tý 4");
                break;

        }

    }
    public void hidenImg (View view) {
        Switch hd = findViewById(R.id.switch1);
        ImageView img = findViewById(R.id.imageView);
        if(hd.isChecked()){
            img.setVisibility(View.VISIBLE);
        }
        else {
            img.setVisibility(View.INVISIBLE);
        }
    }
}
