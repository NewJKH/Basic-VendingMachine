package data.model.user;

public class User {
    private final String username;
    private int balance;
    private Inventory inventory;

    public User(String username, int balance, Inventory inventory) {
        this.username = username;
        this.balance = balance;
        this.inventory = inventory;
    }

    public String getUsername() {
        return username;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }
}
