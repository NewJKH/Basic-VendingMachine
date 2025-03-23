package data.abs;

public interface Product {
    String type();
    String getName();
    int getPrice();
    int getAmount();
    void setAmount(int amount);
}
