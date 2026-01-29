package rohit_sawant.day5.onlinePaymentSystem;

public class PaymentProcessor {

    public static void main(String[] args) {

        double amount = 1500;

        // Lambda expression for validation
        PaymentValidator validator = amt -> amt > 0 && amt <= 50000;

        if (!validator.validate(amount)) {
            System.out.println("Invalid payment amount");
            return;
        }
        
        Payment payment;

        payment = new CreditCardPayment(amount);
        payment.processPayment();

        payment = new UPIPayment(amount);
        payment.processPayment();
    }
}
