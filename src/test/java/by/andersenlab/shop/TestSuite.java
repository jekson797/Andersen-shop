package by.andersenlab.shop;

import by.andersenlab.shop.tests.CommandsTests;
import by.andersenlab.shop.tests.builders.*;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        CommandsTests.class,
        PhoneBuilderTests.class,
        PcBuilderTests.class,
        NotebookBuilderTests.class,
        MonitorBuilderTests.class,
        GameConsoleBuilderTests.class,
        AccessoryBuilderTests.class
})
public class TestSuite { }
