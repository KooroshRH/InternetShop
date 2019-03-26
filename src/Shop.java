import java.util.ArrayList;
import java.util.HashMap;

public class Shop {
    private String name;
    private int income;
    private HashMap<Good, Integer> mapGoods;
    private ArrayList<Customer> customers;
    private ArrayList<Repository> repositories;
    private ArrayList<Good> goods;
    private ArrayList<Discount> discounts;

    public Shop(String name){
        this.name = name;
        income = 0;
        mapGoods = new HashMap<>();
        customers = new ArrayList<>();
        repositories = new ArrayList<>();
        goods = new ArrayList<>();
        discounts = new ArrayList<>();
    }

    public void addCustomer(Customer c){
        customers.add(c);
    }

    public ArrayList<Customer> getCustomers(){
        return customers;
    }

    public void addRepository(Repository r){
        repositories.add(r);
    }

    public ArrayList<Repository> getRepositories(){
        return repositories;
    }

    public int getIncome(){
        return income;
    }

    public void setIncome(int income){
        this.income = income;
    }

    public void addGood(Good g){
        goods.add(g);
        mapGoods.put(g, 0);
    }

    public void increamentGood(Good g, int amount){
        mapGoods.replace(g, mapGoods.get(g)+amount);
        for (Repository x : repositories){
            if (x.getFreeCapacity() > amount){
                x.addGood(g, amount);
            }
    }
    }

    public ArrayList<Good> getGoods(){
        return goods;
    }

    public void addDiscount(Discount d, Order o){
        o.addDiscount(d);
    }

    public HashMap<Good, Integer> getItemSold(){
        return mapGoods;
    }

    public void addDiscount(Discount discount){
        discounts.add(discount);
    }
}
