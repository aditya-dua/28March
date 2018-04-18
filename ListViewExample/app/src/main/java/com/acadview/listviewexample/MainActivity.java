package com.acadview.listviewexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    // List : Same type of items :
    // Ex : List Of Contacts
    // If I have to make a list then that list will have a item which is repeated ??
    // XML in layout ???



    String []colors={"Red","Blue","Black","Green","Orange","Yellow"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(getApplicationContext(),android.R.layout.simple_list_item_1,colors);

        ListView lv = (ListView)findViewById(R.id.listView);
        lv.setAdapter(arrayAdapter);

        // On Click Listener on List
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(MainActivity.this, "Item Clicked is"+colors[i], Toast.LENGTH_SHORT).show();
            }
        });

    }
}
