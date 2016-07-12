package by.it.sergeev.jd03_02;

import java.sql.SQLException;

public class Runner {
    public static void main(String[] args){
        User user = new User(0,"fggret","ersre","gtet","drdrd@tut.by",1);
        UserCRUD userCRUD = new UserCRUD();
        try {
            userCRUD.create(user);
            System.out.println(user);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
