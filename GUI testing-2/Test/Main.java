import java.util.Scanner;

/**
 * Write a description of class Main here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */

// Step 1: Import the Scanner class
import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        
        
        System.out.println(" -While Loop example-\n");
        whileLoopExample();
        System.out.println("\n -For Loop example-\n");
        forLoopExample();
        System.out.println("\n -Nested Loop example-\n");
        nestedLoopExample();
        System.out.println("\n -real world Loop example-\n");
        loopInPractice();

    }
    
    //Sentinel Controlled
    public static void whileLoopExample(){
        int count = 1; // Initialization

        // while loop with continuation condition
        while (count <= 5) {
            System.out.println("Count is: " + count); // Body of the loop
            count++; // Update
        }
    }
    
    //Counter Controlled
    public static void forLoopExample(){
         // for loop with initialization, continuation condition, and update
        for (int count = 1; count <= 5; count++) {
            System.out.println("Count is: " + count); // Body of the loop
        }
    }
    
    //nested loop example
    public static void nestedLoopExample(){
        for (int i = 1; i <= 3; i++) { // Outer loop
            for (int j = 1; j <= 2; j++) { // Inner loop
                System.out.println("i: " + i + ", j: " + j); // Body of the inner loop
            }
        }
    }
    
    
    //store inventory example
    public static void loopInPractice(){
        Scanner scanner = new Scanner(System.in);
        String[] items = {"Apples", "Bananas", "Oranges"};
        int[] stock = {10, 8, 15}; // Initial stock levels

        // Update stock levels based on user input
        for (int i = 0; i < items.length; i++) {
            System.out.print("Enter new stock level for " + items[i] + ": ");
            stock[i] = scanner.nextInt();
        }

        // Display updated stock levels
        System.out.println("Updated Stock Levels:");
        for (int i = 0; i < items.length; i++) {
            System.out.println(items[i] + ": " + stock[i]);
        }
    }
}
