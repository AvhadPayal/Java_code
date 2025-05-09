package com.sql.First_javaproject.model;

import java.util.List;



public class Transaction {

    private String transaction_id;
    public String timestamp;
    private String user_id;
    public List<Item> items;
    private double total_before_discount;
    public double total_discount_applied;
    private double final_amount_payable;
    private Payment payment;
    private String location;
    public Shipping shipping;

    // Getters and Setters

    public String getTransaction_id() {
        return transaction_id;
    }

    public void setTransaction_id(String transaction_id) {
        this.transaction_id = transaction_id;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public double getTotal_before_discount() {
        return total_before_discount;
    }

    public void setTotal_before_discount(double total_before_discount) {
        this.total_before_discount = total_before_discount;
    }

    public double getTotal_discount_applied() {
        return total_discount_applied;
    }

    public void setTotal_discount_applied(double total_discount_applied) {
        this.total_discount_applied = total_discount_applied;
    }

    public double getFinal_amount_payable() {
        return final_amount_payable;
    }

    public void setFinal_amount_payable(double final_amount_payable) {
        this.final_amount_payable = final_amount_payable;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Shipping getShipping() {
        return shipping;
    }

    public void setShipping(Shipping shipping) {
        this.shipping = shipping;
    }

    // Method to calculate total before discount, discount applied, and final amount
    public void calculateTransactionAmounts(List<Item> items, double totalDiscount) {
        double subtotal = 0.0;
        for (Item item : items) {
            subtotal += item.getItem_subtotal();
        }

        this.total_before_discount = subtotal;
        this.total_discount_applied = totalDiscount;
        this.final_amount_payable = this.total_before_discount - this.total_discount_applied;
    }
}

