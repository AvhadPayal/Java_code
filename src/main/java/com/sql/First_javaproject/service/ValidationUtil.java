package com.sql.First_javaproject.service;

import com.sql.First_javaproject.model.Item;
import com.sql.First_javaproject.model.Shipping;
import com.sql.First_javaproject.model.Transaction;

import java.util.Map;

public class ValidationUtil {

    // Check if each item has a valid discount category
    public static boolean isDiscountValid(Transaction txn, Map<String, Double> discounts) {
        if (txn == null || txn.getItems() == null) {
            System.out.println("Transaction or items are null.");
            return false;
        }

        for (Item item : txn.getItems()) {
            System.out.println("Checking item category: " + item.getCategory());  // Log item category
            if (!discounts.containsKey(item.getCategory())) {
                System.out.println("Invalid category for item: " + item.getCategory());  // Log invalid category
                return false;
            }
        }
        return true;
    }

    // Check if delivery info is not null or empty
    public static boolean isDeliveryValid(Transaction txn) {
        Shipping ship = txn.getShipping();
        if (ship == null) {
            System.out.println("Shipping information is null.");
            return false;
        }
        
        // Log Shipping info for debugging
        System.out.println("Carrier: " + ship.getCarrier());
        System.out.println("Status: " + ship.getStatus());
        System.out.println("Delivery Estimate: " + ship.getDelivery_estimate());

        return ship.getCarrier() != null && !ship.getCarrier().trim().isEmpty() &&
               ship.getStatus() != null && !ship.getStatus().trim().isEmpty() &&
               ship.getDelivery_estimate() != null && !ship.getDelivery_estimate().trim().isEmpty();
    }
}
