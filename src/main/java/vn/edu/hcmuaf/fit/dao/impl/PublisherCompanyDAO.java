package vn.edu.hcmuaf.fit.dao.impl;

import vn.edu.hcmuaf.fit.dao.IPublisherCompany;
import vn.edu.hcmuaf.fit.db.JDBCConnector;
import vn.edu.hcmuaf.fit.model.PublisherCompanyModel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PublisherCompanyDAO implements IPublisherCompany {

    @Override
    public List<PublisherCompanyModel> findAll() {
        List<PublisherCompanyModel> results = new ArrayList<>();
        String sql = "SELECT * FROM publisher_company LIMIT 13";
        Connection connection = JDBCConnector.getConnection();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        if(connection != null) {
            try {
                statement = connection.prepareStatement(sql);
                resultSet = statement.executeQuery();
                while (resultSet.next()) {
                    PublisherCompanyModel publisherCompanyModel = new PublisherCompanyModel();
                    publisherCompanyModel.setIdPc(resultSet.getInt("id_pc"));
                    publisherCompanyModel.setName(resultSet.getString("name"));
                    results.add(publisherCompanyModel);
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
