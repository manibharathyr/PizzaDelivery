package com.example.pizzadelivery;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.EditText;

import androidx.annotation.Nullable;

import java.util.Collection;

public class DBHelper extends SQLiteOpenHelper {

    //Database
    public static final String DBNAME = "UserData.db";
    public static final String TABLENAME = "users";
    public static final String COLUMN_1 = "id";
    public static final String COLUMN_2= "username";
    public static final String COLUMN_3 = "email";
    public static final String COLUMN_4 = "password";

    public DBHelper(@Nullable Context context) {
        super(context, "UserData.db", null, 1);
    }


    @Override
    public void onCreate(SQLiteDatabase myData) {
        myData.execSQL("CREATE TABLE " +TABLENAME  + "(ID INTEGER PRIMARY KEY AUTOINCREMENT, username text ,email text, password text)");

    }
    @Override
    public void onUpgrade(SQLiteDatabase myData, int oldVersion, int newVersion) {
        myData.execSQL("DROP TABLE IF EXISTS " +TABLENAME);
        onCreate(myData);
    }
    public boolean insertData(String uname, String upass, String umail){
        SQLiteDatabase myData = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("username",uname);
        contentValues.put("email",umail);
        contentValues.put("password",upass);
        try{
            long result = myData.insert(TABLENAME,null,contentValues);
            getProfilesCount();
            if (result ==0)
                return false;
            else
                return true;
        } catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    //for profile count
    public long getProfilesCount() {
        SQLiteDatabase db = this.getReadableDatabase();
        long count = DatabaseUtils.queryNumEntries(db, TABLENAME);
        db.close();
        return count;
    }
    public Boolean checkUsername(String enteredUserName){
        SQLiteDatabase myDatabase = this.getWritableDatabase();
        try{
            Cursor cursor = myDatabase.rawQuery("select * from users where userName=?", new String[]{enteredUserName});
            if (cursor.getCount() > 0)
                return true;
            else
                return false;
        } catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }
    public boolean getData(String log_name,String log_pass){
        SQLiteDatabase db = this.getWritableDatabase();
        String[] columns = {"username","password"};
        Cursor cursor =db.query(TABLENAME,columns,null,null,null,null,null);
        while (cursor.moveToNext()){
            @SuppressLint("Range") String name =cursor.getString(cursor.getColumnIndex("username"));
            @SuppressLint("Range") String psw =cursor.getString(cursor.getColumnIndex("password"));
            if(log_name.equals(name) && log_pass.equals(psw)){
                return true;
            }else
            {
                return false;
            }
        }
        return false;
        }


    public Collection<Users> getAllUsers() {
        return getAllUsers();
    }
    public boolean checkUser(String username, String password) {

        // array of columns to fetch
        String[] columns = {
                COLUMN_1
        };
        SQLiteDatabase db = this.getReadableDatabase();
        // selection criteria
        String selection = COLUMN_3 + " = ?" + " AND " + COLUMN_4 + " = ?";

        // selection arguments
        String[] selectionArgs = {username, password};

        // query user table with conditions
        /**
         * Here query function is used to fetch records from user table this function works like we use sql query.
         * SQL query equivalent to this query function is
         * SELECT user_id FROM user WHERE user_email = 'jack@androidtutorialshub.com' AND user_password = 'qwerty';
         */
        Cursor cursor = db.query(TABLENAME, //Table to query
                columns,                    //columns to return
                selection,                  //columns for the WHERE clause
                selectionArgs,              //The values for the WHERE clause
                null,                       //group the rows
                null,                       //filter by row groups
                null);                      //The sort order

        int cursorCount = cursor.getCount();

        cursor.close();
        db.close();
        if (cursorCount > 0) {
            return true;
        }

        return false;
    }
}

