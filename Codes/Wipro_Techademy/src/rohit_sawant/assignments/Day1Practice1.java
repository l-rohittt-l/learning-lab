package rohit_sawant.assignments;

import java.util.Scanner;

public class Day1Practice1 {
	public static void camelCase(String S) {
		if(S==null) {
			throw new NullPointerException("Input String is null.");
		}
		if(S.length()==0) {
			throw new IllegalArgumentException("Input String is empty.");
		}
		StringBuilder word = new StringBuilder();
		for(int i=0;i<S.length();i++) {
			char ch=S.charAt(i);
			if(Character.isUpperCase(ch) && word.length()>0) {
				System.out.println(word);
				word.setLength(0);
			}
			word.append(ch);
		}
		System.out.println(word);
	}
	public static void main(String args []) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter the input: ");
		String S = scanner.next();
		camelCase(S);
		scanner.close();
	}
}
