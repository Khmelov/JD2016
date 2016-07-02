package by.it.drachyova.jd01_13;

import java.util.Random;


/**
 Разработать консольное приложение, в котором поместить 3 void  процедуры, вложенные друг в друга.
 Каждую процедуру сопроводить двумя сообщениями: в начале и в конце тела процедуры.
 Код процедуры – произвольный, но с возможным делением на ноль.
 Проследить обработку исключений, обязательно защитить вызов каждой процедуры во внешнем вызывающем блоке.
 Один тип ошибки – деление на ноль обрабатывать в процедуре, остальные ошибки пробрасывать и обрабатывать в main.
 */
public class TaskB {
    public static void main(String[] args) throws Exception {
        Random random=new Random();
        Integer[] array=new Integer[10];
        for (int i = 0; i <array.length ; i++) {
           array [i]= random.nextInt(2);
        }
        try{
            firstProcedure(array);
        }
         catch (Exception e){
             System.out.println("Обработка " +e.getMessage()+" в методе main");
         }

    }

    private static void firstProcedure(Integer[] array) throws Exception {
        System.out.println("Начало процедуры 1");
        System.out.println("Вывод массива:");
        for (int element:array) {
            System.out.print(element+" ");
        }
        System.out.println();
        try {
            secondProcedure(array);
        }
        catch (Exception e){
            System.out.println("В процедуру 1 было проброшено "+e.getMessage());
            throw new Exception("Исключение из первой процедуры");
        }

        System.out.println("Конец процедуры 1");
    }
    private static void secondProcedure(Integer[] array) throws Exception {
        System.out.println("Начало процедуры 2");
        thirdProcedure(array);
        for (int i = 0; i < array.length; i++) {
            array[i]+=3;
            if(array[i]==3){
                System.out.println("Генерируем собственное исключение и пробрасываем его");
                throw new Exception("Исключение из второй процедуры");
            }
        }
        System.out.println("Конец процедуры 2");
    }
    private static void thirdProcedure(Integer[] array){
        System.out.println("Начало процедуры 3");
        try {
            System.out.println("Попробуем выполнить деление на 0");
            for (int i = 0; i < array.length; i++) {
                array[i] = i / array[i];
            }
        }
        catch (ArithmeticException e){
            System.out.println("Исключение из третьей процедуры обработано");
        }
        System.out.println("Конец процедуры 3");
    }
}
