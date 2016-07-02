package by.it.sinkevich.jd01_09.manipulators;

import by.it.sinkevich.jd01_09.exceptions.MathLabException;
import by.it.sinkevich.jd01_09.variables.MathLabFloat;
import by.it.sinkevich.jd01_09.variables.MathLabMatrix;
import by.it.sinkevich.jd01_09.variables.MathLabVariable;
import by.it.sinkevich.jd01_09.variables.MathLabVector;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Класс, содержит набор тестов, которые проверяют все методы деления, содержащиеся в классе AdditionMethodContainer
 *
 * @author Sinkevich Denis
 */
public class DivisionMethodContainerTest {
    @Test
    public void divisionFloatAndFloat() throws Exception {
        MathLabVariable testResult = DivisionMethodContainer.division(new MathLabFloat(1.), new MathLabFloat(2.));
        assertEquals(new MathLabFloat(0.5), testResult);

        testResult = DivisionMethodContainer.division(new MathLabFloat(-1.), new MathLabFloat(-2.));
        assertEquals(new MathLabFloat(0.5), testResult);
    }

    @Test(expected = MathLabException.class)
    public void divisionFloatAndVector() throws Exception {
        Double[] vector = {-1.1, 0., 1.1};
        DivisionMethodContainer.division(new MathLabFloat(3.), new MathLabVector(vector));
    }

    @Test(expected = MathLabException.class)
    public void divisionFloatAndMatrix() throws Exception {
        Double[][] matrix = {{-1.1, 0., 1.1}, {-2., 2., 100.}};
        DivisionMethodContainer.division(new MathLabFloat(3.), new MathLabMatrix(matrix));
    }

    @Test
    public void divisionVectorAndFloat() throws Exception {
        Double[] vector = {-1.1, 0., 1.1};
        MathLabVariable testResult = DivisionMethodContainer.division(new MathLabVector(vector), new MathLabFloat(1.));
        Double[] expectedResult = {-1.1, 0., 1.1};
        assertEquals(new MathLabVector(expectedResult), testResult);

        testResult = DivisionMethodContainer.division(new MathLabVector(vector), new MathLabFloat(-0.5));
        expectedResult = new Double[]{2.2, 0., -2.2};
        assertEquals(new MathLabVector(expectedResult), testResult);
    }

    @Test(expected = MathLabException.class)
    public void divisionVectorAndVector() throws Exception {
        Double[] vector1 = {-1.1, 0., 1.1};
        Double[] vector2 = {10., -10., 0.};
        DivisionMethodContainer.division(new MathLabVector(vector1), new MathLabVector(vector2));
    }

    @Test(expected = MathLabException.class)
    public void divisionVectorAndMatrix() throws Exception {
        Double[] vector = {-1.1, 0., 1.1};
        Double[][] matrix = {{-1.1, 0., 1.1}, {-2., 2., 100.}};
        DivisionMethodContainer.division(new MathLabVector(vector), new MathLabMatrix(matrix));
    }

    @Test
    public void divisionMatrixAndFloat() throws Exception {
        Double[][] matrix = {{-1.1, 0., 1.1}, {-2., 2., 100.}};
        MathLabVariable testResult = DivisionMethodContainer.division(new MathLabMatrix(matrix), new MathLabFloat(0.5));
        Double[][] expectedResult = {{-2.2, 0., 2.2}, {-4., 4., 200.}};
        assertEquals(new MathLabMatrix(expectedResult), testResult);

        testResult = DivisionMethodContainer.division(new MathLabMatrix(matrix), new MathLabFloat(-0.5));
        expectedResult = new Double[][]{{2.2, 0., -2.2}, {4., -4., -200.}};
        assertEquals(new MathLabMatrix(expectedResult), testResult);
    }

    @Test(expected = MathLabException.class)
    public void divisionMatrixAndVector() throws Exception {
        Double[] vector = {-1.1, 0., 1.1};
        Double[][] matrix = {{-1.1, 0., 1.1}, {-2., 2., 100.}};
        DivisionMethodContainer.division(new MathLabMatrix(matrix), new MathLabVector(vector));
    }

    @Test(expected = MathLabException.class)
    public void divisionMatrixAndMatrix() throws Exception {
        Double[][] matrix1 = {{-1.1, 0., 1.1}, {-2., 2., 100.}};
        Double[][] matrix2 = {{-1.1, 0., 1.1}, {-2., 2., 100.}};
        DivisionMethodContainer.division(new MathLabMatrix(matrix1), new MathLabMatrix(matrix2));
    }

}