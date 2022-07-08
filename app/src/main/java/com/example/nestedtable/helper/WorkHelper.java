package com.example.nestedtable.helper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class WorkHelper extends SQLiteOpenHelper {

    public final static String WORK_DB_NAME = "work_db";
    public final static int WORK_DB_VERSION = 1;
    public final static String WORK_TABLE_NAME = "work_table";
    public final static String ID_KEY = "id";
    public final static String WORKER_NAME_KEY = "name";
    public final static String WORK_KEY = "workers";

    public WorkHelper(Context context){
        super(context,WORK_DB_NAME,null,WORK_DB_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String create = "CREATE TABLE " + WORK_TABLE_NAME + " ("
                + ID_KEY + " INTEGER PRIMARY KEY, " + WORKER_NAME_KEY + " TEXT,"
                + WORK_KEY + " TEXT"+")";
        sqLiteDatabase.execSQL(create);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public void addWork(String name,String work){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put(WORKER_NAME_KEY,name);
        contentValues.put(WORK_KEY,work);

        db.insert(WORK_TABLE_NAME,null,contentValues);
        db.close();
    }

    public ArrayList<String> getAllWork(){

        ArrayList<String> workList = new ArrayList<>();

        SQLiteDatabase db = this.getReadableDatabase();
        String select = "SELECT * FROM " + WORK_TABLE_NAME;
        Cursor cursor = db.rawQuery(select,null);

        if (cursor.moveToFirst()){
            do {
                String name = cursor.getString(1);
                String work = cursor.getString(2);
                if (name.equals("sachin")){
                    workList.add(work);
                }
            }while (cursor.moveToNext());
        }

        return workList;


    }
}
