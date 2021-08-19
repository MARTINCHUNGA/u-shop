package com.example.ushop.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.ushop.R;
import com.example.ushop.models.Phone;

import java.util.ArrayList;
import java.util.List;

public class PhoneAdapter extends RecyclerView.Adapter<PhoneAdapter.ViewHolder> {

    Context context;
    ArrayList<Phone> phoneList;

    public PhoneAdapter(Context context, ArrayList<Phone> phoneList) {
        this.context = context;
        this.phoneList = phoneList;
    }

    @NonNull
    @Override
    public PhoneAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.phone_row,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull PhoneAdapter.ViewHolder holder, int position) {

        Glide.with(context).load(phoneList.get(position).getPhoneName()).into(holder.images);
        holder.phone_name.setText(phoneList.get(position).getPhoneName());
        holder.description.setText(phoneList.get(position).getPhoneDescription());
        holder.price.setText(phoneList.get(position).getPhonePrice());

    }

    @Override
    public int getItemCount() {
        return phoneList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView images;
        TextView phone_name,description,price;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            images = itemView.findViewById(R.id.myImage);
            phone_name = itemView.findViewById(R.id.phoneName);
            description = itemView.findViewById(R.id.phoneDescription);
            price = itemView.findViewById(R.id.phonePrice);
        }
    }
}
