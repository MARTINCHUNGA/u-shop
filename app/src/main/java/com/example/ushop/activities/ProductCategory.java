package com.example.ushop.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.ushop.Product;
import com.example.ushop.ProductAdapter;
import com.example.ushop.R;

import java.util.ArrayList;

public class ProductCategory extends AppCompatActivity {

    RecyclerView recyclerView;

   // DatabaseReference databaseReference;

    ProductAdapter productAdapter;
    ArrayList<Product> products;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_category);

//        recyclerView = (RecyclerView)findViewById(R.id.productCategoryList);
//        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}