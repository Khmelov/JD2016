package by.it.novik.jd02_02.entities;

import by.it.novik.jd02_02.interfaces.ISupermarket;
import by.it.novik.jd02_02.utils.RandomCounter;

import java.util.*;

/**
 * Created by Kate Novik.
 */
public class Supermarket implements ISupermarket {

    //Поле id супермаркета
    public int idSM = 1;
    //Поле товары в магазине
    private HashMap<Good, Integer> allGoods;
    //Поле очередь в магазине
    private LinkedList<Buyer> queueInCashRegister;
    //Поле список кассиров
    private List<Cashier> listCashiers;
    //Поле менеджер
    private Manager manager;
    //Поле выручка магазина
    private volatile int revenueMarket;
    //Поле количество покупателей
    private volatile int countBuyers;
    //Поле количество корзинок
    private int countBaskets;

    public Supermarket() {
        this.allGoods = new HashMap<>();
        this.queueInCashRegister = new LinkedList<>();
        this.listCashiers = new ArrayList<>();
        this.manager = new Manager(1,this);
        this.countBuyers = 0;
        this.countBaskets = 0;
        this.revenueMarket = 0;
    }

    public Supermarket(HashMap<Good, Integer> allGoods, Manager manager, int countBaskets) {
        this.allGoods = allGoods;
        this.countBuyers = 0;
        this.countBaskets = countBaskets;
        this.manager = manager;
        this.queueInCashRegister = new LinkedList<>();
        this.listCashiers = new ArrayList<>();
    }

    public int getRevenueMarket() {
        return revenueMarket;
    }

    public synchronized void setRevenueMarket(int revenueMarket) {
        this.revenueMarket = revenueMarket;
    }

    public Manager getManager() {
        return manager;
    }

    @Override
    public HashMap<Good, Integer> getAllGoods() {
        return this.allGoods;
    }

    @Override
    public int getCountBuyers() {
        return this.countBuyers;
    }

    public int getCountBaskets() {
        return this.countBaskets;
    }

    public void setCountBaskets(int countBaskets) {
        this.countBaskets = countBaskets;
    }

    public synchronized LinkedList<Buyer> getQueueInCashRegister() {
        return queueInCashRegister;
    }

    /**
     * Добавление покупателя в очередь на кассу
     * @param buyer Объект покупатель типа Buyer
     */
    public void addBuyerInQueueCashRegister(Buyer buyer) {
        synchronized (this) {
            queueInCashRegister.add(buyer);
        }
        //Вызываем manager с проверкой на открытие касс
        manager.openCashier();
    }

    /**
     * Удаление покупателя из очереди при освобождении кассы
     * @return Объект Buyer
     */
    public synchronized Buyer removeBuyerFromQueueCashRegister () {
        Buyer b = null;

            Iterator<Buyer> it = queueInCashRegister.iterator();
            while (it.hasNext()) {
                Buyer buyerP = it.next();
                if (buyerP.isPensioner()) {
                    it.remove();
                    return buyerP;
                }
            }
        if (!queueInCashRegister.isEmpty()) {
            b = queueInCashRegister.removeFirst();
        }
        return b;
    }

    public List<Cashier> getListCashiers() {
        return listCashiers;
    }

    public void setListCashiers(List<Cashier> listCashiers) {
        this.listCashiers = listCashiers;
    }

    @Override
    public synchronized void incrementCountOfBuyers(Buyer buyer) {
        if (buyer != null) {
            this.countBuyers++;
        }

    }

    @Override
    public synchronized void decrementCountOfBuyers(Buyer buyer) {

        if (buyer != null) {
                this.countBuyers--;
        }
        System.err.println(countBuyers);
        if (this.countBuyers == 0) {
            boolean b = this.manager.closeCashiers();
            System.err.println(b);
        }


    }

    @Override
    public Good createGood(int idGood, String nameGood, String producer, int cost) {
        if (idGood != 0 && nameGood != null && producer != null && cost != 0) {
            Good good = new Good(idGood, nameGood, producer);
            if (!allGoods.containsKey(good)) {
                allGoods.put(good,cost);
            }
            else {
                Iterator<Map.Entry<Good,Integer>> it = allGoods.entrySet().iterator();
                while (it.hasNext()) {
                    Map.Entry<Good,Integer> set = it.next();
                    if (set.getKey().equals(good)) {
                        set.setValue(cost);
                    }
                }
            }
            return good;
        }
        return null;
    }

    @Override
    public Basket decrementBaskets() {
        if (countBaskets > 0) {
            countBaskets--;
            return new Basket();
        }
        return null;
    }

    @Override
    public void addBuyersForSec (int time) {
        if (time <= 30) {
            int count = RandomCounter.countRandom(1, 5);
            while ((getCountBuyers() + count) <= time + 10) {
                count++;
            }
            for (int i = 0; i < count; i++) {
                if ((getCountBuyers() + 1) % 4 != 0) { //Проверка на не каждый четвертый - обычный покупатель
                   new Buyer(getCountBuyers() + 1, this, false);//Создаем покупателя
                } else { //В случае, если каждый четвертый, то пенсионер - флаг true
                    new Buyer(getCountBuyers() + 1, this, true);//Создаем покупателя
                }
                countBuyers++;

            }
        } else if (time > 30 && time <= 60) {
            int count = RandomCounter.countRandom(1, 3);
            while ((getCountBuyers() + count) > (40 + (30 - time))) {
                count--;
            }
            while ((getCountBuyers() + count) < (40 + (30 - time))) {
                count++;
            }
            for (int i = 0; i < count; i++) {
                if ((getCountBuyers() + 1) % 4 != 0) { //Проверка на не каждый четвертый - обычный покупатель
                    new Buyer(getCountBuyers() + 1, this, false);//Создаем покупателя
                } else { //В случае, если каждый четвертый, то пенсионер - флаг true
                    new Buyer(getCountBuyers() + 1, this, true);//Создаем покупателя
                }
                countBuyers++;
            }
        }
    }

}
