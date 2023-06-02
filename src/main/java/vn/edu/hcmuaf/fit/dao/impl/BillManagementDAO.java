package vn.edu.hcmuaf.fit.dao.impl;

import vn.edu.hcmuaf.fit.dao.IBillManagementDAO;
import vn.edu.hcmuaf.fit.db.JDBCConnector;
import vn.edu.hcmuaf.fit.model.BillManagementModel;
import vn.edu.hcmuaf.fit.model.BillModel;
import vn.edu.hcmuaf.fit.model.BookManagementModel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BillManagementDAO implements IBillManagementDAO {

    @Override
    public List<BillManagementModel> findAllBill() {
        Connection connection = JDBCConnector.getConnection();
        ArrayList<BillManagementModel> result = new ArrayList<>();
        String sql = "SELECT b.id_order,CONCAT(t.first_name, ' ', t.last_name) AS fullname,\n" +
                "b.address, CASE WHEN b.payment_method = 0 THEN 'Tiền mặt' ELSE 'Online' END AS payment_method, SUM(b.quantity), \n" +
                "c.totalPrice,   CASE WHEN b.shipping_info = 1 THEN 'Chờ xử lý' \n" +
                "                       WHEN b.shipping_info = 2 THEN 'Đang vận chuyển' \n" +
                "                            WHEN b.shipping_info = 3 THEN 'Đã hoàn thành' \n" +
                "                            WHEN b.shipping_info = 4 THEN 'Đã hủy' END AS shipping_info, c.id\n" +
                "FROM bill b JOIN carts c\n" +
                "ON b.idCart = c.id JOIN customer t \n" +
                "ON t.id_user = c.idUser\n" +
                "GROUP BY b.idCart";

        PreparedStatement statement = null;
        ResultSet resultSet = null;
        if (connection != null) {
            try {
                statement = connection.prepareStatement(sql.toString());
                resultSet = statement.executeQuery();
                while (resultSet.next()) {
                    BillManagementModel billManagementModel = new BillManagementModel();
                    billManagementModel.setIdOrder(resultSet.getInt(1));
                    billManagementModel.setNameUser(resultSet.getString(2));
                    billManagementModel.setAddress(resultSet.getString(3));
                    billManagementModel.setPaymethod(resultSet.getString(4));
                    billManagementModel.setTotalPrice(resultSet.getDouble(6));
                    billManagementModel.setTotalProduct(resultSet.getInt(5));
                    billManagementModel.setStatusBill(resultSet.getString(7));
                    billManagementModel.setIdCart(resultSet.getInt(8));

                    result.add(billManagementModel);
                }

                return result;
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

        return result;
    }

    @Override
    public List<BillManagementModel> findAllBillConfrim() {
        List<BillManagementModel> listBill = new ArrayList<>();
        Connection connection = JDBCConnector.getConnection();
        String sql = new String("SELECT b.id_order, CONCAT(c.first_name, ' ', c.last_name) AS fullname, b.address, \n" +
                "       CASE WHEN b.payment_method = 0 THEN 'Tiền mặt' ELSE 'Online' END AS payment_method, \n" +
                "       b.totalBill, b.quantity, \n" +
                "       CASE WHEN b.shipping_info = 1 THEN 'Chờ xử lý' \n" +
                "            WHEN b.shipping_info = 2 THEN 'Đang vận chuyển' \n" +
                "            WHEN b.shipping_info = 3 THEN 'Đã hoàn thành' \n" +
                "            WHEN b.shipping_info = 4 THEN 'Đã hủy' END AS shipping_info \n" +
                "FROM bill b \n" +
                "INNER JOIN customer c ON b.id_user = c.id_user \n" +
                "WHERE  b.shipping_info = 1");

        PreparedStatement statement = null;
        ResultSet resultSet = null;
        if (connection != null) {
            try {
                statement = connection.prepareStatement(sql.toString());
                resultSet = statement.executeQuery();
                while (resultSet.next()) {
                    BillManagementModel billManagementModel = new BillManagementModel();
                    billManagementModel.setIdOrder(resultSet.getInt(1));
                    billManagementModel.setNameUser(resultSet.getString(2));
                    billManagementModel.setAddress(resultSet.getString(3));
                    billManagementModel.setPaymethod(resultSet.getString(4));
                    billManagementModel.setTotalPrice(resultSet.getDouble(5));
                    billManagementModel.setTotalProduct(resultSet.getInt(6));
                    billManagementModel.setStatusBill(resultSet.getString(7));

                    listBill.add(billManagementModel);
                }

                return listBill;
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

        return listBill;
    }


    @Override
    public BillManagementModel findById(int id) {
        List<BillManagementModel> listID = new ArrayList<>();
        Connection connection = JDBCConnector.getConnection();
        String sql = new String("SELECT DISTINCT b.id_order, CONCAT(c.first_name, ' ',  c.last_name) AS fullname,\n" +
                "                b.address, b.total, b.totalQuantity,\n" +
                "                CASE\n" +
                "                WHEN b.shipping_info =1 THEN 'Chờ xử lý'\n" +
                "                WHEN b.shipping_info =2 THEN 'Đang vận chuyển'\n" +
                "                WHEN b.shipping_info =3 THEN 'Đã giao'\n" +
                "                WHEN b.shipping_info =4 THEN 'Đã hủy'\n" +
                "                END AS shipping_info,\n" +
                "                b.ship_time, b.receive_time\n" +
                "                FROM bill_details d, bill b, customer c\n" +
                "                WHERE b.id_order = d.id_order AND b.id_user = c.id_user AND b.id_order = ?");

        PreparedStatement statement = null;
        ResultSet resultSet = null;
        if(connection != null) {
            try {
                statement = connection.prepareStatement(sql.toString());
                statement.setInt(1, id);
                resultSet = statement.executeQuery();
                while (resultSet.next()) {
                    BillManagementModel billManagementModel = new BillManagementModel();
                    billManagementModel.setIdOrder(resultSet.getInt(1));
                    billManagementModel.setNameUser(resultSet.getString(2));
                    billManagementModel.setAddress(resultSet.getString(3));
                    billManagementModel.setTotalPrice(resultSet.getDouble(4));
                    billManagementModel.setTotalProduct(resultSet.getInt(5));
                    billManagementModel.setStatusBill(resultSet.getString(6));
//                    billManagementModel.setShipdate(resultSet.getDate(7));
//                    billManagementModel.setReceiveDate(resultSet.getDate(8));
                    listID.add(billManagementModel);
                }

                return listID.isEmpty() ? null : listID.get(0);
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
    public int update(int id, String address, String status, Date shipTime, Date receiveTime) {
        Connection connection = JDBCConnector.getConnection();
        String sql = new String("UPDATE bill \n" +
                "SET address = ?,\n" +
                "\tshipping_info = ?,\n" +
                "\tship_time = ?,\n" +
                "\treceive_time = ?\t\n" +
                "WHERE id_order = ?");

        PreparedStatement statement = null;
        if(connection != null) {
            try {
                statement = connection.prepareStatement(sql.toString());
                statement.setInt(5, id);
                statement.setString(1, address);
                statement.setString(2, status);
                statement.setDate(3, (java.sql.Date) shipTime);
                statement.setDate(4, (java.sql.Date) receiveTime);
                return statement.executeUpdate();
            } catch (SQLException e) {
                return 0;
            } finally {
                try {
                    if(connection != null) connection.close();
                    if(statement != null) statement.close();
                } catch (SQLException e) {
                    return 0;
                }
            }
        }
        return 0;
    }

    @Override
    public void create(BillModel bill) {

    }

    @Override
    public void confirmBill(String id_order) {
            Connection connection = JDBCConnector.getConnection();
            String sql = "UPDATE bill SET shipping_info = 2 WHERE idCart = ?";
            PreparedStatement statement = null;
            if (connection != null) {
                try {
                    statement = connection.prepareStatement(sql);
                    statement.setString(1, id_order);
                    statement.executeUpdate();
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

    @Override
    public void deleteBill(String id_order) {
        Connection connection = JDBCConnector.getConnection();
        String sql = "UPDATE bill SET shipping_info = 4 WHERE id_order = ?";
        PreparedStatement statement = null;

        if (connection != null) {
            try {
                statement = connection.prepareStatement(sql);
                statement.setString(1, id_order);
                statement.executeUpdate();
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
