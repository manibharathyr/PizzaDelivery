package com.example.pizzadelivery;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AdminActivity extends AppCompatActivity {
EditText ip_pass,ip_name;
Button ip_btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //remove title
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_admin);
        // for hide nav_bar and padding
        View overlay = findViewById(R.id.main_root);
        overlay.setSystemUiVisibility(View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                | View.SYSTEM_UI_FLAG_FULLSCREEN);

        ip_name=findViewById(R.id.admin_id);
        ip_pass=findViewById(R.id.admin_pass);
        ip_btn=findViewById(R.id.admin_btn);

        ip_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String login_name =ip_name.getText().toString().trim();
                String login_pass =ip_pass.getText().toString().trim();
                try {
                    if (login_name.equals("admin123") && login_pass.equals("1234")){
                        Toast.makeText(getApplicationContext(), "loged", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(AdminActivity.this,UploadActivity.class);
                        startActivity(intent);
                    } else {
                        Toast.makeText(AdminActivity.this, "Invalid AdminName or Password", Toast.LENGTH_SHORT).show();
                    }
                } catch (Exception e){
                    e.printStackTrace();
                }

            }
        });

    }
}