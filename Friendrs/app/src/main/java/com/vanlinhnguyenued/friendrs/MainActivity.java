package com.vanlinhnguyenued.friendrs;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.SearchView;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;


public class MainActivity extends AppCompatActivity {
    private CircleImageView circleImageView;
    private GridView listFr;
    private ArrayList<Friends> friendsArrayList;
    private FriendsAdapter friendsAdapter;
    private SearchView searchView;

    public void mapping(){
        circleImageView = (CircleImageView) findViewById(R.id.avtPr);
        listFr = (GridView) findViewById(R.id.listFr);
        searchView = (SearchView) findViewById(R.id.search);

    }
    private void addFriends(){
        friendsArrayList = new ArrayList<>();
        friendsArrayList.add(new Friends("Black Window", "Natalia Alianovna \"Natasha\" Romanova[1] (Russian: Наталья Альяновна \"Наташа\" Романова; alias: Natasha Romanoff; Russian: Наташа Романоф), colloquial: Black Widow (Russian: Чёрная Вдова; transliterated Chyornaya Vdova)" +
                " is a fictional superhero appearing in American comic books published by Marvel Comics.", R.drawable.blackwindow));
        friendsArrayList.add(new Friends("Hulk", "Bruce Banner is a character in the Marvel Cinematic Universe (MCU) film franchise first portrayed by Edward Norton and currently by Mark Ruffalo, based on the Marvel Comics character" +
                " of the same name and known commonly by his alter ego, the Hulk.", R.drawable.hulk));
        friendsArrayList.add(new Friends("captain america", "Captain Steven Grant \"Steve\" Rogers is a World War II veteran, a founding member of" +
                " the Avengers, and Earth's first superhero", R.drawable.caption));
        friendsArrayList.add(new Friends("Drax", "Drax the Destroyer (Arthur Douglas) is a fictional character appearing in American comic books published by Marvel Comics. Created by Jim Starlin, the character first" +
                " appeared in The Invincible Iron Man #55 (February 1973).", R.drawable.drax1));
        friendsArrayList.add(new Friends("Gamora", "Gamora is a former Zehoberei assassin and a former member of the Guardians of the Galaxy. She became the adopted daughter of " +
                "Thanos and adopted sister of Nebula after he killed half of her race.", R.drawable.gamora1));
        friendsArrayList.add(new Friends("Dr. Strange", "Doctor Stephen Strange is a fictional superhero appearing in American comic books published by Marvel Comics. Created by artist Steve Ditko and writer Stan Lee," +
                " the character first appeared in Strange Tales #110 (cover-dated July 1963).", R.drawable.drstrange));
        friendsArrayList.add(new Friends("Loki", "Loki Laufeyson was the biological son of Laufey, the ruler of the Frost Giants in Jotunheim," +
                " who was abandoned and left to die shortly after his birth", R.drawable.loki));
        friendsArrayList.add(new Friends("Nebula", "Nebula is a Luphomoid assassin, an adopted daughter" +
                " of the intergalactic warlord Thanos and adopted sister of Gamora. ", R.drawable.nebula1));
        friendsArrayList.add(new Friends("star lord", "Star-Lord (Peter Jason Quill) is a fictional superhero appearing in American comic books published by Marvel Comics. The character, created by Steve Englehart" +
                " and Steve Gan, first appeared in Marvel Preview #4 (January 1976).", R.drawable.starlord));
        friendsArrayList.add(new Friends("Thanos", "Thanos is a fictional supervillain appearing in American comic books published by Marvel Comics. The character, created by writer/artist Jim Starlin, first appeared" +
                " in The Invincible Iron Man #55 (cover dated February 1973).", R.drawable.thanos));
        friendsArrayList.add(new Friends("Thor", "Thor Odinson is a fictional superhero appearing in American comic books published by Marvel Comics. The character, which is based on the Norse deity of the same name, is the Asgardian god of thunder who possesses the enchanted hammer," +
                " Mjolnir, which grants him the ability to fly and manipulate weather amongst his other superhuman attributes.", R.drawable.thor));
        friendsArrayList.add(new Friends("Iron Man", "Anthony Edward Stark is a character portrayed by Robert Downey Jr. in the Marvel Cinematic Universe (MCU) film franchise, based on the Marvel Comics character of the" +
                " same name and known commonly by his alter ego, Iron Man.", R.drawable.tonystark));
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mapping();
        addFriends();
        listFr.setNumColumns(3);
        friendsAdapter = new FriendsAdapter(MainActivity.this, R.layout.line_friend, friendsArrayList);
        listFr.setAdapter(friendsAdapter);


       listFr.setOnItemClickListener(new AdapterView.OnItemClickListener() {
           @Override
           public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
               Intent intent = new Intent(MainActivity.this, ProfileActivity.class);

               Friends friends = new Friends(friendsArrayList.get(position).getNameFr(), friendsArrayList.get(position).getDeception(), friendsArrayList.get(position).getAvatarFr());
               intent.putExtra("friend", friends);
               MainActivity.this.startActivity(intent);
           }
       });
        toMyProfile();
    }
    private void toMyProfile (){
        mapping();
        circleImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MyProfileActivity.class);
                MainActivity.this.startActivity(intent);

            }
        });
    }

}
