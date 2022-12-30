package com.example.numberseriesgame;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.view.View;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class MyDataBase extends SQLiteOpenHelper {
    public static final String TBL_DATA_NAME="game";
    public static final int VERSION=1;



    public static final String TBL_GAME ="game";
    public static final String TBL_USER="user_name";
    public static final String TBL_EMAIL="email";
    public static final String TBL_ID="id";
    public static final String TBL_SCORE="score";
    public static final String TBL_PASSWORD="password";
    public static final String TBL_FULLNAME="fullname";
    public static final String TBL_BIRTHDAY="Birthday";
    public static final String TBL_COUNTRY="country";
    public static final String TBL_GENDER="gender";



    public MyDataBase(@Nullable Context context) {
        super((Context) context, TBL_DATA_NAME, null,
                VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("CREATE TABLE " + TBL_DATA_NAME+" ("+ TBL_EMAIL+ "TEXT ,"+
                ""+ TBL_USER+" TEXT ,"+ TBL_PASSWORD + " INTEGER ,"+ TBL_FULLNAME +" TEXT ,"+ TBL_BIRTHDAY+
                "  DATE , " + TBL_COUNTRY +" INTEGER , "+ TBL_GENDER+" BOOLEAN,"+TBL_SCORE+"INT)");




    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }


    public boolean insertGame(Database_newGame database_newGame) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(TBL_USER, database_newGame.getPlayer_name());
        values.put(TBL_BIRTHDAY, database_newGame.getPlayer_date());
        long result = db.insert(TBL_DATA_NAME, null, values);
        if (result > 0)
            return true;
        return false;


    }

    public boolean insertnewGame(Database_newGame database_newGame) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(TBL_SCORE, database_newGame.getScore());
        values.put(TBL_USER, database_newGame.getPlayer_name());
        values.put(TBL_BIRTHDAY, database_newGame.getPlayer_date());
        long result = db.insert(TBL_GAME, null, values);
        if (result > 0)
            return true;
        return false;


    }

//    public boolean deletnewGame(Database_newGame database_newGame) {
//        SQLiteDatabase db = getWritableDatabase();
//        String  name ={Database_newGame};
//        long result = db.delete(TBL_GAME,"name=?",name);
//        if (result > 0)
//            return true;
//        return false;
//
//
//    }

    public ArrayList<Database_newGame> newGames() {
        ArrayList<Database_newGame> games = new ArrayList<>();
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery("select * from " + TBL_GAME, null);
        if (cursor.moveToFirst()) {

            do{
                String fname=cursor.getString(cursor.getColumnIndexOrThrow(TBL_FULLNAME));
                int date =cursor.getInt(cursor.getColumnIndexOrThrow(TBL_BIRTHDAY));
                int score =cursor.getInt(cursor.getColumnIndexOrThrow(TBL_SCORE));
                Database_newGame database_newGame=new Database_newGame(score,fname,date);
                games.add(database_newGame);
            }while (cursor.moveToNext());
            cursor.close();
        }

        return games;
    }

}
