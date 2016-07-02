package by.it.kushel.jd02_01;

/**
 * Created by Diomn on 12.06.2016.
 */
public class Runner {
    public static void main(String[] args) {
       int countOfBuers=0;
        int numberOfBuyers = (int) (Math.random()*2+1);
        while (countOfBuers<=10) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            for (int i = 0; i <= numberOfBuyers; i++) {
                //Buyer buyer = new Buyer(i);


                countOfBuers= countOfBuers+1;
                if (countOfBuers<=10)
                {
                    Buyer buyer=new Buyer(countOfBuers);
                    buyer.start();
                }

            }
        }
    }
}
