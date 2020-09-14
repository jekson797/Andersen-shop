package by.andersenlab.shop.user;

import by.andersenlab.shop.enums.Currency;
import by.andersenlab.shop.enums.UserRole;
import by.andersenlab.shop.products.Product;

import java.math.BigDecimal;
import java.util.ArrayList;

public class User {

    private ArrayList<Product> shoppingCart;
    private UserRole role;
    private BigDecimal money;
    private Currency currency;

    public User(UserRole role, BigDecimal money, Currency currency) {
        shoppingCart = new ArrayList<>();
        this.role = role;
        this.money = money;
        this.currency = currency;
    }

    public UserRole getRole() {
        return role;
    }

    public void setRole(UserRole role) {
        this.role = role;
    }

    public BigDecimal getMoney() {
        return money;
    }

    public void setMoney(BigDecimal money) {
        this.money = money;
    }

    public ArrayList<Product> getShoppingCart() {
        return shoppingCart;
    }
}
