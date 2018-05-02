package com.adityadua.recyclerviewmaterialdesign28mdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView)findViewById(R.id.recycler);

        ItemData []itemDatas={
            new ItemData("Android 4.0 : Jelly Beans",R.drawable.aditya_photo),
            new ItemData("Android 4.0 : Jelly Beans",R.drawable.aditya_photo)
        };

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        MyAdapter myAdapter = new MyAdapter(itemDatas);
        recyclerView.setAdapter(myAdapter);

        recyclerView.setItemAnimator(new DefaultItemAnimator());
    }
}
