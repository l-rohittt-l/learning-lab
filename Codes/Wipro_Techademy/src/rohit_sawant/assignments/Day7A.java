package rohit_sawant.assignments;

import java.util.Scanner;

public class Day7A {

    // This method calculates the sum of all even numbers
    // between the given start and end using a separate thread
    public static void sumOfRange(int start, int end) {

        // Creating a new thread for calculation
        Thread t = new Thread(() -> {

            // Variable to store the sum of even numbers
            int sum = 0;

            // Loop through the given range
            for (int i = start; i <= end; i++) {

                // Check if the number is even
                if (i % 2 == 0) {
                    sum += i;
                }
            }

            // Print the final sum
            System.out.println(sum);
        });

        // Start the thread
        t.start();

        try {
            // Ensure main thread waits until calculation finishes
            t.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    // -------- Non Editable Code --------
    public static void main(String[] args) {

        // Scanner to read input
        Scanner scanner = new Scanner(System.in);

        // Read start and end values
        int start = scanner.nextInt();
        int end = scanner.nextInt();

        // Call method
        sumOfRange(start, end);

        // Close scanner
        scanner.close();
    }
    // -------- Non Editable Code --------
}
