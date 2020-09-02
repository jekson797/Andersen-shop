package by.andersenlab.shop.tests;

import by.andersenlab.shop.conditions.BeforeClassAnnotationsUnitTest;
import by.andersenlab.shop.shop.product.Product;
import org.junit.Assert;
import org.junit.Test;

public class ProductBuilderTests extends BeforeClassAnnotationsUnitTest {

    @Test
    public void createProductTest() {
        Product product = getProduct();
        Assert.assertNotEquals(null, product);
    }
}
