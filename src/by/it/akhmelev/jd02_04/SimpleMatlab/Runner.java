package by.it.akhmelev.jd02_04.SimpleMatlab;

public class Runner {
    //это основной класс учебного проекта, поэтому нужно добавить
    public static void main(String[ ] args) {
        Parser.process("X=3+3.2");
    //проверяем сложение
        Variable one=new Variable("2.2");
        Variable two=new Variable("3.3");
    //создадим результат сложения
        Variable res=one.add(two);
    //проверим, работает ли проектик
        System.out.print(one+"+"+two+"="+res);
    }

}
