
/**
 * A 'record' representing a product with a name, retail cost, and wholesale cost.
 * This class encapsulates product data and provides read-only access via getters.
 *
 * @param productName   Stores the human-readable name of the product.
 * @param retailCost    Holds the price charged to customers for this product.
 * @param wholesaleCost Holds the price the business pays to acquire this product.
 */
record Product(String productName, double retailCost, double wholesaleCost) {
    // No additional methods or fields needed; the record automatically provides
    // constructor, getters, equals, hashCode, and toString methods.
}


/**
 * Manages a collection of Product orders and provides operations to add, remove,
 * persist, and present them. This class contains simple business logic for
 * handling an in-memory order list and demonstrates basic persistence and output.
 */
class OrderProcessor {

    //Helper class references and declaration
    private final OrderManage Manager;
    private final OrderSave Saver;
    private final InvoiceRetail RetailVoice;
    private final InvoiceWholesale WholesaleVoice;

    //default constructor
    public OrderProcessor() {
        Manager = new OrderManage();
        Saver = new OrderSave();
        RetailVoice = new InvoiceRetail();
        WholesaleVoice = new InvoiceWholesale();
    } 

    //constructor for passing in a pretend database path
    public OrderProcessor(String databaseTarget) {
        Manager = new OrderManage();
        Saver = new OrderSave(databaseTarget);
        RetailVoice = new InvoiceRetail();
        WholesaleVoice = new InvoiceWholesale();
    } 

    public void addOrder(Product product) {
        Manager.addOrder(product);
    }

    public void removeOrder(Product product) {
        Manager.removeOrder(product);
    }
    
    public void saveOrdersToDatabase() {
        Saver.saveOrdersToDatabase(Manager);   // Pass the order manager reference
    }

    public void printRetailInvoice() {
        RetailVoice.printRetailInvoice(Manager);  // Pass manager to access order list
    }

    public void printWholesaleInvoice() {
        WholesaleVoice.printWholesaleInvoice(Manager);
    }

}
