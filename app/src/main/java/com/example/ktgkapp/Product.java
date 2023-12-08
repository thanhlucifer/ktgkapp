package com.example.ktgkapp;


public class Product {
    private int imageId;
    private String name;
    private String price;

    public Product(int imageId, String name, String price) {
        this.imageId = imageId;
        this.name = name;
        this.price = price;
    }

    public int getImageId() {
        return imageId;
    }

    public String getName() {
        return name;
    }

    public String getPrice() {
        return price;
    }
}

