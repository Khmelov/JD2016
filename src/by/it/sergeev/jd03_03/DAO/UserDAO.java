package by.it.sergeev.jd03_03.DAO;

import by.it.sergeev.jd03_02.User;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserDAO extends DAO implements IDAO<User> {
    @Override
    public List<User> getAll(String where){
        List<User> users = new ArrayList<>();
        String sql = String.format("SELECT * FROM users_d %s;", where);
        Statement statement = DAO.getStatement();
        ResultSet resultSet;
        try {
            resultSet = statement.executeQuery(sql);
            while (resultSet.next()){
                User user = new User();
                user.setId(resultSet.getInt("id"));
                user.setLogin(resultSet.getString("Login"));
                user.setPassword(resultSet.getString("Password"));
                user.setName(resultSet.getString("Name"));
                user.setEmail(resultSet.getString("Email"));
                user.setFk_role(resultSet.getInt("FK_Role"));
                users.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }

    @Override
    public User read(int id) {
        List<User> users = getAll("WHERE ID=" + id + " LIMIT 0,1");
        if(0 < users.size())
            return users.get(0);
        else
            return null;
    }

    @Override
    public boolean create(User user) {
        String sql = String.format("insert INTO users_d(Login, Password, Name, Email, FK_Role)" +
                        " values('%s', '%s', '%s', '%s', %d);",
                user.getLogin(), user.getPassword(), user.getName(), user.getEmail(),  user.getFk_role());
        return 0 < executeUpdate(sql);
    }

    @Override
    public boolean update(User user) {
        String sql = String.format("UPDATE users_d SET Login='%s',  Password='%s', Name='%s', Email='%s', FK_Role=%d WHERE id=%d",
                user.getLogin(), user.getPassword(), user.getName(), user.getEmail(), user.getFk_role(), user.getId());
        return 0 < executeUpdate(sql);
    }

    @Override
    public boolean delete(User user) {
        String sql = String.format("DELETE FROM users_d WHERE id = %d;", user.getId());
        return 0 < executeUpdate(sql);
    }
}
