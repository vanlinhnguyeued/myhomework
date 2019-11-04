package com.vanlinhnguyenued.friendrs;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.BadParcelableException;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import de.hdodenhof.circleimageview.CircleImageView;

public class ProfileActivity extends AppCompatActivity {

    private ImageView imageViewBack;
    private TextView textViewName, textViewDeception;
    private CircleImageView circleImageView;

    private void mapping(){
        circleImageView = (CircleImageView) findViewById(R.id.avtPr);
        textViewName = (TextView) findViewById(R.id.namePr);
        textViewDeception = (TextView) findViewById(R.id.deceptionPr);
        imageViewBack = (ImageView) findViewById(R.id.back);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        mapping();
        Intent intent = getIntent();
        Friends friends = (Friends) intent.getSerializableExtra("friend");

        textViewDeception.setText(friends.getDeception());
        textViewName.setText(friends.getNameFr());
        circleImageView.setImageResource(friends.getAvatarFr());

        Back();
    }

    private void Back(){
        mapping();
        imageViewBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ProfileActivity.this, MainActivity.class);
                ProfileActivity.this.startActivity(intent);
            }
        });
    }
}
