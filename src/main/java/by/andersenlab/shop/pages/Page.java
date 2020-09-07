package by.andersenlab.shop.pages;

import by.andersenlab.shop.console.ConsoleInput;
import by.andersenlab.shop.commands.console_commands.ConsoleCommand;

import java.util.Set;

public abstract class Page {

    private Set<ConsoleCommand> availableCommands;

    public Page() {
    }

    public Page(Set<ConsoleCommand> availableCommands) {
        this.availableCommands = availableCommands;
        System.out.println("-> Доступные команды: ");
        for (ConsoleCommand command : availableCommands) {
            command.showCommandInfo();
        }
    }

    public void commandChoice() {
        choiceLoop:
        while(true) {
            double userChoice = ConsoleInput.getDoubleFromConsoleInput("Введите номер команды: ");
            for (ConsoleCommand command : availableCommands) {
                if (command.getCommandId() == userChoice) {
                    command.execute();
                    break choiceLoop;
                }
            }
            System.out.println("Номер введённой комманды не верен! Попробуйте ещё раз.");
        }
    }
}
