package com.sql.First_javaproject.service;



import com.sql.First_javaproject.model.*;


import java.time.*;

public class ValidationUtil {

    public static boolean isDeliveryValid(Transaction txn) {
        try {
            ZonedDateTime orderDate = ZonedDateTime.parse(txn.timestamp);
            ZonedDateTime deliveryDate = ZonedDateTime.parse(txn.shipping.delivery_estimate);
            long days = java.time.Duration.between(orderDate, deliveryDate).toDays();
            return days <= 7;
        } catch (Exception e) {
            return false;
        }
    }

    public static boolean isDiscountValid(Transaction txn, java.util.Map<String, Double> config) {
        double expected = 0.0;
        for (Item item : txn.items) {
            double allowed = config.getOrDefault(item.category, 0.0);
            expected += item.item_subtotal * allowed;
        }
        return txn.total_discount_applied <= expected;
    }
}
