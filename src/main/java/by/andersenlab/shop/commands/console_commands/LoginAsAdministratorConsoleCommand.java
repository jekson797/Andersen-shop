package by.andersenlab.shop.commands.console_commands;

import by.andersenlab.shop.pages.MainPage;

public class LoginAsAdministratorCommand implements ConsoleCommand {

    private static final int id = 1;

    @Override
    public void execute() {
        System.out.println("Вход выполнен");
        MainPage mainPage = new MainPage();
        mainPage.commandChoice();
    }

    @Override
    public void showCommandInfo() {
        System.out.println(id + " - Войти как администратор");
    }

    @Override
    public int getCommandId() {
        return id;
    }
}
