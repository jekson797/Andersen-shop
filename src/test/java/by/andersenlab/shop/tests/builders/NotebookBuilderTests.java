package by.andersenlab.shop.tests.builders;

import by.andersenlab.shop.enums.Currency;
import by.andersenlab.shop.enums.DisplayType;
import by.andersenlab.shop.enums.MemoryDriveType;
import by.andersenlab.shop.products.NotebookProduct;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.math.BigDecimal;

@RunWith(JUnitParamsRunner.class)
public class NotebookBuilderTests {

    @Test
    @Parameters({"ASUS TUF Gaming FX505DT-BQ180"})
    public void buildNameTest(String name) {
        NotebookProduct product = new NotebookProduct.NotebookBuilder().buildBrand(name).build();
        Assert.assertEquals(name, product.getBrand());
    }

    @Test
    @Parameters({"NVIDIA GeForce GTX 1650"})
    public void buildGpuNameTest(String gpuName) {
        NotebookProduct product = new NotebookProduct.NotebookBuilder().buildGpuName(gpuName).build();
        Assert.assertEquals(gpuName, product.getGpuName());
    }

    @Test
    @Parameters({"AMD Ryzen 5 3550H"})
    public void buildCpuNameTest(String cpuName) {
        NotebookProduct product = new NotebookProduct.NotebookBuilder().buildCpuName(cpuName).build();
        Assert.assertEquals(cpuName, product.getCpuName());
    }

    @Test
    @Parameters({"4"})
    public void buildCoresNumberTest(int coresNumber) {
        NotebookProduct product = new NotebookProduct.NotebookBuilder().buildCoresNumber(coresNumber).build();
        Assert.assertEquals(coresNumber, product.getCoresNumber());
    }

    @Test
    @Parameters({"8"})
    public void buildRamTest(int ram) {
        NotebookProduct product = new NotebookProduct.NotebookBuilder().buildRam(ram).build();
        Assert.assertEquals(ram, product.getRam());
    }

    @Test
    @Parameters({"256"})
    public void buildMemorySizeTest(int memorySize) {
        NotebookProduct product = new NotebookProduct.NotebookBuilder().buildMemorySize(memorySize).build();
        Assert.assertEquals(memorySize, product.getMemorySize());
    }

    @Test
    @Parameters({"SSD"})
    public void buildDriveTypeTest(MemoryDriveType driveType) {
        NotebookProduct product = new NotebookProduct.NotebookBuilder().buildDriveType(driveType).build();
        Assert.assertEquals(driveType, product.getDriveType());
    }

    @Test
    @Parameters({"IPS"})
    public void buildDisplayTypeTest(DisplayType displayType) {
        NotebookProduct product = new NotebookProduct.NotebookBuilder().buildDisplayType(displayType).build();
        Assert.assertEquals(displayType, product.getDisplayType());
    }

    @Test
    @Parameters({"2537.84"})
    public void buildPriceTest(BigDecimal price) {
        NotebookProduct product = new NotebookProduct.NotebookBuilder().buildPrice(price).build();
        Assert.assertEquals(price, product.getPrice());
    }

    @Test
    @Parameters({"BYR"})
    public void buildCurrencyTest(Currency currency) {
        NotebookProduct product = new NotebookProduct.NotebookBuilder().buildCurrency(currency).build();
        Assert.assertEquals(currency, product.getCurrency());
    }

    @Test
    public void buildTest() {
        NotebookProduct product = new NotebookProduct.NotebookBuilder().build();
        Assert.assertNotNull(product);
    }
}
