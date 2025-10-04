import java.util.*;

public class OrderManage{
    private final List<Product> orders = new ArrayList<>();

    public void addOrder(Product product) {
        //Adds a product to the current collection of orders.
        orders.add(product);
    }


    public void removeOrder(Product product) {
        //Remove the first occurrence of the given Product from the orders list.
        orders.remove(product);
    }


    public List<Product> getOrders() {
        return orders;
    }
}
