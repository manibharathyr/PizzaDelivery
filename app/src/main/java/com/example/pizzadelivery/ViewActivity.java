package com.example.pizzadelivery;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.V;

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

public class ViewActivity extends AppCompatActivity {
    TextView item_name,item_price;
    EditText item_quantity;
    Button btn_add;
    ImageView item_image;

    AddCartDB addCartDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //remove title
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_view);
        // for hide nav_bar and padding
        View overlay = findViewById(R.id.view_root);
        overlay.setSystemUiVisibility(View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                | View.SYSTEM_UI_FLAG_FULLSCREEN);

        item_name = findViewById(R.id.margarita_id);
        item_price = findViewById(R.id.price_id);
        item_quantity = findViewById(R.id.value_id);
        item_image = findViewById(R.id.icon_id);
        btn_add = findViewById(R.id.add_btn);

        addCartDB=new AddCartDB(this);

        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double a = Double.parseDouble(item_price.getText().toString());
                double b = Double.parseDouble(item_quantity.getText().toString());

                Double total = a*b;

                boolean insertdata = addCartDB.insertCartData(" mani@gmail.com",
                        item_name.getText().toString().trim(),
                        item_price.getText().toString().trim(),
                        item_quantity.getText().toString().trim(),
                        String.valueOf(total))         ;

                /*totalAmount();*/


                if (insertdata != true) {

                    Toast.makeText(getApplicationContext(), "error", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getApplicationContext(), String.valueOf(total), Toast.LENGTH_SHORT).show();
                    finish();
                }
            }

        });

    }
    /*public void totalAmount(){
        int total = Integer.valueOf(item_price.getId())* Integer.valueOf(item_quantity.getId());

    }*/
}