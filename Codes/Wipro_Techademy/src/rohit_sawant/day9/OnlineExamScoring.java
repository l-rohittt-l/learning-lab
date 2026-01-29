package rohit_sawant.day9;

import java.util.HashMap;
import java.util.Map;

public class OnlineExamScoring {

    public static void main(String[] args) {

        // creating a Map to store subject name as key and score as value
        // String -> subject name
        // Integer -> score (wrapper class)
        Map<String, Integer> scores = new HashMap<>();

        // adding scores to the map
        // here int values are automatically converted to Integer (autoboxing)
        scores.put("Maths", 85);
        scores.put("English", 78);
        scores.put("Science", 92);

        // variable to store total score
        int total = 0;

        // looping through all the values (scores) in the map
        // Integer is automatically converted to int while adding (unboxing)
        for (Integer score : scores.values()) {
            total = total + score;
        }

        // calculating average score
        // typecasting total to double to get correct average
        double average = (double) total / scores.size();

        // printing results
        System.out.println("Scores: " + scores);
        System.out.println("Total Score: " + total);
        System.out.println("Average Score: " + average);
    }
}
