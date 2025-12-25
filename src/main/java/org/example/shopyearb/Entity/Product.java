package org.example.shopyearb.Entity;

import java.awt.*;

public class Product {
private int barcode;
private double price;
private String name;
private String color;

    public Product(int barcode, double price, String name, String color) {
        this.barcode = barcode;
        this.price = price;
        this.name = name;
        this.color = color;
    }

    public int getBarcode() {
        return barcode;
    }

    public void setBarcode(int barcode) {
        this.barcode = barcode;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Product{" +
                "barcode=" + barcode +
                ", price=" + price +
                ", name='" + name + '\'' +
                ", color=" + color +
                '}';
    }
}
