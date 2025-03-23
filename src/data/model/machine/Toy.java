package data.model.machine;

import data.abs.Play;
import data.abs.Product;
import util.Utils;

public class Toy implements Play, Product {
    private final String name;
    private final int price;
    private int amount;

    public Toy(String name, int price, int amount) {
        this.name = name;
        this.price = price;
        this.amount = amount;
    }

    @Override
    public void play() {
        Utils.message.println(" 가지고 놀기! ");
    }

    @Override
    public String type() {
        return "장난감";
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
