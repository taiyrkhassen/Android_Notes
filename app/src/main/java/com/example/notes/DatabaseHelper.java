package com.example.notes;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class DatabaseHelper extends SQLiteOpenHelper{
    public static final String DATABASE_NAME = "notes.db";
    public static final String DATABASE_TABLE = "notes";
    public static final String ID = "_id";
    public static final String TEXT = "_text";
    public static final String DATE = "_date";


    public DatabaseHelper(Context context) {

        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void     onCreate(SQLiteDatabase sqLiteDatabase){
        sqLiteDatabase.execSQL("create table "+DATABASE_TABLE +
                "("+ID+" integer primary key autoincrement, "+
                TEXT + " text not null, " + DATE +" text not null);"
        );

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
        sqLiteDatabase.execSQL("drop table if exists " + DATABASE_TABLE);
        onCreate(sqLiteDatabase);

    }
    public void insertNote(Note notes){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(TEXT, notes.getNote_text());
        cv.put(DATE, notes.getNote_date());

        db.insert(DATABASE_TABLE, null, cv);



    }

    public ArrayList<Note> getNotes() {
        ArrayList<Note> notes = new ArrayList<>();
        SQLiteDatabase db = getReadableDatabase();
        String all_notes = "select * from "+DATABASE_TABLE;
        Cursor c = db.rawQuery(all_notes, null);
        for(c.moveToFirst(); !c.isAfterLast(); c.moveToNext()){
            notes.add(new Note(c.getString(c.getColumnIndex(TEXT)), c.getString(c.getColumnIndex(DATE))));
        }
        return notes;
    }

}
