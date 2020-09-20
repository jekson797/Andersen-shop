package by.andersenlab.shop.tests.builders;

import by.andersenlab.shop.enums.AccessoryType;
import by.andersenlab.shop.enums.Currency;
import by.andersenlab.shop.products.ComputerAccessoryProduct;
import junitparams.Parameters;
import junitparams.JUnitParamsRunner;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.math.BigDecimal;

@RunWith(JUnitParamsRunner.class)
public class AccessoryBuilderTests {

    @Test
    @Parameters({"Canyon CNS-CMSW18PW"})
    public void buildNameTest(String name) {
        ComputerAccessoryProduct product = new ComputerAccessoryProduct.AccessoryBuilder().buildBrand(name).build();
        Assert.assertEquals(name, product.getBrand());
    }

    @Test
    @Parameters({"MOUSE"})
    public void buildAccessoryTypeTest(AccessoryType accessoryType) {
        ComputerAccessoryProduct product = new ComputerAccessoryProduct.AccessoryBuilder().
                buildAccessoryType(accessoryType).build();
        Assert.assertEquals(accessoryType, product.getAccessoryType());
    }

    @Test
    @Parameters({"47.90"})
    public void buildPriceTest(BigDecimal price) {
        ComputerAccessoryProduct product = new ComputerAccessoryProduct.AccessoryBuilder().buildPrice(price).build();
        Assert.assertEquals(price, product.getPrice());
    }

    @Test
    @Parameters({"BYR"})
    public void buildCurrencyTest(Currency currency) {
        ComputerAccessoryProduct product = new ComputerAccessoryProduct.AccessoryBuilder()
                .buildCurrency(currency).build();
        Assert.assertEquals(currency, product.getCurrency());
    }

    @Test
    public void buildTest() {
        ComputerAccessoryProduct product = new ComputerAccessoryProduct.AccessoryBuilder().build();
        Assert.assertNotNull(product);
    }
}
