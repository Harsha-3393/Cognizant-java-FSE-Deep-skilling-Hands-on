import java.util.Scanner;

// Defining Order class
class Order {
    int orderId;
    String customerName;
    double totalPrice;

    // Constructor
    public Order(int orderId, String customerName, double totalPrice) {
        this.orderId = orderId;
        this.customerName = customerName;
        this.totalPrice = totalPrice;
    }

    @Override
    public String toString() {
        return "OrderID: " + orderId +
               ", Customer: " + customerName +
               ", Total Price: $" + totalPrice;
    }
}

public class OrderSorting {

    // Bubble Sort
    public static void bubbleSort(Order[] orders) {
        int n = orders.length;

        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {

                if (orders[j].totalPrice > orders[j + 1].totalPrice) {

                    Order temp = orders[j];
                    orders[j] = orders[j + 1];
                    orders[j + 1] = temp;
                }
            }
        }
    }

    // Swap Method
    public static void swap(Order[] orders, int i, int j) {
        Order temp = orders[i];
        orders[i] = orders[j];
        orders[j] = temp;
    }

    // Quick Sort
    public static void quickSort(Order[] orders, int left, int right) {

        if (left >= right)
            return;

        int pivotIndex = (left + right) / 2;
        double pivotValue = orders[pivotIndex].totalPrice;

        swap(orders, left, pivotIndex);

        int last = left;

        for (int i = left + 1; i <= right; i++) {

            if (orders[i].totalPrice < pivotValue) {
                last++;
                swap(orders, last, i);
            }
        }

        swap(orders, left, last);

        quickSort(orders, left, last - 1);
        quickSort(orders, last + 1, right);
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of orders: ");
        int n = scanner.nextInt();
        scanner.nextLine();

        Order[] orders = new Order[n];

        // Input Orders
        for (int i = 0; i < n; i++) {

            System.out.println("\nEnter details for Order " + (i + 1));

            System.out.print("Order ID: ");
            int orderId = scanner.nextInt();
            scanner.nextLine();

            System.out.print("Customer Name: ");
            String customerName = scanner.nextLine();

            System.out.print("Total Price: ");
            double totalPrice = scanner.nextDouble();
            scanner.nextLine();

            orders[i] = new Order(orderId, customerName, totalPrice);
        }

        // Display Unsorted Orders
        System.out.println("\nUnsorted Orders:");

        for (Order order : orders) {
            System.out.println(order);
        }

        // Bubble Sort
        bubbleSort(orders);

        System.out.println("\nOrders Sorted using Bubble Sort:");

        for (Order order : orders) {
            System.out.println(order);
        }

        // Quick Sort
        quickSort(orders, 0, orders.length - 1);

        System.out.println("\nOrders Sorted using Quick Sort:");

        for (Order order : orders) {
            System.out.println(order);
        }

        scanner.close();
    }
}