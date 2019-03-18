import java.util.HashMap;

public class Repository {
    private int id;
    private int capacity;
    private int freeCapacity;
    private HashMap<Good, Integer> goods;

    public Repository(int id, int capacity){
        this.id = id;
        this.capacity = capacity;
        freeCapacity = capacity;
    }

    public int getId() {
        return id;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getFreeCapacity() {
        return freeCapacity;
    }

    public HashMap<Good, Integer> getGoods() {
        return goods;
    }

    public void addGood(Good g, int amount){
        if (goods.containsKey(g)){
            goods.replace(g, goods.get(g)+amount);
        } else {
            goods.put(g, amount);
        }
        freeCapacity -= amount;
    }

    public void removeGood(Good g, int amount){
        goods.replace(g, goods.get(g)-amount);
        freeCapacity += amount;
    }
}
