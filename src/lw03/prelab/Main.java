package lw03.prelab;

import java.util.List;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.Map;


public class Main {
    public static void main(String[] args) {
        Scanner inpPl = new Scanner(Main.class.getResourceAsStream("playlist.txt"));
        Scanner inpPa = new Scanner(Main.class.getResourceAsStream("participants.txt"));
        Scanner inpIn = new Scanner(Main.class.getResourceAsStream("inventory.txt"));

        //playlist
        List<String> playlist = new ArrayList<>();
        
        while (inpPl.hasNext()) {
            String type = inpPl.next();
            if (type.equals("ADD")) {
                playlist.add(inpPl.nextLine());
            }
            else if (type.equals("INSERT")) {
                playlist.add(inpPl.nextInt(), inpPl.nextLine());
            }
            else if (type.equals("REMOVE")) {
                playlist.remove(inpPl.nextLine());
                
            }
        }
        
        System.out.println("\n=====  Problem 1 =====" +  "\nTotal Songs: " + playlist.size());
        for (String song : playlist) {
            System.out.println((playlist.indexOf(song)+1) + ": " + song);
        }
        
        
        // participants
        Set<String> participants = new LinkedHashSet<>();
        int duplicateReg = 0;
        
        while (inpPa.hasNext()) {
            String data = inpPa.next();
            if (participants.contains(data)) {
            //    duplicateReg = duplicateReg + 1 ;
                duplicateReg += 1;
            }
            participants.add(data);
        }
        
        System.out.println("\n===== Problem 2 =====" + "\nUnique Participants: " + participants.size());
        int i = 1;
        for (String person : participants) {
            System.out.println(i + ". " + person);
            i++;
        }
        System.out.println("Duplicate registrations: " + duplicateReg);
        
        
        // inventory
        Map<String, Integer> inventory = new LinkedHashMap<>();
        int failed_sales = 0;

        while (inpIn.hasNext()) {
            String type = inpIn.next();
            String product = inpIn.next();
            int quantity = inpIn.nextInt();

            if (type.equals("ADD")) {
                if (!inventory.containsKey(product)) {
                    inventory.put(product, quantity);
                } else {
                    inventory.replace(product, (inventory.get(product) + quantity));
                }
            }
            else if (type.equals("SELL")) {
                if (inventory.containsKey(product) && inventory.get(product) >= quantity) {
                    inventory.replace(product, (inventory.get(product) - quantity));
                } else {
                    failed_sales++;
                }
            }
        }

        int j = 1;
        System.out.println("\n===== Problem 3 =====");
        for (String product : inventory.keySet()) {
            System.out.println(product + ": " + inventory.get(product));
        }
        System.out.println("Failed sales: " + failed_sales);
    }
}
