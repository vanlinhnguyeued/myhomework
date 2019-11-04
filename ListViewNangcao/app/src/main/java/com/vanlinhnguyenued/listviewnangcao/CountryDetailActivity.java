package com.vanlinhnguyenued.listviewnangcao;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class CountryDetailActivity extends AppCompatActivity {
    TextView tv;
    ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_country_detail);

        Intent intent = getIntent();
        int tv1 = intent.getIntExtra("nameCountry", 1);
        tv = (TextView) findViewById(R.id.textView);

        imageView = (ImageView) findViewById(R.id.imageView2);
        imageView.setImageResource(tv1);
    }
}
