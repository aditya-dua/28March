package com.acadview.menu1demo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by AdityaDua on 16/04/18.
 */

public class SettingActivity extends AppCompatActivity {

    ListView lv;
    String [] user_details={"Name : Aditya Dua","Email Id : aditya@gmail.com","Phone Number : +918826665888"};
    ArrayAdapter<String> arrayAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.settings);

        arrayAdapter = new ArrayAdapter<String>(getApplicationContext(),android.R.layout.simple_list_item_1,user_details);
        lv = (ListView) findViewById(R.id.listview1);

        lv.setAdapter(arrayAdapter);

        TextView textView=(TextView)findViewById(R.id.textView1);
        registerForContextMenu(textView);
        registerForContextMenu(lv);
    }

    // If you want to make a context menu :


    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        menu.setHeaderTitle("User Settings Option");
        menu.setHeaderIcon(R.mipmap.ic_launcher);

        if(v.getId() == R.id.textView1){
            menu.add("Cut Text");
            menu.add("Copy Text");
            menu.add("Paste Text");
        }else{
            menu.add("Cut");
            menu.add("Copy");
            menu.add("Paste");
        }
    }
    // User Clicks on the context menu options :


    @Override
    public boolean onContextItemSelected(MenuItem item) {

        if (item.getTitle()== "Cut Text"||item.getTitle()== "Cut"){
            Toast.makeText(this, "Text is now on the ClipBoard", Toast.LENGTH_SHORT).show();
        }
        return super.onContextItemSelected(item);
    }
}
