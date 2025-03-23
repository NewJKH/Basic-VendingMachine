package data.model.machine;

import data.abs.Consum;
import data.abs.Product;
import util.Utils;

public class Drink implements Consum, Product {
    private final String name;
    private final int price;
    private int amount;

    public Drink(String name, int price, int amount) {
        this.name = name;
        this.price = price;
        this.amount = amount;
    }

    @Override
    public void eat() {
        Utils.message.println(" 벌컥벌컥 ");
    }

    @Override
    public String type() {
        return "음료수";
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getPrice() {
        return price;
    }

    @Override
    public int getAmount() {
        return amount;
    }

    @Override
    public void setAmount(int amount) {
        this.amount = amount;
    }
}
