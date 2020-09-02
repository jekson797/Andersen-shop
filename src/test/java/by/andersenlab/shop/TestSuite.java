package by.andersenlab.shop;

import by.andersenlab.shop.tests.CommandsTests;
import by.andersenlab.shop.tests.ProductBuilderTests;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        CommandsTests.class,
        ProductBuilderTests.class
})
public class TestSuite { }
