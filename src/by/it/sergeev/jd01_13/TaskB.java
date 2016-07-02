package by.it.sergeev.jd01_13;

import java.io.IOException;


public class TaskB {
    public static void main (String[] args){
        try
        {
            method1();
        }

        catch (NoSuchFieldException a)
        {
            System.out.println(a);
        }
        catch (IOException v)
        {
            System.out.println(v);
        }
    }

    public static void method1() throws IOException, NoSuchFieldException {
        System.out.println("Начало первого метода");
        method2();
        throw new IOException();

    }

    public static void method2() throws NoSuchFieldException {
        System.out.println("Начало второго метода");
        method3();
        throw new NoSuchFieldException();
    }

    public static void method3() throws ArithmeticException {
        System.out.println("Начало третьего метода");
        try {
            throw new  ArithmeticException();
        } catch (ArithmeticException e) {
            System.out.println("Деление на ноль.");
        }
        System.out.println("Конец третьего метода");
    }
}


