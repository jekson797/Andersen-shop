package by.andersenlab.shop.commands;

import by.andersenlab.shop.products.Product;

import java.util.Set;

public interface ReturnProductsCommand {

    Set<Product> execute(Set<Product> products);
}
