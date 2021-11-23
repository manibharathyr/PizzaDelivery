package com.example.pizzadelivery;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.SharedPreferences;
import android.database.Cursor;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class ViewCartActivity extends AppCompatActivity {

    RecyclerView recyclerview;
    AddCartDB cartDB;
    ListAdapter listAdapter;
    ArrayList<PizzaModuleClass> pizzaModuleClassArrayList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_cart);

        recyclerview = findViewById(R.id.recyclerView_list);
        cartDB=new AddCartDB(this);
        Toast.makeText(getApplicationContext(), "Your Pizza Cart", Toast.LENGTH_SHORT).show();

        pizzaModuleClassArrayList=cartDB.getNotes();
        /*Log.d("pizzaModuleClass",cartDB.getNotes().toString());*/

        RecyclerView recyclerView = findViewById(R.id.recyclerView_list);
        ListAdapter adapter = new ListAdapter(this,pizzaModuleClassArrayList);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

    }

}