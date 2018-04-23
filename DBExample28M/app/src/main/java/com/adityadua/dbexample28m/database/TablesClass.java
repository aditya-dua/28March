package com.adityadua.dbexample28m.database;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.adityadua.dbexample28m.utils.Constants;

/**
 * Created by AdityaDua on 23/04/18.
 */

public class TablesClass extends SQLiteOpenHelper {

    Context context;

    public TablesClass(Context context, String name, int version) {
        // I have to call the parent constructor which will make the DB
        super(context, Constants.DATABASE_NAME, null, Constants.DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        // Create your table in the DB
        String createQuery= "Create TABLE IF NOT EXISTS "+Constants.TABLE_NAME+"( "+
                            Constants.ID +" INTEGER PRIMARY KEY AUTOINCREMENT,"+
                            Constants.BOOK_ID+"  TEXT,"+
                            Constants.BOOK_NAME+"  TEXT,"+
                            Constants.AUTHOR_NAME+"  TEXT);";
        Log.i("Query To create",createQuery);
        sqLiteDatabase.execSQL(createQuery);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        onCreate(sqLiteDatabase);
    }
}
