package by.it.kushel.jd02_04;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Diomn on 20.06.2016.
 */
public class VariableTest {

    @Test

    public void testAdd (){
        Variable var1 = new Variable(2.0);
        Variable var2 = new Variable(3.0);
        Variable res= var1.add(var2);
        Variable var3 = new Variable(5.0);
        assertEquals(var3, res);
    }
    @Test
    public void testSub (){
        Variable var1 = new Variable(5.0);
        Variable var2 = new Variable(3.0);
        Variable res= var1.sub(var2);
        Variable var3 = new Variable(2.0);
        assertEquals(var3, res);
    }
    @Test
    public void testMul (){
        Variable var1 = new Variable(5.0);
        Variable var2 = new Variable(3.0);
        Variable res= var1.mul(var2);
        Variable var3 = new Variable(15.0);
        assertEquals(var3, res);
    }
    @Test
    public void testDiv (){
        Variable var1 = new Variable(15.0);
        Variable var2 = new Variable(3.0);
        Variable res= var1.div(var2);
        Variable var3 = new Variable(5.0);
        assertEquals(var3, res);
    }
}