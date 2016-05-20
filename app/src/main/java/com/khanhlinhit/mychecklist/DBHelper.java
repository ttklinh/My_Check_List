package com.khanhlinhit.mychecklist;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.preference.PreferenceActivity;

import java.security.AccessControlContext;
import java.util.ArrayList;

/**
 * Created by khanhlinh.it on 5/17/2016.
 */

public class DBHelper extends SQLiteOpenHelper {

    private static final String TEXT_TYPE = " TEXT";
    private static final String FLOAT_TYPE = " FLOAT";
    private static final String COMMA_SEP = ",";
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "MyDatabase.db";

    public static final String CREATE_TABLE_HEADER = "create table "
            + ListReader.HeaderEntry.TABLE_NAME + "("
            + ListReader.HeaderEntry._ID + "INTEGER PRIMARY KEY"
            + ListReader.HeaderEntry.COLUMN_NAME_ENTRY_ID + TEXT_TYPE + COMMA_SEP
            + ListReader.HeaderEntry.COLUMN_NAME_DESC + TEXT_TYPE + COMMA_SEP
            + ListReader.HeaderEntry.COLUMN_NAME_NOTE + TEXT_TYPE
            + ")";

    public static final String CREATE_TABLE_ITEM = "create table "
            + ListReader.ItemEntry.TABLE_NAME + "("
            + ListReader.ItemEntry._ID + "INTEGER PRIMARY KEY"
            + ListReader.ItemEntry.COLUMN_NAME_ENTRY_ID + TEXT_TYPE + COMMA_SEP
            + ListReader.ItemEntry.COLUMN_NAME_DESC + TEXT_TYPE + COMMA_SEP
            + ListReader.ItemEntry.COLUMN_NAME_NOTE + TEXT_TYPE + COMMA_SEP
            + ListReader.ItemEntry.COLUMN_NAME_AMOUNT + FLOAT_TYPE
            + ")";

    public DBHelper(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_HEADER);
        db.execSQL(CREATE_TABLE_ITEM);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public ArrayList<String> getAllHeaders()
    {
        ArrayList<String> array_list = new ArrayList<String>();

        //hp = new HashMap();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res =  db.rawQuery( "select * from " + ListReader.HeaderEntry.TABLE_NAME, null );
        res.moveToFirst();

        while(res.isAfterLast() == false){
            array_list.add(res.getString(res.getColumnIndex(ListReader.HeaderEntry.COLUMN_NAME_DESC)));
            res.moveToNext();
        }
        return array_list;
    }
}
