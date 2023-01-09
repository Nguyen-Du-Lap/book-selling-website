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
                "WHERE rate.id_book = ? LIMIT 10";
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
}
