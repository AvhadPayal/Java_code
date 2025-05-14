package com.sql.First_javaproject;

import com.sql.First_javaproject.model.Transaction;
import com.sql.First_javaproject.service.TransactionService;

import java.util.*;

public class App {
    public static void main(String[] args) {

        
        TransactionService service = new TransactionService();

        
        String inputPath = "src/main/java/resources/data.json";
        String discountPath = "src/main/java/resources/discount_config.json";
        String validOutputPath = "src/main/java/resources/transaction.json";
        String invalidOutputPath = "src/main/java/resources/Invalid.json";

        try {
            // Read trasaction
            List<Transaction> transactions = service.readTransactions(inputPath);

            Map<String, Double> discountConfig = service.readDiscounts(discountPath);

            List<Transaction> validList = new ArrayList<>();
            List<Transaction> invalidList = new ArrayList<>();

            // Process transactions
            service.processTransactions(transactions, discountConfig, validList, invalidList);

            // Write valid and invalid transaction
            service.writeTransactionsToFile(validList, validOutputPath);
            service.writeTransactionsToFile(invalidList, invalidOutputPath);

            
            System.out.println("Valid transactions: " + validList.size() + ", Invalid: " + invalidList.size());

        } catch (Exception e) {
            
            e.printStackTrace();
        }
    }
}
