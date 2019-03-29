import java.util.HashMap;
import java.util.Iterator;

public class Order {
    private int id;
    private Customer c;
    private String status;
    private int price;
    private HashMap<Good, Integer> goods;

    public Order(int id, Customer c){
        this.id = id;
        this.c = c;
        price = 0;
        status = "pending";
        goods = new HashMap<>();
    }

    public int getAmount() {
        int amount = 0;
        for (Integer key : goods.values()){
            amount += key;
        }
        return amount;
    }

    public int getPrice() {
        return price;
    }

    public int getId() {
        return id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void addItem(Good good, int amount){
        goods.put(good, amount);
    }

    public void removeItem(Good good){
        goods.remove(good);
    }

    public HashMap<Good, Integer> getItems() {
        return goods;
    }

    public int calculatePrice(){
        for (Good key : goods.keySet()){
            price += key.getPrice() * goods.get(key);
        }
        return price;
    }

    public void addDiscount(Discount discount){
        price = price - (price*(discount.getPercentage()/100));
    }
}
