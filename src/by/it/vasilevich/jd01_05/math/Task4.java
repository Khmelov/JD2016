package by.it.vasilevich.jd01_05.math;

import static java.lang.Math.sin;

/**
 * Created by user_2 on 08.06.2016.
 */
public class Task4 {
    public static double prod (){
        double prod = 1;
        for (double a=-5; a<=12; a+=3.75)
            for (int t=1; t<=3; t++){
                double x=sin(a-t);
                prod*=x;
            }
        return prod;
    }
}
