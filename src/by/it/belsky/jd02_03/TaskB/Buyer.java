package by.it.belsky.jd02_03.TaskB;

import static by.it.novik.jd01_12.Utils.printMap;

/**
 * Created by misha on 21.06.2016.
 */
class Buyer extends Thread implements IBuyer, IUseBasket {

    int num;                    //номер покупателя
    public boolean iWait=false; //флаг того, что покупатель в ожидании

    //конструктор покупателя с его номером
    public Buyer() {
        num=++Dispetcher.countBuyers;
        this.setName("Покупатель № "+ num +" ");
        start();
    }

    @Override //покупатель приходит в зал и выбирает товары.
    public void run() {
        enterToMarket(); // зашел (из задачи уровень А)
        takeBasket(); // берет корзину (уровень Б)
        chooseGoods(); // выбирает (из задачи уровень А)
        putGoodsToBasket(); // ложит товар в корзину от одного до 4х видов (уровень Б)
        goToQueue(); // становится в очерель (из задачи уровень А)
        goToOut(); // выходит (из задачи уровень А)
    }

    //при получение строкового значения для экземпляра покупателя
    @Override
    public String toString() {
        return this.getName();
    }

    //реализация интерфейсов
    @Override
    public void enterToMarket() {
        System.out.println(this + "вошел в магазин");
    }

    @Override
    public void chooseGoods() {
        //вызываем свой генератор случайных чисел
        int pause = Help.fromTo(500, 2000);
        Help.sleep(pause);
        //ожидание окончено
        System.out.println(this + "выбрал товар");
    }

    @Override
    public  void goToQueue() {
        synchronized (this) { //ВНИМАТЕЛЬНО! Специально явно сделана блокировка по покупателю
            //если бы synchronized был указан в методе, то он работает именно так
            //при "отпускании" этого потока
            //кассир - отправитель команды для продолжения этого потока
            //должен будет тоже заблокировать этого же покупателя
            //и оправить ему notify.
            System.out.println(this + "встал в очередь на кассу");
            Queue.add(this);
            //в этой точке поток должен остановиться, поэтому
            //подготовим публичное поле iWait для определения, можно ли идти дальше
            iWait=true;
            while (iWait) try { //ожидаем notify и iWait==false от кассира.
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //ожидание окончено, тут прилетел notify от кассира
            System.out.println(this + "закончил оплату товаров в кассе");
        }
    }
    @Override
    public void goToOut() {
        System.out.println(this + "вышел из магазина");
    }

    @Override
    public void takeBasket() {
        System.out.println(this + "Берет корзину");
    }

    @Override
    public void putGoodsToBasket() {
     int count = Help.numberOfGoods(1, 5); {
      for (int i=0; i<count; i++) {
          Help x = new Help();
        // x.goods().get((int)(Math.random()*9));
          Object[] keys=x.goods().keySet().toArray();
          String good=(String)keys[(int)(Math.random()*keys.length)];
          System.out.println(this+ "ложит в корзину "+  good+" цена "+x.goods().get(good));
        // printMap(x.goods());
      }

        }
    } // ложит товары в корзину
}

