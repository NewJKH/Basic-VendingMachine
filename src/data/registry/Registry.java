package data.registry;

import boot.BootMachine;
import data.model.machine.Machine;
import data.model.user.User;

public class Registry {
    public static Registry instance;
    public static Registry getInstance(){
        if (instance == null) {
            instance = new Registry();
        }
        return instance;
    }
    private final Machine machine;
    private final User user;

    public Registry() {
        BootMachine bootMachine = new BootMachine();
        this.machine = bootMachine.createMachine();
        this.user = bootMachine.createUser();
    }

    public Machine getMachine() {
        return machine;
    }

    public User getUser() {
        return user;
    }
}
