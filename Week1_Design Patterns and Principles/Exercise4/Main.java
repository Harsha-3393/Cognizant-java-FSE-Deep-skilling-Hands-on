public class Main {
    public static void main(String[] args) {

        PaymentProcessor payPalProcessor =
                new PayPalAdapter(new PayPalGateway());

        PaymentProcessor stripeProcessor =
                new StripeAdapter(new StripeGateway());

        payPalProcessor.processPayment(1000.0);
        stripeProcessor.processPayment(2000.0);
    }
}