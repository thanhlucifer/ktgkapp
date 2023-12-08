package com.example.ktgkapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class ProductDetailActivity extends AppCompatActivity {

    private int quantity = 0;
    private double totalPrice = 0.0;
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
        final TextView totalTextView = findViewById(R.id.totalTextView);
        final Button buyButton = findViewById(R.id.buyButton);

        buyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Xử lý sự kiện khi người dùng nhấn vào nút mua
                quantity++;
                totalPrice += getPriceFromIntent(); // Lấy giá từ intent hoặc từ đối tượng sản phẩm
                updateTotalTextView(totalTextView);
            }
        });

    }


    private double getPriceFromIntent() {
        Intent intent = getIntent();
        if (intent != null) {
            String priceString = intent.getStringExtra("price");
            try {
                return Double.parseDouble(priceString.replace("$", ""));
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        }
        return 0.0;
    }

    private void updateTotalTextView(TextView totalTextView) {
        totalTextView.setText(String.format("Total: $%.2f", totalPrice));
    }

    public void onBuyButtonClick(View view) {
        // Xử lý sự kiện khi người dùng nhấn vào nút mua (cách thức này được đặt trong thuộc tính onClick của nút mua)
        quantity++;
        totalPrice += getPriceFromIntent(); // Lấy giá từ intent hoặc từ đối tượng sản phẩm
        updateTotalTextView((TextView) findViewById(R.id.totalTextView));
    }
}