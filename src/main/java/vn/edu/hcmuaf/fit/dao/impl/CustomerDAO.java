package vn.edu.hcmuaf.fit.dao.impl;

import vn.edu.hcmuaf.fit.dao.ICustomerDAO;
import vn.edu.hcmuaf.fit.db.JDBCConnector;
import vn.edu.hcmuaf.fit.model.AuthorModel;
import vn.edu.hcmuaf.fit.model.CustomerModel;

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
        String sql = new String("SELECT * FROM customer WHERE email=? AND password=?");
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        if(connection != null) {
            try {
                statement = connection.prepareStatement(sql.toString());
                statement.setString(1, email);
                statement.setString(2, password);
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
}
