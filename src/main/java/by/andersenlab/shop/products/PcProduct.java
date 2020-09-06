package by.andersenlab.shop.products;

import by.andersenlab.shop.enums.Currency;
import by.andersenlab.shop.enums.MemoryDriveType;
import by.andersenlab.shop.enums.ProductGroup;

import java.math.BigDecimal;
import java.util.Objects;

public class PcProduct extends Product {

    private String gpuName;
    private String cpuName;
    private int coresNumber;
    private int ram;
    private int memorySize;
    private MemoryDriveType driveType;

    public PcProduct(PcBuilder builder) {
        super(builder.name, ProductGroup.PC, builder.price, builder.currency);
        this.gpuName = builder.gpuName;
        this.cpuName = builder.cpuName;
        this.coresNumber = builder.coresNumber;
        this.ram = builder.ram;
        this.driveType = builder.driveType;
        this.memorySize = builder.memorySize;
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

    public MemoryDriveType getDriveType() {
        return driveType;
    }

    public void setDriveType(MemoryDriveType driveType) {
        this.driveType = driveType;
    }

    public int getMemorySize() {
        return memorySize;
    }

    public void setMemorySize(int memorySize) {
        this.memorySize = memorySize;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PcProduct pcProduct = (PcProduct) o;
        return coresNumber == pcProduct.coresNumber &&
                ram == pcProduct.ram &&
                memorySize == pcProduct.memorySize &&
                Objects.equals(gpuName, pcProduct.gpuName) &&
                Objects.equals(cpuName, pcProduct.cpuName) &&
                driveType == pcProduct.driveType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(gpuName, cpuName, coresNumber, ram, memorySize, driveType);
    }

    @Override
    public String toString() {
        return "Id: " + getProductId() +
                " | Group: " + ProductGroup.PC +
                " | Name: " + getName() +
                " | GPU: " + gpuName +
                " | Cpu: " + cpuName +
                " | Cores number: " + coresNumber +
                " | Ram: " + ram + " GB" +
                " | Memory drive type: " + driveType +
                " | Memory: " + memorySize + " GB" +
                " | Price: " + getPrice() + " " + getCurrency();
    }

    public static class PcBuilder {

        private String name;
        private String gpuName;
        private String cpuName;
        private int coresNumber;
        private int ram;
        private int memorySize;
        private MemoryDriveType driveType;
        private BigDecimal price;
        private Currency currency;

        public PcBuilder buildName(String name) {
            this.name = name;
            return this;
        }

        public PcBuilder buildGpuName(String gpuName) {
            this.gpuName = gpuName;
            return this;
        }

        public PcBuilder buildCpuName(String cpuName) {
            this.cpuName = cpuName;
            return this;
        }

        public PcBuilder buildCoresNumber(int coresNumber) {
            this.coresNumber = coresNumber;
            return this;
        }

        public PcBuilder buildRam(int ram) {
            this.ram = ram;
            return this;
        }

        public PcBuilder buildDriveType(MemoryDriveType driveType) {
            this.driveType = driveType;
            return this;
        }

        public PcBuilder buildMemorySize(int memorySize) {
            this.memorySize = memorySize;
            return this;
        }

        public PcBuilder buildPrice(BigDecimal price) {
            this.price = price;
            return this;
        }

        public PcBuilder buildCurrency(Currency currency) {
            this.currency = currency;
            return this;
        }

        public PcProduct build() {
            return new PcProduct(this);
        }
    }
}
