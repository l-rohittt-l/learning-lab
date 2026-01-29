package rohit_sawant.day11.useCase1;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class HospitalSystem7 {

    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        // Ordered map (TreeMap → Red-Black Tree)
        Map<Integer, Patient5> patients = new TreeMap<>();

        while (true) {

            printMenu();
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    handleAddPatient(patients);
                    break;

                case 2:
                    handleUpdatePatient(patients);
                    break;

                case 3:
                    handleGetPatient(patients);
                    break;

                case 4:
                    handleRemovePatient(patients);
                    break;

                case 5:
                    listPatients(patients);
                    break;

                case 6:
                    handleCheckPatient(patients);
                    break;

                case 7:
                    System.out.println("Total patients: " + patients.size());
                    break;

                case 8:
                    patients.clear();
                    System.out.println("System cleared");
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

    // ---------------- INPUT HANDLERS (UI ONLY) ----------------

    private static void handleAddPatient(Map<Integer, Patient5> patients) {

        System.out.print("Enter Patient ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Age: ");
        int age = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Disease: ");
        String disease = sc.nextLine();

        boolean added = addPatient(patients, new Patient5(id, name, age, disease));

        if (added) {
            System.out.println("Patient added successfully");
        } else {
            System.out.println("Patient ID already exists");
        }
    }

    private static void handleUpdatePatient(Map<Integer, Patient5> patients) {

        System.out.print("Enter Patient ID to update: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter New Name: ");
        String name = sc.nextLine();

        System.out.print("Enter New Age: ");
        int age = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter New Disease: ");
        String disease = sc.nextLine();

        boolean updated = updatePatient(patients, id, name, age, disease);

        System.out.println(updated ? "Patient updated" : "Patient not found");
    }

    private static void handleGetPatient(Map<Integer, Patient5> patients) {

        System.out.print("Enter Patient ID: ");
        int id = sc.nextInt();

        Patient5 patient = getPatient(patients, id);

        System.out.println(patient != null ? patient : "Patient not found");
    }

    private static void handleRemovePatient(Map<Integer, Patient5> patients) {

        System.out.print("Enter Patient ID: ");
        int id = sc.nextInt();

        boolean removed = removePatient(patients, id);

        System.out.println(removed ? "Patient removed" : "Patient not found");
    }

    private static void handleCheckPatient(Map<Integer, Patient5> patients) {

        System.out.print("Enter Patient ID: ");
        int id = sc.nextInt();

        System.out.println("Exists: " + patients.containsKey(id));
    }

    // ---------------- LOGIC METHODS (NO INPUT HERE) ----------------

    private static boolean addPatient(Map<Integer, Patient5> patients, Patient5 patient) {

        if (patients.containsKey(patient.id)) {
            return false;
        }

        patients.put(patient.id, patient);
        return true;
    }

    private static boolean updatePatient(
            Map<Integer, Patient5> patients,
            int id,
            String name,
            int age,
            String disease) {

        Patient5 patient = patients.get(id);
        if (patient == null) {
            return false;
        }

        patient.name = name;
        patient.age = age;
        patient.disease = disease;
        return true;
    }

    private static Patient5 getPatient(Map<Integer, Patient5> patients, int id) {
        return patients.get(id);
    }

    private static boolean removePatient(Map<Integer, Patient5> patients, int id) {
        return patients.remove(id) != null;
    }

    private static void listPatients(Map<Integer, Patient5> patients) {

        if (patients.isEmpty()) {
            System.out.println("No patients available");
            return;
        }

        for (Patient5 patient : patients.values()) {
            System.out.println(patient);
        }
    }
  
}
