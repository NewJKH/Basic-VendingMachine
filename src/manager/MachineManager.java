package manager;

import data.abs.Product;

public class MachineManager {


    public void withdraw(Product product, int value) {
        product.setAmount(product.getAmount()-value);
    }
}
