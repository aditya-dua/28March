package com.adityadua.dbexample28m;

import android.content.ContentValues;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.adityadua.dbexample28m.database.DBHelper;
import com.adityadua.dbexample28m.utils.Constants;

/**
 * Created by AdityaDua on 27/04/18.
 */

public class BookDetailsActivity extends AppCompatActivity {

    EditText bnEditText,anEditText;
    Button updateBtn;
    DBHelper db;
    String authorName;
    String bookName;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.book_detail_main);

        Intent i = getIntent();
        authorName = i.getStringExtra(Constants.AUTHOR_NAME);
        bookName  = i.getStringExtra(Constants.BOOK_NAME);

        bnEditText = (EditText)findViewById(R.id.editText);
        bnEditText.setText(bookName);
        anEditText =  (EditText)findViewById(R.id.editText2);
        anEditText.setText(authorName);

        updateBtn = (Button)findViewById(R.id.button2);
        db=DBHelper.getInstance(this);
        updateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ContentValues cv = new ContentValues();
                cv.put(Constants.AUTHOR_NAME,anEditText.getText().toString());
                cv.put(Constants.BOOK_NAME,bnEditText.getText().toString());

                db.updateRecords(Constants.TABLE_NAME,cv,Constants.BOOK_NAME+" ='"+bookName+"';",null);
                Toast.makeText(BookDetailsActivity.this, "Book Updated in the DB!", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
