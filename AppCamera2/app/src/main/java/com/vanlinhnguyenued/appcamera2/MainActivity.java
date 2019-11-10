package com.vanlinhnguyenued.appcamera2;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ListView listView;
    Adapter adapter;
    ArrayList<Country> countries;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = findViewById(R.id.lvFr);
        countries = new ArrayList<>();
        countries.add(new Country("Brunei", (Bitmap) R.drawable.bru));
    }
}
