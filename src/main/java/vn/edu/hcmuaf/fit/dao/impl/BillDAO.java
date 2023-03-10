package vn.edu.hcmuaf.fit.dao.impl;

import vn.edu.hcmuaf.fit.dao.IBillDAO;
import vn.edu.hcmuaf.fit.db.JDBCConnector;
import vn.edu.hcmuaf.fit.model.AuthorModel;
import vn.edu.hcmuaf.fit.model.Bill;
import vn.edu.hcmuaf.fit.model.ShippingInfoModel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BillDAO implements IBillDAO {

    @Override
    public int totalBill() {
        Connection connection = JDBCConnector.getConnection();
        String sql = new String("SELECT Count(*) FROM bill");
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        int result=0;
        if(connection != null) {
            try {
                statement = connection.prepareStatement(sql.toString());
                resultSet = statement.executeQuery();
                while (resultSet.next()) {
                    result = resultSet.getInt(1);
                }

                return result;
            } catch (SQLException e) {
                return 0;
            } finally {
                try {
                    if(connection != null) connection.close();
                    if(statement != null) statement.close();
                    if(resultSet != null) resultSet.close();
                } catch (SQLException e) {
                    return 0;
                }
            }
        }
        return 0;
    }

    @Override
    public List<ShippingInfoModel> shippingInfo() {
        List<ShippingInfoModel> results = new ArrayList<>();
        String sql = "SELECT bi.id_order, CONCAT(c.first_name,' ',c.last_name), SUM(bd.quantity*bo.price), \n" +
                "bi.shipping_info  FROM bill bi JOIN customer c ON bi.id_user = c.id_user\n" +
                "JOIN bill_details bd ON bi.id_order = bd.id_order JOIN book bo ON bd.id_book = bo.id_book \n" +
                "GROUP BY bi.id_order, c.first_name, c.last_name";
        Connection connection = JDBCConnector.getConnection();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        if(connection != null) {
            try {
                statement = connection.prepareStatement(sql);
                resultSet = statement.executeQuery();
                while (resultSet.next()) {
                    ShippingInfoModel shippingInfoModel = new ShippingInfoModel();
                    shippingInfoModel.setIdOrder(resultSet.getInt(1));
                    shippingInfoModel.setFullName(resultSet.getString(2));
                    shippingInfoModel.setPrice(resultSet.getLong(3));
                    shippingInfoModel.setShippingInfo(resultSet.getInt(4));
                    results.add(shippingInfoModel);
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
    public List<Bill> findBillDeliverByIdOrder(int id) {
        List<Bill> results = new ArrayList<>();
        String sql = "SELECT bill.id_order, book.name, bill.totalBill, bill.quantity, bill.id_user, bill.id_book \n" +
                "FROM bill JOIN book ON bill.id_book = book.id_book \n" +
                "WHERE bill.shipping_info = 1 AND bill.id_user = ?";
        Connection connection = JDBCConnector.getConnection();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        if(connection != null) {
            try {
                statement = connection.prepareStatement(sql);
                statement.setInt(1, id);
                resultSet = statement.executeQuery();
                while (resultSet.next()) {
                   Bill bill = new Bill();
                   bill.setIdOrder(resultSet.getInt(1));
                   bill.setName(resultSet.getString(2));
                    bill.setTotalPrice(resultSet.getInt(3));
                    bill.setQuantity(resultSet.getInt(4));
                   bill.setIdUser(resultSet.getInt(5));
                   bill.setImage(findImageById(resultSet.getInt(6)));
                   results.add(bill);
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

    public List<Bill> findBillWarByIdOrder(int id) {
        List<Bill> results = new ArrayList<>();
        String sql = "SELECT bill.id_order, book.name, bill.totalBill, bill.quantity, bill.id_user, bill.id_book \n" +
                "FROM bill JOIN book ON bill.id_book = book.id_book \n" +
                "WHERE bill.shipping_info = 1 AND bill.id_user = ?";
        Connection connection = JDBCConnector.getConnection();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        if(connection != null) {
            try {
                statement = connection.prepareStatement(sql);
                statement.setInt(1, id);
                resultSet = statement.executeQuery();
                while (resultSet.next()) {
                    Bill bill = new Bill();
                    bill.setIdOrder(resultSet.getInt(1));
                    bill.setName(resultSet.getString(2));
                    bill.setTotalPrice(resultSet.getInt(3));
                    bill.setQuantity(resultSet.getInt(4));
                    bill.setIdUser(resultSet.getInt(5));
                    bill.setImage(findImageById(resultSet.getInt(6)));
                    results.add(bill);
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

    public List<Bill> findBillDelivByIdOrder(int id) {
        List<Bill> results = new ArrayList<>();
        String sql = "SELECT bill.id_order, book.name, bill.totalBill, bill.quantity, bill.id_user, bill.id_book \n" +
                "FROM bill JOIN book ON bill.id_book = book.id_book \n" +
                "WHERE bill.shipping_info = 2 AND bill.id_user = ?";
        Connection connection = JDBCConnector.getConnection();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        if(connection != null) {
            try {
                statement = connection.prepareStatement(sql);
                statement.setInt(1, id);
                resultSet = statement.executeQuery();
                while (resultSet.next()) {
                    Bill bill = new Bill();
                    bill.setIdOrder(resultSet.getInt(1));
                    bill.setName(resultSet.getString(2));
                    bill.setTotalPrice(resultSet.getInt(3));
                    bill.setQuantity(resultSet.getInt(4));
                    bill.setIdUser(resultSet.getInt(5));
                    bill.setImage(findImageById(resultSet.getInt(6)));
                    results.add(bill);
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

    public List<Bill> findBillByIdOrder(int id) {
        List<Bill> results = new ArrayList<>();
        String sql = "SELECT bill.id_order, book.name, bill.totalBill, bill.quantity, bill.id_user, bill.id_book \n" +
                "FROM bill JOIN book ON bill.id_book = book.id_book \n" +
                "WHERE bill.shipping_info = 3 AND bill.id_user = ?";
        Connection connection = JDBCConnector.getConnection();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        if(connection != null) {
            try {
                statement = connection.prepareStatement(sql);
                statement.setInt(1, id);
                resultSet = statement.executeQuery();
                while (resultSet.next()) {
                    Bill bill = new Bill();
                    bill.setIdOrder(resultSet.getInt(1));
                    bill.setName(resultSet.getString(2));
                    bill.setTotalPrice(resultSet.getInt(3));
                    bill.setQuantity(resultSet.getInt(4));
                    bill.setIdUser(resultSet.getInt(5));
                    bill.setIdBook(resultSet.getInt(6));
                    bill.setImage(findImageById(resultSet.getInt(6)));
                    results.add(bill);
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

    public List<Bill> findBillRateByIdOrder(int id) {
        List<Bill> results = new ArrayList<>();
        String sql = "SELECT bill.id_order, book.name, bill.quantity, bill.totalBill, bill.id_user, bill.id_book\n" +
                "FROM bill JOIN book ON bill.id_book = book.id_book\n" +
                "WHERE bill.shipping_info = 3 AND bill.id_user = ? AND bill.id_order NOT IN(SELECT id_order FROM rate)";
        Connection connection = JDBCConnector.getConnection();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        if(connection != null) {
            try {
                statement = connection.prepareStatement(sql);
                statement.setInt(1, id);
                resultSet = statement.executeQuery();
                while (resultSet.next()) {
                    Bill bill = new Bill();
                    bill.setIdOrder(resultSet.getInt(1));
                    bill.setName(resultSet.getString(2));
                    bill.setQuantity(resultSet.getInt(3));
                    bill.setTotalPrice(resultSet.getInt(4));
                    bill.setIdUser(resultSet.getInt(5));
                    bill.setIdBook(resultSet.getInt(6));
                    bill.setImage(findImageById(resultSet.getInt(6)));
                    results.add(bill);
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
    public int rateBook(int idUser, int idBook, int idOrder, int start, String comment) {
        Connection connection = JDBCConnector.getConnection();
        String sql = new String("INSERT INTO rate(id_user, id_book, id_order, start_rate, comment) " +
                "VALUES(?,?,?,?,?)");

        PreparedStatement statement = null;
        if(connection != null) {
            try {
                statement = connection.prepareStatement(sql.toString());
                statement.setInt(1, idUser);
                statement.setInt(2, idBook);
                statement.setInt(3, idOrder);
                statement.setInt(4, start);
                statement.setString(5, comment);
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
    public int addBill(int idUser, int idBook, String address,
                       int paymentMethod, int pack, int quantity,
                       double totalPrice, String info, String phone) {
        Connection connection = JDBCConnector.getConnection();
        String sql = new String("INSERT INTO bill(id_user, id_book, address, pack, payment_method, totalBill, quantity, phone, info)\n" +
                "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)");
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(sql.toString());
            statement.setInt(1, idUser);
            statement.setInt(2, idBook);
            statement.setString(3, address);
            statement.setInt(4, pack);
            statement.setInt(5, paymentMethod);
            statement.setDouble(6, totalPrice);
            statement.setInt(7, quantity);
            statement.setString(8, phone);
            statement.setString(9, info);

            return statement.executeUpdate();

        }catch (SQLException e) {
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

    @Override
    public int cancelOrder(int idInt) {
        Connection connection = JDBCConnector.getConnection();
        String sql = new String("UPDATE bill \n" +
                "SET shipping_info = 4 \n" +
                "WHERE id_order = ?");

        PreparedStatement statement = null;
        if(connection != null) {
            try {
                statement = connection.prepareStatement(sql.toString());
                statement.setInt(1, idInt);
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

    public String findImageById(int id) {
        List<String> images = new ArrayList<>();
        Connection connection = JDBCConnector.getConnection();
        String sql = new String("SELECT image FROM image_book WHERE id_book = ?");

        PreparedStatement statement = null;
        ResultSet resultSet = null;
        if(connection != null) {
            try {
                statement = connection.prepareStatement(sql.toString());
                statement.setInt(1, id);
                resultSet = statement.executeQuery();
                while (resultSet.next()) {
                    images.add(resultSet.getString(1));
                }
                return images.isEmpty() ? null : images.get(0);
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
