package com.highstarapp.getimagesfromjson;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageRequest;
import com.android.volley.toolbox.Volley;
import com.koushikdutta.ion.Ion;

import java.util.ArrayList;

public class ImagePagerAdaper extends PagerAdapter {
    private Context context;
    ArrayList<ImageItem> imageItems;

    public ImagePagerAdaper(Context context, ArrayList<ImageItem> imageItems) {
        this.context = context;
        this.imageItems = imageItems;
    }

    @Override
    public int getCount() {
        return imageItems.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view==object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        View inflatedView = View.inflate(context,R.layout.image_item_layout,null);
        container.addView(inflatedView);

        final ImageView imageView= inflatedView.findViewById(R.id.imgView);
        TextView imageDescTV = inflatedView.findViewById(R.id.imgDesc);

        String imageDesc = imageItems.get(position).getDescription();
        imageDescTV.setText(imageDesc);

        ImageRequest request = new ImageRequest(imageItems.get(position).getUrl(),
                new Response.Listener<Bitmap>() {
                    @Override
                    public void onResponse(Bitmap response) {
                        imageView.setImageBitmap(response);
                    }
                }, 0, 0, null,
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.d("ImagePagerAdapter","Network Error");
                    }
                }
        );
        RequestQueue requestQueue= Volley.newRequestQueue(context);
        requestQueue.add(request);

        return inflatedView;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View)object);
    }
}
