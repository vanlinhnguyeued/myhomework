package com.vanlinhnguyenued.grirdview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    GridView alphabet;
    ArrayList<String> arrayList;
    ArrayAdapter adapter;

    public void AnhXa(){
        alphabet = (GridView) findViewById(R.id.gvAlphabet);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AnhXa();
        alphabet.setNumColumns(4);
        arrayList = new ArrayList<>();
        arrayList.add("A");arrayList.add("B");arrayList.add("C");arrayList.add("D");arrayList.add("E");arrayList.add("F");arrayList.add("G");arrayList.add("H");arrayList.add("I");arrayList.add("K");arrayList.add("L");arrayList.add("M");arrayList.add("N");arrayList.add("O");arrayList.add("P");
        arrayList.add("Q");arrayList.add("R");arrayList.add("S");arrayList.add("T");arrayList.add("U");arrayList.add("A");arrayList.add("V");arrayList.add("W");arrayList.add("X");arrayList.add("Y");arrayList.add("Z");

        adapter = new ArrayAdapter(MainActivity.this, android.R.layout.simple_list_item_1, arrayList);
        alphabet.setAdapter(adapter);
        alphabet.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(MainActivity.this, arrayList.get(i), Toast.LENGTH_SHORT).show();
            }
        });
    }
}






