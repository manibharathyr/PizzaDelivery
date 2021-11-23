package com.example.pizzadelivery;

import androidx.appcompat.app.AppCompatActivity;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class UploadActivity extends AppCompatActivity {
    EditText pizza_name, pizza_price;
    Button btn_pizza;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //remove title
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_upload);
        // for hide nav_bar and padding
        View overlay = findViewById(R.id.upload_root);
        overlay.setSystemUiVisibility(View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                | View.SYSTEM_UI_FLAG_FULLSCREEN);

        pizza_name = findViewById(R.id.pizza_ip);
        pizza_price = findViewById(R.id.price_ip);
        btn_pizza = findViewById(R.id.save_btn);


/*
        btn_pizza.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean insertdata = pizzaDataBase.insertData(pizza_name.getText().toString().trim(),pizza_price.getText().toString().trim());
                if (insertdata == true) {
                    finish();
                    Toast.makeText(getApplicationContext(), "saved", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getApplicationContext(), "error", Toast.LENGTH_SHORT).show();
                }
            }
        });
*/
    }

}
