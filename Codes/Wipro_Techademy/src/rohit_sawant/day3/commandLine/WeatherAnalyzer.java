package rohit_sawant.day3.commandLine;

class WeatherRecord {
    String city;
    float temperature;

    WeatherRecord(String city, float temperature) {
        this.city = city;
        this.temperature = temperature;
    }
}

public class WeatherAnalyzer {

    public static void main(String[] args) {

        // Command-line arguments
        String city = args[0];
        float temp = Float.parseFloat(args[1]);

        // Variables of different datatypes
        final int threshold = 30;
        boolean isHot;

        // Weather condition check
        if (temp > threshold) {
            isHot = true;
        } else {
            isHot = false;
        }

        // Creating a temporary object
        WeatherRecord record = new WeatherRecord(city, temp);

        // Making the object eligible for Garbage Collection
        record = null;

        // Output
        System.out.println("City: " + city);
        System.out.println("Temperature: " + temp + "°C");

        if (isHot) {
            System.out.println("Condition: Hot Day");
        } else {
            System.out.println("Condition: Normal Day");
        }
    }
}
