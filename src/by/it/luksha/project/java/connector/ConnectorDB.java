package by.it.luksha.project.java.connector;

import com.mysql.fabric.jdbc.FabricMySQLDriver;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

/**
 * Класс для получение объекта Connection подключения к БД
 */
public class ConnectorDB {
    //данные для подключения
    /*private static final ResourceBundle resource = ResourceBundle.getBundle("by.it.luksha.project.resource.database");
    private static final String url = resource.getString("db.url");
    private static final String user = resource.getString("db.user");
    private static final String pass = resource.getString("db.password");*/
    private static final String url = "jdbc:mysql://localhost:2016/luksha";
    private static final String user = "root";
    private static final String pass = "";

    //экземпляр класса объекта Connection
    private static volatile Connection connection;

    private ConnectorDB() {
    }

    /**
     * Получает connection к БД
     * @return connection
     * @throws SQLException
     */
    public static Connection getConnection() throws SQLException {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.printf("Ошибка драйвера подключения к БД: %s\n", e);
        }

        if (connection == null || connection.isClosed()) {
            synchronized (ConnectorDB.class) {
                if (connection == null || connection.isClosed()) {
                    Driver driver = new FabricMySQLDriver();
                    DriverManager.registerDriver(driver);

                    connection = DriverManager.getConnection(url, user, pass);
                }
            }
        }
        return connection;
    }
}
