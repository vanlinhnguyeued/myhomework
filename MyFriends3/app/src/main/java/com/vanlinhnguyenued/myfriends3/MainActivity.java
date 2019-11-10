package com.vanlinhnguyenued.myfriends3;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements TransmissionInforFriends{


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void DataInforFriends(Friend friend) {
        InforFriendFragment inforFriendFragment = (InforFriendFragment) getFragmentManager().findFragmentById(R.id.fragmentInfor);
        if(inforFriendFragment != null && inforFriendFragment.isInLayout()){
            inforFriendFragment.setInforFriends(friend);
        }
        else{
            Intent intent = new Intent(MainActivity.this, InformationMyFriend.class);
            intent.putExtra("infor", friend);
            MainActivity.this.startActivity(intent);
        }

    }
}
