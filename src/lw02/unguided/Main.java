package lw02.unguided;

import java.util.LinkedList;
import java.util.Scanner;
import java.util.Queue;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Scanner inp =  new Scanner(Main.class.getResourceAsStream("orders.txt"));
        LinkedList<String[]> orders = new LinkedList<>();
        LinkedList<String[]> foodStock = new LinkedList<>();
        LinkedList<String[]> drinkStock = new LinkedList<>();
        LinkedList<String[]> processedOrders = new LinkedList<>();
        Queue<String[]> ordersQueue = new LinkedList<>();
        Stack<String[]> failedOrders = new Stack<>();

        
        foodStock.add(new String[]{"Bakso", "2"});
        foodStock.add(new String[]{"Sate", "1"});
        foodStock.add(new String[]{"Soto", "2"});
        drinkStock.add(new String[]{"EsTeh", "4"});
        drinkStock.add(new String[]{"EsJeruk", "2"});
        
        while (inp.hasNext()) {
            String name = inp.next();
            String food = inp.next();
            String drink = inp.next();
            String table = String.valueOf(inp.next());

            orders.add(new String[]{name, food, drink, table});
        }

        while (!orders.isEmpty()) {
            ordersQueue.add(orders.poll()); 
        }

        while (!ordersQueue.isEmpty()) {
            boolean avFood = true;
            boolean avDrink = true;
            String[] data = ordersQueue.poll();
            if (data[1].equals("Bakso")) {
                for (String[] s : foodStock) {
                    if (s[0].equals("Bakso") && Integer.parseInt(s[1]) > 0) {
                        s[1] = String.valueOf(Integer.parseInt(s[1]) - 1);
                        processedOrders.add(data);
                    } else {
                        failedOrders.add(data);
                    }
                }
            }
            else if (data[1].equals("Sate")) {
                for (String[] s : foodStock) {
                    if (s[0].equals("Sate") && Integer.parseInt(s[1]) > 0) {
                        s[1] = String.valueOf(Integer.parseInt(s[1]) - 1);
                        processedOrders.add(data);
                    } else {
                        failedOrders.add(data);
                    }
                }
            }
            else if (data[1].equals("Soto")) {
                for (String[] s : foodStock) {
                    if (s[0].equals("Soto") && Integer.parseInt(s[1]) > 0) {
                        s[1] = String.valueOf(Integer.parseInt(s[1]) - 1);
                        processedOrders.add(data);
                    } else {
                        failedOrders.add(data);
                    }
                }
            }

            if (data[2].equals("EsTeh")) {
                for (String[] s : drinkStock) {
                    if (s[0].equals("EsTeh") && Integer.parseInt(s[1]) > 0) {
                        s[1] = String.valueOf(Integer.parseInt(s[1]) - 1);
                        processedOrders.add(data);
                    } else {
                        failedOrders.add(data);
                    }
                }    
            }
            else if (data[2].equals("EsJeruk")) {
                for (String[] s : drinkStock) {
                    if (s[0].equals("EsJeruk") && Integer.parseInt(s[1]) > 0) {
                        s[1] = String.valueOf(Integer.parseInt(s[1]) - 1);
                        processedOrders.add(data);
                    } else {
                        failedOrders.add(data);
                    }
                }
            }
        }




        System.out.println("\n=== Successfully Processed Orders ===");
        for (String[] z : processedOrders) {
            System.out.println(z[0] + " " + z[1] + " " + z[2] + " " + z[3]);
        }
        System.out.println("\n=== Remaining Food Stock ===");
        for (String[] z : foodStock) {
            System.out.println("Food: " + z[0] + " : " + z[1]);
        }
        System.out.println("\n=== Remaining Drink Stock ===");
        for (String[] z : drinkStock) {
            System.out.println("Drink: " + z[0] + " : " + z[1]);
        }
        System.out.println("\n=== Failed Orders ===");
        for (String[] z : failedOrders) {
            System.out.println(z[0] + " " + z[1] + " " + z[2] + " " + z[3]);
        }

    }
}
