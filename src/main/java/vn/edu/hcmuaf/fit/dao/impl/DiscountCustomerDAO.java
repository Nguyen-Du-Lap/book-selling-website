package vn.edu.hcmuaf.fit.dao.impl;

import vn.edu.hcmuaf.fit.dao.IDiscountCustomerDAO;
import vn.edu.hcmuaf.fit.db.JDBCConnector;
import vn.edu.hcmuaf.fit.model.DiscountCustomerModel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DiscountCustomerDAO implements IDiscountCustomerDAO {
    public List<DiscountCustomerModel> listDiscountCus(int idUser, double totalPrice) {
        List<DiscountCustomerModel> results = new ArrayList<>();
        String sql = "SELECT dc.id_discount, dc.id_user, d.name, d.percent_discount, d.diktat\n" +
                "from discount_customer dc JOIN discount d ON dc.id_discount = d.id_discount\n" +
                "WHERE dc.id_user = ? AND d.price_minimum < ?";
        Connection connection = JDBCConnector.getConnection();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        if(connection != null) {
            try {
                statement = connection.prepareStatement(sql);
                statement.setInt(1, idUser);
                statement.setDouble(2, totalPrice);
                resultSet = statement.executeQuery();
                while (resultSet.next()) {
                    DiscountCustomerModel customerModel = new DiscountCustomerModel();
                    customerModel.setIdDiscount(resultSet.getInt(1));
                    customerModel.setIdUser(resultSet.getInt(2));
                    customerModel.setName(resultSet.getString(3));
                    customerModel.setPercent_discount(resultSet.getInt(4));
                    customerModel.setDiktat(resultSet.getString(5));
                    results.add(customerModel);
                }

                return results;
            } catch (SQLException e) {
                return null;
            } finally {
                try {
                    if(connection != null) connection.close();
                    if(statement != null) statement.close();
                    if(resultSet != null) resultSet.close();
                } catch (SQLException e) {
                    return null;
                }
            }
        }
        return null;
    }

    @Override
    public boolean checkIdVoucherInCus(int idVoucher, int idUser) {
        List<Integer> results = new ArrayList<>();
        String sql = "SELECT id_discount\n" +
                "FROM discount_customer\n" +
                "WHERE id_user = ? AND id_discount = ?";
        Connection connection = JDBCConnector.getConnection();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        if(connection != null) {
            try {
                statement = connection.prepareStatement(sql);
                statement.setInt(1, idUser);
                statement.setInt(2, idVoucher);
                resultSet = statement.executeQuery();
                while (resultSet.next()) {
                    results.add(resultSet.getInt(1));
                }

                return results.size() > 0;
            } catch (SQLException e) {
                return false;
            } finally {
                try {
                    if(connection != null) connection.close();
                    if(statement != null) statement.close();
                    if(resultSet != null) resultSet.close();
                } catch (SQLException e) {
                    return false;
                }
            }
        }
        return false;
    }

    @Override
    public List<DiscountCustomerModel> findDisByIdVou(int idUser, int idVoucher) {
        List<DiscountCustomerModel> results = new ArrayList<>();
        String sql = "SELECT dc.id_discount, dc.id_user, d.name, d.percent_discount, d.diktat\n" +
                "from discount_customer dc JOIN discount d ON dc.id_discount = d.id_discount\n" +
                "WHERE dc.id_user = ? AND dc.id_discount = ?";
        Connection connection = JDBCConnector.getConnection();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        if(connection != null) {
            try {
                statement = connection.prepareStatement(sql);
                statement.setInt(1, idUser);
                statement.setDouble(2, idVoucher);
                resultSet = statement.executeQuery();
                while (resultSet.next()) {
                    DiscountCustomerModel customerModel = new DiscountCustomerModel();
                    customerModel.setIdDiscount(resultSet.getInt(1));
                    customerModel.setIdUser(resultSet.getInt(2));
                    customerModel.setName(resultSet.getString(3));
                    customerModel.setPercent_discount(resultSet.getInt(4));
                    customerModel.setDiktat(resultSet.getString(5));
                    results.add(customerModel);
                }

                return results;
            } catch (SQLException e) {
                return null;
            } finally {
                try {
                    if(connection != null) connection.close();
                    if(statement != null) statement.close();
                    if(resultSet != null) resultSet.close();
                } catch (SQLException e) {
                    return null;
                }
            }
        }
        return null;
    }
}
