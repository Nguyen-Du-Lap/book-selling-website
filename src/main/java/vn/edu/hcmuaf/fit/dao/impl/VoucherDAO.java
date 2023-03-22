package vn.edu.hcmuaf.fit.dao.impl;

import vn.edu.hcmuaf.fit.dao.IVoucherDAO;
import vn.edu.hcmuaf.fit.db.JDBCConnector;
import vn.edu.hcmuaf.fit.model.SlidePrModel;
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
                "WHERE discount.id_discount NOT IN \n" +
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
}
