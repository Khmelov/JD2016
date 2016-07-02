package by.it.sergeev.jd01_13.TaskC;

/**
 * Created by user_2 on 13.05.2016.
 */
public interface IFilm {
    String getName(); //Название фильма
    /**
     * Этапы создания фильма.
     */
    void development()throws NameException;;//   Разработка
    void preproduction()throws NameException;;// Предварительное производство
    void production()throws NameException;;//    Производство
    void postproduction()throws NameException;;//Пост-продакшн
    void distribution()throws NameException;;//  Распределение
}
