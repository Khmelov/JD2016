package by.it.luksha.jd02_04.operations;

import by.it.luksha.jd02_04.vars.Scalar;
import by.it.luksha.jd02_04.vars.Var;
import org.junit.Test;

import static by.it.luksha.jd02_04.operations.Operation.*;
import static org.junit.Assert.assertEquals;

/**
 * Created by MMauz on 19.06.2016.
 */
public class OperationTest {

    @Test
    public void testAdd() throws Exception {
        String res = add(new Scalar(1), new Scalar(2)).toString();
        assertEquals(new Scalar(3).toString(), res);
    }

    @Test
    public void testMult() throws Exception {
        String res = mult(new Scalar(2), new Scalar(2)).toString();
        assertEquals(new Scalar(4).toString(), res);
    }

    @Test
    public void testDiv() throws Exception {
        String res = div(new Scalar(7), new Scalar(3)).toString();
        assertEquals(new Scalar(2.3).toString(), res);
    }

    @Test
    public void testSub() throws Exception {
        String res = sub(new Scalar(7), new Scalar(3)).toString();
        assertEquals(new Scalar(4).toString(), res);
    }
}