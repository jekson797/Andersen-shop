package by.andersenlab.shop.pages;

import by.andersenlab.shop.commands.console_commands.AddProductConsoleCommand;

import java.util.Arrays;
import java.util.HashSet;

public class MainPage extends Page {

    public MainPage() {
        super(new HashSet<>(Arrays.asList(
            new AddProductConsoleCommand()
        )));
    }
}
