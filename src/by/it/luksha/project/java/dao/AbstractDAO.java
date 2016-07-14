package by.it.luksha.project.java.dao;

import by.it.luksha.project.java.connector.ConnectorDB;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public abstract class AbstractDAO {
    /**
     * Общий метод для Create, Read, Update
     *
     * @param sqlQuery sql запрос
     * @return результат sql запроса или id вставленной записи для insert
     */
    protected int executeUpdate(String sqlQuery) {
        int resultQuery = -1;
        try (
                Connection connection = ConnectorDB.getConnection();
                Statement statement = connection.createStatement();
        ) {
            resultQuery = statement.executeUpdate(sqlQuery);
            //
            if (sqlQuery.trim().toUpperCase().startsWith("INSERT")) {
                ResultSet resultSet = statement.executeQuery("select LAST_INSERT_ID();");
                if (resultSet.next()) {
                    resultQuery = resultSet.getInt(1);
                }
            }
        } catch (SQLException e) {
            //Нужно сделать логгирование SQLException(e)
            System.out.printf("Ошибка соединения или sql запроса: %s\n", e);
        }
        return resultQuery;
    }
}
