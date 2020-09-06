package by.andersenlab.shop.commands.console_commands;

public interface ConsoleCommand {

    void execute();
    void showCommandInfo();
    int getCommandId();
}
