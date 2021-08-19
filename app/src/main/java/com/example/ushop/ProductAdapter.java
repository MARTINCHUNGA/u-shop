package com.example.ushop;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.MyViewHolder> {


    Context context;

    ArrayList<Product> productList;

    public ProductAdapter(Context context, ArrayList<Product> productList) {
        this.context = context;
        this.productList = productList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.product_items,parent,false);
        return  new MyViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        Product product = productList.get(position);

        holder.product_textView.setText(product.getName());
        holder.product_imageView.setImageResource(Integer.parseInt(product.getImg_url()));
    }

    @Override
    public int getItemCount() {
        return productList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        ImageView product_imageView;
        TextView product_textView;

        public  MyViewHolder(@NonNull View itemView){
            super(itemView);
            product_imageView = itemView.findViewById(R.id.product_image);
            product_textView = itemView.findViewById(R.id.product_name);
        }
    }
}
