
package by.it.belsky.jd01_05;

import static java.lang.Math.*;
import static java.lang.StrictMath.atan;

/**
 * Created by misha on 12.05.2016.
 */
public class Task1 {
    public static double variantA(double z) {
        //выражение по частям
        double x = 3.24;
        double a = 5.8;
        double m = atan(pow(x, 2));
        double n = sqrt(x + pow(1.43, 3));
        double p = pow(cos(PI / (2 * a)), 3) / abs(x - pow(a, 0.2));
        z = m - n + p;

        return z;

    }

    //Выражение целиком
    public static double variantB(double z) {
        double x = 3.24;
        double a = 5.8;
       z = atan(pow(x, 2)) - sqrt(x + pow(1.43, 3)) + pow(cos(PI / (2 * a)), 3) / abs(x - pow(a, 0.2));
        return z;
    }

}

