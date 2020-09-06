package by.andersenlab.shop;

import by.andersenlab.shop.commands.shop_commands.ProductCommand;
import by.andersenlab.shop.commands.shop_commands.ReturnProductsCommand;
import by.andersenlab.shop.products.Product;

import java.util.HashSet;
import java.util.Set;

public class Shop {

    private Set<Product> products = new HashSet<>();

    public void processProduct(ProductCommand command, Product product) {
        command.execute(product, products);
    }

    public Set<Product> processReturnProducts(ReturnProductsCommand command) {
        return command.execute(products);
    }
}
