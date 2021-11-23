package com.example.pizzadelivery;

import static android.service.controls.ControlsProviderService.TAG;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

import java.io.File;
import java.io.IOException;
import java.util.Collection;

public class PizzaDataBase extends SQLiteOpenHelper {

    //database name
    public static final String DBPIZZA = "pizzadata.db";
    public static final String TABLENAME_1 = "table_pizza";
    public static final String COLUMN_1 = "id";
    public static final String COLUMN_2 = "pizza_name";
    public static final String COLUMN_3 = "price";
    public static final String COLUMN_4 = "quantity";


    public PizzaDataBase(@Nullable Context context) {
        super(context, "pizzadata.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + TABLENAME_1 + "(ID INTEGER PRIMARY KEY AUTOINCREMENT, pizza_name text ,quantity text,price text )");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLENAME_1);
        onCreate(db);
    }

    public boolean insertData(String name_pizza, String price_pizza,String quantity_pizza) {
        SQLiteDatabase myData = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("pizza_name", name_pizza);
        contentValues.put("price", price_pizza);
        contentValues.put("quantity", quantity_pizza);

        try{
            long result = myData.insert(TABLENAME_1, null, contentValues);
            if (result == 1)
                return false;
            else
                return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
