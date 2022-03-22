package com.example.projectsql;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;


public class Database extends SQLiteOpenHelper {
    public static String name = "TestDb";
    public static int version = 1;
    private String TAG = getClass().getSimpleName();

    public Database(@Nullable Context context) {
        super(context, name, null, version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String query = "CREATE TABLE `orders` (`id` INTEGER PRIMARY KEY AUTOINCREMENT, `userid` INTEGER(11) , `username` TEXT(255) , `orderitem` TEXT(512) NOT NULL, `orderdate` TEXT, `orderprice` INTEGER(10) )";
        sqLiteDatabase.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public void insertValue(ContentValues values) {
        SQLiteDatabase db = this.getWritableDatabase();

        long status = db.insert("orders", null, values);
        Log.e(TAG, "insertValue: " + status);
        db.close();
    }

    @SuppressLint("Range")
    public List<Order> getAllValue() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor data = db.rawQuery("select * from orders", null);
        data.moveToFirst();
        List<Order> list = new ArrayList<>();
        while (data.isAfterLast() == false) {
            Order order = new Order();
            order.setId(data.getString(data.getColumnIndex("id")));
            order.setUserid(data.getString(data.getColumnIndex("userid")));
            order.setUsername(data.getString(data.getColumnIndex("username")));
            order.setOrderitem(data.getString(data.getColumnIndex("orderitem")));
            order.setOrderdate(data.getString(data.getColumnIndex("orderdate")));
            order.setOrderprice(data.getString(data.getColumnIndex("orderprice")));
            list.add(order);
            data.moveToNext();
        }
        Log.e(TAG, "getAllValue: " );
        db.close();
        return list;
    }
}
