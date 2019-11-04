package com.vanlinhnguyenued.appintent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class ListCourseActivity extends AppCompatActivity {
    Button buttonDangxuat, buttonAddCourse, buttonUpadateCourse;
    EditText editTextCourseName;
    TextView textViewUsername;
    ListView listViewCourse;
    ArrayList<String> course;
    ArrayAdapter arrayAdapter;
    int local;

    public void mapping(){
        buttonDangxuat = (Button) findViewById(R.id.btnDangxuat);
        textViewUsername = (TextView) findViewById(R.id.tvUsername);
        editTextCourseName = (EditText) findViewById(R.id.edtCourse);
        listViewCourse = (ListView) findViewById(R.id.listViewCourses);
        buttonAddCourse = (Button) findViewById(R.id.btnAddCourse);
        buttonUpadateCourse = (Button) findViewById(R.id.btnUpdateCourse);


    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_course);
        Toast.makeText(ListCourseActivity.this, "Đăng nhập thành công!", Toast.LENGTH_SHORT).show();
        setTextViewUsername();
        DangXuat();
        cRUDCourse();
        mapping();


    }



    public void setTextViewUsername(){
        Intent intent = getIntent();
        mapping();
        textViewUsername.setText(intent.getStringExtra("username"));
    }


    public void DangXuat(){
        mapping();
        buttonDangxuat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(ListCourseActivity.this, MainActivity.class);
                ListCourseActivity.this.startActivity(intent);

            }
        });
    }

    public void cRUDCourse(){
        mapping();

        course = new ArrayList<>();
        arrayAdapter = new ArrayAdapter(ListCourseActivity.this, android.R.layout.simple_list_item_1,course);
        course.add("PHP");
        course.add("Java");
        course.add("Android");
        listViewCourse.setAdapter(arrayAdapter);
        buttonAddCourse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                course.add(editTextCourseName.getText().toString());
                arrayAdapter.notifyDataSetChanged();
            }
        });
        listViewCourse.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(ListCourseActivity.this, "Remote course!", Toast.LENGTH_SHORT).show();
                course.remove(position);
                arrayAdapter.notifyDataSetChanged();
                return false;
            }
        });
        listViewCourse.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                local=position;
                Toast.makeText(ListCourseActivity.this, course.get(position), Toast.LENGTH_SHORT).show();
                editTextCourseName.setText(course.get(position));
            }
        });
        buttonUpadateCourse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                course.set(local, editTextCourseName.getText().toString());
                Toast.makeText(ListCourseActivity.this, "The update was successful!", Toast.LENGTH_SHORT).show();
                arrayAdapter.notifyDataSetChanged();
            }
        });
    }

}
