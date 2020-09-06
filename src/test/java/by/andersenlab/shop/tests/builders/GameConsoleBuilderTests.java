package by.andersenlab.shop.tests.builders;

import by.andersenlab.shop.enums.Currency;
import by.andersenlab.shop.enums.MemoryDriveType;
import by.andersenlab.shop.products.GameConsoleProduct;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.math.BigDecimal;

@RunWith(JUnitParamsRunner.class)
public class GameConsoleBuilderTests {

    @Test
    @Parameters({"Playstation 4"})
    public void buildNameTest(String name) {
        GameConsoleProduct product = new GameConsoleProduct.GameConsoleBuilder().buildName(name).build();
        Assert.assertEquals(name, product.getName());
    }

    @Test
    @Parameters({"HDD"})
    public void buildDriveTypeTest(MemoryDriveType driveType) {
        GameConsoleProduct product = new GameConsoleProduct.GameConsoleBuilder().buildDriveType(driveType).build();
        Assert.assertEquals(driveType, product.getDriveType());
    }

    @Test
    @Parameters({"500"})
    public void buildMemorySizeTest(int memorySize) {
        GameConsoleProduct product = new GameConsoleProduct.GameConsoleBuilder().buildMemorySize(memorySize).build();
        Assert.assertEquals(memorySize, product.getMemorySize());
    }

    @Test
    @Parameters({"2"})
    public void buildControllersAmountTest(int controllersAmount) {
        GameConsoleProduct product = new GameConsoleProduct.GameConsoleBuilder().buildControllersAmount(2).build();
        Assert.assertEquals(controllersAmount, product.getControllersAmount());
    }

    @Test
    @Parameters({"Uncharted 4"})
    public void addIncludedGameTest(String game) {
        GameConsoleProduct product = new GameConsoleProduct.GameConsoleBuilder().addIncludedGame(game).build();
        Assert.assertTrue(product.getGamesIncluded().contains(game));
    }

    @Test
    @Parameters({"829.00"})
    public void buildPriceTest(BigDecimal price) {
        GameConsoleProduct product = new GameConsoleProduct.GameConsoleBuilder().buildPrice(price).build();
        Assert.assertEquals(price, product.getPrice());
    }

    @Test
    @Parameters({"BYR"})
    public void buildCurrencyTest(Currency currency) {
        GameConsoleProduct product = new GameConsoleProduct.GameConsoleBuilder().buildCurrency(currency).build();
        Assert.assertEquals(currency, product.getCurrency());
    }

    @Test
    public void buildTest() {
        GameConsoleProduct product = new GameConsoleProduct.GameConsoleBuilder().build();
        Assert.assertNotNull(product);
    }
}
