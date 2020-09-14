package by.andersenlab.shop;

import by.andersenlab.shop.enums.Currency;
import by.andersenlab.shop.enums.UserRole;
import by.andersenlab.shop.pages.shop_pages.HomePage;
import by.andersenlab.shop.pages.Page;
import by.andersenlab.shop.singleton.ShopSingleton;
import by.andersenlab.shop.user.User;

import java.math.BigDecimal;

public class Main {

    public static void main(String[] args) {
        System.out.println("<-- Добро пожаловать в магазин Дядюшки Сэма -->");
        ShopSingleton.getShop().setUser(new User(UserRole.USER, new BigDecimal("1000"), Currency.USD));
        Page page = new HomePage();
        while (true) {
            page.showAvailableCommands();
            page.commandChoice();
        }
    }
}
