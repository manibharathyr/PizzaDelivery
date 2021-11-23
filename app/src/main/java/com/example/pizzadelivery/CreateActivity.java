package com.example.pizzadelivery;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class CreateActivity extends AppCompatActivity {
    EditText name_text,mail_text,password_text;
    Button save_btn;
    DBHelper dbHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //remove title
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_create);
        // for hide nav_bar and padding
        View overlay = findViewById(R.id.create_root);
        overlay.setSystemUiVisibility(View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                | View.SYSTEM_UI_FLAG_FULLSCREEN);

        name_text = findViewById(R.id.name_id);
        mail_text = findViewById(R.id.mail_id);
        password_text = findViewById(R.id.password_id);
        save_btn = findViewById(R.id.btn_save);
        dbHelper = new DBHelper(this);

        save_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = name_text.getText().toString().trim();
                String mail = mail_text.getText().toString().trim();
                String password = password_text.getText().toString().trim();

                if (name.equals("") || password.equals("") || mail.equals("")) {
                    Toast.makeText(CreateActivity.this, "please enter Your Details ", Toast.LENGTH_SHORT).show();
                } else{
                    if (!mail.equals(password)){
                        if (dbHelper.getProfilesCount()>=0){
                            Boolean checkUsername = dbHelper.checkUsername(name);
                            if (checkUsername==true){
                                Toast.makeText(getApplicationContext(), "UserName is already exist", Toast.LENGTH_SHORT).show();
                            }else{
                                insertData(name,mail,password);
                            }
                        }else{
                            insertData(name,mail,password);
                        }
                    }else{
                        Toast.makeText(getApplicationContext(), "Failed", Toast.LENGTH_SHORT).show();
                    }

                }
            }
        });

    }
    private void insertData(String name, String mail, String password)
    {
        Boolean insert = dbHelper.insertData(name,password,mail);
        if (insert){
            Toast.makeText(getApplicationContext(), "SignUp successfully", Toast.LENGTH_SHORT).show();
         /*   Intent intent = new Intent(getApplicationContext(),ActivityHome.class);
            startActivity(intent);*/
        }
    }
}