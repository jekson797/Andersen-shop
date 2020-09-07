package by.andersenlab.shop.pages.product_remove_page;

import by.andersenlab.shop.commands.shop_commands.GetAllProductsCommand;
import by.andersenlab.shop.commands.shop_commands.RemoveProductCommand;
import by.andersenlab.shop.console.ConsoleInput;
import by.andersenlab.shop.pages.Page;
import by.andersenlab.shop.products.Product;
import by.andersenlab.shop.singleton.ShopSingleton;

import java.util.Set;

public class ProductRemovingPage extends Page {

    private Set<Product> products = ShopSingleton.getShop().processReturnProducts(new GetAllProductsCommand());

    public void deleteProduct() {
        System.out.println("-> Для возвращения назад введите: -1");
        deletingLoop:
        while(true) {
            int productIdForDeleting = ConsoleInput.
                    getIntegerFromConsoleInput("Введите id товара который хотите удалить: ");
            if (productIdForDeleting == -1) {
                break;
            } else {
                for (Product product : products) {
                    if (product.getProductId() == productIdForDeleting) {
                        ShopSingleton.getShop().processProduct(new RemoveProductCommand(), product);
                        break deletingLoop;
                    }
                }
            }
            System.out.println("Введенный id не найден! Попробуйте еще раз");
        }
    }

    public void showProducts() {
        products.forEach(System.out::println);
    }
}
