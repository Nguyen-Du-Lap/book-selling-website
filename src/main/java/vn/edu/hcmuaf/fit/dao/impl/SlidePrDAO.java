package vn.edu.hcmuaf.fit.dao.impl;

import vn.edu.hcmuaf.fit.dao.ISlidePr;
import vn.edu.hcmuaf.fit.db.JDBCConnector;
import vn.edu.hcmuaf.fit.model.SlidePrModel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SlidePrDAO implements ISlidePr {

    @Override
    public List<SlidePrModel> findAll() {
        List<SlidePrModel> results = new ArrayList<>();
        String sql = "SELECT * FROM slide_pr where status = 1";
        Connection connection = JDBCConnector.getConnection();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        if(connection != null) {
            try {
                statement = connection.prepareStatement(sql);
                resultSet = statement.executeQuery();
                while (resultSet.next()) {
                    SlidePrModel slidePrModel = new SlidePrModel();
                    slidePrModel.setIdPr(resultSet.getInt(1));
                    slidePrModel.setNamePr(resultSet.getString(2));
                    slidePrModel.setImg(resultSet.getString(3));
                    slidePrModel.setLink(resultSet.getString(4));
                    slidePrModel.setStartTime(resultSet.getDate(5));
                    slidePrModel.setFinishTime(resultSet.getDate(6));
                    results.add(slidePrModel);
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
