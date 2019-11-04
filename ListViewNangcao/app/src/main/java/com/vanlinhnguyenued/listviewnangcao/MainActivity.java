package com.vanlinhnguyenued.listviewnangcao;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView listCountry;
    ArrayList<country> arrayCountry;
    countryAdapter adapter;
    private void Anhxa(){
        listCountry = (ListView) findViewById(R.id.listCountry);
        arrayCountry = new ArrayList<>();

        arrayCountry.add(new country("Vietnam", "Ngày 28-7-1995 Vietnam officially joined Asian.", R.drawable.vietnam));
        arrayCountry.add(new country("Lao", "Ngày 28-7-1995 Vietnam officially joined Asian.", R.drawable.lao));
        arrayCountry.add(new country("Thailand", "Ngày 28-7-1995 Vietnam officially joined Asian.", R.drawable.thai));
        arrayCountry.add(new country("Indonesia", "Ngày 28-7-1995 Vietnam officially joined Asian.", R.drawable.indo));
        arrayCountry.add(new country("Philippines", "Ngày 28-7-1995 Vietnam officially joined Asian.", R.drawable.philip));
        arrayCountry.add(new country("Malaysia", "Ngày 28-7-1995 Vietnam officially joined Asian.", R.drawable.malay));
        arrayCountry.add(new country("Myanmar", "Ngày 28-7-1995 Vietnam officially joined Asian.", R.drawable.myanma));
        arrayCountry.add(new country("Campuchia", "Ngày 28-7-1995 Vietnam officially joined Asian.", R.drawable.cam));
        arrayCountry.add(new country("Singapore", "Ngày 28-7-1995 Vietnam officially joined Asian.", R.drawable.sin));
        arrayCountry.add(new country("Brunei", "Ngày 28-7-1995 Vietnam officially joined Asian.", R.drawable.bru));

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Anhxa();
        adapter = new countryAdapter(this, R.layout.linecountry, arrayCountry);
        listCountry.setAdapter(adapter);

        listCountry.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                country SelectedCountry = arrayCountry.get(position);
                Intent intent = new Intent(MainActivity.this, CountryDetailActivity.class);
                intent.putExtra("nameCountry", SelectedCountry.getHinh());
                MainActivity.this.startActivity(intent);
            }
        });
    }


}
