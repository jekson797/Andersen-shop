package by.andersenlab.shop.shop.commands;

import by.andersenlab.shop.shop.product.Product;

import java.util.Set;

public class GetAllProductsCommand implements ReturnProductsCommand {

    @Override
    public Set<Product> execute(Set<Product> products) {
        return products;
    }
}
