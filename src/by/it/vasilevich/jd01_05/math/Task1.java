package by.it.vasilevich.jd01_05.math;


import static java.lang.Math.*;

/**
 * Created by user_2 on 08.06.2016.
 */
public class Task1 {
    public static double optionA(double x){
        //набираем выражение отдельными фрагментами
        double a = pow(sin(PI/6-1),2);
        double b = pow(3+pow(x,2),1.0/4);
        double c = pow(log10(pow(x, 3)-1),3);
        double d = asin(x/2)-1.756*pow(10,-2);
        x=(a+b-c)/d;
        return x;
    }

    public static double optionB(double x){
        x=(pow(sin(PI/6-1),2) + pow(3+pow(x,2),1/4) - pow(log10(pow(x, 3)-1),3)) / (asin(x/2)-1.756*pow(10,-2));
        return x;
    }
}
