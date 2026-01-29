package rohit_sawant.day8;

/* =========================
   SHARED RESOURCE
   ========================= */
class BankAccount {

    private double balance = 10000;

    public synchronized void withdraw(double amount, String channel) {

        System.out.println(channel + " started withdrawal");

        if (balance >= amount) {
            try {
                Thread.sleep(2000); // simulate processing time
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            balance -= amount;
            System.out.println(channel + " withdrawal successful");
            System.out.println("Remaining Balance: ₹" + balance);
        } else {
            System.out.println(channel + " failed: Insufficient balance");
        }

        System.out.println("--------------------------------");
    }
}

/* =========================
   SIMULATION
   ========================= */
public class BankSimulation {

    public static void main(String[] args) {

        // ONE shared bank account
        BankAccount account = new BankAccount();

        /* =========================
           Different real-world cases
           ========================= */

        Thread atm = new Thread(() ->
                account.withdraw(5000, "ATM"));

        Thread mobile = new Thread(() ->
                account.withdraw(5000, "Mobile Banking"));

        Thread atm2 = new Thread(() ->
                account.withdraw(5000, "ATM-2"));

        Thread browserTab = new Thread(() ->
                account.withdraw(5000, "Browser Tab"));

        Thread upi = new Thread(() ->
                account.withdraw(5000, "UPI Payment"));

        /* =========================
           Start simulations
           ========================= */

        atm.start();
        mobile.start();
        atm2.start();
        browserTab.start();
        upi.start();
    }
}
