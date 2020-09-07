package by.andersenlab.shop.pages;

import by.andersenlab.shop.commands.console_commands.AddProductConsoleCommand;
import by.andersenlab.shop.commands.console_commands.RemoveProductConsoleCommand;
import by.andersenlab.shop.commands.console_commands.ShowAllProductsConsoleCommand;

import java.util.Arrays;
import java.util.HashSet;

public class MainPage extends Page {

    public MainPage() {
        super(new HashSet<>(Arrays.asList(
                new AddProductConsoleCommand(),
                new RemoveProductConsoleCommand(),
                new ShowAllProductsConsoleCommand()
        )));
    }
}
