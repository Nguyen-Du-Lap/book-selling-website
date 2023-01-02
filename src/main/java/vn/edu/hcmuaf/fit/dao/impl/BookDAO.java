package vn.edu.hcmuaf.fit.dao.impl;

import vn.edu.hcmuaf.fit.dao.IProductDAO;
import vn.edu.hcmuaf.fit.db.JDBCConnector;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BookDAO implements IProductDAO {

    @Override
    public int totalProduct() {
        Connection connection = JDBCConnector.getConnection();
        String sql = new String("SELECT Count(*) FROM book");
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        int result=0;
        if(connection != null) {
            try {
                statement = connection.prepareStatement(sql.toString());
                resultSet = statement.executeQuery();
                while (resultSet.next()) {
                    result = resultSet.getInt(1);
                }

                return result;
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
    public int outOfStock() {
        Connection connection = JDBCConnector.getConnection();
        String sql = new String("SELECT Count(*) FROM book WHERE quantity < 10");
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        int result=0;
        if(connection != null) {
            try {
                statement = connection.prepareStatement(sql.toString());
                resultSet = statement.executeQuery();
                while (resultSet.next()) {
                    result = resultSet.getInt(1);
                }

                return result;
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
}
