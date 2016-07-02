package by.it.novik.jd02_02.entities;

import by.it.novik.jd02_02.interfaces.IManager;

import java.util.List;


/**
 * Created by Kate Novik.
 */
public class Manager implements IManager {
    //Поле id мэнеджера
    private int idMan;
    //Поле объекта супермаркет
    private Supermarket sm;


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
        for (int i=1; i<=count; i++) {
            sm.getListCashiers().add(new Cashier(i,sm));
        }
    }

    /**
     * Открытие кассы в магазине при появлении покупателей
     */
    @Override
    public void openCashier() {
        //При появлении одного покупателя открываем кассу или через каждые 5 появившихся покупателей в очереди открываем новую кассу
        if(sm.getQueueInCashRegister().size() == 1 || sm.getQueueInCashRegister().size() % 5 == 0) {
            for (Cashier cashier : sm.getListCashiers()) {
                if (cashier.getThCash().getState() == Thread.State.WAITING) {
                    synchronized (cashier) {
                        cashier.cashWait = false;
                        cashier.notify();
                    }
                    break;
                }
            }
        }
    }

    /**
     * Закрытие касс в конце дня
     */
    public boolean closeCashiers() {
        if (sm.getCountBuyers() == 0) {
            for (Cashier cashier : sm.getListCashiers()) {

                synchronized (cashier) {
                    cashier.cashWait = false;
                    cashier.notify();
                }
            }
            return true;
        }
return false;
    }


}
