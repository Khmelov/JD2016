package by.it.kushel.jd01_08;

import org.junit.Test;
import static org.junit.Assert.*;

public class CalculatorTest1 {

    @Test
    public void testAdd() throws Exception {
        double v1=0.1;
        double v2=0.2;
        double res=v1+v2;
        assertEquals(res,0.3,1e-10);
        //throw new Exception("hgfhgfghf");

    }

    @Test
    public void testSub() throws Exception {

    }

    @Test
    public void testMul() throws Exception {

    }

    @Test
    public void testDev() throws Exception {

    }
}