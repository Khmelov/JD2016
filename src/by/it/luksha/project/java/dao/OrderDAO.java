package by.it.luksha.project.java.dao;

import by.it.luksha.project.java.beans.Order;
import by.it.luksha.project.java.connector.ConnectorDB;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by MMauz on 12.07.2016.
 */
public class OrderDAO extends AbstractDAO implements IDAO<Integer, Order> {

    @Override
    public boolean create(Order order) {
        String sqlQuery = String.format(
                "INSERT INTO orders (FK_User, FK_Car, StartRent, EndRent, TotalCost) values (%d, %d, '%s', '%s', %d);",
                order.getFk_user(), order.getFk_car(), order.getStartRent(), order.getEndRent(), order.getTotalCost()
        );
        synchronized (OrderDAO.class) {
            order.setId(executeUpdate(sqlQuery));
        }
        return (order.getId() > 0);
    }

    @Override
    public Order read(Integer id) {
        List<Order> orders = getAll("WHERE ID=" + id + " LIMIT 0,1");
        if (orders.size() > 0) {
            return orders.get(0);
        } else {
            return null;
        }
    }

    @Override
    public boolean update(Order order) {
        int resultQuery;
        String sqlQuery = String.format(
                "UPDATE orders SET FK_User = '%d', FK_Car = '%d', StartRent = '%s', EndRent = '%s', TotalCost = '%d' WHERE orders.ID = '%d';",
                order.getFk_user(), order.getFk_car(), order.getStartRent(), order.getEndRent(), order.getTotalCost(), order.getId()
        );
        synchronized (OrderDAO.class) {
            resultQuery = executeUpdate(sqlQuery);
        }
        return (resultQuery > 0);
    }

    @Override
    public boolean delete(Order order) {
        int resultQuery;
        String sqlQuery = String.format(
                "DELETE FROM orders WHERE orders.ID = '%d';",
                order.getId()
        );
        synchronized (OrderDAO.class) {
            resultQuery = executeUpdate(sqlQuery);
        }
        return (resultQuery > 0);
    }

    @Override
    public List<Order> getAll(String where) {
        List<Order> orders = new ArrayList<>();
        String sqlQuery = "SELECT * FROM orders " + where + " ;";

        try (
                Connection connection = ConnectorDB.getConnection();
                Statement statement = connection.createStatement();
        ) {
            synchronized (OrderDAO.class) {
                ResultSet resultSet = statement.executeQuery(sqlQuery);
                while (resultSet.next()) {
                    Order order = new Order();
                    order.setId(resultSet.getInt("ID"));
                    order.setFk_user(resultSet.getInt("FK_User"));
                    order.setFk_car(resultSet.getInt("FK_Car"));
                    order.setStartRent(resultSet.getTimestamp("StartRent"));
                    order.setEndRent(resultSet.getTimestamp("EndRent"));
                    order.setTotalCost(resultSet.getInt("TotalCost"));
                    orders.add(order);
                }
            }
        } catch (SQLException e) {
            //Нужно сделать логгирование SQLException(e)
            System.out.printf("Ошибка соединения или sql запроса: %s\n", e);
        }
        return orders;
    }
}
