package by.it.luksha.jd01_09mathlab.operations;

import by.it.luksha.jd01_09mathlab.vars.Scalar;
import by.it.luksha.jd01_09mathlab.vars.Var;
import org.junit.Test;

import static by.it.luksha.jd01_09mathlab.operations.Operation.*;
import static org.junit.Assert.*;

/**
 * Created by MMauz on 19.06.2016.
 */
public class OperationTest {

    @Test
    public void testAdd() throws Exception {
        Var res = add(new Scalar(1), new Scalar(2));
        assertEquals(new Scalar(3), res);
    }

    @Test
    public void testMult() throws Exception {
        Var res = mult(new Scalar(7), new Scalar(3));
        assertEquals(new Scalar(21), res);
    }

    @Test
    public void testDiv() throws Exception {
        String res = div(new Scalar(7), new Scalar(3)).toString();
        assertEquals(new Scalar(2.3).toString(), res);
    }

    @Test
    public void testSub() throws Exception {
        Var res = sub(new Scalar(7), new Scalar(3));
        assertEquals(new Scalar(4), res);
    }
}