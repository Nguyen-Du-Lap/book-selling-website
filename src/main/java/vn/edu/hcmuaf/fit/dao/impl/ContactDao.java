package vn.edu.hcmuaf.fit.dao.impl;

import vn.edu.hcmuaf.fit.db.JDBCConnector;
import vn.edu.hcmuaf.fit.model.BookModel;
import vn.edu.hcmuaf.fit.model.ContactModel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ContactDao {
    public ArrayList<ContactModel> getAll() {
        String sql = "SELECT id_contact, id_user, full_name, phone_number, email_contact,  content_contact, status\n" +
                "FROM contact";
        ArrayList<ContactModel> result  = new ArrayList<>();
        Connection connection = JDBCConnector.getConnection();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        if(connection != null) {
            try {
                statement = connection.prepareStatement(sql);
                resultSet = statement.executeQuery();
                while (resultSet.next()) {
                    ContactModel contactModel = new ContactModel();
                    contactModel.setId(resultSet.getInt(1));
                    contactModel.setIdUser(resultSet.getInt(2));
                    contactModel.setFullName(resultSet.getString(3));
                    contactModel.setPhone(resultSet.getString(4));
                    contactModel.setEmail(resultSet.getString(5));
                    contactModel.setContent(resultSet.getString(6));
                    contactModel.setStatus(resultSet.getInt(7));
                    result.add(contactModel);
                }

                return result;
            } catch (SQLException e) {
                e.printStackTrace();
                return result;
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
    public int insertContact( int idUser, String fullName, String phone, String email, String content, int status) {
        Connection connection = JDBCConnector.getConnection();
        PreparedStatement statement = null;

        if (connection != null) {
            try {
                String sql = "INSERT INTO contact  VALUES(null,?,?,?,?,?,?, null)";
                statement = connection.prepareStatement(sql);

                statement.setInt(1, idUser);
                statement.setString(2, fullName);
                statement.setString(3, phone);
                statement.setString(4, email);
                statement.setString(5, content);
                statement.setInt(6, status);

                statement.executeUpdate();
                return 1;
            } catch (SQLException e) {
                e.printStackTrace();
                return  0;
            } finally {
                try {
                    if (connection != null) connection.close();
                    if (statement != null) statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return 0;
    }
    public ContactModel getContactById(int id) {
        String sql = "SELECT id_contact, id_user, full_name, phone_number, email_contact, content_contact, status " +
                "FROM contact WHERE id_contact = ?";

        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        ContactModel result = null;

        try {
            connection = JDBCConnector.getConnection();
            statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            resultSet = statement.executeQuery();

            if (resultSet.next()) {
                result = new ContactModel();
                result.setId(resultSet.getInt(1));
                result.setIdUser(resultSet.getInt(2));
                result.setFullName(resultSet.getString(3));
                result.setPhone(resultSet.getString(4));
                result.setEmail(resultSet.getString(5));
                result.setContent(resultSet.getString(6));
                result.setStatus(resultSet.getInt(7));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (resultSet != null) resultSet.close();
                if (statement != null) statement.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return result;
    }
    public void updateContact(int id,String contentFeedBack) {
        Connection connection = JDBCConnector.getConnection();
        PreparedStatement statement = null;

        if (connection != null) {
            try {
                String sql = "UPDATE contact SET status = 1 , feedback_content = ? WHERE id_contact = ?";
                statement = connection.prepareStatement(sql);

                statement.setString(1, contentFeedBack);
                statement.setInt(2, id);

                statement.executeUpdate();
                System.out.println("Contact update successfully.");
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

}
