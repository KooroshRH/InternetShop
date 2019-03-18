import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        Shop shop = new Shop("Asghar's Shop");
        ArrayList<Order> orders = new ArrayList<>();
        while(true){
            String command = input.nextLine();
            input.nextLine();
            if (command.equals("add")){
                System.out.println(1);
                command = input.nextLine();
                input.nextLine();
                if (command.equals("customer")){
                    int id = input.nextInt();
                    String name = input.nextLine();
                    input.nextLine();
                    shop.addCustomer(new Customer(name, id));
                } else if (command.equals("good")){
                    int id = input.nextInt();
                    String name = input.nextLine();
                    input.nextLine();
                    int price = input.nextInt();
                    int amount = input.nextInt();
                    Good good = new Good(name, id, price);
                    shop.addGood(good);
                    shop.increamentGood(good, amount);
                } else if (command.equals("repository")){
                    System.out.println(2);
                    int id = input.nextInt();
                    int capacity = input.nextInt();
                    shop.addRepository(new Repository(id, capacity));
                    System.out.println(3);
                } else if (command.equals("order")){
                    int orderId = input.nextInt();
                    int customerId = input.nextInt();
                    ArrayList<Customer> customers = shop.getCustomers();
                    for (Customer customer : customers){
                        if (customer.getId() == customerId){
                            orders.add(new Order(orderId, customer));
                            customer.addOrder(new Order(orderId, customer));
                            break;
                        }
                    }
                } else if (command.equals("balance")){
                    int customerId = input.nextInt();
                    int balance = input.nextInt();
                    ArrayList<Customer> customers = shop.getCustomers();
                    for (Customer customer : customers){
                        if (customer.getId() == customerId){
                            customer.setBalance(balance);
                            break;
                        }
                    }
                } else if (command.equals("item")){
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
                } else if (command.equals("discount")){
                    int id = input.nextInt();
                    int percent = input.nextInt();
                    shop.addDiscount(new Discount(id, percent));
                }
            } else if (command.equals("report")){
                System.out.println(4);
                command = input.nextLine();
                input.nextLine();
                if (command.equals("customers")){
                    ArrayList<Customer> customers = shop.getCustomers();
                    for (Customer customer : customers){
                        System.out.println(customer.getId() + ", " + customer.getName() + ", " + customer.getBalance() + ", " + customer.getTotalOrders().size() + ", " + customer.getSubmittedOrders().size());
                    }
                } else if (command.equals("repositories")){
                    System.out.println(5);
                    ArrayList<Repository> repositories = shop.getRepositories();
                    for (Repository repository : repositories){
                        System.out.println(repository.getId() + ", " + repository.getCapacity() + ", " + repository.getFreeCapacity());
                    }
                } else if (command.equals("income")){
                    ArrayList<Customer> customers = shop.getCustomers();
                    int income = 0;
                    for (Customer customer : customers){
                        ArrayList<Order> submittedOrders = customer.getSubmittedOrders();
                        for (Order order : submittedOrders){
                            income += order.calculatePrice();
                        }
                    }
                    System.out.println(income);
                }
            } else if (command.equals("remove")){
                command = input.nextLine();
                input.nextLine();
                if (command.equals("item")){
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
                command = input.nextLine();
                input.nextLine();
                if (command.equals("order")){
                    int id = input.nextInt();

                }
            } else if (command.equals("terminate")){
                break;
            }
        }
    }
}
