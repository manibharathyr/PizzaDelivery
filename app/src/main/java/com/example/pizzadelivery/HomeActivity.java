package com.example.pizzadelivery;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.media.Image;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.pizzadelivery.databinding.ActivityHomeBinding;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.database.DatabaseReference;

import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity {
Button btn_cart;
LinearLayout llt_1,llt_2,llt_3,llt_4,llt_5,llt_6;

RecyclerView recyclerView;
AddCartDB cartDB;
ArrayList<String> pizza_name,pizza_price,pizza_quantity;
ListAdapter listAdapter;
SharedPreferences sharedPreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //remove title
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_home);
        // for hide nav_bar and padding
        View overlay = findViewById(R.id.home_root);
        overlay.setSystemUiVisibility(View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                | View.SYSTEM_UI_FLAG_FULLSCREEN);

        llt_1=findViewById(R.id.pizza1_id);
        llt_2=findViewById(R.id.pizza_2_id);
        llt_3=findViewById(R.id.pizza_3_id);
        llt_4=findViewById(R.id.pizza_4_id);
        llt_5=findViewById(R.id.pizza_5_id);
        llt_6=findViewById(R.id.pizza_6_id);
        btn_cart=findViewById(R.id.cart_btn);

        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this); /*getSharedPreferences("email", MODE_PRIVATE);*/
        btn_cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = sharedPreferences.getString("email","");
                    Intent intent = new Intent(HomeActivity.this,ViewCartActivity.class);
                    startActivity(intent);

            }
        });

        llt_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this,ViewActivity.class);
                startActivity(intent);

                Toast.makeText(HomeActivity.this, "Order Margarita", Toast.LENGTH_SHORT).show();
            }
        });
        llt_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this,ViewActivity2.class);
                startActivity(intent);

                Toast.makeText(HomeActivity.this, "Order Double Cheese Margarita ", Toast.LENGTH_SHORT).show();
            }
        });
        llt_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this,ViewActivity3.class);
                startActivity(intent);

                Toast.makeText(HomeActivity.this, "Order FORM HOUSE ", Toast.LENGTH_SHORT).show();

            }
        });
        llt_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this,ViewActivity4.class);
                startActivity(intent);

                Toast.makeText(HomeActivity.this, "Peppy Paneer ", Toast.LENGTH_SHORT).show();

            }
        });
        llt_5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this,ViewActivity5.class);
                startActivity(intent);

                Toast.makeText(HomeActivity.this, "Mexican Wave ", Toast.LENGTH_SHORT).show();

            }
        });
        llt_6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this,ViewActivity6.class);
                startActivity(intent);

                Toast.makeText(HomeActivity.this, "Deluxe Veggie", Toast.LENGTH_SHORT).show();

            }
        });

    }

}