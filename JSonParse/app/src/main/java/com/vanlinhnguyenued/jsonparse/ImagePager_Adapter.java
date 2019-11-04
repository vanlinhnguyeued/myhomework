package com.vanlinhnguyenued.jsonparse;

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

import java.util.ArrayList;

public class ImagePager_Adapter extends PagerAdapter {
    private Context context;
    private ArrayList<ImageItem> imageItems;

    public ImagePager_Adapter(Context context, ArrayList<ImageItem> imageItems) {
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
        View inflatedView = View.inflate(context, R.layout.image_item,null);
        container.addView(inflatedView);


        final ImageView iv_img = (ImageView) inflatedView.findViewById(R.id.iv_Img);
        TextView tv_description = (TextView) inflatedView.findViewById(R.id.tv_description);


        String descritption = imageItems.get(position).getDescription();
        tv_description.setText(descritption);

        ImageRequest request = new ImageRequest(imageItems.get(position).getUrl(),
                new Response.Listener<Bitmap>() {
                    @Override
                    public void onResponse(Bitmap response) {
                        iv_img.setImageBitmap(response);
                    }
                }, 0, 0, null,
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.d("ImagePagerAdapter","Network Error");
                    }
                }
        );

        RequestQueue requestQueue = Volley.newRequestQueue(context);
        requestQueue.add(request);

        return inflatedView;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }
}
