package lw04.prelab;
import java.util.*;


//rid pake insertion
public class Main {
    public static void main(String[] args) {
        Scanner inp = new Scanner(Main.class.getResourceAsStream("branches.txt"));
        int branchNum = inp.nextInt();
        int branch[] = new int[branchNum];
        
        for (int i = 0; i < branchNum; i++) {
            branch[i] = inp.nextInt();
        }
        
        int targetNum = inp.nextInt();
        int target[] = new int[targetNum];
        
        for (int i = 0; i < targetNum; i++) {
            target[i] = inp.nextInt();
        }
        
        //insertion sort
        for (int i = 1; i <= 3; i++) {
            int key = branch[i];
            int j = i-1;

            while (j>=0 && branch[j]<key) {
                branch[j+1] = branch[j];
                j = j-1;
            }

            branch[j+1] = key;
        }

        for (int i : branch) {
            
            System.out.print(i + " ");
        }
        
        //linear search

        for (int i=0;i<targetNum;i++) {
            boolean targetFound = false;
            int targetIndexOnBranch = 0;
            for (int j=0;j<branchNum;j++) {
                if (branch[j] == target[i]) {
                    targetFound = true;
                    targetIndexOnBranch = j;
                    break;
                }
            }

            if (targetFound) {
                System.out.print("\n"+target[i] + ": FOUND at index " + targetIndexOnBranch);
            }
            else {
                System.out.print("\n"+target[i] + ": NOT FOUND");
            }
        }

        inp.close();
    }
}
