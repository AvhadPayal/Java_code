package com.sql.First_javaproject.model;



public class Item {

    private String item;
    private double price;
    private int quantity;
    public String category;
    private String item_uuid;
    public double item_subtotal;

   

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getItem_uuid() {
        return item_uuid;
    }

    public void setItem_uuid(String item_uuid) {
        this.item_uuid = item_uuid;
    }

    public double getItem_subtotal() {
        return item_subtotal;
    }

    public void setItem_subtotal(double item_subtotal) {
        this.item_subtotal = item_subtotal;
    }
}
