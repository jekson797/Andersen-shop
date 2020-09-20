package by.andersenlab.shop.tests.builders;

import by.andersenlab.shop.enums.Currency;
import by.andersenlab.shop.products.PhoneProduct;
import by.andersenlab.shop.products.Product;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.math.BigDecimal;

@RunWith(JUnitParamsRunner.class)
public class PhoneBuilderTests {

    private static final double DELTA = 0.001;

    @Test
    @Parameters({"HONOR 30"})
    public void buildNameTest(String name) {
        PhoneProduct product = new PhoneProduct.PhoneBuilder().buildBrand(name).build();
        Assert.assertEquals(name, product.getBrand());
    }

    @Test
    @Parameters({"Android 10"})
    public void buildOsTest(String os) {
        PhoneProduct product = new PhoneProduct.PhoneBuilder().buildOs(os).build();
        Assert.assertEquals(os, product.getOs());
    }

    @Test
    @Parameters({"6.53"})
    public void buildScreenSizeTest(double diagonal) {
        PhoneProduct product = new PhoneProduct.PhoneBuilder().buildDiagonal(diagonal).build();
        Assert.assertEquals(diagonal, product.getDiagonal(), DELTA);
    }

    @Test
    @Parameters({"8"})
    public void buildRamTest(int ram) {
        PhoneProduct product = new PhoneProduct.PhoneBuilder().buildRam(ram).build();
        Assert.assertEquals(ram, product.getRam());
    }

    @Test
    @Parameters({"256"})
    public void buildMemorySizeTest(int memorySize) {
        PhoneProduct product = new PhoneProduct.PhoneBuilder().buildMemorySize(memorySize).build();
        Assert.assertEquals(memorySize, product.getMemorySize());
    }

    @Test
    @Parameters({"8"})
    public void buildCoreNumbersTest(int coresNumber) {
        PhoneProduct product = new PhoneProduct.PhoneBuilder().buildCoreNumbers(coresNumber).build();
        Assert.assertEquals(coresNumber, product.getCoresNumber());
    }

    @Test
    @Parameters({"1299.0"})
    public void buildPriceTest(BigDecimal price) {
        PhoneProduct product = new PhoneProduct.PhoneBuilder().buildPrice(price).build();
        Assert.assertEquals(price, product.getPrice());
    }

    @Test
    @Parameters({"BYR"})
    public void buildCurrencyTest(Currency currency) {
        PhoneProduct product = new PhoneProduct.PhoneBuilder().buildCurrency(currency).build();
        Assert.assertEquals(currency, product.getCurrency());
    }

    @Test
    public void buildTest() {
        PhoneProduct product = new PhoneProduct.PhoneBuilder().build();
        Assert.assertNotNull(product);
    }
}
