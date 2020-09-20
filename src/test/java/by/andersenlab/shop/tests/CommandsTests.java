package by.andersenlab.shop.tests;

import by.andersenlab.shop.commands.*;
import by.andersenlab.shop.conditions.BeforeClassAnnotationsUnitTest;
import by.andersenlab.shop.products.Product;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

public class CommandsTests extends BeforeClassAnnotationsUnitTest {

    @Test
    public void addProductCommandTest() {
        Set<Product> products = new HashSet<>();
        int productsSizeBeforeAdding = products.size();
        ProductCommand command = new AddProductCommand();
        command.execute(getProduct(), products);
        int productsSizeAfterAdding = products.size();
        Assert.assertTrue(productsSizeBeforeAdding < productsSizeAfterAdding);
    }

    @Test
    public void removeProductCommandTest() {
        Set<Product> products = new HashSet<>();
        products.add(getProduct());
        int productsSizeBeforeRemoving = products.size();
        ProductCommand command = new RemoveProductCommand();
        command.execute(getProduct(), products);
        int productsSizeAfterRemoving = products.size();
        Assert.assertTrue(productsSizeBeforeRemoving > productsSizeAfterRemoving);
    }

    @Test
    public void getAllProductsCommandTest() {
        Set<Product> products = new HashSet<>();
        products.add(getProduct());
        int productsExpectedSize = products.size();
        ReturnProductsCommand command = new GetAllProductsCommand();
        int productsActualSize = command.execute(products).size();
        Assert.assertEquals(productsExpectedSize, productsActualSize);
    }
}
