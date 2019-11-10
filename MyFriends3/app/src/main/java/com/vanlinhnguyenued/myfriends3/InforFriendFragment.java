package com.vanlinhnguyenued.myfriends3;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class InforFriendFragment extends Fragment {
    TransmissionInforFriends transmissionInforFriends;
    ImageView avt_infor;
    RatingBar ratingBar;
    TextView name_infor,numberphone_infor,email_infor;
    View view;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
         view = inflater.inflate(R.layout.infor_friend_fragment, container,false);
        mapping();
        return view;
    }
    public void setInforFriends(Friend friend){
        avt_infor.setImageResource(friend.getAvatar());
        ratingBar.setRating(friend.getRating());
        name_infor.setText(friend.getName());
        numberphone_infor.setText(friend.getNumberphone());
        email_infor.setText(friend.getEmail());
    }
    private void mapping(){
        avt_infor = (ImageView) view.findViewById(R.id.avt_infor);
        ratingBar = (RatingBar) view.findViewById(R.id.ratingBar);
        name_infor = (TextView) view.findViewById(R.id.name_infor);
        numberphone_infor = (TextView) view.findViewById(R.id.numberphone_infor);
        email_infor = (TextView) view.findViewById(R.id.email_infor);
    }
}
