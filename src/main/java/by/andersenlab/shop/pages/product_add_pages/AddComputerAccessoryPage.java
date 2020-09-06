package by.andersenlab.shop.pages.product_add_pages;

import by.andersenlab.shop.console.ConsoleInput;
import by.andersenlab.shop.commands.shop_commands.AddProductCommand;
import by.andersenlab.shop.commands.shop_commands.ProductCommand;
import by.andersenlab.shop.enums.AccessoryType;
import by.andersenlab.shop.enums.ProductGroup;
import by.andersenlab.shop.products.ComputerAccessoryProduct;
import by.andersenlab.shop.products.Product;
import by.andersenlab.shop.singleton.ShopSingleton;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class AddComputerAccessoryPage extends ProductAddPage {

    public AddComputerAccessoryPage() {
        super(ProductGroup.COMPUTER_ACCESSORY);
    }

    @Override
    public void addProduct() {
        Product product = buildProduct();
        ProductCommand command = new AddProductCommand();
        ShopSingleton.getShop().processProduct(command, product);
    }

    private Product buildProduct() {
        return new ComputerAccessoryProduct.AccessoryBuilder().
                buildName(ConsoleInput.getStringFromConsoleInput("Введите имя продукта: ")).
                buildAccessoryType(getUserAccessoryType()).
                buildPrice(BigDecimal.valueOf(
                        ConsoleInput.getNumberFromConsoleInput("Введите цену продукта: "))).
                buildCurrency(getUserCurrency()).
                build();
    }

    private AccessoryType getUserAccessoryType() {
        List<String> offeredValues =
                Arrays.stream(AccessoryType.values()).map(Enum::toString).collect(Collectors.toList());
        String userChoice =
                ConsoleInput.getUserChoiceFromOfferedValues("Введите тип аксессуара", offeredValues);
        return AccessoryType.valueOf(userChoice);
    }
}
