import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

// Product Class
class Product {
    int productId;
    String productName;
    String category;

    public Product(int productId, String productName, String category) {
        this.productId = productId;
        this.productName = productName;
        this.category = category;
    }

    @Override
    public String toString() {
        return "Product ID: " + productId +
               ", Product Name: " + productName +
               ", Category: " + category;
    }
}

public class ProductSearch {

    // Linear Search
    public static Product linearSearch(Product[] products, int productId) {
        for (Product product : products) {
            if (product.productId == productId) {
                return product;
            }
        }
        return null;
    }

    // Binary Search
    public static Product binarySearch(Product[] products, int productId) {
        int left = 0;
        int right = products.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (products[mid].productId == productId) {
                return products[mid];
            }

            if (products[mid].productId < productId) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return null;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of products: ");
        int n = sc.nextInt();
        sc.nextLine();

        Product[] products = new Product[n];

        // Input products
        for (int i = 0; i < n; i++) {

            System.out.println("\nEnter details of Product " + (i + 1));

            System.out.print("Product ID: ");
            int id = sc.nextInt();
            sc.nextLine();

            System.out.print("Product Name: ");
            String name = sc.nextLine();

            System.out.print("Category: ");
            String category = sc.nextLine();

            products[i] = new Product(id, name, category);
        }

        // Sort for Binary Search
        Arrays.sort(products, new Comparator<Product>() {
            public int compare(Product a, Product b) {
                return Integer.compare(a.productId, b.productId);
            }
        });

        // Search Product
        System.out.print("\nEnter Product ID to search: ");
        int searchId = sc.nextInt();

        // Linear Search
        Product linearResult = linearSearch(products, searchId);

        if (linearResult != null) {
            System.out.println("\nProduct Found using Linear Search:");
            System.out.println(linearResult);
        } else {
            System.out.println("\nProduct Not Found using Linear Search");
        }

        // Binary Search
        Product binaryResult = binarySearch(products, searchId);

        if (binaryResult != null) {
            System.out.println("\nProduct Found using Binary Search:");
            System.out.println(binaryResult);
        } else {
            System.out.println("\nProduct Not Found using Binary Search");
        }

        sc.close();
    }
}