package by.andersenlab.shop.commands;

import by.andersenlab.shop.product.Product;

import java.util.Set;

public class AddProductCommand implements ProductCommand {

    @Override
    public void execute(Product product, Set<Product> products) {
        products.add(product);
    }
}
