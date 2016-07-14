package by.it.luksha.project.java.dao;

import by.it.luksha.project.java.beans.Car;
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
public class CarDAO extends AbstractDAO implements IDAO<Integer, Car> {
    @Override
    public boolean create(Car car) {
        String sqlQuery = String.format(
                "INSERT INTO cars (Brand, Model, Category, Cost, Consumption) values ('%s', '%s', '%s', %d, %.1f);",
                car.getBrand(), car.getModel(), car.getCategory(), car.getCost(), car.getConsumption()
        );
        synchronized (CarDAO.class) {
            car.setId(executeUpdate(sqlQuery));
        }
        return (car.getId() > 0);
    }

    @Override
    public Car read(Integer id) {
        List<Car> cars = getAll("WHERE ID=" + id + " LIMIT 0,1");
        if (cars.size() > 0) {
            return cars.get(0);
        } else {
            return null;
        }
    }

    @Override
    public boolean update(Car car) {
        int resultQuery;
        String sqlQuery = String.format(
                "UPDATE cars SET Brand = '%s', Model = '%s', Category = '%s', Cost = '%d', Consumption = '%.1f' WHERE cars.ID = '%d';",
                car.getBrand(), car.getModel(), car.getCategory(), car.getCost(), car.getConsumption(), car.getId()
        );
        synchronized (CarDAO.class) {
            resultQuery = executeUpdate(sqlQuery);
        }
        return (resultQuery > 0);
    }

    @Override
    public boolean delete(Car car) {
        int resultQuery;
        String sqlQuery = String.format(
                "DELETE FROM cars WHERE cars.ID = '%d';",
                car.getId()
        );
        synchronized (CarDAO.class) {
            resultQuery = executeUpdate(sqlQuery);
        }
        return (resultQuery > 0);
    }

    @Override
    public List<Car> getAll(String where) {
        List<Car> cars = new ArrayList<>();
        String sqlQuery = "SELECT * FROM cars " + where + " ;";

        try (
                Connection connection = ConnectorDB.getConnection();
                Statement statement = connection.createStatement();
        ) {
            synchronized (CarDAO.class) {
                ResultSet resultSet = statement.executeQuery(sqlQuery);
                while (resultSet.next()) {
                    Car car = new Car();
                    car.setId(resultSet.getInt("ID"));
                    car.setBrand(resultSet.getString("Brand"));
                    car.setModel(resultSet.getString("Model"));
                    car.setCategory(resultSet.getString("Category"));
                    car.setCost(resultSet.getInt("Cost"));
                    car.setConsumption(resultSet.getDouble("Consumption"));
                    cars.add(car);
                }
            }
        } catch (SQLException e) {
            //Нужно сделать логгирование SQLException(e)
            System.out.printf("Ошибка соединения или sql запроса: %s\n", e);
        }
        return cars;
    }
}
