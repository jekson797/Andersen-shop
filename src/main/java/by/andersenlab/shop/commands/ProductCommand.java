package by.andersenlab.shop.commands;

import by.andersenlab.shop.product.Product;

import java.util.Set;

public interface ProductCommand {

    void execute(Product product, Set<Product> products);
}
