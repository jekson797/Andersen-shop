package by.andersenlab.shop.commands.console_commands.admin_commands;

import by.andersenlab.shop.commands.console_commands.ConsoleCommand;
import by.andersenlab.shop.commands.console_commands.ReturnToMainPageConsoleCommand;
import by.andersenlab.shop.console.ConsoleInput;
import by.andersenlab.shop.enums.ProductGroup;
import by.andersenlab.shop.pages.product_add_pages.*;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class AddProductConsoleCommand implements ConsoleCommand {

    private static final int ID = 1;
    private static Set<ProductAddPage> availableProductAddPages = new HashSet<>(Arrays.asList(
            new ComputerAccessoryAddPage(),
            new GameConsoleAddPage(),
            new MonitorAddPage(),
            new NotebookAddPage(),
            new PcAddPage(),
            new PhoneAddPage()
    ));

    @Override
    public void execute() {
        ProductGroup productGroup = getUserProductGroup();
        for (ProductAddPage page : availableProductAddPages) {
            if (page.getProductGroup().equals(productGroup)) {
                page.addProduct();
            }
        }
    }

    @Override
    public void showCommandInfo() {
        System.out.println(ID + " - Добавить товар в магазин");
    }

    @Override
    public int getCommandId() {
        return ID;
    }

    private ProductGroup getUserProductGroup() {
        List<String> offeredValues =
                Arrays.stream(ProductGroup.values()).map(Enum::toString).collect(Collectors.toList());
        String userChoice =
                ConsoleInput.getUserChoiceFromOfferedValues("Введите группу товара", offeredValues);
        return ProductGroup.valueOf(userChoice);
    }
}
