public class Customer {
    private String name;
    private int id;
    private int balance;

    public Customer(String name, int id) {
        this.name = name;
        this.id = id;
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

    }

    public Order[] getTotalOrders(){
        return orders;
    }

    public Order[] getPendingOrders(){

    }

    public Order[] getSubmittedOrders(){

    }

    public void submitOrder(Order order){

    }
}
