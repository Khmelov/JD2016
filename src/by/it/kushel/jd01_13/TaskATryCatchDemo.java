package by.it.kushel.jd01_13;


import com.sun.org.apache.xerces.internal.impl.xpath.regex.Match;

import java.util.Scanner;

/**
 * Created by Diomn on 05.06.2016.
 */
public class TaskATryCatchDemo {
    public static void main(String[] args) {
        double number = 0;
        double root=0;
        double sumRoot=0;
        Scanner in = new Scanner(System.in);
        System.out.println("Input number");

       // while (!(input.equalsIgnoreCase("end"))) {
        while (true) {
            String input=in.nextLine();
                try {
                    if(input.equalsIgnoreCase("end")){
                        System.exit(0);
                    }
                    number = Double.parseDouble(input);
                    if(number >=0) {
                        root = Math.sqrt(number);
                        sumRoot = sumRoot + root;
                        System.out.println("Numner= " + number + "; Root= " + Math.rint(100 * root) / 100 + "; Sum of roots=" + Math.rint(100 * sumRoot) / 100);
                    }else System.out.println("Число должно быть больше или равно нулю");
                } catch (NumberFormatException e) {
                    System.out.println("Некорректный ввод");
                }
                catch (ArithmeticException e) {
                    System.out.println("dividing zero");
                }

        }
    }
}