package com.sql.First_javaproject;



import com.sql.First_javaproject.model.Transaction;
import com.sql.First_javaproject.service.TransactionService;

import java.util.*;

public class App {
    public static void main(String[] args) {
        TransactionService service = new TransactionService();
        String txPath = "src/main/java/resources/data.json";
        String dcPath = "src/main/java/resources/discount_config.json";

        try {
            List<Transaction> allTxns = service.readTransactions(txPath);
            Map<String, Double> discounts = service.readDiscountConfig(dcPath);

            List<Transaction> valid = new ArrayList<>();
            List<Transaction> invalid = new ArrayList<>();

            service.processTransactions(allTxns, discounts, valid, invalid);

            service.writeTransactions("src/main/java/resources/transaction.json", valid);
            service.writeTransactions("src/main/java/resources/Invalid.json", invalid);

            System.out.println("Processing complete. Valid: " + valid.size() + ", Invalid: " + invalid.size());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

