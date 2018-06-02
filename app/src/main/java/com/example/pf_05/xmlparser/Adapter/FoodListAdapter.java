package com.example.pf_05.xmlparser.Adapter;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.pf_05.xmlparser.Food;
import com.example.pf_05.xmlparser.R;
import java.util.List;

/**
 * Created by pf-05 on 6/2/2018.
 */

public class FoodListAdapter  extends RecyclerView.Adapter<FoodListAdapter.MyViewHolder>{

    Context context;
    List<Food> foodList;


    public FoodListAdapter(Context context,List<Food> foodList)
    {

        this.context = context;
        this.foodList = foodList;
    }



    @Override
    public FoodListAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.food_adapter,parent,false);
        return new FoodListAdapter.MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final FoodListAdapter.MyViewHolder holder, final int position) {

        final Food food = foodList.get(position);
        holder.food_Name.setText(food.getName());
        holder.food_price.setText(food.getPrice());
        holder.food_calories.setText(food.getCalories());



    }

    @Override
    public int getItemCount() {
        return foodList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder
    {
        public TextView food_Name,food_price,food_calories;



        public MyViewHolder(View itemView) {
            super(itemView);

            food_Name = (TextView)itemView.findViewById(R.id.name);
            food_price = (TextView)itemView.findViewById(R.id.txtPrice);
            food_calories = (TextView)itemView.findViewById(R.id.txt_ser_Type);

        }
    }
}
