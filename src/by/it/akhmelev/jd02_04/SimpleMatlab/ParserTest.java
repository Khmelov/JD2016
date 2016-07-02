package by.it.akhmelev.jd02_04.SimpleMatlab;

import org.junit.Assert;
import org.junit.Test;

public class ParserTest {

    @Test
    public void testProcess() throws Exception {
        char[] xok="6.3".toCharArray();
        char[] x=Parser.process("x=3.1+3.2").toCharArray();
        System.out.print(x);
        //если в вашем варианте Matlab уже реализована обработка выражений (парсинг строки)
        //вида x=3+3.2, то можно собрать тест например так
        //Assert.assertArrayEquals(x, xok);
        //здесь отключено, т.к. в SimpleMatlab "боевого" парсера сейчас нет.
    }
}