package com.example.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DB_Helper extends SQLiteOpenHelper {
   private  final static  String  DB_NAME="userdata";
   private  final static int version=1;
    public DB_Helper( Context context) {
        super(context, DB_NAME, null, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String  c="create table user(id integer primary key autoincrement ,EMAIL text,PASSWORD text)";
        db.execSQL(c);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("Drop table if exists user");
        onCreate(db);

    }
    public  boolean inserdata(String Email,String Password)
    {
        SQLiteDatabase db= getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put("EMAIL",Email);
        values.put("PASSWORD",Password);
        long i=db.insert("user",null,values);
        if (i==-1)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    public boolean checkemailpassword(String Emial,String Password)
    {
        SQLiteDatabase db= getWritableDatabase();
        Cursor cursor= db.rawQuery("select * from user where EMAIL=? AND PASSWORD=?",new String[]{Emial,Password});
        if (cursor.getCount()>0)
        {
            return false;
        }
        else {
            return true;
        }

    }
}
