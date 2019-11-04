package com.vanlinhnguyenued.myfriends2;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.FileProvider;

import android.Manifest;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.view.View;
import android.widget.ImageButton;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import de.hdodenhof.circleimageview.CircleImageView;

import static android.os.Environment.getExternalStoragePublicDirectory;

public class MyProfile extends AppCompatActivity {
    private CircleImageView prfAvatar;
    private ImageButton btnCamera;
    String pathToFile;
    private Profile profile;
    private int GALLERY_REQUEST_CODE = 123;
    private void Mapping(){
        prfAvatar = (CircleImageView) findViewById(R.id.prfAvatar);
        btnCamera = (ImageButton) findViewById(R.id.btnShare);

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_profile);
        Mapping();
        if(Build.VERSION.SDK_INT>=23){
            requestPermissions(new String[]{Manifest.permission.CAMERA, Manifest.permission.WRITE_EXTERNAL_STORAGE}, 2);
        }
        btnCamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handleBtnCamera();
            }
        });
        Intent intent = getIntent();
        prfAvatar.setImageResource(intent.getIntExtra("myAvt", 1));
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        Mapping();
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode==RESULT_OK){
            if(requestCode==1){
                Bitmap bitmap = BitmapFactory.decodeFile(pathToFile);
                prfAvatar.setImageBitmap(bitmap);
            }
            if(requestCode == GALLERY_REQUEST_CODE){
                Uri selectedImage = data.getData();
                prfAvatar.setImageURI(selectedImage);
            }
        }

    }
    private void handleBtnCamera(){
        Intent takePic = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if(takePic.resolveActivity(getPackageManager())!=null){
            File photoFile = null;
            photoFile = createPhotoFile();
            if(photoFile!=null) {
                pathToFile = photoFile.getAbsolutePath();
                Uri photoUri = FileProvider.getUriForFile(MyProfile.this, "com.vanlinhnguyenued.myfriends2.fileprovider", photoFile);
                takePic.putExtra(MediaStore.EXTRA_OUTPUT,photoUri);
                startActivityForResult(takePic, 1);
            }

        }

    }
    private File createPhotoFile() {
        String name = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        File storageDir = getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES);
        File image = null;
        try {
            image = File.createTempFile(name, ".jpg", storageDir);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return image;
    }


}
