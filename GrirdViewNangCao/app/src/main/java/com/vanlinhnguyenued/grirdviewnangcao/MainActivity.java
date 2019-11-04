package com.vanlinhnguyenued.grirdviewnangcao;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.GridView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    GridView listCountry;
    ArrayList<Country> countryArrayList;
    CountryAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Mapping();
        adapter = new CountryAdapter(this, R.layout.countryline, countryArrayList);
        listCountry.setAdapter(adapter);
        listCountry.setNumColumns(3);
    }

    public void Mapping(){
        listCountry = (GridView) findViewById(R.id.listCountry);
        countryArrayList = new ArrayList<>();
        countryArrayList.add(new Country(R.drawable.vietnam,"Vietnam"));
        countryArrayList.add(new Country(R.drawable.lao,"Lao"));
        countryArrayList.add(new Country(R.drawable.thai,"Thailand"));
        countryArrayList.add(new Country(R.drawable.indo,"Indonesia"));
        countryArrayList.add(new Country(R.drawable.philip,"Philippines"));
        countryArrayList.add(new Country(R.drawable.malay,"Malaysia"));
        countryArrayList.add(new Country(R.drawable.myanma,"Myanmar"));
        countryArrayList.add(new Country(R.drawable.cam,"Campuchia"));
        countryArrayList.add(new Country(R.drawable.sin,"Singapore"));
        countryArrayList.add(new Country(R.drawable.bru,"Brunei"));

    }
}
