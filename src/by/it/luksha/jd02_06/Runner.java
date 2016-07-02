package by.it.luksha.jd02_06;

import java.io.IOException;


public class Runner {
    public static  void main(String[] args) throws IOException {
        System.out.println("Калькулятор v0.2a");
        System.out.println("Проходят выражения вида: 2.0 * 3.0 - для скаляров\n" +
                "{1.0,2.0,3.0} + {1.0,2.0,3.0} {1.0,2.0,3.0} * 5.2 - для векторов\n" +
                "{{1.0,2.0,3.0},{1.0,2.0,3.0}} * {{1.0,2.0},{1.0,2.0},{1.0,2.0}} - для матриц\n" +
                "Для окончания ввода введите пустую строку.\n" +
                "2 * (50 - ((3 + 5) * (2 - 3))) / 8 - для тестов");
        /**
         * Test: без ввода
         */
        Test.run();

        /**
         * Test: ввод через консоль
         */
        //TestConsole.run();
    }
}
