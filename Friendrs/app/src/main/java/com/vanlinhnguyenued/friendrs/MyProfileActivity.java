package com.vanlinhnguyenued.friendrs;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Magnifier;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import de.hdodenhof.circleimageview.CircleImageView;

public class MyProfileActivity extends AppCompatActivity {

    private ImageView imgCamera,btnBack;
    private CircleImageView myAvatar;
    private TextView txtName, txtDeception;
    private int REQUEST_CODE_CAMERA = 123;

    private void mapping(){
        btnBack = (ImageView) findViewById(R.id.back1);
        imgCamera = (ImageView) findViewById(R.id.btnCamera);
        myAvatar = (CircleImageView) findViewById(R.id.avtMyPr);
        txtDeception = (TextView) findViewById(R.id.deceptionMyPr);
        txtName = (TextView) findViewById(R.id.nameMyPr);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_profile);

        mapping();
        Back();
        Camera();

    }
    private void Back(){
        mapping();
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MyProfileActivity.this, MainActivity.class);
                MyProfileActivity.this.startActivity(intent);
            }
        });
    }
    private  void Camera(){
        mapping();
        imgCamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ActivityCompat.requestPermissions(MyProfileActivity.this, new String[]{Manifest.permission.CAMERA}, REQUEST_CODE_CAMERA);
            }
        });
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if (requestCode == REQUEST_CODE_CAMERA && grantResults.length > 0 && grantResults[0]== PackageManager.PERMISSION_GRANTED){
            Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            MyProfileActivity.this.startActivityForResult(intent, REQUEST_CODE_CAMERA);
        }
        else{
            Toast.makeText(MyProfileActivity.this, "Bạn không cho phép mở camera", Toast.LENGTH_SHORT).show();
        }
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if(requestCode==REQUEST_CODE_CAMERA&&resultCode==RESULT_OK&&data!=null){
            Bitmap bitmap = (Bitmap) data.getExtras().get("data");
            myAvatar.setImageBitmap(bitmap);
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
}
