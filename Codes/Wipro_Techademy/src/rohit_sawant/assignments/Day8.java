package rohit_sawant.assignments;

import java.util.*;

public class Day8 {

    public static int minLength(String S) {
        int n = S.length();

        // Step 1: Count frequency of each character
        Map<Character, Integer> freqMap = new HashMap<>();
        for (char c : S.toCharArray()) {
            freqMap.put(c, freqMap.getOrDefault(c, 0) + 1);
        }

        // Step 2: If there are 2 or fewer unique characters,
        // we can delete all of them
        if (freqMap.size() <= 2) {
            return 0;
        }

        // Step 3: Find the two highest frequencies
        int max1 = 0;
        int max2 = 0;

        for (int count : freqMap.values()) {
            if (count > max1) {
                max2 = max1;
                max1 = count;
            } else if (count > max2) {
                max2 = count;
            }
        }

        // Step 4: Remaining length after deleting those two characters
        return n - (max1 + max2);
    }

    // Non editable starts here
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String S = scanner.nextLine();
        System.out.println(minLength(S));
        scanner.close();
    }
    // Non editable ends here
}
