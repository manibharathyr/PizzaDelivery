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

public class ViewActivity5 extends AppCompatActivity {
    TextView item_name4,item_price4;
    EditText item_quantity4;
    Button btn_add4;
    ImageView item_image4;

    AddCartDB addCartDB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //remove title
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_view5);
        // for hide nav_bar and padding
        View overlay = findViewById(R.id.view_root4);
        overlay.setSystemUiVisibility(View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                | View.SYSTEM_UI_FLAG_FULLSCREEN);
        item_name4 = findViewById(R.id.margarita_id4);
        item_price4 = findViewById(R.id.price_id4);
        item_quantity4 = findViewById(R.id.value_id4);
        item_image4 = findViewById(R.id.icon_id4);
        btn_add4 = findViewById(R.id.add_btn4);

        addCartDB=new AddCartDB(this);

        btn_add4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double a = Double.parseDouble(item_price4.getText().toString());
                double b = Double.parseDouble(item_quantity4.getText().toString());

                Double amount = a*b;
                boolean insertdata = addCartDB.insertCartData(" mani@gmail.com",
                        item_name4.getText().toString().trim(),
                        item_price4.getText().toString().trim(),
                        item_quantity4.getText().toString().trim(), String.valueOf(amount));

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