package by.andersenlab.shop.products;

import by.andersenlab.shop.enums.Currency;
import by.andersenlab.shop.enums.DisplayType;
import by.andersenlab.shop.enums.ProductGroup;

import java.math.BigDecimal;
import java.util.Objects;

public class MonitorProduct extends Product {

    private String aspectRatio;
    private String resolution;
    private double diagonal;
    private DisplayType displayType;

    public MonitorProduct(MonitorBuilder builder) {
        super(builder.brand, builder.model,
                ProductGroup.MONITOR, builder.price, builder.currency);
        this.aspectRatio = builder.aspectRatio;
        this.resolution = builder.resolution;
        this.diagonal = builder.diagonal;
        this.displayType = builder.displayType;
    }

    public String getAspectRatio() {
        return aspectRatio;
    }

    public void setAspectRatio(String aspectRatio) {
        this.aspectRatio = aspectRatio;
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
                Objects.equals(aspectRatio, that.aspectRatio) &&
                Objects.equals(resolution, that.resolution) &&
                displayType == that.displayType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(aspectRatio, resolution, diagonal, displayType);
    }

    @Override
    public String toString() {
        return "Id: " + getProductId() +
                " | Group: " + ProductGroup.MONITOR +
                " | Brand: " + getBrand() +
                " | Model" + getModel() +
                " | Aspect ration: " + aspectRatio +
                " | Resolution: " + resolution +
                " | Diagonal: " + diagonal +
                " | Display Type: " + displayType +
                " | Price: " + getPrice() + " " + getCurrency();
    }

    public static class MonitorBuilder {

        private String brand;
        private String model;
        private String aspectRatio;
        private String resolution;
        private double diagonal;
        private DisplayType displayType;
        private BigDecimal price;
        private Currency currency;

        public MonitorBuilder buildBrand(String brand) {
            this.brand = brand;
            return this;
        }

        public MonitorBuilder buildModel(String model) {
            this.model = model;
            return this;
        }

        public MonitorBuilder buildAspectRatio(String aspectRatio) {
            this.aspectRatio = aspectRatio;
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
