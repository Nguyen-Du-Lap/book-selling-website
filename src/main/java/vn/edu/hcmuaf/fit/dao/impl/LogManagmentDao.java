package vn.edu.hcmuaf.fit.dao.impl;

import vn.edu.hcmuaf.fit.bean.Log;
import vn.edu.hcmuaf.fit.dao.ILogManagmentDao;
import vn.edu.hcmuaf.fit.db.JDBCConnector;
import vn.edu.hcmuaf.fit.model.SlidePrModel;
import vn.edu.hcmuaf.fit.services.ILogManagmentService;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LogManagmentDao implements ILogManagmentDao {
    @Override
    public List<Log> getAll() {
        List<Log> results = new ArrayList<>();
        String sql = "SELECT * FROM logs";
        Connection connection = JDBCConnector.getConnection();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        if(connection != null) {
            try {
                statement = connection.prepareStatement(sql);
                resultSet = statement.executeQuery();
                while (resultSet.next()) {
                    Log log = new Log();
                    log.setId(resultSet.getInt(1));
                    log.setLevel(resultSet.getInt(2));
                    log.setUser(resultSet.getInt(3));
                    log.setIp(resultSet.getString(4));
                    log.setSrc(resultSet.getString(5));
                    log.setContent(resultSet.getString(6));
                    log.setCreateAt(resultSet.getDate(7));
                    log.setStatus(resultSet.getInt(8));
                    results.add(log);
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
