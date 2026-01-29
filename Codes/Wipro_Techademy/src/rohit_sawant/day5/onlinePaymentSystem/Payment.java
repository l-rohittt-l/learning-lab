package rohit_sawant.day5.onlinePaymentSystem;

public abstract class Payment {

    protected double amount;

    public Payment(double amount) {
        this.amount = amount;
    }

    // Abstract method → must be overridden
    public abstract void processPayment();
}

