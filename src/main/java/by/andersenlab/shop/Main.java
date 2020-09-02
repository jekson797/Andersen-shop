package by.andersenlab.shop;

import by.andersenlab.shop.builder.CommonProductBuilder;
import by.andersenlab.shop.commands.AddProductCommand;
import by.andersenlab.shop.commands.GetAllProductsCommand;
import by.andersenlab.shop.commands.ProductCommand;
import by.andersenlab.shop.commands.ReturnProductsCommand;
import by.andersenlab.shop.enums.Currency;
import by.andersenlab.shop.enums.ProductGroup;
import by.andersenlab.shop.product.Product;

import java.math.BigDecimal;

public class Main {

    public static void main(String[] args) {
        Shop shop = new Shop();
        Product phone =
                createProduct("Iphone X", ProductGroup.PHONE, new BigDecimal("1000.0"), Currency.USD);
        Product gameConsole =
                createProduct("Playstation 5", ProductGroup.GAME_CONSOLE, new BigDecimal("500.0"), Currency.USD);
        Product pc =
                createProduct("Asus", ProductGroup.PC, new BigDecimal("600.0"), Currency.EUR);
        Product mouse =
                createProduct("Razen mouse", ProductGroup.OTHER, new BigDecimal("45.5"), Currency.USD);

        ProductCommand addingCommand = new AddProductCommand();
        shop.processProduct(addingCommand, phone);
        shop.processProduct(addingCommand, gameConsole);
        shop.processProduct(addingCommand, pc);
        shop.processProduct(addingCommand, mouse);

        ReturnProductsCommand select = new GetAllProductsCommand();
        shop.processReturnProducts(select).forEach(System.out::println);
    }

    private static Product createProduct(String name,  ProductGroup group, BigDecimal price, Currency currency) {
        return new CommonProductBuilder().
                reset().
                setName(name).
                setGroup(group).
                setPrice(price).
                setCurrency(currency).
                getProduct();
    }
}
