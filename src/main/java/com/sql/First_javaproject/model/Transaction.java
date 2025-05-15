package com.sql.First_javaproject.model;



import java.util.List;

public class Transaction {
    public String transaction_id;
    public String timestamp;
    public String user_id;
    public List<Item> item;
    public double total_before_discount;
    public double total_discount_applied;
    public double final_amount_payable;
    public Payment payment;
    public String location;
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
        return item;
    }

    public void setItems(List<Item> items) {
        this.item = items;
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
}
