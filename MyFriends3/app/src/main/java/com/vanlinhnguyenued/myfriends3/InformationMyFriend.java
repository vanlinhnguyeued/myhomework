package com.vanlinhnguyenued.myfriends3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class InformationMyFriend extends AppCompatActivity  {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_information_my_friend);
        Intent intent = getIntent();
        Friend friend = (Friend) intent.getSerializableExtra("infor");
        InforFriendFragment inforFriendFragment = (InforFriendFragment) getFragmentManager().findFragmentById(R.id.fragment3);
        inforFriendFragment.setInforFriends(friend);
    }
}
