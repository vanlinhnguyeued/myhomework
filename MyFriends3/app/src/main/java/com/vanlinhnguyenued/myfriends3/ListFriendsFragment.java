package com.vanlinhnguyenued.myfriends3;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.ListFragment;

import java.util.ArrayList;

public class ListFriendsFragment extends ListFragment {
    ArrayList<Friend>friends;
    FriendAdapter adapter;
    TransmissionInforFriends transmissionInforFriends;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        transmissionInforFriends = (TransmissionInforFriends) getActivity();
        friends = new ArrayList<>();
        addFriend();
        adapter = new FriendAdapter(getActivity(), R.layout.row_friend, friends);
        setListAdapter(adapter);

        View view = inflater.inflate(R.layout.list_friends_fragment, container, false);
        return view;

    }

    @Override
    public void onListItemClick(@NonNull ListView l, @NonNull View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        transmissionInforFriends.DataInforFriends(friends.get(position));
    }

    private void addFriend(){
        friends.add(new Friend("Hoang Nhat", "hoangnhat@gmail.com", "0975158123", R.drawable.nhat, 3 ));
        friends.add(new Friend("Thu Huong", "thuhuong@gmail.com", "0975158124", R.drawable.huong, 5 ));
        friends.add(new Friend("Ni Ni", "nini@gmail.com", "0975158125", R.drawable.ni, 2 ));
        friends.add(new Friend("Thao Suong", "thaosuong@gmail.com", "0975158126", R.drawable.suong , 4));
        friends.add(new Friend("Khuong Tiep", "khuongtiep@gmail.com", "0975158127", R.drawable.tiep, 2 ));
    }
}
