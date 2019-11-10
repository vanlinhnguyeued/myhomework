package com.vanlinhnguyenued.myfriends3;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class FriendAdapter extends BaseAdapter {
    private Context context;
    private int layout;
    private List<Friend> friends;

    public FriendAdapter(Context context, int layout, List<Friend> friends) {
        this.context = context;
        this.layout = layout;
        this.friends = friends;
    }

    @Override
    public int getCount() {
        return friends.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }
    private class ViewHolder{
        ImageView avtRowFriend;
        TextView nameRowFriend;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder viewHolder;
        if(convertView==null){
            viewHolder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(layout, null);
            viewHolder.avtRowFriend = convertView.findViewById(R.id.avt_row_friend);
            viewHolder.nameRowFriend = convertView.findViewById(R.id.name_row_friend);
            convertView.setTag(viewHolder);

        }
        else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        Friend friend = friends.get(position);
        viewHolder.nameRowFriend.setText(friend.getName());
        viewHolder.avtRowFriend.setImageResource(friend.getAvatar());
        return convertView;
    }
}
