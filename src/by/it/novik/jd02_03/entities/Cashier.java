package by.it.novik.jd02_03.entities;

import by.it.novik.jd02_03.interfaces.ICashier;
import by.it.novik.jd02_03.utils.PrintCheck;
import by.it.novik.jd02_03.utils.RandomCounter;

import java.util.Map;


/**
 * Created by Kate Novik.
 */
public class Cashier implements ICashier, Runnable {
    //Поле id кассы
    private int idCashier;
    //Поле объекта супермаркет
    private Supermarket sm;
    //Поле потока кассиров
    private Thread thCash;
    //Поле для синхронизации кассиров
    public boolean cashWait = false;


    public Cashier(int idCashier, Supermarket sm) {
        this.idCashier = idCashier;
        this.sm = sm;
        thCash = new Thread(this);
        thCash.setName("Касса № " + idCashier);
    }

    public int getIdCashier() {
        return idCashier;
    }

    public void setIdCashier(int idCashier) {
        this.idCashier = idCashier;
    }

    public Thread getThCash() {
        return thCash;
    }

    @Override
    public String toString() {
        return this.thCash.getName();
    }

    /**
     * Обслуживание покупателя
     */
    @Override
    public void serveBuyers() {
        do {
            try {
                while (sm.getQueueInCashRegister().size() != 0) {
                    //Вызываем метод с генератором случайных чисел для генерации числа в промежутке от 200 до 500 мс
                    int pause = RandomCounter.countRandom(200, 500);
                    final Buyer buyer = sm.removeBuyerFromQueueCashRegister();
                    if (buyer != null) {
                        //Выводим покупателя с ожидания
                        synchronized (buyer) {
                            buyer.iWait = false;
                            buyer.notify();
                        }
                        System.out.println(this + " обслуживает покупателя - " + buyer);
                        Thread.sleep(pause);


                        int sum = 0;
                        //System.out.println(buyer.getBasket().getGoodsInBasket().size());
                        while (buyer.getBasket().getGoodsInBasket().size() != 0) {
                            Map.Entry<Good, Integer> set = buyer.getBasket().takeGoodFromBasket();
                            sum += set.getValue();
                            System.out.println(set.getKey() + " = " + set.getValue());
                        }
                        System.out.println("Общая сумма чека " + sum);
                        sm.setRevenueMarket(sm.getRevenueMarket() + sum); //Добавим сумму в выручку магазина
                        synchronized (PrintCheck.class) {
                            PrintCheck.getCheck(this,sm,sum);
                        }
                        System.out.println("");
                        System.out.println(this + " обслужила покупателя - "+ buyer);
                        //Выводим покупателя с ожидания
                        synchronized (buyer) {
                            buyer.iWait = false;
                            buyer.notify();
                        }
                    }
                }
            } catch (InterruptedException e) {
                System.out.println(this + " : некорректное завершение ожидания!");
            }
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //Проверка на закрытие касс
            if (sm.getCountBuyers() == 0) {
                if (sm.getManager().closeCashiers) {
                    break;
                }
            }
            //Ожидания команды открытия кассы от менеджера в случае появления покупателя в очереди
            // или в случае подготовки к закрытию всех касс и завершению потоков
//            synchronized (this) {
//                cashWait = true;
//                sm.waitingCashiers.add(this);
//                sm.workingCashiers.remove(this);
//                while (cashWait) {
//                    try { //ожидаем notify и iWait==false от менеджера.
//                        this.wait();
//                    } catch (InterruptedException e) {
//                        System.out.println(this + " : некорректное завершение ожидания открытия кассы!");
//                    }
//                }
//            }
            //Проверка на закрытие касс
            if (sm.getManager().closeCashiers) {
                break;
            }

        }
        while (true);
        System.out.println(this + " закрылась");
        }


    @Override
    public void run() {
        serveBuyers();
    }
}
