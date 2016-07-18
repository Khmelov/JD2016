package by.it.vasilevich.jd03_03;


<<<<<<< HEAD


=======
>>>>>>> b0d0f6832c0651a55d08b90a6da14c6a1602da18
import by.it.vasilevich.jd03_03.beans.Ad;
import by.it.vasilevich.jd03_03.custom_dao.DAO;

import java.sql.SQLException;

public class AdRunner {

    public static void main(String[] args) throws SQLException {
        DAO dao= DAO.getDAO();
        Ad ad=new Ad(0,17500,"Mercedes","S500","sedan",2003,"petrol","manual","rear",173000,"blue",22);
        System.out.println("All-------------------------");
        System.out.println(dao.ad.getAll(""));

        dao.ad.create(ad);
        System.out.println("-------- Create ------------");
        System.out.println(dao.ad.getAll(""));

        ad.setBrand("unknow");
        dao.ad.update(ad);
        System.out.println("-------- Update ------------");
        System.out.println(dao.ad.getAll(""));

        dao.ad.delete(ad);
        System.out.println("-------- Delete ------------");
        System.out.println(dao.ad.getAll(""));

    }
}
