package boot;

import data.model.machine.Drink;
import data.model.machine.Food;
import data.model.machine.Machine;
import data.model.machine.Toy;
import data.model.user.Inventory;
import data.model.user.User;
import util.Utils;

import java.util.HashMap;
import java.util.List;

public class BootMachine {
    /**
     * @msg 간단한 추가입니다.
     * @see data.abs.Product 클레스만 추상메서드로 추가한다면 뭐든지 추가할 수 있습니다.
     */
    public Machine createMachine() {
        return new Machine(List.of(
                Utils.productFactory.createProduct(Drink.class,"콜라",100,5),
                Utils.productFactory.createProduct(Drink.class,"사이다",300,10),
                Utils.productFactory.createProduct(Drink.class,"식혜",500,15),

                Utils.productFactory.createProduct(Food.class,"짜장면",1000,4),
                Utils.productFactory.createProduct(Food.class,"파스타",2300,8),
                Utils.productFactory.createProduct(Food.class,"불고기",3500,12),

                Utils.productFactory.createProduct(Toy.class,"플스5",10000,1),
                Utils.productFactory.createProduct(Toy.class,"닌텐도",30000,2),
                Utils.productFactory.createProduct(Toy.class,"컴퓨터",50000,3)));
    }

    /**
     * @return 간단한 내 정보 출력
     */
    public User createUser() {
        return new User("장군호",100000, new Inventory(new HashMap<>()));
    }
}
