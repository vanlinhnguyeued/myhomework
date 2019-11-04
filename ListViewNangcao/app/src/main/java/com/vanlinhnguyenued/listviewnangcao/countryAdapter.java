package com.vanlinhnguyenued.listviewnangcao;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class countryAdapter extends BaseAdapter {

    private Context context;
    private int layout;
    private List<country> countryList;

    public countryAdapter(Context context, int layout, List<country> countryList) {
        this.context = context;
        this.layout = layout;
        this.countryList = countryList;
    }

    @Override
    public int getCount() {
        return countryList.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        view = inflater.inflate(layout, null);

        TextView txtTen = (TextView) view.findViewById(R.id.nameCountry);
        TextView txtMota = (TextView) view.findViewById(R.id.textView2);
        ImageView imgHinh = (ImageView) view.findViewById(R.id.imageView);

        country country = countryList.get(i);
        txtTen.setText(country.getTen());
        txtMota.setText(country.getMota());
        imgHinh.setImageResource(country.getHinh());


        return view;
    }
}
