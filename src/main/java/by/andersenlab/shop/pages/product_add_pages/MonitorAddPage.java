package by.andersenlab.shop.pages.product_add_pages;

import by.andersenlab.shop.commands.shop_commands.AddProductCommand;
import by.andersenlab.shop.commands.shop_commands.ProductCommand;
import by.andersenlab.shop.console.ConsoleInput;
import by.andersenlab.shop.enums.DisplayType;
import by.andersenlab.shop.enums.ProductGroup;
import by.andersenlab.shop.products.MonitorProduct;
import by.andersenlab.shop.products.Product;
import by.andersenlab.shop.singleton.ShopSingleton;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MonitorAddPage extends ProductAddPage {

    public MonitorAddPage() {
        super(ProductGroup.MONITOR);
    }

    @Override
    public void addProduct() {
        Product product = buildProduct();
        ProductCommand command = new AddProductCommand();
        ShopSingleton.getShop().processProduct(command, product);
    }

    private Product buildProduct() {
        return new MonitorProduct.MonitorBuilder().
                buildName(ConsoleInput.getStringFromConsoleInput("Введите название монитора: ")).
                buildResolution(ConsoleInput.getStringFromConsoleInput("Введите разрешение экрана: ")).
                buildAspectRation(ConsoleInput.getStringFromConsoleInput("Введите соотношение сторон: ")).
                buildDiagonal(ConsoleInput.getDoubleFromConsoleInput("Введите диагональ: ")).
                buildDisplayType(getUserDisplayType()).
                buildPrice(BigDecimal.valueOf(ConsoleInput.
                        getDoubleFromConsoleInput("Введите цену монитора: "))).
                buildCurrency(getUserCurrency()).
                build();
    }

    private DisplayType getUserDisplayType() {
        List<String> offeredValues =
                Arrays.stream(DisplayType.values()).map(Enum::toString).collect(Collectors.toList());
        String userChoice =
                ConsoleInput.getUserChoiceFromOfferedValues("Введите тип экрана", offeredValues);
        return DisplayType.valueOf(userChoice);
    }
}
