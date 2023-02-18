package vn.edu.hcmuaf.fit.dao.impl;

import vn.edu.hcmuaf.fit.dao.IBillDetailsDAO;
import vn.edu.hcmuaf.fit.db.JDBCConnector;
import vn.edu.hcmuaf.fit.model.BillDetail;
import vn.edu.hcmuaf.fit.model.BookManagementModel;
import vn.edu.hcmuaf.fit.model.BookModel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BillDetailDAO implements IBillDetailsDAO {
    @Override
    public void create(BillDetail billDetail) {
//        List<BillModel>
    }

    @Override
    public List<BillDetail> findAll() {
        return null;
    }

    @Override
    public BillDetail findById(int id) {
        List<BillDetail> users = new ArrayList<>();
        Connection connection = JDBCConnector.getConnection();
        String sql = new String("SELECT book.id_book, book.name, bill_details.quantity, book.price*(1- book.discount_price) as price_final\n" +
                "from bill_details, book\n" +
                "WHERE bill_details.id_book = book.id_book AND bill_details.id_order=?");

        PreparedStatement statement = null;
        ResultSet resultSet = null;
        if(connection != null) {
            try {
                statement = connection.prepareStatement(sql.toString());
                statement.setInt(1, id);
                resultSet = statement.executeQuery();
                while (resultSet.next()) {
                    BillDetail billDetail = new BillDetail();
                    billDetail.setId(resultSet.getInt(1));
                    billDetail.setName(resultSet.getString(2));
                    billDetail.setQuantity(resultSet.getInt(3));
                    billDetail.setPrice(resultSet.getLong(4));
                    users.add(billDetail);
                }

                return users.isEmpty() ? null : users.get(0);
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
