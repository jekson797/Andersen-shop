package by.andersenlab.shop.tests.builders;

import by.andersenlab.shop.enums.Currency;
import by.andersenlab.shop.enums.MemoryDriveType;
import by.andersenlab.shop.products.PcProduct;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.math.BigDecimal;

@RunWith(JUnitParamsRunner.class)
public class PcBuilderTests {

    @Test
    @Parameters({"Irwin Computers Zen G1-07"})
    public void buildNameTest(String name) {
        PcProduct product = new PcProduct.PcBuilder().buildName(name).build();
        Assert.assertEquals(name, product.getName());
    }

    @Test
    @Parameters({"NVIDIA GeForce GTX 1650"})
    public void buildGpuNameTest(String gpuName) {
        PcProduct product = new PcProduct.PcBuilder().buildGpuName(gpuName).build();
        Assert.assertEquals(gpuName, product.getGpuName());
    }

    @Test
    @Parameters({"AMD Ryzen 5 2600"})
    public void buildCpuNameTest(String cpuName) {
        PcProduct product = new PcProduct.PcBuilder().buildCpuName(cpuName).build();
        Assert.assertEquals(cpuName, product.getCpuName());
    }

    @Test
    @Parameters({"6"})
    public void buildCoresNumberTest(int coresNumber) {
        PcProduct product = new PcProduct.PcBuilder().buildCoresNumber(coresNumber).build();
        Assert.assertEquals(coresNumber, product.getCoresNumber());
    }

    @Test
    @Parameters({"16"})
    public void buildRamTest(int ram) {
        PcProduct product = new PcProduct.PcBuilder().buildRam(ram).build();
        Assert.assertEquals(ram, product.getRam());
    }

    @Test
    @Parameters({"SSD"})
    public void buildDriveTypeTest(MemoryDriveType driveType) {
        PcProduct product = new PcProduct.PcBuilder().buildDriveType(driveType).build();
        Assert.assertEquals(driveType, product.getDriveType());
    }

    @Test
    @Parameters({"480"})
    public void buildMemorySizeTest(int memorySize) {
        PcProduct product = new PcProduct.PcBuilder().buildMemorySize(memorySize).build();
        Assert.assertEquals(memorySize, product.getMemorySize());
    }

    @Test
    @Parameters({"1632.0"})
    public void buildPriceTest(BigDecimal price) {
        PcProduct product = new PcProduct.PcBuilder().buildPrice(price).build();
        Assert.assertEquals(price, product.getPrice());
    }

    @Test
    @Parameters({"BYR"})
    public void buildCurrencyTest(Currency currency) {
        PcProduct product = new PcProduct.PcBuilder().buildCurrency(currency).build();
        Assert.assertEquals(currency, product.getCurrency());
    }

    @Test
    public void buildTest() {
        PcProduct product = new PcProduct.PcBuilder().build();
        Assert.assertNotNull(product);
    }
}
