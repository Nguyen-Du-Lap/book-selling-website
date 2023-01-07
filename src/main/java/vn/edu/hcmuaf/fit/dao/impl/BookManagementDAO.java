package vn.edu.hcmuaf.fit.dao.impl;

import vn.edu.hcmuaf.fit.dao.IBookManagementDAO;
import vn.edu.hcmuaf.fit.db.JDBCConnector;
import vn.edu.hcmuaf.fit.model.BookManagementModel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookManagementDAO implements IBookManagementDAO {

    @Override
    public List<BookManagementModel> findAllBook() {
        List<BookManagementModel> users = new ArrayList<>();
        Connection connection = JDBCConnector.getConnection();
        String sql = new String("SELECT b.id_book, b.name, b.quantity," +
                "CASE" +
                "      WHEN b.quantity>0 THEN 'Còn hàng'" +
                "      WHEN b.quantity=0 THEN 'Hết hàng'" +
                "END," +
                "b.price, c.name" +
                "  FROM book b JOIN catalog c ON b.id_catalog = c.id_catalog" +
                " Where isActive = 1");


        PreparedStatement statement = null;
        ResultSet resultSet = null;
        if(connection != null) {
            try {
                statement = connection.prepareStatement(sql.toString());
                resultSet = statement.executeQuery();
                while (resultSet.next()) {
                    BookManagementModel bookManagementModel = new BookManagementModel();
                    bookManagementModel.setId(resultSet.getString(1));
                    bookManagementModel.setName(resultSet.getString(2));
                    bookManagementModel.setQuantity(resultSet.getInt(3));
                    bookManagementModel.setStatus(resultSet.getString(4));
                    bookManagementModel.setPrice(resultSet.getDouble(5));
                    bookManagementModel.setCategory(resultSet.getString(6));
                    users.add(bookManagementModel);
                }

                return users;
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
    public void deleteById(String id) {
        Connection connection = JDBCConnector.getConnection();
        String sql = new String("UPDATE book SET isActive = 0 WHERE id_book = ?");

        PreparedStatement statement = null;
        if(connection != null) {
            try {
                statement = connection.prepareStatement(sql.toString());
                statement.setString(1, id);
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
    public BookManagementModel findById(String id){
        List<BookManagementModel> users = new ArrayList<>();
        Connection connection = JDBCConnector.getConnection();
        String sql = new String("SELECT b.id_book, b.name, b.quantity," +
                "CASE" +
                "      WHEN b.quantity>0 THEN 'Còn hàng'" +
                "      WHEN b.quantity=0 THEN 'Hết hàng'" +
                "END," +
                "b.price, c.name" +
                "  FROM book b JOIN catalog c ON b.id_catalog = c.id_catalog" +
                " Where isActive = 1 AND id_book = ?");

        PreparedStatement statement = null;
        ResultSet resultSet = null;
        if(connection != null) {
            try {
                statement = connection.prepareStatement(sql.toString());
                statement.setString(1, id);
                resultSet = statement.executeQuery();
                while (resultSet.next()) {
                    BookManagementModel bookManagementModel = new BookManagementModel();
                    bookManagementModel.setId(resultSet.getString(1));
                    bookManagementModel.setName(resultSet.getString(2));
                    bookManagementModel.setQuantity(resultSet.getInt(3));
                    bookManagementModel.setStatus(resultSet.getString(4));
                    bookManagementModel.setPrice(resultSet.getDouble(5));
                    bookManagementModel.setCategory(resultSet.getString(6));
                    users.add(bookManagementModel);
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
    public int update(String id, String name, int quantity, double price) {
        Connection connection = JDBCConnector.getConnection();
        String sql = new String("UPDATE book \n" +
                "SET name = ?,\n" +
                "\tquantity = ?,\n" +
                "\tprice = ?\t\n" +
                "WHERE id_book = ?");

        PreparedStatement statement = null;
        if(connection != null) {
            try {
                statement = connection.prepareStatement(sql.toString());
                statement.setString(4, id);
                statement.setString(1, name);
                statement.setInt(2, quantity);
                statement.setDouble(3, price);
                return statement.executeUpdate();
            } catch (SQLException e) {
                return 0;
            } finally {
                try {
                    if(connection != null) connection.close();
                    if(statement != null) statement.close();
                } catch (SQLException e) {
                    return 0;
                }
            }
        }
        return 0;
    }

    @Override
    public List<String> listCatalog() {
        List<String> list = new ArrayList<>();
        Connection connection = JDBCConnector.getConnection();
        String sql = new String("Select name FROM catalog");

        PreparedStatement statement = null;
        ResultSet resultSet;
        if(connection != null) {
            try {
                statement = connection.prepareStatement(sql.toString());
                resultSet = statement.executeQuery();
                while (resultSet.next()) {
                    list.add(resultSet.getString(1));
                }
                return list;
            } catch (SQLException e) {
                return null;
            } finally {
                try {
                    if(connection != null) connection.close();
                    if(statement != null) statement.close();
                } catch (SQLException e) {
                    return null;
                }
            }
        }
        return null;
    }

    @Override
    public List<String> listPublisherCompany() {
        List<String> list = new ArrayList<>();
        Connection connection = JDBCConnector.getConnection();
        String sql = new String("Select name From publisher_company");

        PreparedStatement statement = null;
        ResultSet resultSet;
        if(connection != null) {
            try {
                statement = connection.prepareStatement(sql.toString());
                resultSet = statement.executeQuery();
                while (resultSet.next()) {
                    list.add(resultSet.getString(1));
                }
                return list;
            } catch (SQLException e) {
                return null;
            } finally {
                try {
                    if(connection != null) connection.close();
                    if(statement != null) statement.close();
                } catch (SQLException e) {
                    return null;
                }
            }
        }
        return null;
    }


}
