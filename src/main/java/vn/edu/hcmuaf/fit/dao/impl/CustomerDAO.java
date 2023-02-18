package vn.edu.hcmuaf.fit.dao.impl;

import vn.edu.hcmuaf.fit.dao.ICustomerDAO;
import vn.edu.hcmuaf.fit.db.JDBCConnector;
import vn.edu.hcmuaf.fit.model.CustomerModel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class
CustomerDAO implements ICustomerDAO {

    @Override
    public CustomerModel findByUsernameAndPasswordAndStatus(String email, String password, int status) {
        List<CustomerModel> users = new ArrayList<>();
        Connection connection = JDBCConnector.getConnection();
        String sql = new String("SELECT * FROM customer WHERE email=? AND password=? AND status = ?");
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        if (connection != null) {
            try {
                statement = connection.prepareStatement(sql.toString());
                statement.setString(1, email);
                statement.setString(2, password);
                statement.setInt(3, status);
                resultSet = statement.executeQuery();
                while (resultSet.next()) {
                    CustomerModel customerModel = new CustomerModel();
                    customerModel.setIdUser(resultSet.getInt("id_user"));
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
                    if (connection != null) connection.close();
                    if (statement != null) statement.close();
                    if (resultSet != null) resultSet.close();
                } catch (SQLException e) {
                    return null;
                }
            }
        }
        return null;
    }


    public CustomerModel checkAccountExist(String email) {
        List<CustomerModel> users = new ArrayList<>();
        String sql = new String("SELECT * FROM customer WHERE email = ?");
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            Connection connection = JDBCConnector.getConnection();
            statement = connection.prepareStatement(sql.toString());
            statement.setString(1, email);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                CustomerModel customerModel = new CustomerModel();
                customerModel.setIdUser(resultSet.getInt("id_user"));
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
        }

    }

    public void signup(String email, String password, String firstname, String lastname, String phone, String address) {
        String sql = new String("INSERT INTO customer (first_name, last_name, email, password, address, phone, role, status)\n" +
                "VALUES (?, ?, ?, ?, ?, ?, 'user', 1)");
        PreparedStatement statement = null;
        try {
            Connection connection = JDBCConnector.getConnection();
            statement = connection.prepareStatement(sql.toString());
            statement.setString(1, firstname);
            statement.setString(2, lastname);
            statement.setString(3, email);
            statement.setString(4, password);
            statement.setString(5, address);
            statement.setString(6, phone);
            statement.executeUpdate();

        } catch (SQLException e) {
        }
    }

    public void changePassword(String email, String oldPass, String newPass) {
        String sql = new String("UPDATE customer \n" +
                "SET password = ?\n" +
                "WHERE email = ?");
        PreparedStatement statement = null;
        try {
            Connection connection = JDBCConnector.getConnection();
            statement = connection.prepareStatement(sql.toString());
            statement.setString(1, email);
            statement.setString(2, oldPass);
            statement.setString(3, newPass);
            statement.executeUpdate();
        } catch (SQLException e) {
        }
    }

    @Override
    public int totalCustomer() {
        Connection connection = JDBCConnector.getConnection();
        String sql = new String("SELECT Count(*) FROM customer WHERE role = 'user'");
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        int result = 0;
        if (connection != null) {
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
                    if (connection != null) connection.close();
                    if (statement != null) statement.close();
                    if (resultSet != null) resultSet.close();
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
        String sql = "SELECT id_user, CONCAT(first_name,' ',last_name), phone FROM customer WHERE role = 'user' " +
                "ORDER BY created_time DESC " +
                "LIMIT 0,10"; //lấy ra 10 khách hàng đăng kí gần nhất
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        if (connection != null) {
            try {
                statement = connection.prepareStatement(sql);
                resultSet = statement.executeQuery();
                while (resultSet.next()) {
                    CustomerModel customerModel = new CustomerModel();
                    customerModel.setIdUser(resultSet.getInt(1));
                    customerModel.setFullName(resultSet.getString(2));
                    customerModel.setPhone(resultSet.getString(3));
                    results.add(customerModel);
                }

                return results;
            } catch (SQLException e) {
                return null;
            } finally {
                try {
                    if (connection != null) connection.close();
                    if (statement != null) statement.close();
                    if (resultSet != null) resultSet.close();
                } catch (SQLException e) {
                    return null;
                }
            }
        }
        return null;
    }

    @Override
    public List<CustomerModel> findAllCustomer() {
        List<CustomerModel> users = new ArrayList<>();
        Connection connection = JDBCConnector.getConnection();
        String sql = new String("SELECT c.id_user, CONCAT(c.first_name,' ',c.last_name), c.phone, c.address, COUNT(b.id_user) " +
                "FROM customer c JOIN bill b ON c.id_user = b.id_user\n" +
                "GROUP BY c.id_user, CONCAT(c.first_name,' ',c.last_name), c.phone, c.address, b.id_user");
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            statement = connection.prepareStatement(sql.toString());
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                CustomerModel customerModel = new CustomerModel();
                customerModel.setIdUser(resultSet.getInt(1));
                customerModel.setFullName(resultSet.getString(2));
                customerModel.setPhone(resultSet.getString(3));
                customerModel.setAddress(resultSet.getString(4));
                customerModel.setTotalBill(resultSet.getInt(5));
                users.add(customerModel);
            }
            return users;
        } catch (SQLException e) {
            return null;
        }
    }

    @Override
    public CustomerModel findById(int idUser) {
        List<CustomerModel> users = new ArrayList<>();
        Connection connection = JDBCConnector.getConnection();
        String sql = new String("SELECT id_user, first_name, last_name, phone, address FROM customer " +
                "WHERE id_user = ?");
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            statement = connection.prepareStatement(sql.toString());
            statement.setInt(1, idUser);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                CustomerModel customerModel = new CustomerModel();
                customerModel.setIdUser(resultSet.getInt(1));
                customerModel.setFirstName(resultSet.getString(2));
                customerModel.setLastName(resultSet.getString(3));
                customerModel.setPhone(resultSet.getString(4));
                customerModel.setAddress(resultSet.getString(5));
                users.add(customerModel);
            }
            return users.isEmpty() ? null : users.get(0);
        } catch (SQLException e) {
            return null;
        }
    }

    @Override
    public int update(int idUser, String firstName, String lastName, String phone, String address) {
        Connection connection = JDBCConnector.getConnection();
        String sql = new String("UPDATE customer\n" +
                "SET first_name = ?,\n" +
                "last_name = ?,\n" +
                "phone = ?, \n" +
                "address = ?\n" +
                "WHERE id_user = ?");
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(sql.toString());
            statement.setInt(5, idUser);
            statement.setString(1, firstName);
            statement.setString(2, lastName);
            statement.setString(3, phone);
            statement.setString(4, address);
            return statement.executeUpdate();
        } catch (SQLException e) {
            return 0;
        }
    }

    @Override
    public CustomerModel findByUsername(String email, int status) {
        List<CustomerModel> users = new ArrayList<>();
        Connection connection = JDBCConnector.getConnection();
        String sql = new String("SELECT * FROM customer WHERE email=? AND  status = ?");
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        if (connection != null) {
            try {
                statement = connection.prepareStatement(sql.toString());
                statement.setString(1, email);
                statement.setInt(2, status);
                resultSet = statement.executeQuery();
                while (resultSet.next()) {
                    CustomerModel customerModel = new CustomerModel();
                    customerModel.setIdUser(resultSet.getInt("id_user"));
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
                    if (connection != null) connection.close();
                    if (statement != null) statement.close();
                    if (resultSet != null) resultSet.close();
                } catch (SQLException e) {
                    return null;
                }
            }
        }
        return null;
    }
}

