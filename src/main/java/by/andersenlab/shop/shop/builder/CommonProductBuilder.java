package by.andersenlab.shop.shop.builder;

import by.andersenlab.shop.shop.enums.Currency;
import by.andersenlab.shop.shop.product.Product;
import by.andersenlab.shop.shop.enums.ProductGroup;

import java.math.BigDecimal;

public class CommonProductBuilder implements ProductBuilder {

    private Product product;

    @Override
    public CommonProductBuilder reset() {
        product = new Product();
        return this;
    }

    @Override
    public CommonProductBuilder setName(String name) {
        product.setName(name);
        return this;
    }

    @Override
    public CommonProductBuilder setGroup(ProductGroup group) {
        product.setGroup(group);
        return this;
    }

    @Override
    public CommonProductBuilder setPrice(BigDecimal price) {
        product.setPrice(price);
        return this;
    }

    @Override
    public CommonProductBuilder setCurrency(Currency currency) {
        product.setCurrency(currency);
        return this;
    }

    @Override
    public Product getProduct() {
        return product;
    }
}
