package vn.edu.hcmuaf.fit.dao.impl;

import vn.edu.hcmuaf.fit.dao.IContactDAO;
import vn.edu.hcmuaf.fit.db.JDBCConnector;
import vn.edu.hcmuaf.fit.model.ContactModel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ContactDAO implements IContactDAO {
    @Override
    public List<ContactModel> findAllContact() {
        List<ContactModel> contact = new ArrayList<>();
        Connection connection = JDBCConnector.getConnection();
        String sql = new String("SELECT id_contact, full_name, email_contact, phone_number, content_contact, status " +
                "FROM contact");
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            statement = connection.prepareStatement(sql.toString());
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                ContactModel contactModel = new ContactModel();
                contactModel.setId(resultSet.getInt(1));
                contactModel.setFullName(resultSet.getString(2));
                contactModel.setEmail(resultSet.getString(3));
                contactModel.setPhone(resultSet.getString(4));
                contactModel.setContent(resultSet.getString(5));
                contactModel.setStatus(resultSet.getInt(6));
                contact.add(contactModel);
            }
            return contact;
        } catch (SQLException e) {
            return null;
        }
    }
    @Override
    public ContactModel findById(int id) {
        List<ContactModel> contact = new ArrayList<>();
        Connection connection = JDBCConnector.getConnection();
        String sql = new String("SELECT id_contact, status FROM contact WHERE id_contact = ?");
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            statement = connection.prepareStatement(sql.toString());
            statement.setInt(1, id);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                ContactModel contactModel = new ContactModel();
                contactModel.setId(resultSet.getInt(1));
                contactModel.setStatus(resultSet.getInt(2));
                contact.add(contactModel);
            }
            return contact.isEmpty() ? null : contact.get(0);
        } catch (SQLException e) {
            return null;
        }
    }
    @Override
    public int update(int id, int status) {
        Connection connection = JDBCConnector.getConnection();
        String sql = new String("UPDATE contact\n" +
                "SET status = ?\n" +
                "WHERE id_contact = ?");
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(sql.toString());
            statement.setInt(1, id);
            statement.setInt(2, status);
            return statement.executeUpdate();
        } catch (SQLException e) {
            return 0;
        }
    }
}
