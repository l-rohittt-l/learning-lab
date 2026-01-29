package rohit_sawant.day2;

import java.util.Scanner;

public class ElectricityBill {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter total units consumed: ");
        int units = sc.nextInt();

        int billAmount;

        if (units <= 100) {
            billAmount = units * 2;
        } else if (units <= 200) {
            billAmount = units * 3;
        } else {
            billAmount = units * 5;
        }

        System.out.println("Electricity Bill Amount = ₹" + billAmount);

        sc.close();
    }
}
