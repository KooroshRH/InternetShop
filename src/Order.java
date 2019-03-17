import java.util.HashMap;

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
        for (Integer key : goods.values()){
            price += key;
        }
        return price;
    }

    public void addDiscount(Discount discount){
        price = price - (price*(discount.getPercentage()/100));
    }
}
