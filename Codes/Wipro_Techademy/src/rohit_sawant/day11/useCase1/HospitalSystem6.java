package rohit_sawant.day11.useCase1;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class HospitalSystem6 {

    // Centralized Scanner
    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        /*
         * TreeMap is used instead of HashMap.
         * Keys (Patient ID) will ALWAYS remain sorted.
         * Internally, TreeMap uses a Red-Black Tree.
         */
        Map<Integer, Patient4> patients = new TreeMap<>();

        while (true) {

            printMenu();
            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    addPatient(patients);
                    break;

                case 2:
                    updatePatient(patients);
                    break;

                case 3:
                    getPatient(patients);
                    break;

                case 4:
                    removePatient(patients);
                    break;

                case 5:
                    listPatients(patients);
                    break;

                case 6:
                    checkPatient(patients);
                    break;

                case 7:
                    countPatients(patients);
                    break;

                case 8:
                    clearSystem(patients);
                    break;

                case 9:
                    System.out.println("Exiting system...");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice");
            }
        }
    }

    // ---------------- MENU ----------------

    private static void printMenu() {
        System.out.println("\n--- Hospital Patient Records System ---");
        System.out.println("1. Add patient");
        System.out.println("2. Update patient");
        System.out.println("3. Get patient details");
        System.out.println("4. Remove patient");
        System.out.println("5. List all patients (sorted by ID)");
        System.out.println("6. Check patient existence");
        System.out.println("7. Count total patients");
        System.out.println("8. Clear system");
        System.out.println("9. Exit");
        System.out.print("Enter your choice: ");
    }

    // ---------------- OPERATIONS ----------------

    private static void addPatient(Map<Integer, Patient4> patients) {

        System.out.print("Enter Patient ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        // Duplicate ID protection
        if (patients.containsKey(id)) {
            System.out.println("Patient ID already exists. Cannot add duplicate.");
            return;
        }

        System.out.print("Enter Patient Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Patient Age: ");
        int age = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Disease: ");
        String disease = sc.nextLine();

        Patient4 patient = new Patient4(id, name, age, disease);
        patients.put(id, patient);

        System.out.println("Patient added successfully");
    }

    private static void updatePatient(Map<Integer, Patient4> patients) {

        System.out.print("Enter Patient ID to update: ");
        int id = sc.nextInt();
        sc.nextLine();

        if (!patients.containsKey(id)) {
            System.out.println("Patient not found");
            return;
        }

        Patient4 patient = patients.get(id);

        System.out.print("Enter new Name: ");
        patient.name = sc.nextLine();

        System.out.print("Enter new Age: ");
        patient.age = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter new Disease: ");
        patient.disease = sc.nextLine();

        System.out.println("Patient updated successfully");
    }

    private static void getPatient(Map<Integer, Patient4> patients) {

        System.out.print("Enter Patient ID to retrieve: ");
        int id = sc.nextInt();

        if (patients.containsKey(id)) {
            System.out.println(patients.get(id));
        } else {
            System.out.println("Patient not found");
        }
    }

    private static void removePatient(Map<Integer, Patient4> patients) {

        System.out.print("Enter Patient ID to remove: ");
        int id = sc.nextInt();

        if (patients.remove(id) != null) {
            System.out.println("Patient removed successfully");
        } else {
            System.out.println("Patient not found");
        }
    }

    private static void listPatients(Map<Integer, Patient4> patients) {

        if (patients.isEmpty()) {
            System.out.println("No patients available");
            return;
        }

        /*
         * TreeMap guarantees ascending order of keys.
         * This loop will ALWAYS print patients sorted by ID.
         */
        System.out.println("All Patients (Sorted by ID):");
        for (Patient4 patient : patients.values()) {
            System.out.println(patient);
        }
    }

    private static void checkPatient(Map<Integer, Patient4> patients) {

        System.out.print("Enter Patient ID to check: ");
        int id = sc.nextInt();

        System.out.println("Exists: " + patients.containsKey(id));
    }

    private static void countPatients(Map<Integer, Patient4> patients) {
        System.out.println("Total patients: " + patients.size());
    }

    private static void clearSystem(Map<Integer, Patient4> patients) {
        patients.clear();
        System.out.println("System cleared");
    }
}

// ---------------- PATIENT CLASS (VERSION 4) ----------------

class Patient4 {

    int id;
    String name;
    int age;
    String disease;

    Patient4(int id, String name, int age, String disease) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.disease = disease;
    }

    @Override
    public String toString() {
        return "ID: " + id +
               ", Name: " + name +
               ", Age: " + age +
               ", Disease: " + disease;
    }
}
