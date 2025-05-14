package com.sql.First_javaproject.service;

import com.sql.First_javaproject.model.Item;
import com.sql.First_javaproject.model.Transaction;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.*;

public class TransactionService {

    // read transaction from json file
    public List<Transaction> readTransactions(String filePath) {
        ObjectMapper mapper = new ObjectMapper();
        List<Transaction> transactions = new ArrayList<>();
        try {
            transactions = mapper.readValue(new File(filePath), new TypeReference<List<Transaction>>() {});
        } catch (Exception e) {
            e.printStackTrace();
        }
        return transactions;
    }

    // read discount from json file
    public Map<String, Double> readDiscounts(String filePath) {
        ObjectMapper mapper = new ObjectMapper();
        Map<String, Double> discounts = null;
        try {
            discounts = mapper.readValue(new File(filePath), new TypeReference<Map<String, Double>>() {});
        } catch (Exception e) {
            e.printStackTrace();
        }
        return discounts;
    }

    // validate and calculate 
    public void processTransactions(List<Transaction> allTxns, Map<String, Double> discounts,
                                    List<Transaction> valid, List<Transaction> invalid) {

        for (Transaction txn : allTxns) {

            
            calculateTransactionFields(txn, discounts);

            
            if (ValidationUtil.isDiscountValid(txn, discounts) &&
                ValidationUtil.isDeliveryValid(txn)) {
                valid.add(txn);
            } else {
                invalid.add(txn);
            }
        }
    }

    // totals, discounts, final amount
    public void calculateTransactionFields(Transaction txn, Map<String, Double> discounts) {
        double totalBefore = 0.0;
        double totalDiscount = 0.0;

        for (Item item : txn.getItems()) {
            double subtotal = item.getPrice() * item.getQuantity();
            item.setItem_subtotal(subtotal);

            totalBefore += subtotal;

            double discountRate = discounts.getOrDefault(item.getCategory(), 0.0);
            totalDiscount += subtotal * discountRate;
        }

        txn.setTotal_before_discount(totalBefore);
        txn.setTotal_discount_applied(totalDiscount);
        txn.setFinal_amount_payable(totalBefore - totalDiscount);
    }

    // write o/p into JSON
    public void writeTransactionsToFile(List<Transaction> transactions, String filename) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            mapper.writerWithDefaultPrettyPrinter().writeValue(new File(filename), transactions);
            System.out.println("Written to file: " + filename);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
