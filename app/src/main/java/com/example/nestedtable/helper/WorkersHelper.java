package com.example.nestedtable.helper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class WorkersHelper extends SQLiteOpenHelper {

    public final static String WORKERS_DB_NAME = "workers_db";
    public final static int WORKERS_DB_VERSION = 1;
    public final static String WORKERS_TABLE_NAME = "workers_table";
    public final static String ID_KEY = "id";
    public final static String WORKERS_KEY = "workers";

    public WorkersHelper(Context context){
        super(context,WORKERS_DB_NAME,null,WORKERS_DB_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String create = "CREATE TABLE " + WORKERS_TABLE_NAME + " ("
                + ID_KEY + " INTEGER PRIMARY KEY, " + WORKERS_KEY + " TEXT" + ")";
        sqLiteDatabase.execSQL(create);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public void addData(String name){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(WORKERS_KEY,name);
        db.insert(WORKERS_TABLE_NAME,null,values);
        db.close();
    }

    public ArrayList<String> getAllWorkers(){
        ArrayList<String> list = new ArrayList<>();

        SQLiteDatabase db = this.getReadableDatabase();

        String select = "SELECT * FROM " + WORKERS_TABLE_NAME;
        Cursor cursor = db.rawQuery(select,null);

        if (cursor.moveToFirst()){
            do {
                String worker = cursor.getString(1);
                list.add(worker);
            }while (cursor.moveToNext());
        }

        return list;
    }
}
