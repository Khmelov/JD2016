package by.it.novik.jd02_03.utils;

import by.it.novik.jd02_03.entities.Supermarket;
import by.it.novik.jd02_03.entities.Buyer;
import by.it.novik.jd02_03.entities.Cashier;
import java.util.List;


/**
 * Created by Kate Novik.
 */
public class PrintCheck {

public static StringBuilder check = new StringBuilder();

    /**
     * Печать сводной таблицы работы всех касс
     */
    public static void printCheckForBuyer () {
        synchronized (System.out){
            //System.out.flush();
            System.out.print(check);
            System.out.flush();

        }
    }

    /**
     * Получение сводной таблицы для всех касс
     * @param cashier Кассир
     * @param sm Супермаркет
     */
    public static void getCheck (Cashier cashier, Supermarket sm, int sum) {
        List<Cashier> listCashiers = sm.getListCashiers();
        int sizeHeader = 88;
        //Если первая касса печатает, то создаем строку с заголовками столбцов
        if (check.length() == 0) {
        for (int i=0;i<listCashiers.size();i++){
            check.append(" | ").append(listCashiers.get(i).getThCash().getName());
        }
        check.append(" | Очередь   | Выручка     \n");
            for (int i = sizeHeader + 1; i < sizeHeader * 2 + 1; i++) {
                check.append(" ");
            }
        }
        //Начальная позиция для вставки суммы чека по кассе
        int firstPlaceSum = sizeHeader + 6 + (cashier.getIdCashier()-1)*12;
        String sSum = ((Integer)sum).toString();
        //Начальная позиция для вставки размера очереди
        int firstPlaceQueue = sizeHeader+ 7 + listCashiers.size()*12;
        String sQueue = ((Integer)sm.getQueueInCashRegister().size()).toString();
        //Начальная позиция для вставки выручки по магазину
        int firstPlaceRevenue = sizeHeader+ 7 + listCashiers.size()*12 + 12;
        String sRevenue = ((Integer)sm.getRevenueMarket()).toString();
        //Заменяем в строке таблицы необходимые позиции для вставки
        check.replace(firstPlaceSum,firstPlaceSum + sSum.length(), sSum);
        check.replace(firstPlaceQueue,firstPlaceQueue + sQueue.length(), sQueue);
        check.replace(firstPlaceRevenue,firstPlaceRevenue + sRevenue.length() ,sRevenue);
        //Вызываем метод для печати таблицы
        printCheckForBuyer();
    }
}
