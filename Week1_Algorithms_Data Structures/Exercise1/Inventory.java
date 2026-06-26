import java.util.ArrayList;
import java.util.List;

public class Inventory {

    private List<Product> products;

    public Inventory() {
        products = new ArrayList<>();
    }

    // Add Product
    public void addProduct(Product product) {
        products.add(product);
    }

    // Update Product
    public void updateProduct(int productId, String productName,
                              int quantity, double price) {

        for(Product p : products) {
            if(p.getProductId() == productId) {

                p.setProductName(productName);
                p.setQuantity(quantity);
                p.setPrice(price);

                System.out.println("Product Updated");
                return;
            }
        }

        System.out.println("Product Not Found");
    }

    // Delete Product
    public void deleteProduct(int productId) {

        for(Product p : products) {

            if(p.getProductId() == productId) {
                products.remove(p);
                System.out.println("Product Deleted");
                return;
            }
        }

        System.out.println("Product Not Found");
    }

    // Display Products
    public void displayProducts() {

        for(Product p : products) {
            System.out.println(p);
        }
    }

    public static void main(String[] args) {

        Inventory inventory = new Inventory();

        inventory.addProduct(
            new Product(101,"Laptop",10,75000)
        );

        inventory.addProduct(
            new Product(102,"Mouse",50,500)
        );

        inventory.displayProducts();

        inventory.updateProduct(
            101,"Gaming Laptop",8,95000
        );

        inventory.deleteProduct(102);

        System.out.println("\nAfter Operations:");

        inventory.displayProducts();
    }
}