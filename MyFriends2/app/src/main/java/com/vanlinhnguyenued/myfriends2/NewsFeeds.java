package com.vanlinhnguyenued.myfriends2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.GridView;
import android.text.TextUtils;
import android.widget.ImageButton;

import java.io.Serializable;
import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class NewsFeeds extends AppCompatActivity {
    private GridView gvFriends;
    private ArrayList<Friend>friendArrayList;
    private FriendsAdapter friendsAdapter;
    private EditText edtStatus;
    private CircleImageView profile_image;
    private Profile avt ;
    private ImageButton btnShare;
    private void Mapping(){
        gvFriends = (GridView) findViewById(R.id.gvFriends);
        edtStatus = (EditText) findViewById(R.id.edtStatus);
        profile_image = (CircleImageView) findViewById(R.id.profile_image);
        btnShare = (ImageButton) findViewById(R.id.btnShare);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_feeds);
        Mapping();
        postStatus();
        setDataOnListMyFriends();
        toMyProfile();
        avt = new Profile(R.drawable.avt);
        profile_image.setImageResource(avt.getAvt());
        toFrProfile();
        toShareActivity();
    }

    private void toShareActivity() {
        Mapping();
        btnShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(NewsFeeds.this, ShareActivity.class);
                NewsFeeds.this.startActivity(intent);
            }
        });
    }

    private void setDataOnListMyFriends() {
        Mapping();
        friendArrayList = new ArrayList<>();
        friendArrayList.add(new Friend("Thao Suong", "A woman gives and forgives, a man gets and forgets",R.drawable.suong));
        friendArrayList.add(new Friend("Minh Tiep", "Don’t trouble trouble till trouble troubles you",R.drawable.tiep));
        friendArrayList.add(new Friend("Thu Huong", "Tell me who your friends are and I’ll tell you who you are",R.drawable.huong));
        friendArrayList.add(new Friend("Hoang Nhat", " A great lover is not one who loves many, but one who loves one woman for life.",R.drawable.nhat));
        friendArrayList.add(new Friend("Ni Nguyen", "You know when you love someone when you want them to be happy even if " +
                "their happiness means that you’re not part of it",R.drawable.ni));
        friendsAdapter = new FriendsAdapter(NewsFeeds.this, R.layout.line_friend, friendArrayList);
        gvFriends.setAdapter(friendsAdapter);

    }

    private void postStatus(){
        Mapping();
        edtStatus.setOnKeyListener(new View.OnKeyListener() {
            public boolean onKey(View v, int keyCode, KeyEvent event) {

                if((event.getAction()==KeyEvent.ACTION_DOWN)&&(keyCode==KeyEvent.KEYCODE_ENTER)&& !TextUtils.isEmpty(edtStatus.getText().toString())){
                    friendArrayList.add(0, new Friend("Vanlinh Nguyen", edtStatus.getText().toString(), profile_image.getDrawable()));
                    edtStatus.setText("");
                    return true;
                }
                return false;
            }
        });
    }

    private void toMyProfile(){
        Mapping();
        profile_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(NewsFeeds.this, MyProfile.class);
                intent.putExtra("myAvt", avt.getAvt());
                NewsFeeds.this.startActivity(intent);
            }
        });
    }
    private void toFrProfile(){
        Mapping();
        gvFriends.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(NewsFeeds.this, FrProfileActivity.class);
                Friend friend = new Friend(friendArrayList.get(position).getName(), friendArrayList.get(position).getStatus(), friendArrayList.get(position).getAvatar());
                intent.putExtra("friend", friend);
                NewsFeeds.this.startActivity(intent);



            }
        });
    }
}
