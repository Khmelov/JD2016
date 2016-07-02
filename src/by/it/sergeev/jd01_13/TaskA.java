package by.it.sergeev.jd01_13;


import java.util.Scanner;

public class TaskA {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        String s;
        double sum=0;
        int i=0;

        while ( !(s = sc.nextLine()).equals ("END")) {
            try {
                i = Integer.valueOf(s);
                System.out.println(i);
                sum += Math.sqrt(i);
                System.out.println(sum);
            } catch (NumberFormatException | ArithmeticException e){
                System.err.println("Ошибка! Введите положительное число!");
            }
        }
        sc.close();
        System.out.println("Результат: " + sum);
    }
}
