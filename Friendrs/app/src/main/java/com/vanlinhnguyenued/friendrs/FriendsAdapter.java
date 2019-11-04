package com.vanlinhnguyenued.friendrs;

import android.content.Context;
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
    private List<Friends> friendsList;

    public FriendsAdapter(Context context, int layout, List<Friends> friendsList) {
        this.context = context;
        this.layout = layout;
        this.friendsList = friendsList;
    }

    @Override
    public int getCount() {
        return friendsList.size();
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
        convertView = inflater.inflate(layout, null);

        TextView txtNameFr = (TextView) convertView.findViewById(R.id.nameFr);
        ImageView avatarFr = (ImageView) convertView.findViewById(R.id.avatarFr);

        Friends friends = friendsList.get(position);
        txtNameFr.setText(friends.getNameFr());
        avatarFr.setImageResource(friends.getAvatarFr());

        return convertView;
    }
}
