package by.it.kust.jd01_13.TaskB;

/**
 * Created by Tanya Kust.
 */
public class Methods {
    private int a, b, c;
    private double rez;
    private int[] mas = {1,2};

    void firstMethod() throws ArrayIndexOutOfBoundsException{
        System.out.println(" Первый метод. Начало.");
        try {
            secondMethod();
            a = (int)(Math.random()*10);
            rez = 1/a;

        }catch (ArithmeticException e){
            System.out.println("  Первый метод. Ошибка: деление на ноль");
        }catch (ArrayIndexOutOfBoundsException e){
            System.out.println("  Первый метод: перехваченное исключение из второго методе - пробрасываем выше");
            throw e;
        }
        System.out.println(" Первый метод. Конец.");
    }

    void secondMethod() throws ArrayIndexOutOfBoundsException{
        System.out.println("  Второй метод. Начало.");
        try {
            thirdMethod();
            b = (int)(Math.random()*5);
            rez = 1/b;
            mas[10] = 100;
        }catch (ArithmeticException e){
            System.out.println("   Второй метод. Исключение: деление на ноль");
        }catch (ArrayIndexOutOfBoundsException e){
            System.out.println("   Второй метод исключение перехватываем и пробрасываем выше: "+e);
            throw new ArrayIndexOutOfBoundsException("--<проброшенное исключение второго метода>--");
        }
        System.out.println("  Второй метод. Конец.");
    }

    void thirdMethod(){
        System.out.println("   Третий метод. Начало.");
        try {
            c = (int)(Math.random()*1);
            rez = 1/c;
        }catch (ArithmeticException e){
            System.out.println("    Третий метод. Исключение обработано в третьем методе: деление на ноль: " + e);
        }
        System.out.println("   Третий метод. Конец.");
    }
}
