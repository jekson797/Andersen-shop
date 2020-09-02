package by.andersenlab.shop.commands;

import by.andersenlab.shop.product.Product;

import java.util.Set;

public class RemoveProductCommand implements ProductCommand {

    @Override
    public void execute(Product product, Set<Product> products) {
        products.remove(product);
    }
}
