package service;

import data.abs.Product;
import data.registry.Registry;
import util.Utils;

import java.util.ArrayList;

public class MachineService {

    public void view() {
        Registry registry = Registry.getInstance();
        String line = "%-10s %-10s %-10s %-10s%n";
        Utils.message.printf(line, "카테고리","상품명","갯수","가격");

        registry.getMachine()
                .products()
                .forEach(product -> {
                    Utils.message.printf(line,product.type(),product.getName(),Utils.unit.intUnit(product.getAmount()),Utils.unit.intUnit(product.getPrice()));
                });
    }

    public void command() {
        ArrayList<String> lore = new ArrayList<>();
        lore.add("1. 구매");
        lore.add("2. 뒤로가기");
        Utils.message.textBox(lore);
    }

    public void info(Product product) {
        ArrayList<String> lore = new ArrayList<>();
        lore.add(" 카테고리: "+product.type());
        lore.add(" 상품: "+product.getName());
        lore.add(" 가격: "+Utils.unit.intUnit(product.getPrice()));
        lore.add(" 잔여: "+Utils.unit.intUnit(product.getAmount()));
        Utils.message.textBox(lore);
    }

    /**
     * @param productName < 상품명
     * @return false/true
     * 찾으면 true
     * 못찾으면 false
     */
    public boolean contain(String productName) {
        Registry registry = Registry.getInstance();
        return registry.getMachine()
                .products()
                .stream()
                .anyMatch(product -> product.getName().equals(productName));
    }

    /**
     * @param productName < 상품명
     * @return Product < 상품
     */
    public Product getProduct(String productName){
        Registry registry = Registry.getInstance();
        return registry.getMachine()
                .products()
                .stream()
                .filter(product -> product.getName().equals(productName))
                .findFirst().orElse(null);
    }

}
