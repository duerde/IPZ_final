package com.example.ipz_final;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

public class DBManager {

    private DatabaseHelper dbHelper;

    private Context context;

    private SQLiteDatabase database;

    public DBManager(Context c) {
        context = c;
    }

    public DBManager open() throws SQLException {
        dbHelper = new DatabaseHelper(context);
        database = dbHelper.getWritableDatabase();
        return this;
    }

    public void close() {
        dbHelper.close();
    }

    public long length() { return dbHelper.getProfilesCount(); }

    public void insert(String marka, String model, String paliwo, String rok, float spalanie ) {
        ContentValues contentValue = new ContentValues();
        contentValue.put(DatabaseHelper.marka, marka);
        contentValue.put(DatabaseHelper.model, model);
        contentValue.put(DatabaseHelper.paliwo, paliwo);
        contentValue.put(DatabaseHelper.rok, rok);
        contentValue.put(DatabaseHelper.spalanie, spalanie);
        database.insert(DatabaseHelper.TABLE_NAME, null, contentValue);
    }

    public Cursor fetch() {
        String[] columns = new String[] { DatabaseHelper._ID, DatabaseHelper.marka, DatabaseHelper.model,DatabaseHelper.paliwo,DatabaseHelper.rok,DatabaseHelper.spalanie};
        Cursor cursor = database.query(DatabaseHelper.TABLE_NAME, columns, null, null, null, null, null);
        if (cursor != null) {
            cursor.moveToFirst();
        }
        return cursor;
    }

    public int update(long _id, String name, String desc) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(DatabaseHelper.marka, name);
        contentValues.put(DatabaseHelper.model, desc);
        int i = database.update(DatabaseHelper.TABLE_NAME, contentValues, DatabaseHelper._ID + " = " + _id, null);
        return i;
    }

    public void delete(long _id) {
        database.delete(DatabaseHelper.TABLE_NAME, DatabaseHelper._ID + "=" + _id, null);
    }

}