package by.andersenlab.shop.pages.product_add_pages;

import by.andersenlab.shop.commands.shop_commands.AddProductCommand;
import by.andersenlab.shop.commands.shop_commands.ProductCommand;
import by.andersenlab.shop.console.ConsoleInput;
import by.andersenlab.shop.enums.MemoryDriveType;
import by.andersenlab.shop.enums.ProductGroup;
import by.andersenlab.shop.products.PcProduct;
import by.andersenlab.shop.products.Product;
import by.andersenlab.shop.singleton.ShopSingleton;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class PcAddPage extends ProductAddPage {

    public PcAddPage() {
        super(ProductGroup.PC);
    }

    @Override
    public void addProduct() {
        Product product = buildProduct();
        ProductCommand command = new AddProductCommand();
        ShopSingleton.getShop().processProduct(command, product);
    }

    public Product buildProduct() {
        return new PcProduct.PcBuilder().
                buildName(ConsoleInput.getStringFromConsoleInput("Введите название компьютера: ")).
                buildGpuName(ConsoleInput.getStringFromConsoleInput("Введите название видеокарты: ")).
                buildCpuName(ConsoleInput.getStringFromConsoleInput("Введите название процессора: ")).
                buildCoresNumber(ConsoleInput.getIntegerFromConsoleInput("Введите количество ядер: ")).
                buildRam(ConsoleInput.getIntegerFromConsoleInput("Введите размер ОЗУ: ")).
                buildDriveType(getUserDriveType()).
                buildMemorySize(ConsoleInput.getIntegerFromConsoleInput("Введите размер жёсткого диска: ")).
                buildPrice(BigDecimal.valueOf(ConsoleInput.
                        getDoubleFromConsoleInput("Введите цену компьютера: "))).
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
