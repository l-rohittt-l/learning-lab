package rohit_sawant.day5.onlinePaymentSystem;

@FunctionalInterface
public interface PaymentValidator {
    boolean validate(double amount);
}

