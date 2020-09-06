package by.andersenlab.shop.commands.console_commands;

import by.andersenlab.shop.pages.MainPage;

public class LoginAsAdministratorConsoleCommand implements ConsoleCommand {

    private static final int ID = 1;

    @Override
    public void execute() {
        System.out.println("Вход выполнен");
        MainPage mainPage = new MainPage();
        mainPage.commandChoice();
    }

    @Override
    public void showCommandInfo() {
        System.out.println(ID + " - Войти как администратор");
    }

    @Override
    public int getCommandId() {
        return ID;
    }
}
