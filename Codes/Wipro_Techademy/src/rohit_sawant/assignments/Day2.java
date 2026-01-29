package rohit_sawant.assignments;

import java.util.*;

public class Day2 {

    public static int[] sortArray(int N, int[] A) {

        int[] sortedArray = new int[N];

        // Temporary Integer array for custom, stable sorting
        Integer[] numbersForSorting = new Integer[N];

        // Copy input array to Integer array
        for (int index = 0; index < N; index++) {
            numbersForSorting[index] = A[index];
        }

        // Sort based on number of digits (stable sort)
        Arrays.sort(numbersForSorting, new Comparator<Integer>() {
            public int compare(Integer firstNumber, Integer secondNumber) {
                int firstDigitCount = String.valueOf(firstNumber).length();
                int secondDigitCount = String.valueOf(secondNumber).length();
                return firstDigitCount - secondDigitCount;
            }
        });

        // Copy sorted values back to result array
        for (int index = 0; index < N; index++) {
            sortedArray[index] = numbersForSorting[index];
        }

        return sortedArray;
    }

    // Non editable starts here
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int[] A = new int[N];

        for (int i = 0; i < N; i++) {
            A[i] = scanner.nextInt();
        }

        int[] sortedArray = sortArray(N, A);

        for (int num : sortedArray) {
            System.out.print(num + " ");
        }
    }
    // Non editable ends here
}
