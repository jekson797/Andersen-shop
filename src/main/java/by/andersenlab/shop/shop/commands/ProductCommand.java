package by.andersenlab.shop.shop.commands;

import by.andersenlab.shop.shop.product.Product;

import java.util.Set;

public interface ProductCommand {

    void execute(Product product, Set<Product> products);
}
