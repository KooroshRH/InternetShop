import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        Shop shop = new Shop("Asghar's Shop");
        ArrayList<Order> orders = new ArrayList<>();
        while(true){
            String command = input.nextLine();
            if (command.equals("add")){
                String newCommand = input.nextLine();
                if (newCommand.equals("customer")){
                    int id = input.nextInt();
                    input.nextLine();
                    String name = input.nextLine();
                    shop.addCustomer(new Customer(name, id));
                } else if (newCommand.equals("good")){
                    int id = input.nextInt();
                    String name = input.nextLine();
                    input.nextLine();
                    int price = input.nextInt();
                    int amount = input.nextInt();
                    Good good = new Good(name, id, price);
                    shop.addGood(good);
                    shop.increamentGood(good, amount);
                } else if (newCommand.equals("repository")){
                    int id = input.nextInt();
                    int capacity = input.nextInt();
                    Repository r = new Repository(id, capacity);
                    shop.addRepository(r);
                } else if (newCommand.equals("order")){
                    int orderId = input.nextInt();
                    int customerId = input.nextInt();
                    ArrayList<Customer> customers = shop.getCustomers();
                    for (Customer customer : customers){
                        if (customer.getId() == customerId){
                            Order newOrder = new Order(orderId, customer);
                            orders.add(newOrder);
                            customer.addOrder(newOrder);
                            break;
                        }
                    }
                } else if (newCommand.equals("balance")){
                    int customerId = input.nextInt();
                    int balance = input.nextInt();
                    ArrayList<Customer> customers = shop.getCustomers();
                    for (Customer customer : customers){
                        if (customer.getId() == customerId){
                            customer.setBalance(customer.getBalance()+balance);
                            break;
                        }
                    }
                } else if (newCommand.equals("item")){
                    int orderId = input.nextInt();
                    int goodId = input.nextInt();
                    int amount = input.nextInt();
                    for (Order order : orders){
                        if (order.getId() == orderId){
                            int key = 0;
                            ArrayList<Good> goods = shop.getGoods();
                            for (Good good : goods){
                                if (good.getId() == goodId){
                                    order.addItem(good, amount);
                                    key = 1;
                                    break;
                                }
                            }
                            if (key == 1){
                                break;
                            }
                        }
                    }
                } else if (newCommand.equals("discount")){
                    int id = input.nextInt();
                    int percent = input.nextInt();
                    shop.addDiscount(new Discount(id, percent));
                }
            } else if (command.equals("report")){
                String newCommand = input.nextLine();
                if (newCommand.equals("customers")){
                    ArrayList<Customer> customers = shop.getCustomers();
                    for (Customer customer : customers){
                        System.out.println(customer.getId() + ", " + customer.getName() + ", " + customer.getBalance() + ", " + customer.getTotalOrders().size() + ", " + customer.getSubmittedOrders().size());
                    }
                } else if (newCommand.equals("repositories")){
                    ArrayList<Repository> repositories = shop.getRepositories();
                    for (Repository repository : repositories){
                        System.out.println(repository.getId() + ", " + repository.getCapacity() + ", " + repository.getFreeCapacity());
                    }
                } else if (newCommand.equals("income")){
                    System.out.println(shop.getIncome());
                }
            } else if (command.equals("remove")){
                String newCommand = input.nextLine();
                if (newCommand.equals("item")){
                    int orderId = input.nextInt();
                    int goodId = input.nextInt();
                    Good good = null;
                    for (Good good1 : shop.getGoods()){
                        if (good1.getId() == goodId){
                            good = good1;
                            break;
                        }
                    }
                    for (Order order : orders){
                        if (order.getId() == orderId){
                            order.removeItem(good);
                        }
                    }
                }
            } else if (command.equals("submit")){
                String newCommand = input.nextLine();
                if (newCommand.equals("order")){
                    int id = input.nextInt();
                    ArrayList<Customer> customers = shop.getCustomers();
                    for (Customer customer : customers){
                        ArrayList<Order> orders1 = customer.getPendingOrders();
                        for (Order order : orders1) {
                            if (order.getId() == id) {
                                order.calculatePrice();
                                if (customer.getBalance() >= order.getPrice()) {
                                    customer.submitOrder(order);
                                    customer.setBalance(customer.getBalance()-order.getPrice());
                                    shop.setIncome(shop.getIncome()+order.getPrice());
                                    
                                }
                                break;
                            }
                        }
                    }
                }
            } else if (command.equals("terminate")){
                break;
            }
        }
    }
}
