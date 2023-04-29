package vn.edu.hcmuaf.fit.dao.impl;

import vn.edu.hcmuaf.fit.bean.Log;
import vn.edu.hcmuaf.fit.dao.ISliderManagmentDao;
import vn.edu.hcmuaf.fit.db.JDBCConnector;
import vn.edu.hcmuaf.fit.model.RateModel;
import vn.edu.hcmuaf.fit.model.SlidePrModel;
import vn.edu.hcmuaf.fit.services.ISliderManagementService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SliderManagmentDao implements ISliderManagmentDao {


    @Override
    public List<SlidePrModel> getAll() {
        List<SlidePrModel> results = new ArrayList<>();
        String sql = "SELECT * \n" +
                "FROM slide_pr r\n";

        Connection connection = JDBCConnector.getConnection();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        if(connection != null) {
            try {
                statement = connection.prepareStatement(sql);
                resultSet = statement.executeQuery();
                while (resultSet.next()) {
                    SlidePrModel rateModel = new SlidePrModel();
                    rateModel.setIdPr(resultSet.getInt(1));
                    rateModel.setNamePr(resultSet.getString(2));
                    rateModel.setImg(resultSet.getString(3));
                    rateModel.setLink(resultSet.getString(4));
                    rateModel.setStartTime(resultSet.getDate(5));
                    rateModel.setFinishTime(resultSet.getDate(6));
                    rateModel.setCreateTime(resultSet.getTimestamp(7));
                    rateModel.setStatus(resultSet.getInt(8));
                    results.add(rateModel);
                }

                return results;
            } catch (SQLException e) {
                e.printStackTrace();
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
    public void hiddenSilde(String id) {
        String sql = "UPDATE slide_pr SET STATUS = 0 WHERE id_pr = ?";
        Connection connection = JDBCConnector.getConnection();
        PreparedStatement statement = null;
        try {
            if(connection != null) {
                statement = connection.prepareStatement(sql);
                statement.setString(1, id);
                statement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if(connection != null) connection.close();
                if(statement != null) statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void activitySilde(String id) {
        String sql = "UPDATE slide_pr SET STATUS = 1 WHERE id_pr = ?";
        Connection connection = JDBCConnector.getConnection();
        PreparedStatement statement = null;
        try {
            if (connection != null) {
                statement = connection.prepareStatement(sql);
                statement.setString(1, id);
                statement.executeUpdate();
            }
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

    public void insert(String name, String image, String link, String timeS, String timeF) {
        String sql = "INSERT INTO slide_pr(name_pr, img,link,start_time, finish_time) VALUES (?,?,?,?,?)";
        try (Connection connection = JDBCConnector.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, name);
            statement.setString(2, image);
            statement.setString(3, link);
            statement.setString(4, timeS);
            statement.setString(5, timeF);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void addImage(HttpServletRequest request, HttpServletResponse response, String name, String image, Part part, String timeS, String timeF) {

    }


}
