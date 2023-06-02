package vn.edu.hcmuaf.fit.dao.impl;

import vn.edu.hcmuaf.fit.dao.IRateDAO;
import vn.edu.hcmuaf.fit.db.JDBCConnector;
import vn.edu.hcmuaf.fit.model.Bill;
import vn.edu.hcmuaf.fit.model.RateModel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RateDAO implements IRateDAO {
    public List<RateModel> listRate(int idBook) {
        List<RateModel> results = new ArrayList<>();
        String sql = "SELECT rate.id_user, rate.id_book, rate.id_order, rate.start_rate ,rate.`comment`, rate.rate_time, customer.first_name\n" +
                "FROM rate JOIN customer ON rate.id_user = customer.id_user\n" +
                "WHERE rate.id_book = ? LIMIT 10 and rate.status =1";
        Connection connection = JDBCConnector.getConnection();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        if(connection != null) {
            try {
                statement = connection.prepareStatement(sql);
                statement.setInt(1, idBook);
                resultSet = statement.executeQuery();
                while (resultSet.next()) {
                    RateModel rateModel = new RateModel();
                    rateModel.setIdOrder(resultSet.getInt(1));
                    rateModel.setIdBook(resultSet.getInt(2));
                    rateModel.setIdOrder(resultSet.getInt(3));
                    rateModel.setStartRate(resultSet.getInt(4));
                    rateModel.setComment(resultSet.getString(5));
                    rateModel.setRate_time(resultSet.getTimestamp(6));
                    rateModel.setNameUser(resultSet.getString(7));
                    results.add(rateModel);
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
    public List<RateModel> listAll() {
        List<RateModel> results = new ArrayList<>();
        String sql = "SELECT r.id_book, r.id_order, r.start_rate, r.comment, r.rate_time, r.status,CONCAT(c.first_name, ' ', c.last_name) AS fullname, r.id_user\n" +
                "FROM rate r\n" +
                "JOIN customer c ON r.id_user = c.id_user ";

        Connection connection = JDBCConnector.getConnection();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        if(connection != null) {
            try {
                statement = connection.prepareStatement(sql);
                resultSet = statement.executeQuery();
                while (resultSet.next()) {
                    RateModel rateModel = new RateModel();
                    rateModel.setIdBook(resultSet.getInt(1));
                    rateModel.setIdOrder(resultSet.getInt(2));
                    rateModel.setStartRate(resultSet.getInt(3));
                    rateModel.setComment(resultSet.getString(4));
                    rateModel.setRate_time(resultSet.getTimestamp(5));
                    rateModel.setStatus(resultSet.getInt(6));
                    rateModel.setNameUser(resultSet.getString(7));
                    rateModel.setIdUser(resultSet.getInt(8));
                    results.add(rateModel);
                }

                return results;
            } catch (SQLException e) {
                e.printStackTrace();
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
    public void hideRate(String idOrder, String idBook) {
        String sql = "UPDATE rate SET STATUS = 0 WHERE id_order = ? AND id_book = ?";
        Connection connection = JDBCConnector.getConnection();
        PreparedStatement statement = null;
        try {
            if(connection != null) {
                statement = connection.prepareStatement(sql);
                statement.setString(1, idOrder);
                statement.setString(2, idBook);
                statement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if(connection != null) connection.close();
                if(statement != null) statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    public void actitvityRate(String idOrder, String idBook) {
        String sql = "UPDATE rate SET STATUS = 1 WHERE id_order = ? AND id_book = ?";
        Connection connection = JDBCConnector.getConnection();
        PreparedStatement statement = null;
        try {
            if(connection != null) {
                statement = connection.prepareStatement(sql);
                statement.setString(1, idOrder);
                statement.setString(2, idBook);
                statement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if(connection != null) connection.close();
                if(statement != null) statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }



}
