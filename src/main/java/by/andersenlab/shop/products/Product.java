package by.andersenlab.shop.products;

import by.andersenlab.shop.enums.Currency;
import by.andersenlab.shop.enums.ProductGroup;

import java.math.BigDecimal;

public abstract class Product {

    private static long id = 0L;

    private long productId = id;
    private String name;
    private ProductGroup group;
    private BigDecimal price;
    private Currency currency;

    public Product(String name, ProductGroup group, BigDecimal price, Currency currency) {
        id++;
        this.name = name;
        this.group = group;
        this.price = price;
        this.currency = currency;
    }

    public long getProductId() {
        return productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ProductGroup getGroup() {
        return group;
    }

    public void setGroup(ProductGroup group) {
        this.group = group;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    public Currency getCurrency() {
        return currency;
    }
}
