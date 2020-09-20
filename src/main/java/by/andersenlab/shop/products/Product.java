package by.andersenlab.shop.products;

import by.andersenlab.shop.enums.Currency;
import by.andersenlab.shop.enums.ProductGroup;

import java.math.BigDecimal;

public class Product {

    private long productId;
    private String brand;
    private String model;
    private ProductGroup group;
    private BigDecimal price;
    private Currency currency;

    public Product(String brand, String model,
                   ProductGroup group, BigDecimal price, Currency currency) {
        this.brand = brand;
        this.model = model;
        this.group = group;
        this.price = price;
        this.currency = currency;
    }

    public Product() {
    }

    public void setProductId(long productId) {
        this.productId = productId;
    }

    public long getProductId() {
        return productId;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getGroup() {
        return group.toString();
    }

    public ProductGroup getGroupEnum() {
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
