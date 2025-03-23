package util.validator;

import util.Utils;

import java.util.Scanner;

public class MachineValidator {

    private final Scanner scanner;

    public MachineValidator(Scanner scanner) {
        this.scanner = scanner;
    }

    public <T> T input(Class<T> type) {
        while (true) {
            try {
                String value = scanner.next();
                if (type == Integer.class) {
                    return type.cast(Integer.parseInt(value));
                } else if (type == Double.class) {
                    return type.cast(Double.parseDouble(value));
                } else if (type == Boolean.class) {
                    return type.cast(Boolean.parseBoolean(value));
                } else if (type == String.class) {
                    return type.cast(value);
                }
                throw new IllegalArgumentException("지원되지 않는 타입: " + type.getSimpleName());
            } catch (Exception e) {
                Utils.message.print(" 값이 잘못 입력되었습니다. ");
                Utils.message.print(" 다시 입력해주세요. ");
                scanner.nextLine();
            }
        }
    }
}
