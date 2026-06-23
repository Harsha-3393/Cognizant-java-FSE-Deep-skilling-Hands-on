public class Main {
    public static void main(String[] args) {

        StockMarket stockMarket = new StockMarket();

        Observer mobileUser = new MobileApp("Harsha");
        Observer webUser = new WebApp("Admin");

        stockMarket.registerObserver(mobileUser);
        stockMarket.registerObserver(webUser);

        System.out.println("Stock Price Changed:");

        stockMarket.setStock("TCS", 4200.50);

        System.out.println();

        stockMarket.setStock("Infosys", 1650.75);

        System.out.println();

        stockMarket.deregisterObserver(webUser);

        System.out.println("After removing Web Observer:");

        stockMarket.setStock("Wipro", 280.25);
    }
}