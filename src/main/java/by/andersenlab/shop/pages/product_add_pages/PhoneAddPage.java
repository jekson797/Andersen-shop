package by.andersenlab.shop.pages.product_add_pages;

import by.andersenlab.shop.commands.shop_commands.AddProductCommand;
import by.andersenlab.shop.commands.shop_commands.ProductCommand;
import by.andersenlab.shop.console.ConsoleInput;
import by.andersenlab.shop.enums.ProductGroup;
import by.andersenlab.shop.products.PhoneProduct;
import by.andersenlab.shop.products.Product;
import by.andersenlab.shop.singleton.ShopSingleton;

import java.math.BigDecimal;

public class PhoneAddPage extends ProductAddPage {

    public PhoneAddPage() {
        super(ProductGroup.PHONE);
    }

    @Override
    public void addProduct() {
        Product product = buildProduct();
        ProductCommand command = new AddProductCommand();
        ShopSingleton.getShop().processProduct(command, product);
    }

    private Product buildProduct() {
        return new PhoneProduct.PhoneBuilder().
                buildName(ConsoleInput.getStringFromConsoleInput("Введите название телефона: ")).
                buildOs(ConsoleInput.getStringFromConsoleInput("Введите название операционной системы: ")).
                buildCoreNumbers(ConsoleInput.getIntegerFromConsoleInput("Введите количество ядер: ")).
                buildRam(ConsoleInput.getIntegerFromConsoleInput("Введите размер ОЗУ: ")).
                buildMemorySize(ConsoleInput.getIntegerFromConsoleInput("Введите размер памяти: ")).
                buildDiagonal(ConsoleInput.getDoubleFromConsoleInput("Введите диагональ: ")).
                buildPrice(BigDecimal.valueOf(ConsoleInput.
                        getDoubleFromConsoleInput("Введите цену телефона: "))).
                buildCurrency(getUserCurrency()).
                build();
    }
}
