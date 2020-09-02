package by.andersenlab.shop.commands;

import by.andersenlab.shop.product.Product;

import java.util.Set;

public interface ReturnProductsCommand {

    Set<Product> execute(Set<Product> products);
}
