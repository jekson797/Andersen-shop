package by.andersenlab.shop.pages.product_add_pages;

import by.andersenlab.shop.commands.shop_commands.AddProductCommand;
import by.andersenlab.shop.commands.shop_commands.ProductCommand;
import by.andersenlab.shop.console.ConsoleInput;
import by.andersenlab.shop.enums.MemoryDriveType;
import by.andersenlab.shop.enums.ProductGroup;
import by.andersenlab.shop.products.GameConsoleProduct;
import by.andersenlab.shop.products.Product;
import by.andersenlab.shop.singleton.ShopSingleton;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class GameConsoleAddPage extends ProductAddPage {

    public GameConsoleAddPage() {
        super(ProductGroup.GAME_CONSOLE);
    }

    @Override
    public void addProduct() {
        Product product = buildProduct();
        ProductCommand command = new AddProductCommand();
        ShopSingleton.getShop().processProduct(command, product);
    }

    private Product buildProduct() {
        return new GameConsoleProduct.GameConsoleBuilder().
                buildName(ConsoleInput.getStringFromConsoleInput("Введите название консоли: ")).
                buildDriveType(getUserDriveType()).
                buildMemorySize(ConsoleInput.getIntegerFromConsoleInput("Введите размер жёсткого диска: ")).
                addIncludedGame(ConsoleInput.getStringFromConsoleInput("Введите название игр в комплекте: ")).
                buildControllersAmount(ConsoleInput.
                        getIntegerFromConsoleInput("Введите количество контроллеров: ")).
                buildPrice(BigDecimal.valueOf(ConsoleInput.
                        getDoubleFromConsoleInput("Введите цену консоли: "))).
                buildCurrency(getUserCurrency()).
                build();
    }

    private MemoryDriveType getUserDriveType() {
        List<String> offeredValues =
                Arrays.stream(MemoryDriveType.values()).map(Enum::toString).collect(Collectors.toList());
        String userChoice =
                ConsoleInput.getUserChoiceFromOfferedValues("Введите тип жёсткого диска", offeredValues);
        return MemoryDriveType.valueOf(userChoice);
    }
}
