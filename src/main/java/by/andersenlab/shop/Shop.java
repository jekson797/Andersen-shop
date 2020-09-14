package by.andersenlab.shop;

import by.andersenlab.shop.commands.shop_commands.ProductCommand;
import by.andersenlab.shop.commands.shop_commands.ReturnProductsCommand;
import by.andersenlab.shop.enums.Currency;
import by.andersenlab.shop.enums.MemoryDriveType;
import by.andersenlab.shop.products.GameConsoleProduct;
import by.andersenlab.shop.products.Product;
import by.andersenlab.shop.user.User;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Shop {

    private User user;
    private Set<Product> products = new HashSet<>(Arrays.asList(
            new GameConsoleProduct.
                    GameConsoleBuilder().
                    buildName("PS5").
                    buildMemorySize(500).
                    buildDriveType(MemoryDriveType.SSD).
                    buildControllersAmount(2).
                    buildPrice(new BigDecimal("500")).
                    buildCurrency(Currency.USD).
                    build()
    ));

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
