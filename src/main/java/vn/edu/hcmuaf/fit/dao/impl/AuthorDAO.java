package vn.edu.hcmuaf.fit.dao.impl;

import vn.edu.hcmuaf.fit.dao.IAuthorDAO;
import vn.edu.hcmuaf.fit.db.JDBCConnector;
import vn.edu.hcmuaf.fit.model.AuthorModel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AuthorDAO implements IAuthorDAO {

    @Override
    public List<AuthorModel> findAll() {
        List<AuthorModel> results = new ArrayList<>();
        String sql = "SELECT * FROM author";
        Connection connection = JDBCConnector.getConnection();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        if(connection != null) {
            try {
                statement = connection.prepareStatement(sql);
                resultSet = statement.executeQuery();
                while (resultSet.next()) {
                   AuthorModel authorModel = new AuthorModel();
                   authorModel.setIdAuthor(resultSet.getInt("id_author"));
                   authorModel.setName(resultSet.getString("name"));
                   authorModel.setImg(resultSet.getString("img"));
                   authorModel.setInformation(resultSet.getString("information"));
                   results.add(authorModel);
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

    @Override
    public List<AuthorModel> find10Author() {
        List<AuthorModel> results = new ArrayList<>();
        String sql = "SELECT * FROM author LIMIT 10";
        Connection connection = JDBCConnector.getConnection();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        if(connection != null) {
            try {
                statement = connection.prepareStatement(sql);
                resultSet = statement.executeQuery();
                while (resultSet.next()) {
                    AuthorModel authorModel = new AuthorModel();
                    authorModel.setIdAuthor(resultSet.getInt("id_author"));
                    authorModel.setName(resultSet.getString("name"));
                    authorModel.setImg(resultSet.getString("img"));
                    authorModel.setInformation(resultSet.getString("information"));
                    results.add(authorModel);
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
