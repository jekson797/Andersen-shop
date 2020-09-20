package by.andersenlab.shop;

import by.andersenlab.shop.commands.ProductCommand;
import by.andersenlab.shop.commands.ReturnProductsCommand;
import by.andersenlab.shop.products.Product;
import by.andersenlab.shop.user.User;

import java.util.HashSet;
import java.util.Set;

public class Shop {

    private User user;
    private Set<Product> products = new HashSet<>();

    public void processProduct(ProductCommand command, Product product) {
        command.execute(product, products);
    }

    public Set<Product> processReturnProducts(ReturnProductsCommand command) {
        return command.execute(products);
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
