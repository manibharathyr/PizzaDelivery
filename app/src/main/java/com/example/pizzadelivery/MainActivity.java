package com.example.pizzadelivery;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.os.Handler;
import android.preference.PreferenceManager;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText mEmail,mPass;
    Button mLoginBtn,mCreateBtn;
    TextView textLog,textCreate,text_admin;

    DBHelper dbHelper;
    SQLiteDatabase msqlitedatabase;
    SQLiteOpenHelper openHelper;

    SharedPreferences sharedPreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //remove title
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);
        // for hide nav_bar and padding
        View overlay = findViewById(R.id.main_act);
        overlay.setSystemUiVisibility(View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                | View.SYSTEM_UI_FLAG_FULLSCREEN);

        mEmail=findViewById(R.id.user_id);
        mPass=findViewById(R.id.user_password);
        mLoginBtn=findViewById(R.id.login_btn);
        mCreateBtn=findViewById(R.id.create_btn);
        /*textCreate=findViewById(R.id.text_create);*/
        textLog=findViewById(R.id.text_log);
        /*text_admin=findViewById(R.id.text_admin);*/

        openHelper = new DBHelper(this);
        dbHelper = new DBHelper(this);
        msqlitedatabase = openHelper.getReadableDatabase();

        /*sharedpreferences = getSharedPreferences("email", MODE_PRIVATE);*/
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);

        mLoginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String log_name =mEmail.getText().toString();
                String log_pass =mPass.getText().toString();

                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("email", log_name);
                editor.apply();
                try {
                    if (dbHelper.checkUser(log_name, log_pass)){
                        Intent intent = new Intent(getApplicationContext(),HomeActivity.class);
                        intent.putExtra("username",mEmail.getText().toString());
                        startActivity(intent);
                    }else{
                        Toast.makeText(MainActivity.this, "Invalid userName or Password", Toast.LENGTH_SHORT).show();
                    }
                } catch (Exception e){
                    e.printStackTrace();
                }
            }
        });
        mCreateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),CreateActivity.class);
                startActivity(intent);
            }
        });
/*
        text_admin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),AdminActivity.class);
                startActivity(intent);
            }
        });*/
    }
}

