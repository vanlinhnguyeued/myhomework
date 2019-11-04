package com.vanlinhnguyenued.jsonparse;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class Main2Activity extends AppCompatActivity {
    private TextView tvName;
    private RequestQueue requestQueue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);




        jSonParse();
    }

    private void jSonParse() {
        requestQueue = Volley.newRequestQueue(Main2Activity.this);
        Intent intent = getIntent();
        String URL = intent.getStringExtra("url");
        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, URL, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {

                    String nameAlbum = response.get("name").toString();
                    tvName = (TextView) findViewById(R.id.tvName);
                    tvName.setText(nameAlbum);

                    JSONArray jsonArray =response.getJSONArray("images");
                    ArrayList<ImageItem>imageItems =new ArrayList<>();
                    for(int i = 0; i<jsonArray.length(); i++){
                        JSONObject jsonObject = jsonArray.getJSONObject(i);
                        ImageItem imageItem = new ImageItem(jsonObject.get("name").toString(), jsonObject.get("description").toString());
                        imageItems.add(imageItem);
                        ViewPager viewPagerImg =(ViewPager) findViewById(R.id.viewPagerImg);
                        ImagePager_Adapter imagePager_adapter = new ImagePager_Adapter(Main2Activity.this, imageItems);
                        viewPagerImg.setAdapter(imagePager_adapter);
                    }
                }
                catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        });
        requestQueue.add(request);
    }
}
