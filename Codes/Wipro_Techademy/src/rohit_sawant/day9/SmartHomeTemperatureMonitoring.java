package rohit_sawant.day9;

import java.util.ArrayList;

public class SmartHomeTemperatureMonitoring {

    public static void main(String[] args) {

        // creating an ArrayList to store temperature values from sensors
        // Double wrapper is used because collections do not support primitives
        ArrayList<Double> temperatureList = new ArrayList<>();

        // adding temperature readings
        // double values are automatically converted to Double (autoboxing)
        temperatureList.add(24.5);
        temperatureList.add(28.0);
        temperatureList.add(31.2);
        temperatureList.add(26.8);

        // threshold temperature for alert
        double threshold = 30.0;

        // looping through all temperature values
        for (Double temp : temperatureList) {

            // Double is converted to double while comparison (unboxing)
            if (temp > threshold) {
                System.out.println("High temperature detected: " + temp);
            } else {
                System.out.println("Temperature normal: " + temp);
            }

            // converting Double value to String using wrapper method
            String tempAsString = Double.toString(temp);
            System.out.println("Stored as String: " + tempAsString);
        }
    }
}
