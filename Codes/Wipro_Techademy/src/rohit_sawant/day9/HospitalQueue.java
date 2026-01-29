package rohit_sawant.day9;

import java.util.LinkedList;

//This class represents a single patient
class Patient {
 String name;
 int age;
 String issue;

 // Constructor to store patient details
 Patient(String name, int age, String issue) {
     this.name = name;
     this.age = age;
     this.issue = issue;
 }

 // Converts patient object into readable text while printing
 @Override
 public String toString() {
     return "Name: " + name + ", Age: " + age + ", Issue: " + issue;
 }
}

public class HospitalQueue {

 // LinkedList is used to maintain patient order (queue behavior)
 private LinkedList<Patient> queue = new LinkedList<>();

 // Adds a normal OPD patient at the end of the queue
 public void addPatient(Patient p) {
     queue.addLast(p);
 }

 // Adds an emergency patient at the beginning of the queue
 public void addEmergencyPatient(Patient p) {
     queue.addFirst(p);
 }

 // Removes the first patient after treatment
 public Patient removePatient() {
     if (queue.isEmpty())
         return null;   // No patient to remove
     return queue.removeFirst();
 }

 // Displays all patients in the queue in arrival order
 public void viewAllPatients() {
     if (queue.isEmpty()) {
         System.out.println("No patients in queue");
         return;
     }

     // Loop through each patient and print details
     for (Patient p : queue) {
         System.out.println(p);
     }
 }

 // Searches a patient by name
 public void searchPatient(String name) {
     for (Patient p : queue) {
         // Comparing names ignoring case
         if (p.name.equalsIgnoreCase(name)) {
             System.out.println("Found: " + p);
             return;
         }
     }
     System.out.println("Patient not found");
 }

 // Displays the first patient in the queue
 public void firstPatient() {
     if (!queue.isEmpty())
         System.out.println("First patient: " + queue.getFirst());
 }

 // Displays the last patient in the queue
 public void lastPatient() {
     if (!queue.isEmpty())
         System.out.println("Last patient: " + queue.getLast());
 }

 public static void main(String[] args) {

     // Creating hospital queue object
     HospitalQueue hq = new HospitalQueue();

     // Adding normal OPD patients
     hq.addPatient(new Patient("Ravi", 30, "Fever"));
     hq.addPatient(new Patient("Asha", 25, "Cold"));

     // Adding emergency patient (goes first)
     hq.addEmergencyPatient(new Patient("Kiran", 40, "Accident"));

     // Viewing all patients
     hq.viewAllPatients();

     // Searching for a patient by name
     hq.searchPatient("Asha");

     // Checking first and last patient
     hq.firstPatient();
     hq.lastPatient();

     // Removing the treated patient
     hq.removePatient();

     // Viewing remaining patients
     hq.viewAllPatients();
 }
}
