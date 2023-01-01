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
                "  FROM book b JOIN catalog c ON b.id_catalog = c.id_catalog");


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
}
