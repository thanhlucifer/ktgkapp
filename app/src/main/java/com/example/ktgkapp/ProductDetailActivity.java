package com.example.ktgkapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class ProductDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_detail);

        ImageView imageView = findViewById(R.id.detailImageView);
        TextView nameTextView = findViewById(R.id.detailNameTextView);
        TextView priceTextView = findViewById(R.id.detailPriceTextView);

        Intent intent = getIntent();
        if (intent != null) {
            int imageId = intent.getIntExtra("imageId", R.drawable.ic_launcher_foreground);
            String name = intent.getStringExtra("name");
            String price = intent.getStringExtra("price");

            imageView.setImageResource(imageId);
            nameTextView.setText(name);
            priceTextView.setText("Price: " + price);
        }
    }
}