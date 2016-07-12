package by.it.sergeev.jd03_02;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class AdCRUD {

    public Ad create(Ad ad) throws SQLException
    {
        boolean okCreate=false;
        try (

                Connection connection = Connector.getConnection(); //создаэм соединения с базой
                Statement statement = connection.createStatement();//создаэм объект для обращения к базе
        ) {
            //формирование строки createUserSQL по данным bean user
            String sql = String.format("insert into user(Electronics, Manufacturer, Name, Model, Price, Description) values('%s','%s','%s','%s','%d','%s');",
                    ad.getElectronics(), ad.getManufacturer(), ad.getName(),ad.getModel(), ad.getPrice(), ad.getDescription());
            //выполняем добавление в базу. Должна быть добавлена одна запись.
            if (statement.executeUpdate(sql) == 1) {
                //если всё добавлена то узнаем последний ID
                ResultSet resultSet = statement.executeQuery("SELECT LAST_INSERT_ID();");
                if (resultSet.next())
                    ad.setId(resultSet.getInt(1));
                okCreate=true;
            }
        } catch (SQLException e) {
            throw e;
        }
        return ad;
    }
}