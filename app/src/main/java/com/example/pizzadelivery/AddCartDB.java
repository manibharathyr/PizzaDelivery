package com.example.pizzadelivery;

import static com.example.pizzadelivery.PizzaDataBase.TABLENAME_1;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.Collection;

public class AddCartDB extends SQLiteOpenHelper {
    //database name
    public static final String DBCART = "cartdata.db";
    public static final String TABLENAME_2 = "cart_table";
    public static final String COLUMN_1 = "id";
    public static final String COLUMN_2 = "pizza_user_id";
    public static final String COLUMN_3 = "pizza_name";
    public static final String COLUMN_4 = "pizza_price";
    public static final String COLUMN_5 = "pizza_quantity";
    public static final String COLUMN_6 = "pizza_total";
    /*public static final String COLUMN6 = "image";*/

    public AddCartDB(@Nullable Context context) {
        super(context, "cartdata.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + TABLENAME_2 + "(ID INTEGER PRIMARY KEY AUTOINCREMENT," +
                "pizza_user_id text, " +
                "pizza_name text ," +
                "pizza_price text , " +
                "pizza_quantity text, " +
                "pizza_total text)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLENAME_2);
        onCreate(db);
    }

    public boolean insertCartData(String user_id, String name_pizza, String price_pizza, String qnty_pizza,String total_pizza) {

        SQLiteDatabase myData = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("pizza_user_id", user_id);
        contentValues.put("pizza_name", name_pizza);
        contentValues.put("pizza_price", price_pizza);
        contentValues.put("pizza_quantity", qnty_pizza);
        contentValues.put("pizza_total", total_pizza);
        /*contentValues.put("photo", photo_pizza);*/
        try {
            long result = myData.insert(TABLENAME_2, null, contentValues);

            if (result == 0)
                return false;
            else
                return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }

    public ArrayList<PizzaModuleClass> getNotes() {
        ArrayList<PizzaModuleClass> arrayList = new ArrayList<>();

        // select all query
        String select_query = "SELECT *FROM " + TABLENAME_2;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(select_query, null);
        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                PizzaModuleClass pizzaModuleClass = new PizzaModuleClass();
                pizzaModuleClass.setPizza_user_id(cursor.getString(1));
                pizzaModuleClass.setPizza_name(cursor.getString(2));
                pizzaModuleClass.setPizza_price(cursor.getString(3));
                pizzaModuleClass.setPizza_quantity(cursor.getString(4));
                pizzaModuleClass.setPizza_total(cursor.getString(5));
                arrayList.add(pizzaModuleClass);

            } while (cursor.moveToNext());
        }
        return arrayList;
    }

    public Collection<PizzaModuleClass> getAllDatas() {
        return getAllDatas();
    }
}
