package by.andersenlab.shop.commands.shop_commands;

import by.andersenlab.shop.products.Product;

import java.util.Set;

public class GetAllProductsCommand implements ReturnProductsCommand {

    @Override
    public Set<Product> execute(Set<Product> products) {
        return products;
    }
}
