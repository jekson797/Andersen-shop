package by.andersenlab.shop.products;

import by.andersenlab.shop.enums.Currency;
import by.andersenlab.shop.enums.ProductGroup;

import java.math.BigDecimal;
import java.util.Objects;

public class PhoneProduct extends Product {

    private String os;
    private int memorySize;
    private int ram;
    private int coresNumber;
    private double diagonal;

    public PhoneProduct(PhoneBuilder builder) {
        super(builder.name, ProductGroup.PHONE, builder.price, builder.currency);
        this.os = builder.os;
        this.diagonal = builder.diagonal;
        this.ram = builder.ram;
        this.coresNumber = builder.coresNumber;
        this.memorySize = builder.memorySize;
    }

    public String getOs() {
        return os;
    }

    public void setOs(String os) {
        this.os = os;
    }

    public double getDiagonal() {
        return diagonal;
    }

    public void setDiagonal(double diagonal) {
        this.diagonal = diagonal;
    }

    public int getMemorySize() {
        return memorySize;
    }

    public void setMemorySize(int memorySize) {
        this.memorySize = memorySize;
    }

    public int getRam() {
        return ram;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }

    public int getCoresNumber() {
        return coresNumber;
    }

    public void setCoresNumber(int coresNumber) {
        this.coresNumber = coresNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PhoneProduct that = (PhoneProduct) o;
        return Double.compare(that.diagonal, diagonal) == 0 &&
                ram == that.ram &&
                coresNumber == that.coresNumber &&
                Objects.equals(os, that.os);
    }

    @Override
    public int hashCode() {
        return Objects.hash(os, diagonal, ram, coresNumber);
    }

    @Override
    public String toString() {
        return "Id: " + getProductId() +
                " | Group: " + ProductGroup.PHONE +
                " | Name: " + getName() +
                " | Os: " + os +
                " | Diagonal: " + diagonal +
                " | Memory: " + memorySize + " GB" +
                " | Ram: " + ram + " GB" +
                " | Cores number: " + coresNumber +
                " | Price: " + getPrice() + " " + getCurrency();
    }

    public static class PhoneBuilder {

        private String name;
        private String os;
        private int memorySize;
        private int ram;
        private int coresNumber;
        private double diagonal;
        private BigDecimal price;
        private Currency currency;

        public PhoneBuilder buildName(String name) {
            this.name = name;
            return this;
        }

        public PhoneBuilder buildOs(String os) {
            this.os = os;
            return this;
        }

        public PhoneBuilder buildScreenSize(double diagonal) {
            this.diagonal = diagonal;
            return this;
        }

        public PhoneBuilder buildRam(int ram) {
            this.ram = ram;
            return this;
        }

        public PhoneBuilder buildMemorySize(int memorySize) {
            this.memorySize = memorySize;
            return this;
        }

        public PhoneBuilder buildCoreNumbers(int coresNumber) {
            this.coresNumber = coresNumber;
            return this;
        }

        public PhoneBuilder buildPrice(BigDecimal price) {
            this.price = price;
            return this;
        }

        public PhoneBuilder buildCurrency(Currency currency) {
            this.currency = currency;
            return this;
        }

        public PhoneProduct build() {
            return new PhoneProduct(this);
        }
    }
}