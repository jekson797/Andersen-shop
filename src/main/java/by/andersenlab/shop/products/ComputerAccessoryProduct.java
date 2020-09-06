package by.andersenlab.shop.products;

import by.andersenlab.shop.enums.AccessoryType;
import by.andersenlab.shop.enums.Currency;
import by.andersenlab.shop.enums.ProductGroup;

import java.math.BigDecimal;
import java.util.Objects;

public class ComputerAccessoryProduct extends Product {

    private AccessoryType accessoryType;

    public ComputerAccessoryProduct(AccessoryBuilder builder) {
        super(builder.name, ProductGroup.COMPUTER_ACCESSORY, builder.price, builder.currency);
        this.accessoryType = builder.accessoryType;
    }

    public AccessoryType getAccessoryType() {
        return accessoryType;
    }

    public void setAccessoryType(AccessoryType accessoryType) {
        this.accessoryType = accessoryType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ComputerAccessoryProduct that = (ComputerAccessoryProduct) o;
        return accessoryType == that.accessoryType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(accessoryType);
    }

    @Override
    public String toString() {
        return "Id: " + getProductId() +
                " | Group: " + ProductGroup.COMPUTER_ACCESSORY +
                " | Name: " + getName() +
                " | Accessory type: " + accessoryType +
                " | Price: " + getPrice() + " " + getCurrency();
    }

    public static class AccessoryBuilder {

        private String name;
        private AccessoryType accessoryType;
        private BigDecimal price;
        private Currency currency;

        public AccessoryBuilder buildName(String name) {
            this.name = name;
            return this;
        }

        public AccessoryBuilder buildAccessoryType(AccessoryType accessoryType) {
            this.accessoryType = accessoryType;
            return this;
        }

        public AccessoryBuilder buildPrice(BigDecimal price) {
            this.price = price;
            return this;
        }

        public AccessoryBuilder buildCurrency(Currency currency) {
            this.currency = currency;
            return this;
        }

        public ComputerAccessoryProduct build() {
            return new ComputerAccessoryProduct(this);
        }
    }
}
