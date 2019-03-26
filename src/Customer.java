import java.util.ArrayList;

public class Customer {
    private String name;
    private int id;
    private int balance;
    private ArrayList<Order> orders;
    private ArrayList<Order> pendingOrders;
    private ArrayList<Order> submittedOrders;

    public Customer(String name, int id) {
        this.name = name;
        this.id = id;
        orders = new ArrayList<>();
        pendingOrders = new ArrayList<>();
        submittedOrders = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public void addOrder(Order order){
        orders.add(order);
        pendingOrders.add(order);
    }

    public ArrayList<Order> getTotalOrders(){
        return orders;
    }

    public ArrayList<Order> getPendingOrders(){
        return pendingOrders;
    }

    public ArrayList<Order> getSubmittedOrders(){
        return submittedOrders;
    }

    public void submitOrder(Order order){
        pendingOrders.remove(order);
        submittedOrders.add(order);
    }
}
