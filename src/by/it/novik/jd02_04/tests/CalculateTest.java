package by.it.novik.jd02_04.tests;

import by.it.novik.jd02_04.matlab.utils.Calculate;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Kate Novik.
 */
public class CalculateTest {
    private static Calculate calculate;
    @BeforeClass
    public static void initCalculate () {
        calculate = new Calculate();
    }

    @Test
    public void calculateExpForAddDouble() throws Exception {
        String expected = "J = 9.3";
        String actual = calculate.calculateExp("J = 5.3 + 4");
        assertEquals ("Addition with Double is wrong!",expected,actual);
    }

    @Test
    public void calculateExpForSubDouble() throws Exception {
        String expected = "W = 6.4";
        String actual = calculate.calculateExp("W = 10.8 - 4.4");
        assertEquals ("Subtraction with Double is wrong!",expected,actual);
    }

    @Test
    public void calculateExpForMulDouble() throws Exception {
        String expected = "C = 27.5";
        String actual = calculate.calculateExp("C = 5 * 5.5");
        assertEquals ("Multiplication with Double is wrong!",expected,actual);
    }

    @Test
    public void calculateExpForDivDouble() throws Exception {
        String expected = "E = 1.25";
        String actual = calculate.calculateExp("E = 5 / 4");
        assertEquals ("Division with Double is wrong!",expected,actual);
    }

    @Test
    public void calculateExpForAddVector() throws Exception {
        String expected = "F = {2.0,4.0,6.0}";
        String actual = calculate.calculateExp("F = {1,2,3} + {1,2,3}");
        assertEquals ("Addition with Vector is wrong!",expected,actual);
    }

    @Test
    public void calculateExpForSubVector() throws Exception {
        String expected = "G = {5.0,5.0,5.0}";
        String actual = calculate.calculateExp("G = {10,10,10} - 5");
        assertEquals ("Subtraction with Vector is wrong!",expected,actual);
    }

    @Test
    public void calculateExpForMulVector() throws Exception {
        String expected = "P = {5.5,11.0,16.5}";
        String actual = calculate.calculateExp("P = {1,2,3} * 5.5");
        assertEquals ("Multiplication with Vector is wrong!",expected,actual);
    }

    @Test
    public void calculateExpForDivVector() throws Exception {
        String expected = "T = {1.0,1.0}";
        String actual = calculate.calculateExp("T = {4.0,4.0} / 4");
        assertEquals ("Division with Vector is wrong!",expected,actual);
    }

    @Test
    public void calculateExpForAddMatrix() throws Exception {
        String expected = "U = {{3.0,4.0},{5.0,6.0}}";
        String actual = calculate.calculateExp("U = {{1,2},{3,4}} + 2");
        assertEquals ("Addition with Matrix is wrong!",expected,actual);
    }

    @Test
    public void calculateExpForSubMatrix() throws Exception {
        String expected = "X = {{1.0,1.0},{2.0,2.0}}";
        String actual = calculate.calculateExp("X = {{2,2},{3,3}} - 1");
        assertEquals ("Subtraction with Matrix is wrong!",expected,actual);
    }

    @Test
    public void calculateExpForMulMatrix() throws Exception {
        String expected = "Y = {{2.0,2.0},{4.0,4.0}}";
        String actual = calculate.calculateExp("Y = {{1.0,1.0},{2.0,2.0}} * 2");
        assertEquals ("Multiplication with Matrix is wrong!",expected,actual);
    }

    @Test
    public void calculateExpForDivMatrix() throws Exception {
        String expected = "Q = {{3.0,3.0},{2.0,2.0}}";
        String actual = calculate.calculateExp("Q = {{9,9},{6,6}} / 3");
        assertEquals ("Division with Matrix is wrong!",expected,actual);
    }

}