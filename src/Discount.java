public class Discount {
    private int id;
    private int percent;
    private Order order;

    public Discount(int id, int percent){
        this.id = id;
        this.percent = percent;
    }

    public int getId(){
        return id;
    }

    public void setOrder(Order order){
        this.order = order;
    }

    public Order getOrder() {
        return order;
    }

    public int getPercentage() {
        return percent;
    }
}
