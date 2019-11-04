package com.vanlinhnguyenued.myfriends2;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class FriendsAdapter extends BaseAdapter {
    private Context context;
    private int layout;
    private List<Friend> friendList;

    public FriendsAdapter(Context context, int layout, List<Friend> friendList) {
        this.context = context;
        this.layout = layout;
        this.friendList = friendList;
    }

    @Override
    public int getCount() {
        return friendList.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = inflater.inflate(layout,null);

        TextView tvNameFriend = (TextView) convertView.findViewById(R.id.tvNameFriend);
        TextView tvStatusFriend = (TextView) convertView.findViewById(R.id.tvStatusFriend);
        ImageView imgAvtFriend = (ImageView) convertView.findViewById(R.id.imgAvtFriend);

        Friend friend = friendList.get(position);
        tvNameFriend.setText(friend.getName());
        tvStatusFriend.setText(friend.getStatus());
        if (friend.getAvatar_drawable()==null)
            imgAvtFriend.setImageResource(friend.getAvatar());
        else
            imgAvtFriend.setImageDrawable(friend.getAvatar_drawable());
        return convertView;
    }
}
