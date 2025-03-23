package controller;

import util.Utils;
import util.validator.MachineValidator;

import java.util.ArrayList;
import java.util.Scanner;

public class ScannerController {
    public void command() {
        ArrayList<String> lore = new ArrayList<>();
        lore.add("1. 내 정보");
        lore.add("2. 자판기 정보");
        lore.add("3. 종료");

        Utils.message.textBox(lore);
    }
    public void detect(){
        MachineValidator validator = new MachineValidator(new Scanner(System.in));
        command();
        Utils.message.print(" 번호를 입력해주세요 : ");
        int num = validator.input(Integer.class);
        switch (num){
            case 1->{
                UserController controller = new UserController(validator);
                controller.start();
                detect();
            }
            case 2->{
                MachineController controller = new MachineController(validator);
                controller.start();
                detect();
            }
            case 3->{
                // 종료
                return;
            }
            default -> {
                Utils.message.println(" 잘못된 번호가 입력되었습니다. ");
                detect();
            }
        }
    }
}
