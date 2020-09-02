package by.andersenlab.shop.conditions;

import by.andersenlab.shop.builder.CommonProductBuilder;
import by.andersenlab.shop.enums.Currency;
import by.andersenlab.shop.enums.ProductGroup;
import by.andersenlab.shop.product.Product;
import org.junit.BeforeClass;

import java.math.BigDecimal;

public class BeforeClassAnnotationsUnitTest {

    private static Product product;

    @BeforeClass
    public static void setup() {
        product = new CommonProductBuilder().
                reset().
                setName("Playstation 5").
                setGroup(ProductGroup.GAME_CONSOLE).
                setPrice(new BigDecimal("500.0")).
                setCurrency(Currency.USD).
                getProduct();
    }

    protected Product getProduct() {
        return product;
    }
}
