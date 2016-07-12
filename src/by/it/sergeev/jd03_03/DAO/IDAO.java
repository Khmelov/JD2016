package by.it.sergeev.jd03_03.DAO;

import java.util.List;

public interface IDAO<TYPE> {
    List<TYPE> getAll(String where);
    TYPE read(int id);
    boolean create(TYPE type);
    boolean update(TYPE type);
    boolean delete(TYPE type);
}