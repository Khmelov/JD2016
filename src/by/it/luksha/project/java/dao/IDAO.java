package by.it.luksha.project.java.dao;


import java.util.List;

/**
 * Интерфейс с описанием общих методов для взаимодействия с таблицами(CRUD + getAll)
 *
 * @param <K> ключ в таблице
 * @param <T> бизнес-сущность
 */
public interface IDAO<K, T> {
    /**
     * Создание записи о сущности в БД
     *
     * @param entity сущность
     * @return успех операции
     */
    boolean create(T entity);

    /**
     * Чтение записи о сущности из БД по ключу
     *
     * @param id ключ
     * @return сущность
     */
    T read(K id);

    /**
     * Обновление записи сущности в БД
     *
     * @param entity сущность с изменениями
     * @return успех операции
     */
    boolean update(T entity);

    /**
     * Удаление записи о сущности из БД
     *
     * @param entity сущность для удаления
     * @return успех операции
     */
    boolean delete(T entity);

    /**
     * Получение списка всех сущностей по условию
     *
     * @param where условие
     * @return список сущностей
     */
    List<T> getAll(String where);
}
