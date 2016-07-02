package by.it.novik.jd02_03.entities;

import by.it.novik.jd02_03.interfaces.ISupermarket;
import by.it.novik.jd02_03.utils.RandomCounter;

import java.util.*;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by Kate Novik.
 */
public class Supermarket implements ISupermarket {

    //Поле id супермаркета
    public int idSM = 1;
    //Поле товары в магазине
    private HashMap<Good, Integer> allGoods;
    //Поле очередь в магазине
    private final ConcurrentLinkedQueue queueInCashRegister;
    //Поле список кассиров
    private List<Cashier> listCashiers;
    //Поле менеджер
    private Manager manager;
    //Поле выручка магазина
    private AtomicInteger revenueMarket;
    //Поле количество покупателей
    private AtomicInteger countBuyers;
    //Поле количество корзинок
    private AtomicInteger countBaskets;
    public CopyOnWriteArrayList<Cashier> workingCashiers = new CopyOnWriteArrayList<>();
    public CopyOnWriteArrayList<Cashier> waitingCashiers = new CopyOnWriteArrayList<>();

    public Supermarket() {
        this.allGoods = new HashMap<>();
        this.queueInCashRegister = new ConcurrentLinkedQueue();
        this.listCashiers = new ArrayList<>();
        this.manager = new Manager(1,this);
        this.countBuyers = new AtomicInteger(0);
        this.countBaskets = new AtomicInteger(0);
        this.revenueMarket = new AtomicInteger(0);
    }

    public Supermarket(HashMap<Good, Integer> allGoods, Manager manager, int countBaskets) {
        this.allGoods = allGoods;
        this.countBuyers = new AtomicInteger(0);
        this.countBaskets = new AtomicInteger(0);
        this.manager = manager;
        this.queueInCashRegister = new ConcurrentLinkedQueue();
        this.listCashiers = new ArrayList<>();
    }

    public int getRevenueMarket() {
        return revenueMarket.get();
    }

    public void setRevenueMarket(int revenueMarket) {
        this.revenueMarket.set(revenueMarket);
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
        return countBuyers.get();
    }

    public int getCountBaskets() {
        return countBaskets.get();
    }

    public void setCountBaskets(int countBaskets) {
        this.countBaskets.set(countBaskets);
    }

    /**
     * Получение очереди покупателей
     * @return Очередь покупателей
     */
    public ConcurrentLinkedQueue getQueueInCashRegister() {
        return queueInCashRegister;
    }

    /**
     * Добавление покупателя в очередь на кассу
     * @param buyer Объект покупатель типа Buyer
     */
    public void addBuyerInQueueCashRegister(Buyer buyer) {
            queueInCashRegister.add(buyer);
        //Вызываем manager с проверкой на открытие касс
        synchronized (this) {
            manager.openCashier();
        }
    }

    /**
     * Удаление покупателя из очереди при освобождении кассы
     * @return Объект Buyer
     */
    public Buyer removeBuyerFromQueueCashRegister () {
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
            b = (Buyer) queueInCashRegister.poll();
        }
        return b;
    }

    public List<Cashier> getListCashiers() {
        return listCashiers;
    }

    @Override
    public void incrementCountOfBuyers(Buyer buyer) {
        if (buyer != null) {
            countBuyers.incrementAndGet();
        }

    }

    @Override
    public void decrementCountOfBuyers(Buyer buyer) {

        if (buyer != null) {
                countBuyers.decrementAndGet();
        }
       // System.err.println(countBuyers);
        if (countBuyers.get() == 0) {
           this.manager.closeCashiers();
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
        if (countBaskets.get() > 0) {
            countBaskets.decrementAndGet();
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
                countBuyers.incrementAndGet();

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
                countBuyers.incrementAndGet();
            }
        }
    }

}
