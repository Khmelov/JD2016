package by.it.drachyova.jd01_13;

import by.it.drachyova.jd01_08.PublicBuilding;
import by.it.drachyova.jd01_08.Theatre;
import by.it.drachyova.jd01_08.TheatreVisitor;

/**
    Создать произвольный пример JD01_13/VariantC на базе своего
    задания по ООП (JD01_08) с собственным событием обработки ошибки.
 */
public class TaskC {
    public static void main(String[] args) throws Exception {

        PublicBuilding opera = new Theatre();
        TheatreVisitor visitor = new TheatreVisitor("Иван", 30);
        opera.closeDoors();                                                 //закроем двери
        try {
            if (opera.closeDoors())                                         // если двери открыты
                visitor.visitTheatre();                                     //посетитель посещает театр
             else                                                           //иначе
                throw new Exception("Ошибка!!! Посетитель не может попасть в театр"); //возникает ошибка
        }
        catch (Exception e){                                                 //обрабатываем исключение
            System.out.println(e.getMessage());                              //выводим сообщение об ошибке
            opera.openDoors();                                               //откроем двери, чтобы
            visitor.visitTheatre();                                          //посетитель мог посетить театр

        }
    }
}
