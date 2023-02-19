package vn.edu.hcmuaf.fit.dao.impl;

import vn.edu.hcmuaf.fit.db.JDBCConnector;

import java.sql.*;
import java.time.LocalDate;
import java.time.LocalTime;

public class BLockUserDao {

    private static Connection con = null;
    private static PreparedStatement ps = null;
    private static ResultSet rs = null;


    public static String Attempts(String email)  {
        con = JDBCConnector.getConnection();
        String message = "";
        int value = 3;
        int date = -1;
        PreparedStatement sel = null;
        Date dateCurrent = Date.valueOf(LocalDate.now());
        int timeCurrent = (int) dateCurrent.getTime();
        try {
            sel = con.prepareStatement(
                    "SELECT * FROM customer WHERE email = ? ");

        sel.setString(1, email);
        ResultSet rs = sel.executeQuery();
        if (rs.next()) {
            value = rs.getInt("attempts");
            date = rs.getInt("lock_time");

        }
        //checking if value is not equal to 0
        if (value != 0 && date == -1) {
            //subtract 1
            int subtracts = value - 1;
            //updatting
            PreparedStatement ps = con.prepareStatement(
                    "UPDATE customer SET attempts = ? WHERE email = ?");
            ps.setInt(1,subtracts);
            ps.setString(2, email);
            int count = ps.executeUpdate();
            if (count > 0) {
                message = "Updated";

            }
        } else {
            if(value == 0 && date == -1 ) {
                message = "block";
                PreparedStatement ps = con.prepareStatement("update customer set status = ? , lock_time = ? where email = ?");
                ps.setInt(1,0);
                ps.setInt(2,timeCurrent);
                ps.setString(3,email);
                ps.executeUpdate();
            } else {
                if(value == 0 && date != -1 && (timeCurrent - date) >= 24*60*60*1000) {
                    message = "reset";
                    PreparedStatement ps = con.prepareStatement("update customer set status = ? , lock_time= ? , attempts = ? where email = ?");
                    ps.setInt(1,1);
                    ps.setInt(2,-1);
                    ps.setInt(3,3);
                    ps.setString(4,email);
                    ps.executeUpdate();
                } else {
                    message = "block";
                }

            //already 0 do something
        }
        }

        return message; //return back

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }



}
