package lw06.unguided;

import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner read = new Scanner(Main.class.getResourceAsStream("treenumbers.txt"));

        String[] numbers = read.nextLine().split(" ");
        
        BinarySearchTree bst = new BinarySearchTree();
        bst.root = null;
        for (String number : numbers) {
            bst.insert(Integer.parseInt(number));
        }

        System.out.print("\nPreorder: ");
        bst.preOrder();
        System.out.print("Inorder: ");
        bst.inOrder();
        System.out.print("Postorder: ");
        bst.postOrder();

        int target = read.nextInt();
        System.out.println("Search " + target + ": " + bst.search(target));
        bst.search(target);

        System.out.println("Total Nodes: " + bst.countNodes());
        System.out.println("Total Leaves: " + bst.countLeaves());

        read.close();
    }
}
