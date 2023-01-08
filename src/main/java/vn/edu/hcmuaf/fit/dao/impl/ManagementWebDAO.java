package vn.edu.hcmuaf.fit.dao.impl;

import vn.edu.hcmuaf.fit.dao.IManagementWebDAO;
import vn.edu.hcmuaf.fit.db.JDBCConnector;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ManagementWebDAO implements IManagementWebDAO {
    @Override
    public void saveWebManagement(String name, String nameWeb, String content) {
        Connection connection = JDBCConnector.getConnection();
        String sql = new String("INSERT INTO owner(name_website, name_company, information_company) " +
                "VALUES (?, ?, ?)");

        PreparedStatement statement = null;
        if(connection != null) {
            try {
                statement = connection.prepareStatement(sql.toString());
                statement.setString(1, nameWeb);
                statement.setString(2, name);
                statement.setString(3, content);
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
