package com.example.projectsql;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.ContentValues;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private String TAG = getClass().toString();
    private RecyclerView orderrecycler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        orderrecycler = findViewById(R.id.order);
        orderrecycler.setLayoutManager(new LinearLayoutManager(MainActivity.this));

        Database db = new Database(MainActivity.this);
        ContentValues values = new ContentValues();
//        values.put("id",1);//optional
        values.put("userid", 1);
        values.put("username", "username1");
        values.put("orderitem", "item1,item2,item3");
        values.put("orderdate", "21-03-2022");
        values.put("orderprice", 200);
        db.insertValue(values);
        db.close();

        List<Order> order = db.getAllValue();
        orderrecycler.setAdapter(new OrderListAdapter(MainActivity.this, order));
        for (int i = 0; i < order.size(); i++) {
            Log.e(TAG, "onCreate: " + order.get(i).getId());
        }


    }

    private class OrderListAdapter extends RecyclerView.Adapter<OrderListAdapter.MyViewHolder> {
        Context context;
        List<Order> list;

        public OrderListAdapter(Context context, List<Order> list) {
            this.context = context;
            this.list = list;
        }

        @NonNull
        @Override
        public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(context).inflate(R.layout.row, parent, false);
            MyViewHolder holder = new MyViewHolder(view);
            return holder;
        }

        @Override
        public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
            holder.index.setText("Position "+list.get(position).getId());
        }

        @Override
        public int getItemCount() {
            return list.size();
        }

        public class MyViewHolder extends RecyclerView.ViewHolder {
            TextView index;

            public MyViewHolder(@NonNull View itemView) {
                super(itemView);
                index = itemView.findViewById(R.id.index);
            }
        }
    }
}