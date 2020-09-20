package by.andersenlab.shop.dao;

import by.andersenlab.shop.enums.Currency;
import by.andersenlab.shop.products.PhoneProduct;
import by.andersenlab.shop.products.Product;
import by.andersenlab.shop.singleton.DatabaseConnection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PhoneDao extends ProductDao {

    @Override
    public boolean save(Product product) {
        PhoneProduct phone = (PhoneProduct) product;
        String query = getQueryForSaving();
        try (PreparedStatement statement = DatabaseConnection.getConnection().prepareStatement(query)) {
            configureStatementForSaving(statement, phone);
            statement.executeUpdate();
            DatabaseConnection.getConnection().commit();
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
    protected List<Product> convertResultSetToProductsList(ResultSet resultSet) {
        List<Product> products = new ArrayList<>();
        try {
            while (resultSet.next()) {
                PhoneProduct product = new PhoneProduct.PhoneBuilder().
                        buildBrand(resultSet.getString("brand")).
                        buildModel(resultSet.getString("model")).
                        buildOs(resultSet.getString("os")).
                        buildMemorySize(resultSet.getInt("memorySize")).
                        buildRam(resultSet.getInt("ram")).
                        buildCoreNumbers(resultSet.getInt("coresNumber")).
                        buildDiagonal(resultSet.getFloat("diagonal")).
                        buildPrice(resultSet.getBigDecimal("price")).
                        buildCurrency(Currency.valueOf(resultSet.getString("currency"))).
                        build();
                products.add(product);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return products;
    }

    @Override
    protected String getQueryForSelectingById() {
        return "SELECT p.productId, p.brand, p.model, " +
                "ph.os, ph.memory_size, ph.ram, " +
                "ph.cpu_cores, ph.diagonal, p.price, p.currency " +
                "FROM products p JOIN phones ph ON p.productId=ph.productId " +
                "WHERE productId=?";
    }

    @Override
    protected String getQueryForAllSelecting() {
        return "SELECT p.productId, p.brand, p.model, " +
                "ph.os, ph.memory_size, ph.ram, " +
                "ph.cpu_cores, ph.diagonal, p.price, p.currency " +
                "FROM products p JOIN phones ph ON p.productId=ph.productId " +
                "WHERE productId=?";
    }

    @Override
    protected String getQueryForSaving() {
        return "INSERT INTO phones (brand, model, os, memory_size, ram, cpu_cores, diagonal) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?)";
    }

    private void configureStatementForSaving(PreparedStatement statement, PhoneProduct phone)
            throws SQLException {
        statement.setString(1, phone.getBrand());
        statement.setString(2, phone.getModel());
        statement.setString(3, phone.getOs());
        statement.setInt(4, phone.getMemorySize());
        statement.setInt(5, phone.getRam());
        statement.setInt(6, phone.getCoresNumber());
        statement.setDouble(7, phone.getDiagonal());
    }
}
