package by.andersenlab.shop.tests.builders;

import by.andersenlab.shop.enums.Currency;
import by.andersenlab.shop.enums.DisplayType;
import by.andersenlab.shop.products.MonitorProduct;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.math.BigDecimal;

@RunWith(JUnitParamsRunner.class)
public class MonitorBuilderTests {

    private static final double DELTA  = 0.01;

    @Test
    @Parameters({"HP 27f"})
    public void buildNameTest(String name) {
        MonitorProduct product = new MonitorProduct.MonitorBuilder().buildBrand(name).build();
        Assert.assertEquals(name, product.getBrand());
    }

    @Test
    @Parameters({"16:9"})
    public void buildAspectRationTest(String aspectRation) {
        MonitorProduct product = new MonitorProduct.MonitorBuilder().buildAspectRatio(aspectRation).build();
        Assert.assertEquals(aspectRation, product.getAspectRatio());
    }

    @Test
    @Parameters({"1920x1080"})
    public void buildResolutionTest(String resolution) {
        MonitorProduct product = new MonitorProduct.MonitorBuilder().buildResolution(resolution).build();
        Assert.assertEquals(resolution, product.getResolution());
    }

    @Test
    @Parameters({"27.0"})
    public void buildDiagonalTest(double diagonal) {
        MonitorProduct product = new MonitorProduct.MonitorBuilder().buildDiagonal(diagonal).build();
        Assert.assertEquals(diagonal, product.getDiagonal(), DELTA);
    }

    @Test
    @Parameters({"IPS"})
    public void buildDisplayTypeTest(DisplayType displayType) {
        MonitorProduct product = new MonitorProduct.MonitorBuilder().buildDisplayType(displayType).build();
        Assert.assertEquals(displayType, product.getDisplayType());
    }

    @Test
    @Parameters({"507.32"})
    public void buildPriceTest(BigDecimal price) {
        MonitorProduct product = new MonitorProduct.MonitorBuilder().buildPrice(price).build();
        Assert.assertEquals(price, product.getPrice());
    }

    @Test
    @Parameters({"BYR"})
    public void buildCurrencyTest(Currency currency) {
        MonitorProduct product = new MonitorProduct.MonitorBuilder().buildCurrency(currency).build();
        Assert.assertEquals(currency, product.getCurrency());
    }

    @Test
    public void buildTest() {
        MonitorProduct product = new MonitorProduct.MonitorBuilder().build();
        Assert.assertNotNull(product);
    }
}
