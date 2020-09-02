package by.andersenlab.shop.shop.builder;

import by.andersenlab.shop.shop.enums.Currency;
import by.andersenlab.shop.shop.product.Product;
import by.andersenlab.shop.shop.enums.ProductGroup;

import java.math.BigDecimal;

public interface ProductBuilder {

    ProductBuilder reset();
    ProductBuilder setName(String name);
    ProductBuilder setGroup(ProductGroup group);
    ProductBuilder setPrice(BigDecimal price);
    ProductBuilder setCurrency(Currency currency);
    Product getProduct();
}
