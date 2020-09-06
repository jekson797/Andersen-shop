package by.andersenlab.shop.products;

import by.andersenlab.shop.enums.Currency;
import by.andersenlab.shop.enums.DisplayType;
import by.andersenlab.shop.enums.ProductGroup;

import java.math.BigDecimal;
import java.util.Objects;

public class MonitorProduct extends Product {

    private String aspectRation;
    private String resolution;
    private double diagonal;
    private DisplayType displayType;

    public MonitorProduct(MonitorBuilder builder) {
        super(builder.name, ProductGroup.MONITOR, builder.price, builder.currency);
        this.aspectRation = builder.aspectRation;
        this.resolution = builder.resolution;
        this.diagonal = builder.diagonal;
        this.displayType = builder.displayType;
    }

    public String getAspectRation() {
        return aspectRation;
    }

    public void setAspectRation(String aspectRation) {
        this.aspectRation = aspectRation;
    }

    public String getResolution() {
        return resolution;
    }

    public void setResolution(String resolution) {
        this.resolution = resolution;
    }

    public double getDiagonal() {
        return diagonal;
    }

    public void setDiagonal(double diagonal) {
        this.diagonal = diagonal;
    }

    public DisplayType getDisplayType() {
        return displayType;
    }

    public void setDisplayType(DisplayType displayType) {
        this.displayType = displayType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MonitorProduct that = (MonitorProduct) o;
        return Double.compare(that.diagonal, diagonal) == 0 &&
                Objects.equals(aspectRation, that.aspectRation) &&
                Objects.equals(resolution, that.resolution) &&
                displayType == that.displayType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(aspectRation, resolution, diagonal, displayType);
    }

    @Override
    public String toString() {
        return "Id: " + getProductId() +
                " | Group: " + ProductGroup.MONITOR +
                " | Name: " + getName() +
                " | Aspect ration: " + aspectRation +
                " | Resolution: " + resolution +
                " | Diagonal: " + diagonal +
                " | Display Type: " + displayType +
                " | Price: " + getPrice() + " " + getCurrency();
    }

    public static class MonitorBuilder {

        private String name;
        private String aspectRation;
        private String resolution;
        private double diagonal;
        private DisplayType displayType;
        private BigDecimal price;
        private Currency currency;

        public MonitorBuilder buildName(String name) {
            this.name = name;
            return this;
        }

        public MonitorBuilder buildAspectRation(String aspectRation) {
            this.aspectRation = aspectRation;
            return this;
        }

        public MonitorBuilder buildResolution(String resolution) {
            this.resolution = resolution;
            return this;
        }

        public MonitorBuilder buildDiagonal(double diagonal) {
            this.diagonal = diagonal;
            return this;
        }

        public MonitorBuilder buildDisplayType(DisplayType displayType) {
            this.displayType = displayType;
            return this;
        }

        public MonitorBuilder buildPrice(BigDecimal price) {
            this.price = price;
            return this;
        }

        public MonitorBuilder buildCurrency(Currency currency) {
            this.currency = currency;
            return this;
        }

        public MonitorProduct build() {
            return new MonitorProduct(this);
        }
    }
}
