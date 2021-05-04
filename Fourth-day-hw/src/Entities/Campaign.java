package Entities;

public class Campaign {
    private int id;
    private String name;
    private String info;
    private int discount_amount;

    public Campaign(int id,String name,String info, int discount_amount) {
        this.id = id;
        this.name = name;
        this.info = info;
        this.discount_amount = discount_amount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public int getDiscount_amount() {
        return discount_amount;
    }

    public void setDiscount_amount(int discount_amount) {
        this.discount_amount = discount_amount;
    }
}
