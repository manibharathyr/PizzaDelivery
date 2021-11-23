package com.example.pizzadelivery;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ViewHolder> {

    ArrayList<PizzaModuleClass> pizzaModuleClassArrayList;

    ListAdapter(Context context, ArrayList<PizzaModuleClass> pizzaModuleClassArrayList){
        this.pizzaModuleClassArrayList = pizzaModuleClassArrayList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_activity,
                parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final PizzaModuleClass myListData = pizzaModuleClassArrayList.get(position);
        /*holder.item_user.setText(activity.get (position).getUser_id());*/
        holder.item_name.setText(myListData.getPizza_name());
        holder.item_price.setText(myListData.getPizza_price());
        holder.item_quantity.setText(myListData.getPizza_quantity());
        holder.item_total.setText(myListData.getPizza_total());
        Log.d("total",myListData.pizza_total);

    }

    @Override
    public  int getItemCount() {
        return pizzaModuleClassArrayList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public RelativeLayout relativeLayout;
        public ImageView imageView;
        public TextView item_name,item_price,item_quantity,item_total;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            /*imageView=itemView.findViewById(R.id.img_id);*/
            item_name=itemView.findViewById(R.id.text_name);
            item_price=itemView.findViewById(R.id.text_price);
            item_quantity=itemView.findViewById(R.id.text_quantity);
            item_total=itemView.findViewById(R.id.text_total);
        }
    }
}
