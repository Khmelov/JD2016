package by.it.sergeev.jd03_03.DAO;

import by.it.sergeev.jd03_02.Ad;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class AdDAO extends DAO implements IDAO<Ad> {
    @Override
    public List<Ad> getAll(String where){
        List<Ad> ads = new ArrayList<>();
        String sql = String.format("SELECT * FROM tours_d %s;", where);
        ResultSet resultSet;
        Statement statement = DAO.getStatement();
        try{
            resultSet = statement.executeQuery(sql);
            while (resultSet.next()){
                Ad ad = new Ad();
                ad.setId(resultSet.getInt("ID"));
                ad.setElectronics(resultSet.getString("Электроника"));
                ad.setManufacturer(resultSet.getString("Производитель"));
                ad.setName(resultSet.getString("Название"));
                ad.setModel(resultSet.getString("Модель"));
                ad.setPrice(resultSet.getInt("Цена"));
                ad.setDescription(resultSet.getString("Описание"));
                ad.setFk_user(resultSet.getInt("user"));
                ads.add(ad);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ads;
    }

    @Override
    public Ad read(int id) {
        List<Ad> ads = getAll("WHERE ID=" + id + " LIMIT 0,1");
        if (0 < ads.size())
            return ads.get(0);
        else
            return null;
    }

    @Override
    public boolean create(Ad ad) {
        String sql = String.format("INSERT INTO ads_d(Электроника, Производитель, Название, Модель, Цена, Описание)" +
                        " values(%s, %s, %s, %s, %d, %s);",
                ad.getElectronics(), ad.getManufacturer(), ad.getName(), ad.getModel(), ad.getPrice(), ad.getDescription());
        return 0 < executeUpdate(sql);
    }

    @Override
    public boolean update(Ad ad) {
        String sql = String.format("UPDATE ads_d SET Электроника=%s,  Производитель=%s,  Название=%s,  Модель=%s,  Цена=%d, Описание=%s;",
                ad.getElectronics(), ad.getManufacturer(), ad.getName(), ad.getModel(), ad.getPrice(), ad.getDescription());
        return 0 < executeUpdate(sql);
    }

    @Override
    public boolean delete(Ad ad) {
        String sql = String.format("DELETE FROM ads_d WHERE id = %d;", ad.getId());
        return 0 < executeUpdate(sql);
    }
}