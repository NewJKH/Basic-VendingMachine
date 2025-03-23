package controller;

import data.model.user.User;
import manager.UserManager;
import service.UserService;
import util.Utils;
import util.validator.MachineValidator;

public class UserController {
    private final MachineValidator validator;
    private final UserService service;
    private final UserManager manager;

    public UserController(MachineValidator validator) {
        this.validator = validator;
        this.manager = new UserManager();
        this.service = new UserService();
    }

    public void start() {
        User user = service.getUser();
        if ( user == null ) {
            new ScannerController().detect();
            return;
        }
        Utils.message.print(" 번호를 입력해주세요 : ");

        service.command(user);
        select(user);
    }
    private void select(User user){
        int slot = validator.input(Integer.class);

        switch (slot){
            case 1->{
                Utils.message.print(" 추가할 금액을 입력해주세요: ");
                int balance = validator.input(Integer.class);
                manager.addBalance(user,balance);
                start();
            }
            case 2->{
                // 나중에 개발 ㅎㅎ
            }
            default -> new ScannerController().detect();
        }
    }
}
