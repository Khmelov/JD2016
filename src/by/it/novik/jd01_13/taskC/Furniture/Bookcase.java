package by.it.novik.jd01_13.taskC.Furniture;

import by.it.novik.jd01_13.taskC.Furniture.Cupboards;
import by.it.novik.jd01_13.taskC.Entity.Book;
import by.it.novik.jd01_13.taskC.Entity.Things;
import by.it.novik.jd01_13.taskC.exceptions.EmptyNameException;

import java.util.Collections;
import java.util.Comparator;


/**
 * Created by Kate Novik.
 */
public class Bookcase extends Cupboards {
    // Укажем состояние для книжных шкафов по вешанью
    private boolean stateHang;

    public Bookcase() {
        super();
        stateHang = false;
    }

    public Bookcase(double stateX, double stateY) {
        super();
        stateHang = false;
        setStateX(stateX);
        setStateY(stateY);
    }

    /**
     * Метод повесить шкаф
     */
    public void hangBookcase() {
        stateHang = true;
    }

    /**
     * Перегрузка метода put - положить вещь в шкаф
     * @param book Объект книга
     * @return true - книга положена, в противном случае - false
     */
    public boolean put(Book book) {
        if (book != null) { // Проверка на не пустой объект
            listOfThings.add(book);
            return true;
        }
        return false;
    }

    /**
     * Переопределение метода getByName - взять вещь
     * @param name Поле ISBN книги
     * @return Обект book или null
     */
    @Override
    public Book getByName(String name) throws EmptyNameException {
        if (!name.isEmpty()) { // Проверка на не пусте имя книги
            for (Things book : listOfThings) {
                if (book.getName().equals(name)) {
                    listOfThings.remove(book);
                    return (Book) book;
                }
            }
        }
        else throw new EmptyNameException("Receive empty name of thing!");
        return null;
    }

    /**
     * Используем динамическое связывниие, переопределяя метод disassemble абстрактного класса
     * Добавляем значение поля stateHang = false, т.к. при разборке шкаф не повешен
     */
    @Override
    public boolean disassemble() { // Динамическое связывание
        super.disassemble();
        stateHang = false; // Добавляем значение поля повешен
        return getStateAssemble();
    }

    /**
     * Показать состояния шкафа
     */
    public void showState() {
        System.out.print("Состояние книжного шкафа:");
        if (getStateAssemble()) {
            System.out.print("собран");
            if (stateHang) {
                System.out.print(", повешен");
            } else {
                System.out.print(", не повешен");
            }
            if (getStateOpen()) {
                System.out.print(", открыт");
            } else {
                System.out.print(", закрыт");
            }
        } else {
            System.out.print("разобран, не повешен, открыт");
        }
        System.out.print(", положение x=" + getStateX() + ", положение y=" + getStateY());
        System.out.println("");
    }

    /**
     * Сортировка книг
     * @return true - книги отсортированы
     */
    public boolean sortThings() {
        Collections.sort(listOfThings, new Comparator<Things>() {
            public int compare(Things thing1, Things thing2) {
                Book book1 = (Book) thing1;
                Book book2 = (Book) thing2;
                return book1.getISBNBook().compareToIgnoreCase(book2.getISBNBook());
            }
        });
        return true;
    }

    public void setStateHang(boolean stateHang) {
        this.stateHang = stateHang;
    }

    public boolean getStateHang() {
        return stateHang;
    }

    /**
     * Печать списка книг
     */
    public void printListOfBooks() {
        int i = 0;
        for (Things thing : listOfThings) {
            Book book = (Book) thing;
            i++;
            System.out.println("Книга " + i);
            System.out.print("ISBN: " + book.getISBNBook() + ",");
            System.out.print("Автор: " + book.getAuthor() + ",");
            System.out.println("Название: " + book.getName() + ".");
        }
    }


}

