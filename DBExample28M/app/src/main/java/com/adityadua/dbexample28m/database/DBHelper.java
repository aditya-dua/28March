package com.adityadua.dbexample28m.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.adityadua.dbexample28m.utils.Constants;

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



}
