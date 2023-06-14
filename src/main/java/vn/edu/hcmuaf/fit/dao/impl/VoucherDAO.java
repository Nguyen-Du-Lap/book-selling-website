package vn.edu.hcmuaf.fit.dao.impl;

import vn.edu.hcmuaf.fit.dao.IVoucherDAO;
import vn.edu.hcmuaf.fit.db.JDBCConnector;
import vn.edu.hcmuaf.fit.model.SlidePrModel;
import vn.edu.hcmuaf.fit.model.VoucherManagementModel;
import vn.edu.hcmuaf.fit.model.VoucherModel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class VoucherDAO implements IVoucherDAO {
    @Override
    public List<VoucherModel> findAllVoucherById(int idUser) {
        List<VoucherModel> results = new ArrayList<>();
        String sql = "SELECT discount.id_discount, discount.name, discount.diktat\n" +
                "FROM discount \n" +
                "WHERE discount.`status` = 1 AND discount.id_discount NOT IN \n" +
                "(SELECT discount_customer.id_discount FROM discount_customer WHERE discount_customer.id_user = ?)";
        Connection connection = JDBCConnector.getConnection();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        if(connection != null) {
            try {
                statement = connection.prepareStatement(sql);
                statement.setInt(1, idUser);
                resultSet = statement.executeQuery();
                while (resultSet.next()) {
                   VoucherModel voucherModel = new VoucherModel();
                   voucherModel.setIdVoucher(resultSet.getInt(1));
                   voucherModel.setName(resultSet.getString(2));
                   voucherModel.setDiktat(resultSet.getString(3));
                    results.add(voucherModel);
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
    public int getPriceVoucher(int idVoucher) {
        int results = 0;
        String sql = "SELECT percent_discount \n" +
                "FROM discount\n" +
                "WHERE id_discount = ?";
        Connection connection = JDBCConnector.getConnection();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        if(connection != null) {
            try {
                statement = connection.prepareStatement(sql);
                statement.setInt(1, idVoucher);
                resultSet = statement.executeQuery();
                while (resultSet.next()) {
                    results = resultSet.getInt(1);
                }

                return results;
            } catch (SQLException e) {
                return 0;
            } finally {
                try {
                    if(connection != null) connection.close();
                    if(statement != null) statement.close();
                    if(resultSet != null) resultSet.close();
                } catch (SQLException e) {
                    return 0;
                }
            }
        }
        return 0;
    }

    @Override
    public void saveVoucherCus(int id, int idCus) {
        String sql = "INSERT INTO discount_customer VALUES(?, ?, 1)";
        Connection connection = JDBCConnector.getConnection();
        PreparedStatement statement = null;
        if(connection != null) {
            try {
                statement = connection.prepareStatement(sql);
                statement.setInt(1, id);
                statement.setInt(2, idCus);
                statement.executeUpdate();
            } catch (SQLException e) {
            } finally {
                try {
                    if(connection != null) connection.close();
                    if(statement != null) statement.close();
                } catch (SQLException e) {
                }
            }
        }
    }

    @Override
    public void updateVoucher(int id) {
        String sql = "UPDATE discount SET quantity = quantity-1 WHERE id_discount = ?";
        Connection connection = JDBCConnector.getConnection();
        PreparedStatement statement = null;
        if(connection != null) {
            try {
                statement = connection.prepareStatement(sql);
                statement.setInt(1, id);
                statement.executeUpdate();
            } catch (SQLException e) {
            } finally {
                try {
                    if(connection != null) connection.close();
                    if(statement != null) statement.close();
                } catch (SQLException e) {
                }
            }
        }
    }

    public List<VoucherManagementModel> findAllVoucher() {
        List<VoucherManagementModel> results = new ArrayList<>();
        String sql = "SELECT * FROM discount";
        Connection connection = JDBCConnector.getConnection();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        if(connection != null) {
            try {
                statement = connection.prepareStatement(sql);
                resultSet = statement.executeQuery();
                while (resultSet.next()) {
                    VoucherManagementModel voucherModel = new VoucherManagementModel();
                    voucherModel.setId_discount(resultSet.getInt(1));
                    voucherModel.setName(resultSet.getString(2));
                    voucherModel.setQuantity(resultSet.getInt(3));
                    voucherModel.setPercent_discount(resultSet.getInt(4));
                    voucherModel.setDiktat(resultSet.getString(5));
                    voucherModel.setStatus(resultSet.getInt(6));
                    voucherModel.setPrice_minimum(resultSet.getInt(7));
                    results.add(voucherModel);
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

    // function addVoucher have attribute name, quantity, percent_discount, diktat, price_minimum
    public void addVoucher(String name, int quantity, int percent_discount, String diktat, int price_minimum) {
        String sql = "INSERT INTO discount (name, quantity, percent_discount, diktat, status, price_minimum) VALUES(?, ?, ?, ?, ?, ?)";
        Connection connection = JDBCConnector.getConnection();
        PreparedStatement statement = null;
        if(connection != null) {
            try {
                statement = connection.prepareStatement(sql);
                statement.setString(1, name);
                statement.setInt(2, quantity);
                statement.setInt(3, percent_discount);
                statement.setString(4, diktat);
                statement.setInt(5, 1);
                statement.setInt(6, price_minimum);
                statement.executeUpdate();
            } catch (SQLException e) {
            } finally {
                try {
                    if(connection != null) connection.close();
                    if(statement != null) statement.close();
                } catch (SQLException e) {
                }
            }
        }
    }

}
