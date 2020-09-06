package by.andersenlab.shop.pages;

import by.andersenlab.shop.commands.console_commands.LoginAsAdministratorConsoleCommand;

import java.util.Arrays;
import java.util.HashSet;

public class LoginPage extends Page {

    public LoginPage() {
        super(new HashSet<>(Arrays.asList(
                new LoginAsAdministratorConsoleCommand()
        )));
    }
}
