package by.it.drachyova.jd02_03;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

//Напишите программу, моделирующую кассы (класс Cashier) в магазине.
// Существует 5 экземпляров Cashier, работающих одновременно, которые запускаются как пул потоков.
// Общее количество покупателей (коллекция buyers) составляет от 5 до 40, они стоят в общей для всех очереди.
// Одновременно не может обрабатываться больше покупателей, чем имеется рабочих касс.
// Время обслуживания покупателя от 2 до 5 секунд. ВСЕГО обслуживается 100 покупателей.

// Доработайте программу так, чтобы:
// У каждого покупателя был набор из 1..4 товаров из фиксированного списка с ценой (рекомендуется hashmap,
// где товар – key, цена – value).
// Товары с ценой были выведены на консоль в процессе обслуживания.
// Выведена общая сумма чека.

// Доработайте программу так, чтобы
// вывод данных по кассам, проводился таблично, в пять столбцов. В шестом столбце – текущий размер очереди.
// В седьмом – общая выручка магазина.
// коллекция покупателей базировалась на классе Buyer
// пенсионеры (поле boolean pensioner) обслуживались вне очереди.
// число покупателей изменялось - менее 10 в начале каждой минуты и до 40 на 30 секунде каждой минуты.
// Кассы без покупателей закрывались и открывались по одной на каждые 5 лишних покупателей в очереди.

public class Runner {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(5);
        executor.execute(new Cashier());
        executor.execute(new Cashier());
        executor.execute(new Cashier());
        executor.execute(new Cashier());
        executor.execute(new Cashier());
        while (!(Manager.countBuyers.intValue() == 100)) {
            Utils.sleep(1000);
            int count = Utils.getMyRandom(0, 2);
            for (int i = 0; i <= count; i++) {

                new Buyer();
                if (Manager.countBuyers.intValue() == 100)
                    break;
            }
        }
        executor.shutdown();

    }
}

