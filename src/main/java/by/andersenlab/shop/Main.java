package by.andersenlab.shop;

import by.andersenlab.shop.pages.ActionPage;
import by.andersenlab.shop.pages.Page;

public class Main {

    public static void main(String[] args) {
        System.out.println("Добро пожаловать в магазин Дядюшки Сэма");
        while(true) {
            Page page = new ActionPage();
            page.commandChoice();
        }
    }
}
