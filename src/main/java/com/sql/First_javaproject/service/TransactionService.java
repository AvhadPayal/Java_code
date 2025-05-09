package com.sql.First_javaproject.service;



import com.sql.First_javaproject.model.Transaction;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.type.TypeReference;

import java.io.File;
import java.nio.file.Paths;
import java.util.*;

public class TransactionService {
    private final ObjectMapper mapper = new ObjectMapper();

    // Read the discount configuration 
    public Map<String, Double> readDiscountConfig(String filePath) throws Exception {
        return mapper.readValue(new File(filePath), new TypeReference<Map<String, Double>>() {});
    }

    // Read the list of transactions
    public List<Transaction> readTransactions(String filePath) throws Exception {
        return mapper.readValue(new File(filePath), new TypeReference<List<Transaction>>() {});
    }

    // Write the transactions
    public void writeTransactions(String filePath, List<Transaction> transactions) throws Exception {
        mapper.writerWithDefaultPrettyPrinter().writeValue(Paths.get(filePath).toFile(), transactions);
    }

    public void processTransactions(List<Transaction> allTxns, Map<String, Double> discounts,
            List<Transaction> valid, List<Transaction> invalid) {
        for (Transaction txn : allTxns) {
            // Validate the transaction and categorize it as valid or invalid
            if (isDiscountValid(txn, discounts) && isDeliveryValid(txn)) {
                valid.add(txn);
            } else {
                invalid.add(txn);
            }
        }
    }

    // Validation function for checking if the discount applied is valid
    private boolean isDiscountValid(Transaction txn, Map<String, Double> discounts) {
        double totalDiscount = txn.getTotal_discount_applied();
        return totalDiscount <= txn.getTotal_before_discount();  // Discount shouldn't exceed total before discount
    }

    // Validation function to check if the delivery is valid (optional logic, can be customized)
    private boolean isDeliveryValid(Transaction txn) {
        // Example: Checking if the shipping status is 'Shipped' and delivery estimate exists
        return txn.getShipping() != null && "Shipped".equalsIgnoreCase(txn.getShipping().getStatus()) &&
                txn.getShipping().getDelivery_estimate() != null;
    }
}
