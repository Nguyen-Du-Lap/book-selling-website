package vn.edu.hcmuaf.fit.dao.impl;

import vn.edu.hcmuaf.fit.dao.ICustomerDAO;
import vn.edu.hcmuaf.fit.db.JDBCConnector;
import vn.edu.hcmuaf.fit.model.AuthorModel;
import vn.edu.hcmuaf.fit.model.CustomerModel;
import vn.edu.hcmuaf.fit.model.ShippingInfoModel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerDAO implements ICustomerDAO {

    @Override
    public CustomerModel findByUsernameAndPasswordAndStatus(String email, String password, int status) {
        List<CustomerModel> users = new ArrayList<>();
        Connection connection = JDBCConnector.getConnection();
        String sql = new String("SELECT * FROM customer WHERE email=? AND password=? AND status = ?");
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        if(connection != null) {
            try {
                statement = connection.prepareStatement(sql.toString());
                statement.setString(1, email);
                statement.setString(2, password);
                statement.setInt(3, status);
                resultSet = statement.executeQuery();
                while (resultSet.next()) {
                    CustomerModel customerModel = new CustomerModel();
                    customerModel.setIdUser(resultSet.getString("id_user"));
                    customerModel.setFirstName(resultSet.getString("first_name"));
                    customerModel.setLastName(resultSet.getString("last_name"));
                    customerModel.setEmail(resultSet.getString("email"));
                    customerModel.setPassword(resultSet.getString("password"));
                    customerModel.setAddress(resultSet.getString("address"));
                    customerModel.setPhone(resultSet.getString("phone"));
                    customerModel.setRole(resultSet.getString("role"));
                    customerModel.setStatus(resultSet.getInt("status"));
                    customerModel.setCreatedTime(resultSet.getTimestamp("created_time"));
                    users.add(customerModel);
                }

                return users.isEmpty() ? null : users.get(0);
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
    public int totalCustomer() {
        Connection connection = JDBCConnector.getConnection();
        String sql = new String("SELECT Count(*) FROM customer WHERE role = 'user'");
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
    public List<CustomerModel> newCustomer() {
        List<CustomerModel> results = new ArrayList<>();
        Connection connection = JDBCConnector.getConnection();
        String sql = "SELECT id_user, CONCAT(first_name,' ',last_name),phone FROM customer " +
                "ORDER BY created_time DESC " +
                "LIMIT 0,10"; //lấy ra 10 khách hàng đăng kí gần nhất
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        if(connection != null) {
            try {
                statement = connection.prepareStatement(sql);
                resultSet = statement.executeQuery();
                while (resultSet.next()) {
                    CustomerModel customerModel = new CustomerModel();
                    customerModel.setIdUser(resultSet.getString(1));
                    customerModel.setFullName(resultSet.getString(2));
                    customerModel.setPhone(resultSet.getString(3));
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
