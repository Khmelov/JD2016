package by.it.novik.jd02_01;

import by.it.novik.jd02_01.entities.Supermarket;
import by.it.novik.jd02_01.utils.InOut;


/**
 * Created by Kate Novik.
 */
public class Runner {
    public static void main(String[] args) {
        //Создаем супермаркет
        Supermarket sm = new Supermarket();
        //Добавляем корзинки в супермаркет
        sm.setCountBaskets(500);
        //Чтение товаров из файла в HashMap
        InOut.inputRead(sm);
        try {
            //Добавим покупателей за последние 2 минуты
            int time = 0; //счетчик минут
            int min = 0;
            while (min!=2) {
                System.err.println(sm.getCountBuyers() + "start");
                while (time <= 30) {
                    Thread.sleep(1000);
                    time++;
                    sm.addBuyersForSec(time);
                }
                System.err.println(sm.getCountBuyers() + "part/2");
                while (time > 30 && time <= 60) {
                    Thread.sleep(1000);
                    time++;
                    sm.addBuyersForSec(time);
                }

                System.err.println(sm.getCountBuyers() + "end");
                time = 0;
                min++;
            }
        } catch (InterruptedException e) {
            System.out.println("Некорректное завершение ожидания в main!");
        }
        //Запись товаров из HashMap в файл
        //Input.outputWrite(sm);
    }
}
