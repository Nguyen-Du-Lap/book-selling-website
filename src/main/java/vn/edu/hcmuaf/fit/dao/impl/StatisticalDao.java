package vn.edu.hcmuaf.fit.dao.impl;

import vn.edu.hcmuaf.fit.db.JDBCConnector;
import vn.edu.hcmuaf.fit.model.StatisticalModel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class StatisticalDao {
    public StatisticalModel nhapHang() {
        StatisticalModel result =new StatisticalModel();
        String sql = "SELECT\n" +
                "  SUM(CASE WHEN month_num.month = 1 THEN quantity * prime_cost ELSE 0 END) AS 'Month 1',\n" +
                "  SUM(CASE WHEN month_num.month = 2 THEN quantity * prime_cost ELSE 0 END) AS 'Month 2',\n" +
                "  SUM(CASE WHEN month_num.month = 3 THEN quantity * prime_cost ELSE 0 END) AS 'Month 3',\n" +
                "  SUM(CASE WHEN month_num.month = 4 THEN quantity * prime_cost ELSE 0 END) AS 'Month 4',\n" +
                "  SUM(CASE WHEN month_num.month = 5 THEN quantity * prime_cost ELSE 0 END) AS 'Month 5',\n" +
                "  SUM(CASE WHEN month_num.month = 6 THEN quantity * prime_cost ELSE 0 END) AS 'Month 6',\n" +
                "  SUM(CASE WHEN month_num.month = 7 THEN quantity * prime_cost ELSE 0 END) AS 'Month 7',\n" +
                "  SUM(CASE WHEN month_num.month = 8 THEN quantity * prime_cost ELSE 0 END) AS 'Month 8',\n" +
                "  SUM(CASE WHEN month_num.month = 9 THEN quantity * prime_cost ELSE 0 END) AS 'Month 9',\n" +
                "  SUM(CASE WHEN month_num.month = 10 THEN quantity * prime_cost ELSE 0 END) AS 'Month 10',\n" +
                "  SUM(CASE WHEN month_num.month = 11 THEN quantity * prime_cost ELSE 0 END) AS 'Month 11',\n" +
                "  SUM(CASE WHEN month_num.month = 12 THEN quantity * prime_cost ELSE 0 END) AS 'Month 12'\n" +
                "FROM (\n" +
                "    SELECT 1 AS month UNION ALL SELECT 2 UNION ALL SELECT 3 UNION ALL SELECT 4 UNION ALL SELECT 5 UNION ALL\n" +
                "    SELECT 6 UNION ALL SELECT 7 UNION ALL SELECT 8 UNION ALL SELECT 9 UNION ALL SELECT 10 UNION ALL SELECT 11 UNION ALL SELECT 12\n" +
                ") AS month_num\n" +
                "LEFT JOIN book ON month_num.month = MONTH(created) AND YEAR(created) = YEAR(CURRENT_DATE);\n";
        Connection connection = JDBCConnector.getConnection();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        if(connection != null) {
            try {
                statement = connection.prepareStatement(sql);
                resultSet = statement.executeQuery();
                while (resultSet.next()) {

                    result.setT1(resultSet.getDouble(1));
                    result.setT2(resultSet.getDouble(2));
                    result.setT3(resultSet.getDouble(3));
                    result.setT4(resultSet.getDouble(4));
                    result.setT5(resultSet.getDouble(5));
                    result.setT6(resultSet.getDouble(6));
                    result.setT7(resultSet.getDouble(7));
                    result.setT8(resultSet.getDouble(8));
                    result.setT9(resultSet.getDouble(9));
                    result.setT10(resultSet.getDouble(10));
                    result.setT11(resultSet.getDouble(11));
                    result.setT12(resultSet.getDouble(12));


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
    public StatisticalModel xuatHang() {
        StatisticalModel result = new StatisticalModel();
        String sql = "SELECT\n" +
                "  SUM(CASE WHEN month_num.month = 1 THEN totalPrice ELSE 0 END) AS 'Month 1',\n" +
                "  SUM(CASE WHEN month_num.month = 2 THEN totalPrice ELSE 0 END) AS 'Month 2',\n" +
                "  SUM(CASE WHEN month_num.month = 3 THEN totalPrice ELSE 0 END) AS 'Month 3',\n" +
                "  SUM(CASE WHEN month_num.month = 4 THEN totalPrice ELSE 0 END) AS 'Month 4',\n" +
                "  SUM(CASE WHEN month_num.month = 5 THEN totalPrice ELSE 0 END) AS 'Month 5',\n" +
                "  SUM(CASE WHEN month_num.month = 6 THEN totalPrice ELSE 0 END) AS 'Month 6',\n" +
                "  SUM(CASE WHEN month_num.month = 7 THEN totalPrice ELSE 0 END) AS 'Month 7',\n" +
                "  SUM(CASE WHEN month_num.month = 8 THEN totalPrice ELSE 0 END) AS 'Month 8',\n" +
                "  SUM(CASE WHEN month_num.month = 9 THEN totalPrice ELSE 0 END) AS 'Month 9',\n" +
                "  SUM(CASE WHEN month_num.month = 10 THEN totalPrice ELSE 0 END) AS 'Month 10',\n" +
                "  SUM(CASE WHEN month_num.month = 11 THEN totalPrice ELSE 0 END) AS 'Month 11',\n" +
                "  SUM(CASE WHEN month_num.month = 12 THEN totalPrice ELSE 0 END) AS 'Month 12'\n" +
                "FROM (\n" +
                "    SELECT 1 AS month UNION ALL SELECT 2 UNION ALL SELECT 3 UNION ALL SELECT 4 UNION ALL SELECT 5 UNION ALL\n" +
                "    SELECT 6 UNION ALL SELECT 7 UNION ALL SELECT 8 UNION ALL SELECT 9 UNION ALL SELECT 10 UNION ALL SELECT 11 UNION ALL SELECT 12\n" +
                ") AS month_num\n" +
                "LEFT JOIN carts ON month_num.month = MONTH(create_time) AND YEAR(create_time) = YEAR(CURRENT_DATE) WHERE create_time >= DATE_SUB(CURDATE(), INTERVAL 5 MONTH) AND infoShip = 3;";
        Connection connection = JDBCConnector.getConnection();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        if(connection != null) {
            try {
                statement = connection.prepareStatement(sql);
                resultSet = statement.executeQuery();
                while (resultSet.next()) {

                    result.setT1(resultSet.getDouble(1));
                    result.setT2(resultSet.getDouble(2));
                    result.setT3(resultSet.getDouble(3));
                    result.setT4(resultSet.getDouble(4));
                    result.setT5(resultSet.getDouble(5));
                    result.setT6(resultSet.getDouble(6));
                    result.setT7(resultSet.getDouble(7));
                    result.setT8(resultSet.getDouble(8));
                    result.setT9(resultSet.getDouble(9));
                    result.setT10(resultSet.getDouble(10));
                    result.setT11(resultSet.getDouble(11));
                    result.setT12(resultSet.getDouble(12));



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



    public StatisticalModel thuNhapTrong6Thang() {
        StatisticalModel result =new StatisticalModel();
        String sql = "SELECT\n" +
                "  SUM(CASE WHEN MONTH(c.create_time) = MONTH(DATE_SUB(CURDATE(), INTERVAL 5 MONTH)) THEN c.totalPrice - a.von - c.feeShip ELSE 0 END) AS 'Month 1',\n" +
                "  SUM(CASE WHEN MONTH(c.create_time) = MONTH(DATE_SUB(CURDATE(), INTERVAL 4 MONTH)) THEN c.totalPrice - a.von - c.feeShip ELSE 0 END) AS 'Month 2',\n" +
                "  SUM(CASE WHEN MONTH(c.create_time) = MONTH(DATE_SUB(CURDATE(), INTERVAL 3 MONTH)) THEN c.totalPrice - a.von - c.feeShip ELSE 0 END) AS 'Month 3',\n" +
                "  SUM(CASE WHEN MONTH(c.create_time) = MONTH(DATE_SUB(CURDATE(), INTERVAL 2 MONTH)) THEN c.totalPrice - a.von - c.feeShip ELSE 0 END) AS 'Month 4',\n" +
                "  SUM(CASE WHEN MONTH(c.create_time) = MONTH(DATE_SUB(CURDATE(), INTERVAL 1 MONTH)) THEN c.totalPrice - a.von - c.feeShip ELSE 0 END) AS 'Month 5',\n" +
                "  SUM(CASE WHEN MONTH(c.create_time) = MONTH(CURDATE()) THEN c.totalPrice - a.von - c.feeShip ELSE 0 END) AS 'Month 6'\n" +
                "FROM carts c JOIN (SELECT SUM(b.prime_cost) AS von, c.idCart\n" +
                "FROM book b JOIN bill c\n" +
                "ON b.id_book = c.id_book\n" +
                "GROUP BY c.idCart) a ON c.id = a.idCart\n" +
                "\n" +
                "WHERE create_time >= DATE_SUB(CURDATE(), INTERVAL 5 MONTH) AND c.infoShip = 3;";
        Connection connection = JDBCConnector.getConnection();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        if(connection != null) {
            try {
                statement = connection.prepareStatement(sql);
                resultSet = statement.executeQuery();
                while (resultSet.next()) {
                    result.setT1(resultSet.getDouble(1));
                    result.setT2(resultSet.getDouble(2));
                    result.setT3(resultSet.getDouble(3));
                    result.setT4(resultSet.getDouble(4));
                    result.setT5(resultSet.getDouble(5));
                    result.setT6(resultSet.getDouble(6));
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


}
