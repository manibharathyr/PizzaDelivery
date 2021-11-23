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

public class ViewActivity3 extends AppCompatActivity {

    TextView item_name2,item_price2;
    EditText item_quantity2;
    Button btn_add2;
    ImageView item_image2;

    AddCartDB addCartDB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //remove title
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_view3);
        // for hide nav_bar and padding
        View overlay = findViewById(R.id.view_root2);
        overlay.setSystemUiVisibility(View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                | View.SYSTEM_UI_FLAG_FULLSCREEN);


        item_name2 = findViewById(R.id.margarita_id2);
        item_price2 = findViewById(R.id.price_id2);
        item_quantity2 = findViewById(R.id.value_id2);
        item_image2 = findViewById(R.id.icon_id2);
        btn_add2 = findViewById(R.id.add_btn2);

        addCartDB=new AddCartDB(this);

        btn_add2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double a = Double.parseDouble(item_price2.getText().toString());
                double b = Double.parseDouble(item_quantity2.getText().toString());

                Double amount = a*b;
                boolean insertdata = addCartDB.insertCartData(" mani@gmail.com",
                        item_name2.getText().toString().trim(),
                        item_price2.getText().toString().trim(),
                        item_quantity2.getText().toString().trim(), String.valueOf(amount));


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