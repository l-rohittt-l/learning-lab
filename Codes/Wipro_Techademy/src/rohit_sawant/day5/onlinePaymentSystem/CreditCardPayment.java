package rohit_sawant.day5.onlinePaymentSystem;

public class CreditCardPayment extends Payment {

    public CreditCardPayment(double amount) {
        super(amount);
    }

    @Override
    public void processPayment() {
        System.out.println("Processing Credit Card payment of ₹" + amount);
    }
}
