package by.it.novik.jd03_03.dao;

import by.it.novik.jd03_03.beans.Authorization;
import by.it.novik.jd03_03.connection.ConnectorDB;
import by.it.novik.jd03_03.beans.User;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Kate Novik.
 */
public class UserDAO extends AbstractDAO implements IDAO<User,Integer> {

    @Override
    public boolean create(User object) {
        String createObject = String.format ("INSERT INTO users (First_Name, Middle_Name, Last_Name, Passport, Address, Phone, " +
                        "Login, Password, Email, FK_Role) VALUES ('%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%d');",
                object.getFirstName(), object.getMiddleName(), object.getLastName(), object.getPassport(), object.getAddress(),
                object.getPhone(), object.getNickname(), object.getPassword(),
                object.getEmail(), object.getFK_Role());
        //Синхронзация по классу
        synchronized (UserDAO.class) {
            object.setIdUser(executeUpdate(createObject));
        }
        return (object.getIdUser() > 0);
    }

    @Override
    public User read(Integer id) {
        User resultUser = null;
        List<User> listUser = getAll("WHERE ID=" + id + " LIMIT 0,1");
        if (listUser.size() > 0) {
            resultUser = listUser.get(0);
        }
        return resultUser;
    }

    @Override
    public boolean update(User object) {
        int result;
        String updateObject = String.format ("UPDATE users SET First_Name='%s', Middle_Name='%s', Last_Name='%s', " +
                        "Passport='%s', Address='%s', Phone='%s', Login='%s', Password='%s', Email='%s', FK_Role='%d' Where users.ID='%d';",
                object.getFirstName(), object.getMiddleName(), object.getLastName(), object.getPassport(), object.getAddress(),
                object.getPhone(), object.getNickname(), object.getPassword(), object.getEmail(), object.getFK_Role(), object.getIdUser());
        //Синхронзация по классу
        synchronized (UserDAO.class) {
            result = executeUpdate(updateObject);
        }
        return (result > 0);
    }

    @Override
    public boolean delete(User object) {
        int result;
        String deleteObject = String.format ("DELETE From users Where users.ID='%d';", object.getIdUser());
        //Синхронзация по классу
        synchronized (UserDAO.class) {
            result = executeUpdate(deleteObject);
        }
        return (result > 0);
    }

    @Override
    public List<User> getAll(String where) {
        User resultUser;
        List<User> userList = new ArrayList<>();
        String readObject = "Select * From users " + where + ";";
        try (Connection connection = ConnectorDB.getConnection();
             Statement statement = connection.createStatement()) {
            //Синхронзация по классу
            synchronized (UserDAO.class) {
                ResultSet resultSet = statement.executeQuery(readObject);
                while (resultSet.next()) { //Создание user в соответствии с полученными данными с таблицы
                    resultUser = new User(
                            resultSet.getInt("ID"),
                            resultSet.getString("First_Name"),
                            resultSet.getString("Middle_Name"),
                            resultSet.getString("Last_Name"),
                            resultSet.getString("Passport"),
                            resultSet.getString("Address"),
                            resultSet.getString("Phone"),
                            resultSet.getString("Login"),
                            resultSet.getString("Password"),
                            resultSet.getString("Email"),
                            resultSet.getInt("FK_Role"));
                    userList.add(resultUser);
                }
            }
        }
        catch (SQLException e) {
            System.out.println("Error connection or sql operation!" + e);
        }
        return userList;
    }

    /**
     * Получение объекта User по ДТО Authorization
     * @param authorization ДТО Authorization
     * @return объект User
     */
    public User getByAuthorization (Authorization authorization) {
        User resultUser = null;
        List<User> listUser = getAll("Where users.Login=" + authorization.getNickname() + " AND users.Password=" + authorization.getPassword());
        if (listUser.size() > 0) {
            resultUser = listUser.get(0);
        }
        return resultUser;
    }

}
