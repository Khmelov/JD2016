package by.it.kust.jd02_01;

/**
 * Created by user_2 on 10.06.2016.
 */
public class Runner {
    public static void main(String[] args) {
        int countTotalBuyers = 0;   // общее кол-во покупателей
        for (int i = 0; i<10; i++){   // кол-во потоков
            try {
                Thread.sleep(1000);   // пауза на 1 секунду
            }catch (InterruptedException e){
                e.printStackTrace();
            }
            int countBuyers = Rnd.getTimeOut(0,2);   // кол-во входящих покупателей за 1 раз (0 1 2)
            for (int j = 0; j< countBuyers; j++){
                countTotalBuyers++;
                Buyer buyer = new Buyer(countTotalBuyers);
                Thread thBuyer = new Thread(buyer);
                thBuyer.start();
            }
        }
    }

}
