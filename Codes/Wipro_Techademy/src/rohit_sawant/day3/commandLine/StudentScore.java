package rohit_sawant.day3.commandLine;

public class StudentScore {

    // Student object to store details
    static class Student {
        String name;
        int english;
        int maths;
        int total;
        double percentage;
        char grade;
    }

    public static void main(String[] args) {

        // Read command-line arguments
        String name = args[0];
        int english = Integer.parseInt(args[1]);
        int maths = Integer.parseInt(args[2]);

        // Create student object
        Student s = new Student();
        s.name = name;
        s.english = english;
        s.maths = maths;

        // Calculations
        s.total = english + maths;
        s.percentage = s.total / 2.0;

        // Grade calculation using switch
        switch ((int) s.percentage / 10) {
            case 10:
            case 9:
                s.grade = 'A';
                break;
            case 8:
            case 7:
                s.grade = 'B';
                break;
            case 6:
            case 5:
                s.grade = 'C';
                break;
            default:
                s.grade = 'F';
        }

        // Output
        System.out.println("Student: " + s.name);
        System.out.println("English: " + s.english);
        System.out.println("Maths: " + s.maths);
        System.out.println("Total: " + s.total);
        System.out.println("Percentage: " + s.percentage + "%");
        System.out.println("Grade: " + s.grade);

        // Eligible for Garbage Collection
        s = null;
    }
}
