package by.it.vasilevich.jd01_09.SimpleProject;

import org.junit.Assert;
import org.junit.Test;

public class VariableTest {

    @Test
    public void testAdd() throws Exception {
        Variable one = new Variable(1.1);
        Variable two = new Variable(2.2);
        Variable result = one.add(two);
        Assert.assertEquals(new Variable(3.3).getValue(), result.getValue(),0.01);
    }

    @Test
    public void testSub() throws Exception {
        Variable one = new Variable(2.);
        Variable two = new Variable(3.);
        Variable result = one.sub(two);
        Assert.assertEquals(new Variable(-1.).getValue(), result.getValue(),0.01);
    }

    @Test
    public void testMul() throws Exception {
        Variable one = new Variable(2.);
        Variable two = new Variable(3.);
        Variable result = one.mul(two);
        Assert.assertEquals(new Variable(6.).getValue(), result.getValue(),0.01);
    }

    @Test
    public void testDiv() throws Exception {
        Variable one = new Variable(6.);
        Variable two = new Variable(3.);
        Variable result = one.div(two);
        Assert.assertEquals(new Variable(2.).getValue(), result.getValue(),0.01);
    }
}