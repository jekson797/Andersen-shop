package by.andersenlab.shop.dao;

import by.andersenlab.shop.enums.Currency;
import by.andersenlab.shop.enums.ProductGroup;
import by.andersenlab.shop.products.Product;
import by.andersenlab.shop.singleton.DatabaseConnection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ProductDao implements Dao<Product> {

    @Override
    public Optional<Product> getById(long id) {
        Optional<Product> product = Optional.empty();
        String query = getQueryForSelectingById();
        try (PreparedStatement statement = DatabaseConnection.getConnection().prepareStatement(query)) {
            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();
            product = Optional.ofNullable(convertResultSetToProductsList(resultSet).get(0));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return product;
    }

    @Override
    public List<Product> getAll() {
        List<Product> products = null;
        String query = getQueryForAllSelecting();
        try (Statement statement = DatabaseConnection.getConnection().createStatement()) {
            ResultSet resultSet = statement.executeQuery(query);
            products = convertResultSetToProductsList(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return products;
    }

    @Override
    public boolean save(Product product) {
        String query = getQueryForSaving();
        try (PreparedStatement statement = DatabaseConnection.getConnection().prepareStatement(query)) {
            configureStatementForSaving(statement, product);
            statement.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            try {
                DatabaseConnection.getConnection().rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            return false;
        }
    }

    @Override
    public void deleteById(long id) {

    }

    protected List<Product> convertResultSetToProductsList(ResultSet resultSet) {
        List<Product> products = new ArrayList<>();
        try {
            while (resultSet.next()) {
                Product product = new Product();
                product.setProductId(resultSet.getInt("productId"));
                product.setBrand(resultSet.getString("brand"));
                product.setModel(resultSet.getString("model"));
                product.setGroup(ProductGroup.valueOf(resultSet.getString("category")));
                product.setPrice(resultSet.getBigDecimal("price"));
                product.setCurrency(Currency.valueOf(resultSet.getString("currency")));
                products.add(product);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return products;
    }

    protected String getQueryForSelectingById() {
        return "SELECT * FROM products WHERE productId=?";
    }

    protected String getQueryForAllSelecting() {
        return "SELECT * FROM products";
    }

    protected String getQueryForSaving() {
        return "INSERT INTO products (brand, model, category, price, currency) " +
                "VALUES (?, ?, ?, ?, ?)";
    }

    private void configureStatementForSaving(PreparedStatement statement, Product product)
            throws SQLException {
        statement.setString(1, product.getBrand());
        statement.setString(2, product.getModel());
        statement.setString(3, product.getGroupEnum().getOriginalValue());
        statement.setBigDecimal(4, product.getPrice());
        statement.setString(5, product.getCurrency().toString());
    }
}
