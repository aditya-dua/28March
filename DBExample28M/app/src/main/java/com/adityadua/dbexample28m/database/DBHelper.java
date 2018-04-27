package com.adityadua.dbexample28m.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import android.widget.Toast;

import com.adityadua.dbexample28m.model.BookData;
import com.adityadua.dbexample28m.utils.Constants;

import java.io.Console;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by AdityaDua on 23/04/18.
 * This class is created to interact with the DB.
 * Create,Update,Read & Delete
 *
 * To Insert in DB
 * To read from DB
 * I have to open the DB
 *
 * Done :
 * 1) Creation Of Table
 * 2) Data insert
 * 3) Data Update
 * 4) Data Delete
 *
 * To be Done:
 * 5) Data select
 * 6) Functions for C,U,D to be called
 */

public class DBHelper {

    private SQLiteDatabase db;
    private Context context;
    private final TablesClass dbHelperTabledClass;
    private static DBHelper db_helper=null;

    // I am giving you a method which will help you create the DBHElper object

    public static DBHelper getInstance(Context context){

       try{
           if(db_helper==null){
               db_helper=new DBHelper(context);
               db_helper.open();
           }
       }catch(Exception e){
           e.printStackTrace();
       }

        return db_helper;

    }

    public DBHelper(Context context) {
        this.context = context;
        dbHelperTabledClass = new TablesClass(context, Constants.DATABASE_NAME,Constants.DATABASE_VERSION);
    }

    public void open(){

        try {
            db = dbHelperTabledClass.getWritableDatabase();
        }catch (Exception e){
            e.printStackTrace();
            db=dbHelperTabledClass.getReadableDatabase();
        }
    }

    public void close(){

        if(db.isOpen()){
            db.close();
        }else{
            Log.i("DB Closed","Database is closed already");

        }

    }

    // How many of you are aware about Content Values ?
  /*  Insert into table test
            (id,roll,name)
    values
            (1,1,"ABC")

     Content Values ::   Map :?
    id : 1
    roll : 1
    name  :  ABC */

    public long insertContentValues(String tabName, ContentValues cv){
        long id =0;

        try{
            db.beginTransaction();
            id=db.insert(tabName,null,cv);
            db.setTransactionSuccessful();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            db.endTransaction();
        }

        return id;
    }

    // It will return number of rows updated
    // update tab set col1 = val1 where id=1
    public int updateRecords(String tabName,ContentValues cv,String whereClause,String[] whereArgs){

        int count =0;
        try{
            db.beginTransaction();
            count=db.update(tabName,cv,whereClause,whereArgs);
            db.setTransactionSuccessful();

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            db.endTransaction();
        }
        return count;
    }

    public void deleteRecord(String tabName,String whereClause,String [] whereArgs){

        try{
            db.beginTransaction();
            db.delete(tabName,whereClause,whereArgs);
            db.setTransactionSuccessful();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            db.endTransaction();
        }
    }


    // We have to add functions that will read from DB.
    // Query : select * from books;
    // Cursors :?
    // query : fucntion which has different definations
    // you use when to want to select the data from the DB.
    // select distinct(roll)

    public int getFullContent(String tabName,String where){

        int count =0;
        Cursor cursor = db.query(false,tabName,null,where,null,null,null,null,null);

        if(cursor !=null){
            cursor.moveToFirst();
            count=cursor.getCount();

            Toast.makeText(context, "Count of the Records are :"+count, Toast.LENGTH_SHORT).show();
            cursor.close();
        }

        return count;
    }

    public List<BookData> getAllBooks(){
        List<BookData> books = new LinkedList<>();

        String query = "select * from "+Constants.TABLE_NAME;
        Log.i("Select Query is:",query);

        Cursor c = db.rawQuery(query,null);

        BookData book=null;

        if(c.moveToFirst()){
            do{
                book = new BookData();
                book.setId(c.getInt(0));
                book.setBookid(c.getString(1));
                book.setBookName(c.getString(2));
                book.setAuthorName(c.getString(3));

                books.add(book);

            }while (c.moveToNext());
        }

        c.close();

        return books;

    }






}
