package controller;

import data.abs.Product;
import data.model.user.User;
import manager.MachineManager;
import manager.UserManager;
import service.MachineService;
import service.UserService;
import util.Utils;
import util.validator.MachineValidator;

public class MachineController {
    private final MachineValidator validator;
    private final MachineService service;
    private final MachineManager manager;

    public MachineController(MachineValidator validator) {
        this.validator = validator;
        this.manager = new MachineManager();
        this.service = new MachineService();
    }

    public void start() {
        service.view();
        service.command();

        select();
    }
    private void select(){
        int slot = validator.input(Integer.class);
        switch (slot){
            case 1->{
                buyProduct();
                start();
            }
            case 2->{
                new ScannerController().detect();
            }
        }
    }
    public void buyProduct() {
        Utils.message.print(" 구매하려는 상품을 입력해주세요: ");
        String productName = validator.input(String.class);
        if (!service.contain(productName)){
            Utils.message.println(" 상품이 없습니다. ");
            select();
            return;
        }

        Product product = service.getProduct(productName);
        service.info(product);
        int ea = product.getAmount();
        if ( ea <= 0 ){
            Utils.message.println(" 잔여 상품이 없습니다. ");
            select();
            return;
        }

        Utils.message.print(" 구매하려는 갯수를 입력해주세요: ");
        int v = validator.input(Integer.class);
        if ( v > ea ){
            Utils.message.println(" 구매하려는 갯수가 지금 자판기에 있는 갯수보다 많습니다. ");
            select();
            return;
        }

        finalCheck(product, v);
    }

    private void finalCheck(Product product, int value) {
        UserService userService = new UserService();
        User user = userService.getUser();

        int totalPrice = product.getPrice() * value;
        boolean b = userService.checkBalance(user, totalPrice);
        if ( !b ) {
            Utils.message.println(" 돈이 부족합니다. ");
            select();
            return;

        }

        UserManager userManager = new UserManager();
        userManager.withdraw(user,totalPrice);
        userManager.addInventory(user,product,value);

        manager.withdraw(product, value);
        Utils.message.println(" 감사합니다 상품을 구매했습니다. ");
        select();
    }

}
