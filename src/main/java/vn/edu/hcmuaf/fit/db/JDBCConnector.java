package vn.edu.hcmuaf.fit.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCConnector {
    public static Connection getConnection(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://"+DBProperties.getDbHost()+":"+DBProperties.getDbPort()+"/"+DBProperties.getDbName();
            String user = DBProperties.getUsername();
            String password = DBProperties.getPassword();
            return DriverManager.getConnection(url, user, password);
        } catch (ClassNotFoundException | SQLException e) {
            return null;
        }

    }
}
