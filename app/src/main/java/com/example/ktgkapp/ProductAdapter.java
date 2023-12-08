package com.example.ktgkapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

// src/main/java/com/yourpackage/ProductAdapter.java
public class ProductAdapter extends ArrayAdapter<Product> {
    public ProductAdapter(Context context, ArrayList<Product> products) {
        super(context, 0, products);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_product, parent, false);
        }

        Product product = getItem(position);

        ImageView imageView = convertView.findViewById(R.id.productImageView);
        TextView nameTextView = convertView.findViewById(R.id.nameTextView);
        TextView priceTextView = convertView.findViewById(R.id.priceTextView);

        if (product != null) {
            imageView.setImageResource(product.getImageId());
            nameTextView.setText(product.getName());
            priceTextView.setText(product.getPrice());
        }

        return convertView;
    }
}
