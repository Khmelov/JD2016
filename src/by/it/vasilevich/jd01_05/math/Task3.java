package by.it.vasilevich.jd01_05.math;

import static java.lang.Math.pow;
import static java.lang.Math.E;


/**
 * Created by user_2 on 08.06.2016.
 */
public class Task3 {
    public static void printTable(double x){
        for (double a=0; a<=2; a+=0.2){
            double f = pow(E,a*x)-3.45*a;
            System.out.printf("%10.2f %30.2f\n",a,f);

        }
    }
}
