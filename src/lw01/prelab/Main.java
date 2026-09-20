package lw01.prelab;

import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        File inpFile = new File ("src\\lw01\\prelab\\jobs.txt");
        try (Scanner inp = new Scanner(inpFile)) {
            ArrayList<PrintJob> printJobs = new ArrayList<PrintJob>();
            while (inp.hasNextLine()) {
                String data = inp.nextLine();
                String[] words = data.split("\\s+");
                int inpPages = Integer.parseInt(words[2]); 

                if (inpPages <= 0) {
                    throw new IllegalArgumentException("The number of pages cant be less than 1");
                } 

                
                if (words[0].equals("MONO")) {
                    MonoPrint print = new MonoPrint(words[1], inpPages);
                    printJobs.add(print);
                } else if (words[0].equals("COLOUR")) {
                    ColourPrint print = new ColourPrint(words[1], inpPages);
                    printJobs.add(print);
                }

                //System.out.println(inpPages); 

                //done: input, splitting string, parsing integer
                //todo: cal the methods  to work
            }
            for (int i = 0; i < printJobs.size(); i++) {
                System.out.println(printJobs.get(i).summary());
            }
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred; File not found.");
            e.printStackTrace(); 
        }
    }
}
