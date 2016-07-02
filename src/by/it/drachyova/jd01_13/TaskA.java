package by.it.drachyova.jd01_13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 Создать программу с использованием двух типов обработки исключений, которая:
    открывает консоль;
    считывает данные из консоли построчно;
    переводит каждую строку в число и выводит в консоль данное число и сумму корней всех ранее введенных чисел,
    включая введенное;
    если перевести ввод в число невозможно или невозможно извлечь корень, то
    программа обрабатывает ошибку и показывает на русском языке соответствующее сообщение в консоли;
    закрывается при вводе в консоль слова END.
 */
public class TaskA {
    public static void main(String[] args) throws IOException {
        try {
            TaskA.getLinesToNumbers();
        }
        catch (NumberFormatException e){ //обрабатываем ошибку типа NumberFormatException
            System.out.println("Ошибка ввода " + e.getMessage()); //показываем сообщение об ошибке в консоли
        }
        catch (ArithmeticException e){   //обрабатываем ошибку типа ArithmeticException
            System.out.println("Арифметическая ошибка "+e.getMessage()); //показываем сообщение об ошибке в консоли
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
    private static void getLinesToNumbers() throws NumberFormatException, ArithmeticException, IOException {
        String line;
        Double number;
        Double sum=0.0;
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));//открываем консоль
        do{
            line=bufferedReader.readLine();         //считываем строку
            if (line.equals("end"))                 //если введено слово "end"
                break;                              //выходим из цикла
            number = Double.parseDouble(line);      //преобразуем строку в число
            if (number.isNaN())                     //если преобразовать в число невозможно
                throw new NumberFormatException();  //отдаем управление в main
            sum += Math.sqrt(number);               //считаем сумму корней всех введенных чисел
            if (sum.isNaN())                        //если невозможно извлечь корень и посчитать сумму
                throw new ArithmeticException();    //отдаем управление в main
            System.out.println(number +" "+sum);    //выводим в консоль данное число и сумму корней всех ранее
                                                    // введенных чисел, включая введенное;
        }
        while (true);
        bufferedReader.close();
    }
}
