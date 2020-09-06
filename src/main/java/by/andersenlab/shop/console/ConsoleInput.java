package by.andersenlab.shop.console;

import java.util.List;
import java.util.Scanner;

public class ConsoleInput {

    private static final Scanner scanner = new Scanner(System.in);

    public static double getNumberFromConsoleInput(String inputPrefix) {
        double userNumber = 0;
        while (true) {
            try {
                System.out.print(inputPrefix);
                userNumber = Double.parseDouble(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Введено неверное значение! Попробуйте ещё раз.");
                continue;
            }
            break;
        }
        return userNumber;
    }

    public static String getStringFromConsoleInput(String inputPrefix) {
        String userInput;
        while (true) {
            System.out.print(inputPrefix);
            userInput = scanner.nextLine();
            if (userInput.length() <= 0) {
                System.out.println("Ничего не введено! Попробуйте ещё раз.");
            } else {
                break;
            }
        }
        return userInput;
    }

    public static String getUserChoiceFromOfferedValues(String inputPrefix, List<String> offeredValues) {
        inputPrefix = getStringInputMessageWithAvailableChoices(inputPrefix, offeredValues);
        String userInput;
        while (true) {
            userInput = getStringFromConsoleInput(inputPrefix).toUpperCase().trim();
            boolean isInputCorrect = offeredValues.contains(userInput);
            if (isInputCorrect) {
                break;
            } else {
                System.out.println("Введено неверное значение! Попробуйте ещё раз");
            }
        }
        return userInput;
    }

    private static String getStringInputMessageWithAvailableChoices(String inputPrefix, List<String> offeredValues) {
        StringBuilder builder = new StringBuilder().append(inputPrefix).append("(");
        for (String value : offeredValues) {
            builder.append(value).append(" | ");
        }
        builder.delete(builder.length() - 3, builder.length());
        builder.append("): ");
        return builder.toString();
    }
}
