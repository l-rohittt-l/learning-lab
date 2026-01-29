package rohit_sawant.assignments;

import java.util.Scanner;

public class Day1 {
    public static void camelCase(String S) {
        // Write your logic here
        if(S==null) {
        	throw new NullPointerException("Input String is null.");
        }
        if(S.length()==0) {
        	throw new IllegalArgumentException("Input String is empty.");
        }
        StringBuilder word = new StringBuilder();
        System.out.println(word.length());
        String test = "he";
        StringBuilder word2 = new StringBuilder(test);
        word2.append('h');
        System.out.println(word2);
        System.out.println(word2.toString());

//        heyThereIAmGood
        for (int i = 0; i < S.length(); i++) {//i= 11 12 13 14-last
            char ch = S.charAt(i);//G o o

            if (Character.isUpperCase(ch) && word.length() > 0) { //T F F F-last
                System.out.println(word.toString());//Am
                word.setLength(0);
            }

            word.append(ch);//G o o d-last
        }
//        word = Good
        System.out.println(word.toString());//Good
    }

    // Non editable starts here
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String S = scanner.next();
        camelCase(S);
    }
    // Non editable ends here
}
