package by.andersenlab.shop.product;

import by.andersenlab.shop.enums.Currency;
import by.andersenlab.shop.enums.ProductGroup;

import java.math.BigDecimal;
import java.util.Objects;

public class Product {

    private static long id = 0L;

    private long productId = id;
    private String name;
    private ProductGroup group;
    private BigDecimal price;
    private Currency currency;

    public Product() {
        id++;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGroup(ProductGroup group) {
        this.group = group;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    @Override
    public String toString() {
        return "Product: " +
                "Id - " + productId +
                " | Name - " + name +
                " | Group - " + group +
                " | Price - " + price +
                " | Currency - " + currency;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(name, product.name) &&
                group == product.group &&
                Objects.equals(price, product.price) &&
                currency == product.currency;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, group, price, currency);
    }
}
