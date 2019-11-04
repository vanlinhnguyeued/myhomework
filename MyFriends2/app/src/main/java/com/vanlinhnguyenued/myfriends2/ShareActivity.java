package com.vanlinhnguyenued.myfriends2;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.FileProvider;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static android.os.Environment.getExternalStoragePublicDirectory;

public class ShareActivity extends AppCompatActivity {
    private ImageButton imageButtonCmrShare, imageButtonGalleryShare,imageButtonShare;
    private ImageView myImage;
    String pathToFile;
    private int GALLERY_REQUEST_CODE = 123;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_share);
        
        Mapping();
        handleCameraShare();
        handleGalleryShare();
        handleShare();
    }

    private void handleShare() {
        Mapping();
        imageButtonShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent sendIntent = new Intent();
                sendIntent.setAction(Intent.ACTION_SEND);
                sendIntent.putExtra(Intent.EXTRA_TEXT, "This is my text to send.");
                sendIntent.setType("text/plain");

                Intent shareIntent = Intent.createChooser(sendIntent, null);
                startActivity(shareIntent);
            }
        });
    }

    private void handleGalleryShare() {
        Mapping();
        imageButtonGalleryShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Create an Intent with action as ACTION_PICK
                Intent intent=new Intent(Intent.ACTION_PICK);
                // Sets the type as image/*. This ensures only components of type image are selected
                intent.setType("image/*");
                //We pass an extra array with the accepted mime types. This will ensure only components with these MIME types as targeted.
                String[] mimeTypes = {"image/jpeg", "image/png"};
                intent.putExtra(Intent.EXTRA_MIME_TYPES,mimeTypes);
                // Launching the Intent
                startActivityForResult(intent,GALLERY_REQUEST_CODE);
            }
        });
    }

    private void handleCameraShare() {
        Mapping();
        imageButtonCmrShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent takePic = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                if(takePic.resolveActivity(getPackageManager())!=null){
                    File photoFile = null;
                    photoFile = createPhotoFile();
                    if(photoFile!=null) {
                        pathToFile = photoFile.getAbsolutePath();
                        Uri photoUri = FileProvider.getUriForFile(ShareActivity.this, "com.vanlinhnguyenued.myfriends2.fileprovider", photoFile);
                        takePic.putExtra(MediaStore.EXTRA_OUTPUT,photoUri);
                        startActivityForResult(takePic, 1);
                    }

                }
            }
        });
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
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        Mapping();
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode==RESULT_OK){
            if(requestCode==1){
                Bitmap bitmap = BitmapFactory.decodeFile(pathToFile);
                myImage.setImageBitmap(bitmap);
            }
            if(requestCode == GALLERY_REQUEST_CODE){
                Uri selectedImage = data.getData();
                myImage.setImageURI(selectedImage);
            }
        }

    }

    private void Mapping() {
        imageButtonCmrShare = (ImageButton) findViewById(R.id.imageButtonCmrShare);
        imageButtonGalleryShare = (ImageButton) findViewById(R.id.imageButtonGalleryShare);
        imageButtonShare = (ImageButton) findViewById(R.id.imageButtonShare);
        myImage = (ImageView) findViewById(R.id.myImg);
    }
}
