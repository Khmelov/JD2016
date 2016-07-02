package by.it.sergeev.jd02_04;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        String s = Calc.Line();
        List<String> list = Calc.Hex(s);
        if (!list.isEmpty())
            Calc.printHex(list);
        else
            System.out.println("В строке нет шестнадцатеричного числа");
    }
}
