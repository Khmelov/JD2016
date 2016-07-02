package by.it.kust.jd01_13.TaskB;

/**
 * Разработать консольное приложение, в котором поместить 3 void
 процедуры, вложенные друг в друга.
 § Каждую процедуру сопроводить двумя сообщениями: в начале и в конце тела
 процедуры. Код процедуры – произвольный, но с возможным делением на ноль.
 § Проследить обработку исключений, обязательно защитить вызов каждой процедуры во
 внешнем вызывающем блоке.
 § Один тип ошибки – деление на ноль обрабатывать в процедуре, остальные ошибки
 пробрасывать и обрабатывать в main.
 */
public class ExceptionsRun {
    public static void main(String[] args) {
        System.out.println("Начало VariantB1.");
        Methods run = new Methods();
        try {
            run.firstMethod();
        } catch (ArrayIndexOutOfBoundsException e){
            System.out.println("Исключение метода main перехватило проброшенное " +
                    "исключение второго метода с сообщением " + e);
        } finally {
            System.out.println("Блок finally в main.");
        }
        System.out.println("Конец VariantB1.");
    }
}
