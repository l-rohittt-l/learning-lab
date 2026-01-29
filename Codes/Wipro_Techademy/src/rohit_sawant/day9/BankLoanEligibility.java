package rohit_sawant.day9;

import java.util.ArrayList;

public class BankLoanEligibility {

    public static void main(String[] args) {

        // age of the applicant (wrapper class Integer)
        Integer age = 25;

        // CIBIL score of the applicant (wrapper class Integer)
        Integer cibilScore = 750;

        // creating ArrayList to store monthly income values
        // Double wrapper is used because collections cannot store primitive types
        ArrayList<Double> monthlyIncomeList = new ArrayList<>();

        // adding monthly income values
        // double is automatically converted to Double (autoboxing)
        monthlyIncomeList.add(30000.0);//double -> Double
        monthlyIncomeList.add(32000.0);
        monthlyIncomeList.add(31000.0);

        // variable to store total income
        double totalIncome = 0.0;

        // looping through income list
        // Double is converted to double while calculation (unboxing)
        for (Double income : monthlyIncomeList) {//Double -> double
            totalIncome = totalIncome + income;
        }

        // calculating average monthly income
        double averageIncome = totalIncome / monthlyIncomeList.size();

        // checking loan eligibility conditions
        // wrapper values are unboxed automatically during comparison
        if (age >= 21 && cibilScore >= 700 && averageIncome >= 25000) {
            System.out.println("Loan Approved");
        } else {
            System.out.println("Loan Rejected");
        }

        // printing details
        System.out.println("Age: " + age);
        System.out.println("CIBIL Score: " + cibilScore);
        System.out.println("Average Monthly Income: " + averageIncome);
    }
}
