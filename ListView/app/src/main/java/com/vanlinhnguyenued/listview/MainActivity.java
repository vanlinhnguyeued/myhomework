package com.vanlinhnguyenued.listview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView listcouses;
    ArrayList<String> courses;
    Button btn, updateBtn;
    EditText edt;
    int local;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        listcouses = (ListView) findViewById(R.id.lv);
        btn = (Button) findViewById(R.id.addBtn);
        edt = (EditText) findViewById(R.id.editText);
        updateBtn = (Button) findViewById(R.id.updateBtn);
        courses = new ArrayList<>();

        final ArrayAdapter adapter = new ArrayAdapter(MainActivity.this, android.R.layout.simple_list_item_1, courses);

        listcouses.setAdapter(adapter);

        listcouses.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(MainActivity.this, courses.get(i), Toast.LENGTH_SHORT).show();
                edt.setText(courses.get(i));
                local = i;
            }
        });

        listcouses.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {

                Toast.makeText(MainActivity.this, "Removed "+courses.get(i), Toast.LENGTH_SHORT).show();
                courses.remove(i);
                adapter.notifyDataSetChanged();
                return false;
            }
        });


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String coursename = edt.getText().toString();
                courses.add(coursename);
                adapter.notifyDataSetChanged();
            }
        });

        updateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                courses.set(local, edt.getText().toString());
                adapter.notifyDataSetChanged();
            }
        });
    }
}
