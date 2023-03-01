package com.example.food_app_charles;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class SQL_LITE_HELPER extends SQLiteOpenHelper {
    public SQL_LITE_HELPER(@Nullable Context context) {
        super(context, "mydatabase", null, 21);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE IF NOT EXISTS userdata(Username text, Email text, Password text, Phone text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS userdata");
        onCreate(db);
    }

    public void Insertdata(Data data){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put("Username", data.getName());
        contentValues.put("Email", data.getEmail());
        contentValues.put("Password", data.getPass());
        contentValues.put("Phone", data.getPhone());

        long userdata = sqLiteDatabase.insert("userdata", null, contentValues);
        Log.e("My Message", "userdata: " + userdata);
    }

    public ArrayList<ModelClass> Fetchdata(){
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        ArrayList<ModelClass> arrayList = new ArrayList<>();
        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM userdata", null);
        while (cursor.moveToNext()){
            ModelClass modelClass = new ModelClass();
            modelClass.id = cursor.getInt(0);
            modelClass.name = cursor.getString(1);
            modelClass.email = cursor.getString(2);
            modelClass.pass = cursor.getString(3);
            modelClass.phone = cursor.getString(4);
            arrayList.add(modelClass);
        }
        return arrayList;
    }
}
