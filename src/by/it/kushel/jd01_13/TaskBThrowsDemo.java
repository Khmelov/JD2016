package by.it.kushel.jd01_13;

/**
 * Created by Diomn on 05.06.2016.
 */
public class TaskBThrowsDemo {
    public static void main(String[] args) {
        try {
            devAndSum(0, 2);
        }catch (Exception e){
            System.out.println("Некорректные данные");
        }
    }
    public static void dev(double a, double b) throws Exception {
        System.out.println("3 start");
        double c=0;
        try{
        c=a/b;
        System.out.println("c="+c);
        }catch (ArithmeticException e){
            System.out.println("деление на ноль");
        }
        System.out.println("3 finish");
    }
    public static void devAndMul (double a, double b) throws Exception {
        System.out.println("2 start");
        double d;
        d=a*b;
        System.out.println("d="+d);
        try {
            dev(d, d - 25);
        }catch (ArithmeticException e){
            System.out.println("деление на ноль");
        }
        System.out.println("2 finish");
    }
    public  static void devAndSum(double a, double b) throws Exception  {
        System.out.println("1 start");
        double k;
            k=a+b/a;
            System.out.println("k="+k);
        try {
            devAndMul(k, 2*k);
            double[] mas = new double[5];
            mas[(int)k]=6;
        }catch (ArithmeticException e){
            System.out.println("деление на ноль");
        }catch (Exception e) {
            throw e;
        }
        System.out.println("1 finish");
    }
}
