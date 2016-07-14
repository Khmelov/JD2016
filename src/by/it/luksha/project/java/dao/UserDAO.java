package by.it.luksha.project.java.dao;

import by.it.luksha.project.java.beans.User;
import by.it.luksha.project.java.connector.ConnectorDB;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserDAO extends AbstractDAO implements IDAO<Integer, User> {
    @Override
    public boolean create(User user) {
        String sqlQuery = String.format(
                "INSERT INTO users (Login, Password, Email, FK_Role) values ('%s', '%s', '%s', %d);",
                user.getLogin(), user.getPassword(), user.getEmail(), user.getFk_role()
        );
        synchronized (UserDAO.class) {
            user.setId(executeUpdate(sqlQuery));
        }
        return (user.getId()>0);
    }

    @Override
    public User read(Integer id) {
        List<User> users = getAll("WHERE ID=" + id + " LIMIT 0,1");
        if (users.size() > 0) {
            return users.get(0);
        } else {
            return null;
        }
    }

    @Override
    public boolean update(User user) {
        int resultQuery;
        String sqlQuery = String.format(
                "UPDATE users SET Login = '%s', Password = '%s', Email = '%s', FK_Role = '%d' WHERE users.ID = '%d';",
                user.getLogin(), user.getPassword(), user.getEmail(), user.getFk_role(), user.getId()
        );
        synchronized (UserDAO.class) {
            resultQuery = executeUpdate(sqlQuery);
        }
        return  (resultQuery > 0);
    }

    @Override
    public boolean delete(User user) {
        int resultQuery;
        String sqlQuery = String.format(
                "DELETE FROM users WHERE users.ID = '%d';",
                user.getId()
        );
        synchronized (UserDAO.class) {
            resultQuery = executeUpdate(sqlQuery);
        }
        return (resultQuery > 0);
    }

    @Override
    public List<User> getAll(String where) {
        List<User> users = new ArrayList<>();
        String sqlQuery = "SELECT * FROM users "+ where + " ;";

        try (
                Connection connection = ConnectorDB.getConnection();
                Statement statement = connection.createStatement();
                ) {
            synchronized (UserDAO.class) {
                ResultSet resultSet = statement.executeQuery(sqlQuery);
                while (resultSet.next()) {
                    User user = new User();
                    user.setId(resultSet.getInt("ID"));
                    user.setLogin(resultSet.getString("Login"));
                    user.setPassword(resultSet.getString("Password"));
                    user.setEmail(resultSet.getString("Email"));
                    user.setFk_role(resultSet.getInt("FK_Role"));
                    users.add(user);
                }
            }
        } catch (SQLException e) {
            //Нужно сделать логгирование SQLException(e)
            System.out.printf("Ошибка соединения или sql запроса: %s\n", e);
        }
        return users;
    }
}
