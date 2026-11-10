package lw04.unguided;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner inp = new Scanner(Main.class.getResourceAsStream("parcels.txt"));
        int parcelNum = inp.nextInt();
        int parcel[] = new int[parcelNum];
        
        for (int i = 0; i < parcelNum; i++) {
            parcel[i] = inp.nextInt();
        }
        
        int targetNum = inp.nextInt();
        int target[] = new int[targetNum];
        
        for (int i = 0; i < targetNum; i++) {
            target[i] = inp.nextInt();
        }

        //bub sort
        for (int i = 0; i < parcelNum - 1; i++) {
            boolean swapped = false;

            for (int j = 0; j < parcelNum - 1 - i; j++) {
                if (parcel[j] < parcel[j + 1]) {
                    int temp = parcel[j];
                    parcel[j] = parcel[j + 1];
                    parcel[j + 1] = temp;

                    swapped = true;
                }
            }

            if (i == 1) {
                System.out.println("\n==== After 2 Passes ====");
                for (int k : parcel) {
                    System.out.print(k + " ");
                }
                System.out.println();
            }

            if (!swapped) {
                System.out.println("\n==== Fully Sorted ====");
                for (int k : parcel) {
                    System.out.print(k + " ");
                }
                System.out.println();
                break;
            }
        }

        //binary search
        System.out.println("\n==== Search Results ====");
        for (int i=0;i<targetNum;i++) {
            boolean targetFound = false;
            int targetIndexOnParcel = 0;
            int left = 0;
            int right = parcel.length - 1;
            int steps =  0;
            while (left <= right) {
                int mid = (left + right) / 2;
                steps++;

                if (parcel[mid] == target[i]) {
                    targetFound = true;
                    targetIndexOnParcel = mid;
                    break;
                } else if (parcel[mid] > target[i]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
            if (targetFound) {
                System.out.println(target[i] + ": FOUND at index " + targetIndexOnParcel + " (Steps: " + steps + ")");
            }
            else {
                System.out.println(target[i] + ": NOT FOUND (Steps: " + steps + ")");
            }
        }
        
        System.out.println();
        inp.close();
    }
}
