package by.it.novik.jd02_02;

import by.it.novik.jd02_02.entities.Supermarket;
import by.it.novik.jd02_02.utils.InOut;
import by.it.novik.jd02_02.entities.Buyer;
import by.it.novik.jd02_02.utils.RandomCounter;


/**
 * Created by Kate Novik.
 */
public class Runner {
    public static void main(String[] args) throws InterruptedException {
        //Создаем супермаркет
        Supermarket sm = new Supermarket();
        //Добавляем корзинки в супермаркет
        sm.setCountBaskets(100);
        //Создаем кассы
       sm.getManager().createCashiers(5);
        //Чтение товаров из файла в HashMap
        InOut.inputRead(sm);

while (sm.getCountBuyers() < 30) {
    try {
        Thread.sleep(1000);
    } catch (InterruptedException e) {
        e.printStackTrace();
    }
    int count = RandomCounter.countRandom(4, 6);

    for (int i = 0; i < count; i++) {
        Buyer buyer;
        if ((sm.getCountBuyers() + 1) % 4 != 0) { //Проверка на не каждый четвертый - обычный покупатель
            buyer = new Buyer(sm.getCountBuyers() + 1, sm, false);//Создаем покупателя
        } else { //В случае, если каждый четвертый, то пенсионер - флаг true
            buyer = new Buyer(sm.getCountBuyers() + 1, sm, true);//Создаем покупателя
        }
        sm.incrementCountOfBuyers(buyer);
    }
}



//        try {
//            //Добавим покупателей за последние 2 минуты
//            int time = 0; //счетчик минут
//            int min = 0;
//            while (min!=2) {
//                System.err.println(sm.getCountBuyers() + "start");
//                while (time <= 30) {
//                    Thread.sleep(1000);
//                    time++;
//                    sm.addBuyersForSec(time);
//                }
//                System.err.println(sm.getCountBuyers() + "part/2");
//                while (time > 30 && time <= 60) {
//                    Thread.sleep(1000);
//                    time++;
//                    sm.addBuyersForSec(time);
//                }
//
//                System.err.println(sm.getCountBuyers() + "end");
//                time = 0;
//                min++;
//            }
//        } catch (InterruptedException e) {
//            System.out.println("Некорректное завершение ожидания в main!");
//        }
        //Запись товаров из HashMap в файл
        //Input.outputWrite(sm);
    }
}
