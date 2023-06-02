package vn.edu.hcmuaf.fit.dao.impl;

import vn.edu.hcmuaf.fit.db.JDBCConnector;
import vn.edu.hcmuaf.fit.model.InformationDeliverModel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class InformationDeliverDao {
    public InformationDeliverModel getById(int id) {
        InformationDeliverModel informationDeliverModel = new InformationDeliverModel();
        String sql = "SELECT id, idCart, x,y,z,w,districtTo, warTo FROM infomationdelivers where idCart =?";
        Connection connection = JDBCConnector.getConnection();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        if(connection != null) {
            try {
                statement = connection.prepareStatement(sql);
                statement.setInt(1, id);
                resultSet = statement.executeQuery();
                while (resultSet.next()) {

                    informationDeliverModel.setId(resultSet.getInt(1));
                    informationDeliverModel.setIdOrder(resultSet.getInt(2));
                    informationDeliverModel.setX(resultSet.getInt(3));
                    informationDeliverModel.setY(resultSet.getInt(4));
                    informationDeliverModel.setZ(resultSet.getInt(5));
                    informationDeliverModel.setW(resultSet.getInt(6));
                    informationDeliverModel.setDistrictTo(resultSet.getString(7));
                    informationDeliverModel.setWarTo(resultSet.getString(8));

                }

                return informationDeliverModel;
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
    public void insertInfomationDeliver(InformationDeliverModel a) {
        Connection connection = JDBCConnector.getConnection();
        PreparedStatement statement = null;

        if (connection != null) {
            try {
                String sql = "INSERT INTO infomationdelivers(idCart, x,y,z,w, districtTo,warTo) VALUES (?, ?, ?, ?, ?,?,?)";
                statement = connection.prepareStatement(sql);
                statement.setInt(1, a.getIdOrder());
                statement.setInt(2, a.getX());
                statement.setInt(3, a.getY());
                statement.setInt(4, a.getZ());
                statement.setInt(5, a.getW());
                statement.setString(6, a.getDistrictTo());
                statement.setString(7, a.getWarTo());
                statement.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                try {
                    if (connection != null) connection.close();
                    if (statement != null) statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    public void updateToken(int id, String token) {
        String sql = "update infomationdelivers set token =? where idCart =?";
        Connection connection = JDBCConnector.getConnection();
        PreparedStatement statement = null;

        if(connection != null) {
            try {
                statement = connection.prepareStatement(sql);
                statement.setString(1, token);
                statement.setInt(2, id);
               statement.executeUpdate();

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
