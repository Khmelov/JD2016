package by.it.vasilevich.jd03_03.custom_dao;


import by.it.vasilevich.jd03_03.beans.Ad;
import by.it.vasilevich.jd03_03.connection.ConnectionCreator;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class AdDAO extends AbstractDAO implements InterfaceDAO<Ad> {
    @Override
    public Ad read(int id) {
        List<Ad> roles = getAll("WHERE ID=" + id + " LIMIT 0,1");
        if (roles.size() > 0) {
            return roles.get(0);
        } else
            return null;    }

    @Override
    public boolean create(Ad ad) {
        String sql = String.format(Locale.ENGLISH,
                "insert INTO ad(Price,Brand,Model,Type,Year,Engine,Transmission,Drive_unit,Mileage,Color,FK_Users)" +
                        "\n values('%d', '%s', '%s', '%s', '%d', '%s', '%s', '%s', '%d',  '%s',  '%d');",
                ad.getPrice(),
                ad.getBrand(),
                ad.getModel(),
                ad.getType(),
                ad.getYear(),
                ad.getEngine(),
                ad.getTransmission(),
                ad.getDrive_unit(),
                ad.getMileage(),
                ad.getColor(),
                ad.getFK_Users()
        );
        ad.setID(executeUpdate(sql));
        return (ad.getID() > 0);    }

    @Override
    public boolean update(Ad ad) {
        String sql = String.format(Locale.ENGLISH,
                "UPDATE `ad` SET " +
                        "`Price`=%d" +
                        ",`Brand`='%s'" +
                        ",`Model`='%s'" +
                        ",`Type`='%s'" +
                        ",`Year`=%d" +
                        ",`Engine`='%s'" +
                        ",`Transmission`='%s'" +
                        ",`Drive_unit`='%s'" +
                        ",`Mileage`=%d" +
                        ",`Color`='%s'" +
                        ",`FK_Users`=%d " +
                        " WHERE `ad`.`ID` = %d",
                ad.getPrice(),
                ad.getBrand(),
                ad.getModel(),
                ad.getType(),
                ad.getYear(),
                ad.getEngine(),
                ad.getTransmission(),
                ad.getDrive_unit(),
                ad.getMileage(),
                ad.getColor(),
                ad.getFK_Users(),
                ad.getID()
        );

        return (0 < executeUpdate(sql));    }

    @Override
    public boolean delete(Ad ad) {
        String sql = String.format(
                "DELETE FROM `ad` WHERE `ad`.`ID`=%d;", ad.getID()
        );
        return (0 < executeUpdate(sql));    }

    @Override
    public List<Ad> getAll(String WHERE) {
        List<Ad> ads = new ArrayList<>();
        String sql = "SELECT * FROM ad " + WHERE + " ;";
        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement()
        ) {
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                Ad ad = new Ad();
                ad.setID(rs.getInt("ID"));
                ad.setPrice(rs.getInt("Price"));
                ad.setBrand(rs.getString("Brand"));
                ad.setModel(rs.getString("Model"));
                ad.setType(rs.getString("Type"));
                ad.setYear(rs.getInt("Year"));
                ad.setEngine(rs.getString("Engine"));
                ad.setTransmission(rs.getString("Transmission"));
                ad.setDrive_unit(rs.getString("Drive_unit"));
                ad.setMileage(rs.getInt("Mileage"));
                ad.setColor(rs.getString("Color"));
                ad.setFK_Users(rs.getInt("FK_Users"));
                ads.add(ad);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ads;
    }
}
