import java.util.HashMap;

public class Shop {
    private String name;
    private int income;

    public Shop(String name){

    }

    public void addCustomer(Customer c){

    }

    public Customer[] getCustomers(){
        return customers;
    }

    public void addRepository(Repository r){

    }

    public Repository[] getRepositories(){
        return repositories;
    }

    public int getIncome(){
        return income;
    }

    public void setIncome(int income){
        this.income = income;
    }

    public void addGood(Good g){

    }

    public void increamentGood(Good g, int amount){

    }

    public Good[] getGoods(){
        return goods;
    }

    public void addDiscount(Discount d, Customer c){

    }

    public HashMap<Good, Integer> getItemSold(){

    }

    public void addDiscount(Discount discount){

    }
}
