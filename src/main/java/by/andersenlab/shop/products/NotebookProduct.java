package by.andersenlab.shop.products;

import by.andersenlab.shop.enums.Currency;
import by.andersenlab.shop.enums.DisplayType;
import by.andersenlab.shop.enums.MemoryDriveType;
import by.andersenlab.shop.enums.ProductGroup;

import java.math.BigDecimal;
import java.util.Objects;

public class NotebookProduct extends Product {

    private String gpuName;
    private String cpuName;
    private int coresNumber;
    private int ram;
    private int memorySize;
    private MemoryDriveType driveType;
    private DisplayType displayType;

    public NotebookProduct(NotebookBuilder builder) {
        super(builder.brand, builder.model,
                ProductGroup.NOTEBOOK, builder.price, builder.currency);
        this.gpuName = builder.gpuName;
        this.cpuName = builder.cpuName;
        this.coresNumber = builder.coresNumber;
        this.ram = builder.ram;
        this.memorySize = builder.memorySize;
        this.driveType = builder.driveType;
        this.displayType = builder.displayType;
    }

    public String getGpuName() {
        return gpuName;
    }

    public void setGpuName(String gpuName) {
        this.gpuName = gpuName;
    }

    public String getCpuName() {
        return cpuName;
    }

    public void setCpuName(String cpuName) {
        this.cpuName = cpuName;
    }

    public int getCoresNumber() {
        return coresNumber;
    }

    public void setCoresNumber(int coresNumber) {
        this.coresNumber = coresNumber;
    }

    public int getRam() {
        return ram;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }

    public int getMemorySize() {
        return memorySize;
    }

    public void setMemorySize(int memorySize) {
        this.memorySize = memorySize;
    }

    public MemoryDriveType getDriveType() {
        return driveType;
    }

    public void setDriveType(MemoryDriveType driveType) {
        this.driveType = driveType;
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
        NotebookProduct that = (NotebookProduct) o;
        return coresNumber == that.coresNumber &&
                ram == that.ram &&
                memorySize == that.memorySize &&
                Objects.equals(gpuName, that.gpuName) &&
                Objects.equals(cpuName, that.cpuName) &&
                driveType == that.driveType &&
                displayType == that.displayType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(gpuName, cpuName, coresNumber, ram, memorySize, driveType, displayType);
    }

    @Override
    public String toString() {
        return "Id: " + getProductId() +
                " | Group: " + ProductGroup.NOTEBOOK +
                " | Brand: " + getBrand() +
                " | Model: " + getModel() +
                " | Display type: " + displayType +
                " | GPU: " + gpuName +
                " | Cpu: " + cpuName +
                " | Cores number: " + coresNumber +
                " | Ram: " + ram + " GB" +
                " | Memory drive type: " + driveType +
                " | Memory: " + memorySize + " GB" +
                " | Price: " + getPrice() + " " + getCurrency();
    }

    public static class NotebookBuilder {

        private String brand;
        private String model;
        private String gpuName;
        private String cpuName;
        private int coresNumber;
        private int ram;
        private int memorySize;
        private MemoryDriveType driveType;
        private DisplayType displayType;
        private BigDecimal price;
        private Currency currency;

        public NotebookBuilder buildBrand(String brand) {
            this.brand = brand;
            return this;
        }

        public NotebookBuilder buildModel(String model) {
            this.model = model;
            return this;
        }

        public NotebookBuilder buildGpuName(String gpuName) {
            this.gpuName = gpuName;
            return this;
        }

        public NotebookBuilder buildCpuName(String cpuName) {
            this.cpuName = cpuName;
            return this;
        }

        public NotebookBuilder buildCoresNumber(int coresNumber) {
            this.coresNumber = coresNumber;
            return this;
        }

        public NotebookBuilder buildRam(int ram) {
            this.ram = ram;
            return this;
        }

        public NotebookBuilder buildMemorySize(int memorySize) {
            this.memorySize = memorySize;
            return this;
        }

        public NotebookBuilder buildDriveType(MemoryDriveType driveType) {
            this.driveType = driveType;
            return this;
        }

        public NotebookBuilder buildDisplayType(DisplayType displayType) {
            this.displayType = displayType;
            return this;
        }

        public NotebookBuilder buildPrice(BigDecimal price) {
            this.price = price;
            return this;
        }

        public NotebookBuilder buildCurrency(Currency currency) {
            this.currency = currency;
            return this;
        }

        public NotebookProduct build() {
            return new NotebookProduct(this);
        }
    }
}
