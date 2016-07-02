package by.it.novik.jd01_13.taskC;


import by.it.novik.jd01_13.taskC.Entity.Book;
import by.it.novik.jd01_13.taskC.Furniture.Bookcase;
import by.it.novik.jd01_13.taskC.exceptions.EmptyNameException;

/**
 * Created by Kate Novik.
 */
public class Run {
    public static void main(String[ ] args) {
        //Создадим книжный шкаф
        Bookcase bookcase = new Bookcase();
        //Покажем состояние шкафа
        bookcase.showState();
        //Переместим шкаф на x=20, y=30
        bookcase.move(20, 30);
        //Откроем шкаф
        bookcase.open();
        //Повесим шкаф
        bookcase.hangBookcase();
        //Покажем состояние шкафа
        bookcase.showState();

        //Создадим объекты книга
        Book book1 = new Book ();
        book1.setISBNBook("978-985-6047-33-2");
        book1.setAuthor("Сутеев В.Г.");
        book1.setName("Стихи для детей");

        Book book2 = new Book ();
        book2.setISBNBook("978-935-6020-33-2");
        book2.setAuthor("Пушкин А.С.");
        book2.setName("Руслан и Людмила");

        Book book3 = new Book ();
        book3.setISBNBook("978-945-5010-21-2");
        book3.setAuthor("Грибоедов А.C.");
        book3.setName("Горе от Ума");

        //Положим книги в шкаф
        System.out.println("Положим книги в шкаф");
        bookcase.put(book1);
        bookcase.put(book2);
        bookcase.put(book3);
        //Просмотр списка книг
        bookcase.printListOfBooks();
        //Отсортируем книги в шкафу
        System.out.println("Отсортируем книги в шкафу");
        bookcase.sortThings();
        bookcase.printListOfBooks();
        //Забирем книгу "Руслан и Людмила" из шкафа
        System.out.println("Забирем книгу \"Руслан и Людмила\" из шкафа");

       // String name = "Руслан и Людмила";
        String name = "";
        try {
            bookcase.getByName(name); //Здесь может быть исключение
        }
        catch (EmptyNameException e) {
            System.out.println(e.getMessage()); //Печатаем сообщение EmptyNameException
            e.printStackTrace();
        }

        //Выводим оставшиеся книги
        bookcase.printListOfBooks();
        //Очистим шкаф
        System.out.println("Очистим шкаф");
        bookcase.clean();
        bookcase.printListOfBooks();
        //Разберем шкаф
        bookcase.disassemble();
        bookcase.showState();

    }
}
