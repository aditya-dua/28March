package com.adityadua.dbexample28m;

import android.content.ContentValues;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.adityadua.dbexample28m.database.DBHelper;
import com.adityadua.dbexample28m.model.BookData;
import com.adityadua.dbexample28m.utils.Constants;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener{

    // Demo Data insert in DB

    String [] book_name=new String[]{
            "The Monk who sold his ferrari",
            "Rich Dad,Poor Dad",
            "You Can Win"
    };

    String [] author_name=new String[]{
            "Robin Sharma",
            "Robert",
            "Shiv Khera"
    };

    String [] ids=new String[]{
            "1234",
            "2345",
            "4566"
    };

    ListView listView;
    ArrayAdapter<String> arrayAdapter;
    DBHelper dbHelper;
    List<BookData> dataList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dbHelper = DBHelper.getInstance(this);
        listView = (ListView)findViewById(R.id.book_lv);

        int count = dbHelper.getFullContent(Constants.TABLE_NAME,null);

        if(count==0){
            // I will insert the data over here
            insertData();
        }

        dataList = dbHelper.getAllBooks();
        // ArrayAdapter is of type string
        List<String> listTitles=new ArrayList<>();
        for(int i=0;i<dataList.size();i++){
            listTitles.add(dataList.get(i).getBookName());

        }

        arrayAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,listTitles);

        listView.setAdapter(arrayAdapter);
        listView.setOnItemClickListener(this);

    }

    private void insertData(){
        for(int i=0;i<book_name.length;i++){

            ContentValues contentValues= new ContentValues();
            contentValues.put(Constants.BOOK_ID,ids[i]);
            contentValues.put(Constants.BOOK_NAME,book_name[i]);
            contentValues.put(Constants.AUTHOR_NAME,author_name[i]);

            dbHelper.insertContentValues(Constants.TABLE_NAME,contentValues);
        }
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

        Intent intent = new Intent(this,BookDetailsActivity.class);
        intent.putExtra(Constants.BOOK_NAME,dataList.get(i).getBookName());
        intent.putExtra(Constants.AUTHOR_NAME,dataList.get(i).getAuthorName());

        startActivity(intent);
    }
}
