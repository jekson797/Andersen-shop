package by.andersenlab.shop.pages.product_add_pages;

import by.andersenlab.shop.console.ConsoleInput;
import by.andersenlab.shop.enums.Currency;
import by.andersenlab.shop.enums.ProductGroup;
import by.andersenlab.shop.pages.Page;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public abstract class ProductAddPage extends Page {

    private final ProductGroup productGroup;

    public ProductAddPage(ProductGroup productGroup) {
        this.productGroup = productGroup;
    }

    public abstract void addProduct();

    public ProductGroup getProductGroup() {
        return productGroup;
    }

    protected Currency getUserCurrency() {
        List<String> offeredValues =
                Arrays.stream(Currency.values()).map(Enum::toString).collect(Collectors.toList());
        String userChoice =
                ConsoleInput.getUserChoiceFromOfferedValues("Введите тип валюты", offeredValues);
        return Currency.valueOf(userChoice);
    }
}
