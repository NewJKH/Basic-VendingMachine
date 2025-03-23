package util.factory;

import data.abs.Product;

import java.lang.reflect.Constructor;

public class ProductFactory {

    public <T extends Product> T createProduct(Class<T> clazz, Object... args) {
        try {
            Constructor<?>[] constructors = clazz.getConstructors();
            for (Constructor<?> constructor : constructors) {
                if (constructor.getParameterCount() == args.length) {
                    return clazz.cast(constructor.newInstance(args));
                }
            }
            throw new IllegalArgumentException("적절한 생성자를 찾을 수 없습니다.");
        } catch (Exception e) {
            throw new RuntimeException("Product 생성 실패", e);
        }
    }
}
