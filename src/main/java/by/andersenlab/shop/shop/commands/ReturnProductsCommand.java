package by.andersenlab.shop.shop.commands;

import by.andersenlab.shop.shop.product.Product;

import java.util.Set;

public interface ReturnProductsCommand {

    Set<Product> execute(Set<Product> products);
}
