package rohit_sawant.day11;

import java.util.TreeMap;
import java.util.Map;

public class TreeMapExample {
    public static void main(String[] args) {

        // TreeMap stores data in sorted order of keys
        Map<Integer, String> employee = new TreeMap<>();

        // Adding key-value pairs
        employee.put(103, "Rahul");
        employee.put(101, "Vinay");
        employee.put(102, "Amit");
        employee.put(104, "Neha");

        // Printing TreeMap
        System.out.println(employee);
    }
}