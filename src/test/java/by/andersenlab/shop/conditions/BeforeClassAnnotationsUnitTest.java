package by.andersenlab.shop.conditions;

import by.andersenlab.shop.products.GameConsoleProduct;
import by.andersenlab.shop.products.Product;
import org.junit.BeforeClass;

public class BeforeClassAnnotationsUnitTest {

    private static Product product;

    @BeforeClass
    public static void setup() {
        product = new GameConsoleProduct.GameConsoleBuilder().build();
    }

    protected Product getProduct() {
        return product;
    }
}
