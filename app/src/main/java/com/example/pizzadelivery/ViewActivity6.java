package com.example.pizzadelivery;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class ViewActivity6 extends AppCompatActivity {
    TextView item_name5,item_price5;
    EditText item_quantity5;
    Button btn_add5;
    ImageView item_image5;

    AddCartDB addCartDB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //remove title
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_view6);
        // for hide nav_bar and padding
        View overlay = findViewById(R.id.view_root4);
        overlay.setSystemUiVisibility(View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                | View.SYSTEM_UI_FLAG_FULLSCREEN);
        item_name5 = findViewById(R.id.margarita_id5);
        item_price5 = findViewById(R.id.price_id5);
        item_quantity5 = findViewById(R.id.value_id5);
        item_image5 = findViewById(R.id.icon_id5);
        btn_add5 = findViewById(R.id.add_btn5);

        addCartDB=new AddCartDB(this);

        btn_add5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double a = Double.parseDouble(item_price5.getText().toString());
                double b = Double.parseDouble(item_quantity5.getText().toString());

                Double amount = a*b;
                boolean insertdata = addCartDB.insertCartData(" mani@gmail.com",
                        item_name5.getText().toString().trim(),
                        item_price5.getText().toString().trim(),
                        item_quantity5.getText().toString().trim(), String.valueOf(amount));


                if (insertdata != true) {
                    Toast.makeText(getApplicationContext(), "error", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getApplicationContext(), "saved", Toast.LENGTH_SHORT).show();
                    finish();
                }
            }
        });
    }
}