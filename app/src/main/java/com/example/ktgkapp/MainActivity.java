package com.example.ktgkapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<Product> products = new ArrayList<>();
        products.add(new Product(R.drawable.product1, "Trà Chanh", "$19.99"));
        products.add(new Product(R.drawable.product2, "Kem dâu", "$29.99"));
        products.add(new Product(R.drawable.product3, "Rượu nho", "$15.99"));
        products.add(new Product(R.drawable.product4, "Rượu nho siêu cấp", "$30.99"));
        products.add(new Product(R.drawable.product5, "Chanh muối", "$25.99"));


        ProductAdapter adapter = new ProductAdapter(this, products);

        ListView listView = findViewById(R.id.productListView);
        listView.setAdapter(adapter);
    }
}