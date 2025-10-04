
public class OrderSave {
    private static String databaseTarget;

    public OrderSave() {
        //default constructor
        this.databaseTarget = "<Some Path to a Database>";
    }

    //constructor for passing in a pretend database path
    public OrderSave(String databaseTarget) {
        //constructor
        this.databaseTarget = databaseTarget;
    }


    public void saveOrdersToDatabase(OrderManage Manager) {
        // Fake database save
        System.out.printf("Pretending to connect to %s%n", databaseTarget);

        // Iterate over each Product to simulate individual INSERT operations.
        for (Product p : Manager.getOrders()) {
            // Print a generated SQL INSERT statement using the product's fields.
            System.out.printf("INSERT INTO orders VALUES('%s', %.2f, %.2f)%n", p.productName(), p.retailCost(), p.wholesaleCost());
        }
    }


}
   