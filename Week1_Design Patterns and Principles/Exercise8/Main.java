public class Main {
    public static void main(String[] args) {

        PaymentContext context = new PaymentContext();

        // Credit Card Payment
        context.setPaymentStrategy(
            new CreditCardPayment("1234-5678-9012")
        );
        context.executePayment(5000);

        // PayPal Payment
        context.setPaymentStrategy(
            new PayPalPayment("user@gmail.com")
        );
        context.executePayment(2500);
    }
}