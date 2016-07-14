package by.it.luksha.project.java.dao;

public class DAO {
    //Экземпляр singleton
    private static DAO dao;

    //конкретные DAO для сущностей
    private UserDAO userDAO;
    private CarDAO carDAO;
    private OrderDAO orderDAO;


    private DAO() {
    }

    /**
     * Возвращает экземпяр DAO или создает и возвращает экземпляр DAO
     *
     * @return DAO
     */
    public static DAO getDAO() {
        if (dao == null) {
            synchronized (DAO.class) {
                if (dao == null) {
                    dao = new DAO();
                    dao.userDAO = new UserDAO();
                    dao.carDAO = new CarDAO();
                    dao.orderDAO = new OrderDAO();
                    //новые куски DAO добавляются аналогично при расширении DAO
                    //...
                }
            }
        }
        return dao;
    }

    public UserDAO getUserDAO() {
        return userDAO;
    }

    public CarDAO getCarDAO() {
        return carDAO;
    }

    public OrderDAO getOrderDAO() {
        return orderDAO;
    }
}
