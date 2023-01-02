package vn.edu.hcmuaf.fit.dao.impl;

import vn.edu.hcmuaf.fit.dao.IBillDAO;
import vn.edu.hcmuaf.fit.db.JDBCConnector;
import vn.edu.hcmuaf.fit.model.AuthorModel;
import vn.edu.hcmuaf.fit.model.ShippingInfoModel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BillDAO implements IBillDAO {

    @Override
    public int totalBill() {
        Connection connection = JDBCConnector.getConnection();
        String sql = new String("SELECT Count(*) FROM bill");
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
    public List<ShippingInfoModel> shippingInfo() {
        List<ShippingInfoModel> results = new ArrayList<>();
        String sql = "SELECT bi.id_order, CONCAT(c.first_name,' ',c.last_name), bd.quantity*bo.price, " +
                "bi.shipping_info  FROM bill bi JOIN customer c ON bi.id_user = c.id_user " +
                "JOIN bill_details bd ON bi.id_order = bd.id_order JOIN book bo ON bd.id_book = bo.id_book ";
        Connection connection = JDBCConnector.getConnection();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        if(connection != null) {
            try {
                statement = connection.prepareStatement(sql);
                resultSet = statement.executeQuery();
                while (resultSet.next()) {
                    ShippingInfoModel shippingInfoModel = new ShippingInfoModel();
                    shippingInfoModel.setIdOrder(resultSet.getString(1));
                    shippingInfoModel.setFullName(resultSet.getString(2));
                    shippingInfoModel.setPrice(resultSet.getLong(3));
                    shippingInfoModel.setShippingInfo(resultSet.getString(4));
                    results.add(shippingInfoModel);
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
