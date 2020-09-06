package by.andersenlab.shop.commands.shop_commands;

import by.andersenlab.shop.products.Product;

import java.util.Set;

public class RemoveProductCommand implements ProductCommand {

    @Override
    public void execute(Product product, Set<Product> products) {
        products.remove(product);
    }
}
