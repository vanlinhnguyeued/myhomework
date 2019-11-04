package com.vanlinhnguyenued.myfriends2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class FrProfileActivity extends AppCompatActivity {
    private CircleImageView prfAvatar;
    private TextView prfName;
    private ListView lvStatus;
    ArrayList<String> listStt;
    public void Mapping(){
        prfAvatar = (CircleImageView) findViewById(R.id.prfAvatarfr);
        prfName = (TextView) findViewById(R.id.prfNamefr);
        lvStatus = (ListView) findViewById(R.id.lvStatusfr);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fr_profile);
        Mapping();
        Intent intent = getIntent();
        Friend friend = (Friend) intent.getSerializableExtra("friend");
        prfName.setText(friend.getName());
        prfAvatar.setImageResource(friend.getAvatar());
        listStt = new ArrayList<>();
        listStt.add(friend.getStatus());
        ArrayAdapter adapter =new ArrayAdapter(FrProfileActivity.this, android.R.layout.simple_list_item_1, listStt);
        lvStatus.setAdapter(adapter);

    }

}
