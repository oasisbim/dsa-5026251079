package lw02.prelab;

import java.util.LinkedList;
import java.util.Scanner;
import java.util.Queue;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        @SuppressWarnings("resource")
        Scanner inp =  new Scanner(Main.class.getResourceAsStream("transaction.txt"));
        LinkedList<String[]> transactionList = new LinkedList<>();
        LinkedList<String[]> customerList = new LinkedList<>();
        Queue<String[]> transactionQueue = new LinkedList<>();
        Stack<String[]> failedTransactions = new Stack<>();
        
        
        while (inp.hasNext()) {
            String name = inp.next();
            String type = inp.next();
            String amount = String.valueOf(inp.nextInt());
    
            transactionList.add(new String[]{name, type, amount});
        }

        for (String[] transaction : transactionList) {
            String name = transaction[0];
        
            boolean exists = false;
            for (String[] customer : customerList) {
                if (customer[0].equals(name)) {
                    exists = true;
                }
            }
            
            if (!exists) {
                customerList.add(new String[]{name, "0"});
            }   
        }


        while (!transactionList.isEmpty()) {
            transactionQueue.add(transactionList.poll()); 
        }

        while (!transactionQueue.isEmpty()) {
            String[] t = transactionQueue.poll();
            String name = t[0];
            String type = t[1];
            int amount = Integer.parseInt(t[2]);

            for (String[] customer : customerList) {
                if (customer[0].equals(name)) {
                    int currentBalance = Integer.parseInt(customer[1]);

                    if (type.equals("DEPOSIT")) {
                        currentBalance += amount;
                        customer[1] = String.valueOf(currentBalance);
                    } else if (type.equals("WITHDRAW")) {
                        if (currentBalance >= amount) {
                            currentBalance -= amount;
                            customer[1] = String.valueOf(currentBalance);
                        } else {
                            failedTransactions.push(t);
                        }
                    }
                }
            }
        }

        System.out.println("\n=== Final Balances ===");
        for (String[] customer : customerList) {
            System.out.println("Customer: " + customer[0] + " | Balance: " + customer[1]);
        }
        System.out.println("\n=== Failed Transactions ===");
        if (failedTransactions.isEmpty()) {
            System.out.println("No failed transactions.");
        } else {
            while (!failedTransactions.isEmpty()) {
                String[] failedTx = failedTransactions.pop(); // Pop retrieves from top of stack
                System.out.println(failedTx[0] + " " + failedTx[1] + " " + failedTx[2]);
            }
        }
    }
}