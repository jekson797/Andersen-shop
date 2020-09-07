package by.andersenlab.shop.commands.shop_commands;

import by.andersenlab.shop.products.Product;

import java.util.Set;

public class AddProductCommand implements ProductCommand {

    @Override
    public void execute(Product product, Set<Product> products) {
        products.add(product);
        System.out.println("Добавление продукта завершено");
    }
}
