package by.it.novik.jd02_03.entities;

import by.it.novik.jd02_03.interfaces.IManager;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


/**
 * Created by Kate Novik.
 */
public class Manager implements IManager {
    //Поле id мэнеджера
    private int idMan;
    //Поле Executor для запуска касс
    private ExecutorService executor;
    //Поле объекта супермаркет
    private Supermarket sm;
    public boolean closeCashiers = false;


    public Manager(int idMan, Supermarket sm) {
        this.idMan = idMan;
        this.sm = sm;

    }

    /**
     * Создание касс
     * @param count Количество касс
     */
    @Override
    public void createCashiers(int count) {
        //Запускаем пул потоков касс
        executor = Executors.newFixedThreadPool(count);
        for (int i=1; i<=count; i++) {
            Cashier cashier = new Cashier(i,sm);
            //Запускаем поток кассира
            executor.execute(cashier);
            //cashier.getThCash().start();
            sm.getListCashiers().add(cashier);
            sm.workingCashiers.add(cashier);
        }
    }

    /**
     * Открытие кассы в магазине при появлении покупателей
     */
    @Override
    public void openCashier() {
        if ((sm.getQueueInCashRegister().size() >= 1 && sm.getQueueInCashRegister().size() < 5 && sm.workingCashiers.size() == 0) ||
                (sm.getQueueInCashRegister().size() % 5 == 0 && sm.workingCashiers.size() < sm.getQueueInCashRegister().size() / 5 ))
        {
            for (Cashier cashier : sm.waitingCashiers) {
                    synchronized (cashier) {
                        cashier.cashWait = false;
                        cashier.notify();
                    }
                sm.workingCashiers.add(cashier);
                sm.waitingCashiers.remove(cashier);
                    break;

            }
        }
    }

    /**
     * Закрытие касс в конце дня
     */
    @Override
    public void closeCashiers() {
        if (sm.getCountBuyers() == 0) {
            for (Cashier cashier : sm.getListCashiers()) {

                synchronized (cashier) {
                    cashier.cashWait = false; //Переводим флаг ожидания кассира в false и выводим всех с ожидания
                    cashier.notifyAll();
                }
            }
            closeCashiers = true;

           executor.shutdown(); //Остановка потоков после завершения работы касс
        }
    }




}
