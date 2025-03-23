package service;

import data.abs.Product;
import data.model.user.User;
import data.registry.Registry;
import util.Utils;
import util.message.Message;

import java.util.ArrayList;
import java.util.Map;

public class UserService {

    public void command(User user) {
        Message message = Utils.message;
        message.println("");
        ArrayList<String> lore = new ArrayList<>();
        lore.add("  이름 : "+user.getUsername());
        lore.add("  잔고 : "+Utils.unit.intUnit(user.getBalance()));
        if ( !user.getInventory().hold().isEmpty() ) {
            for (Map.Entry<Product,Integer> entry : user.getInventory().hold().entrySet() ){
                Product product = entry.getKey();
                int ea = entry.getValue();
                lore.add(product.type()+" "+product.getName()+" "+Utils.unit.intUnit(ea));
            }
        }else{
            lore.add(" 가방이 비었다... ");
        }
        lore.add("1. 계좌에 추가할 금액 입력");
        lore.add("2. 가방에 물품 사용");
        lore.add("3. 뒤로가기");
        message.textBox(lore);
    }

    public boolean checkBalance(User user, int totalPrice) {
        return user.getBalance() >= totalPrice;
    }
    public User getUser() {
        return Registry.getInstance()
                .getUser();
    }
}
