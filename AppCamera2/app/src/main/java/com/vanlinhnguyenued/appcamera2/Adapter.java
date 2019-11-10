package com.vanlinhnguyenued.appcamera2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class Adapter extends BaseAdapter {
    Context context;
    int layout;
    List<Country> countries;

    @Override
    public int getCount() {
        return countries.size();
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

        TextView name = convertView.findViewById(R.id.name);
        ImageView img = convertView.findViewById(R.id.img);

        Country country =countries.get(position);
        name.setText(country.getName());
        img.setImageBitmap(country.getImage());
        return convertView;
    }
}
