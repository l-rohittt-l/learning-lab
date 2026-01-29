package rohit_sawant.day11.useCase1;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class HospitalSystem3 {

    public static void main(String[] args) {

        // Scanner for user input
        Scanner sc = new Scanner(System.in);

        // HashMap to store patients
        // Key   -> Patient ID
        // Value -> Patient object
        Map<Integer, Patient> patients = new HashMap<>();

        // Infinite loop to keep system running
        while (true) {

            printMenu();
            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    addPatient(sc, patients);
                    break;

                case 2:
                    updatePatient(sc, patients);
                    break;

                case 3:
                    getPatient(sc, patients);
                    break;

                case 4:
                    removePatient(sc, patients);
                    break;

                case 5:
                    listPatients(patients);
                    break;

                case 6:
                    checkPatient(sc, patients);
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
        System.out.println("5. List all patients");
        System.out.println("6. Check patient existence");
        System.out.println("7. Count total patients");
        System.out.println("8. Clear system");
        System.out.println("9. Exit");
        System.out.print("Enter your choice: ");
    }

    // ---------------- OPERATIONS ----------------

    private static void addPatient(Scanner sc, Map<Integer, Patient> patients) {

        System.out.print("Enter Patient ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Patient Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Patient Age: ");
        int age = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Disease: ");
        String disease = sc.nextLine();

        Patient patient = new Patient(id, name, age, disease);

        patients.put(id, patient);

        System.out.println("Patient added successfully");
    }

    private static void updatePatient(Scanner sc, Map<Integer, Patient> patients) {

        System.out.print("Enter Patient ID to update: ");
        int id = sc.nextInt();
        sc.nextLine();

        if (!patients.containsKey(id)) {
            System.out.println("Patient not found");
            return;
        }

        Patient patient = patients.get(id);

        System.out.print("Enter new Name: ");
        patient.name = sc.nextLine();

        System.out.print("Enter new Age: ");
        patient.age = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter new Disease: ");
        patient.disease = sc.nextLine();

        System.out.println("Patient updated successfully");
    }

    private static void getPatient(Scanner sc, Map<Integer, Patient> patients) {

        System.out.print("Enter Patient ID to retrieve: ");
        int id = sc.nextInt();

        if (patients.containsKey(id)) {
            System.out.println(patients.get(id));
        } else {
            System.out.println("Patient not found");
        }
    }

    private static void removePatient(Scanner sc, Map<Integer, Patient> patients) {

        System.out.print("Enter Patient ID to remove: ");
        int id = sc.nextInt();

        if (patients.remove(id) != null) {
            System.out.println("Patient removed successfully");
        } else {
            System.out.println("Patient not found");
        }
    }

    private static void listPatients(Map<Integer, Patient> patients) {

        if (patients.isEmpty()) {
            System.out.println("No patients available");
            return;
        }

        System.out.println("All Patients:");
        for (Patient patient : patients.values()) {
            System.out.println(patient);
        }
    }

    private static void checkPatient(Scanner sc, Map<Integer, Patient> patients) {

        System.out.print("Enter Patient ID to check: ");
        int id = sc.nextInt();

        System.out.println("Exists: " + patients.containsKey(id));
    }

    private static void countPatients(Map<Integer, Patient> patients) {
        System.out.println("Total patients: " + patients.size());
    }

    private static void clearSystem(Map<Integer, Patient> patients) {
        patients.clear();
        System.out.println("System cleared");
    }
}

// ---------------- PATIENT CLASS ----------------

class Patient {

    int id;
    String name;
    int age;
    String disease;

    Patient(int id, String name, int age, String disease) {
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
