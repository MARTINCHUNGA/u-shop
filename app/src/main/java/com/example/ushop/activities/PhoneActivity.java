 package com.example.ushop.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.ushop.R;
import com.example.ushop.adapters.PhoneAdapter;
import com.example.ushop.models.Phone;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class PhoneActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    ArrayList<Phone> arrayList;
    //List<Phone> list;
    PhoneAdapter phoneAdapter;
    DatabaseReference database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phone);

       // recyclerView = findViewById(R.id.recyclerview);
        database = FirebaseDatabase.getInstance().getReference("Phones");
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        arrayList = new ArrayList<>();

        phoneAdapter = new PhoneAdapter(this,arrayList);
        recyclerView.setAdapter(phoneAdapter);
        database.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for(DataSnapshot dataSnapshot1: dataSnapshot.getChildren()){

                    Phone phone = dataSnapshot1.getValue(Phone.class);
                    arrayList.add(phone);

                }

                phoneAdapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}