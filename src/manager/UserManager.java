package manager;

import data.abs.Product;
import data.model.user.User;

import java.util.Map;

public class UserManager {
    public void addBalance(User user,int balance) {
        user.setBalance(user.getBalance()+balance);
    }

    public void withdraw(User user,int totalPrice) {
        user.setBalance(user.getBalance()-totalPrice);
    }

    public void addInventory(User user,Product product, int value) {
        Map<Product,Integer> hold =  user.getInventory().hold();
        if ( hold.containsKey(product)){
            hold.put(product,hold.get(product)+value);
        }else{
            hold.put(product,value);
        }
    }
}
