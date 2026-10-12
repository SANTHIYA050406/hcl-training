
import java.util.*;

public class OrderProcessor {
    static int stock = 10;

    static void processOrder(int quantity)
            throws InsufficientStockException {

        try {
            if (quantity <= 0) {
                throw new InvalidQuantityException(
                        "Quantity must be greater than 0",
                        new IllegalArgumentException(
                                "Received quantity: " + quantity
                        )
                );
            } else if (quantity > stock) {
                throw new InsufficientStockException(
                        "Requested quantity: " + quantity
                                + ", but available stock is: " + stock,
                        new IllegalStateException(
                                "Inventory validation failed"
                        )
                );
            } else {
                stock -= quantity;
                System.out.println("Order successful!");
                System.out.println("Remaining stock: " + stock);
            }

        } catch (InvalidQuantityException | InsufficientStockException e) {
            System.out.println("Order failed: " + e.getMessage());
            throw e;

        } finally {
            System.out.println("Audit: Order processing completed.");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter quantity:");
        int quantity = sc.nextInt();

        try {
            processOrder(quantity);
        } catch (InvalidQuantityException | InsufficientStockException e) {
            System.out.println(
                    "Exception type: " + e.getClass().getSimpleName()
            );
            e.printStackTrace();
        }

        sc.close();
    }
}
