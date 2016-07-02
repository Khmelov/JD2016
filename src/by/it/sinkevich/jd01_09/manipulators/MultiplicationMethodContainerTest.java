package by.it.sinkevich.jd01_09.manipulators;

import by.it.sinkevich.jd01_09.exceptions.MathLabException;
import by.it.sinkevich.jd01_09.variables.MathLabFloat;
import by.it.sinkevich.jd01_09.variables.MathLabMatrix;
import by.it.sinkevich.jd01_09.variables.MathLabVariable;
import by.it.sinkevich.jd01_09.variables.MathLabVector;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Класс, содержит набор тестов, которые проверяют все методы умножения, содержащиеся в классе AdditionMethodContainer
 *
 * @author Sinkevich Denis
 */
public class MultiplicationMethodContainerTest {
    @Test
    public void multiplicationFloatAndFloat() throws Exception {
        MathLabVariable testResult = MultiplicationMethodContainer.multiplication(new MathLabFloat(1.), new MathLabFloat(2.));
        assertEquals(new MathLabFloat(2.), testResult);

        testResult = MultiplicationMethodContainer.multiplication(new MathLabFloat(-1.), new MathLabFloat(-2.));
        assertEquals(new MathLabFloat(2.), testResult);

        testResult = MultiplicationMethodContainer.multiplication(new MathLabFloat(-5.), new MathLabFloat(1000.1));
        assertEquals(new MathLabFloat(-5000.5), testResult);

        testResult = MultiplicationMethodContainer.multiplication(new MathLabFloat(-0.), new MathLabFloat(0.));
        assertEquals(new MathLabFloat(0.), testResult);
    }

    @Test
    public void multiplicationFloatAndVector() throws Exception {
        Double[] vector = {-1.1, 0., 1.1};
        MathLabVariable testResult = MultiplicationMethodContainer.multiplication(new MathLabFloat(3.), new MathLabVector(vector));
        Double[] expectedResult = {-3.3, 0., 3.3};
        assertEquals(new MathLabVector(expectedResult), testResult);

        testResult = MultiplicationMethodContainer.multiplication(new MathLabFloat(-3.), new MathLabVector(vector));
        expectedResult = new Double[]{3.3, 0., -3.3};
        assertEquals(new MathLabVector(expectedResult), testResult);

        testResult = MultiplicationMethodContainer.multiplication(new MathLabFloat(0.), new MathLabVector(vector));
        expectedResult = new Double[]{0., 0., 0.};
        assertEquals(new MathLabVector(expectedResult), testResult);
    }

    @Test
    public void multiplicationFloatAndMatrix() throws Exception {
        Double[][] matrix = {{-1.1, 0., 1.1}, {-2., 2., 100.}};
        MathLabVariable testResult = MultiplicationMethodContainer.multiplication(new MathLabFloat(3.), new MathLabMatrix(matrix));
        Double[][] expectedResult = {{-3.3, 0., 3.3}, {-6., 6., 300.}};
        assertEquals(new MathLabMatrix(expectedResult), testResult);

        testResult = MultiplicationMethodContainer.multiplication(new MathLabFloat(-3.), new MathLabMatrix(matrix));
        expectedResult = new Double[][]{{3.3, 0., 3.3}, {6., -6., -300.}};
        assertEquals(new MathLabMatrix(expectedResult), testResult);

        testResult = MultiplicationMethodContainer.multiplication(new MathLabFloat(-0.), new MathLabMatrix(matrix));
        expectedResult = new Double[][]{{0., 0., 0.}, {0., 0., 0.}};
        assertEquals(new MathLabMatrix(expectedResult), testResult);
    }

    @Test
    public void multiplicationVectorAndFloat() throws Exception {
        Double[] vector = {-1.1, 0., 1.1};
        MathLabVariable testResult = MultiplicationMethodContainer.multiplication(new MathLabVector(vector), new MathLabFloat(3.));
        Double[] expectedResult = {-3.3, -0., 3.3};
        assertEquals(new MathLabVector(expectedResult), testResult);

        testResult = MultiplicationMethodContainer.multiplication(new MathLabVector(vector), new MathLabFloat(-3.));
        expectedResult = new Double[]{3.3, 0., -3.3};
        assertEquals(new MathLabVector(expectedResult), testResult);

        testResult = MultiplicationMethodContainer.multiplication(new MathLabVector(vector), new MathLabFloat(0.));
        expectedResult = new Double[]{0., 0., 0.};
        assertEquals(new MathLabVector(expectedResult), testResult);
    }

    @Test
    public void multiplicationVectorAndVector() throws Exception {
        Double[] vector1 = {-1.1, 0., 1.1};
        Double[] vector2 = {10., -10., 0.};
        MathLabVariable testResult = MultiplicationMethodContainer.multiplication(new MathLabVector(vector1), new MathLabVector(vector2));
        assertEquals(new MathLabFloat(-11.), testResult);

        vector1 = new Double[]{1., 2., 3.};
        vector2 = new Double[]{1., 2., 3.};
        testResult = MultiplicationMethodContainer.multiplication(new MathLabVector(vector1), new MathLabVector(vector2));
        assertEquals(new MathLabFloat(14.), testResult);
    }

    @Test(expected = MathLabException.class)
    public void multiplicationVectorAndVectorException() throws Exception {
        Double[] vector1 = {-1.1, 0.};
        Double[] vector2 = {10., -10., 0.};
        MultiplicationMethodContainer.multiplication(new MathLabVector(vector1), new MathLabVector(vector2));
    }

    @Test(expected = MathLabException.class)
    public void multiplicationVectorAndMatrix() throws Exception {
        Double[] vector = {-1.1, 0., 1.1};
        Double[][] matrix = {{-1.1, 0., 1.1}, {-2., 2., 100.}};
        MultiplicationMethodContainer.multiplication(new MathLabVector(vector), new MathLabMatrix(matrix));
    }

    @Test
    public void multiplicationMatrixAndFloat() throws Exception {
        Double[][] matrix = {{-1.1, 0., 1.1}, {-2., 2., 100.}};
        MathLabVariable testResult = MultiplicationMethodContainer.multiplication(new MathLabMatrix(matrix), new MathLabFloat(2.));
        Double[][] expectedResult = {{-2.2, 0., 2.2}, {-4., 4., 200.}};
        assertEquals(new MathLabMatrix(expectedResult), testResult);

        testResult = MultiplicationMethodContainer.multiplication(new MathLabMatrix(matrix), new MathLabFloat(-2.));
        expectedResult = new Double[][]{{2.2, 0., -2.2}, {4., -4., -200.}};
        assertEquals(new MathLabMatrix(expectedResult), testResult);

        testResult = MultiplicationMethodContainer.multiplication(new MathLabMatrix(matrix), new MathLabFloat(0.));
        expectedResult = new Double[][]{{-0., 0., 0.}, {-0., 0., 0.}};
        assertEquals(new MathLabMatrix(expectedResult), testResult);
    }

    @Test
    public void multiplicationMatrixAndVector() throws Exception {
        Double[][] matrix = new Double[][]{{1., 2., 3.}, {1., 2., 3.}};
        Double[] vector = new Double[]{-1., 0., 2.};
        MathLabVariable testResult = MultiplicationMethodContainer.multiplication(new MathLabMatrix(matrix), new MathLabVector(vector));
        Double[] expectedResult = new Double[]{5., 5.};
        assertEquals(new MathLabVector(expectedResult), testResult);
    }

    @Test(expected = MathLabException.class)
    public void multiplicationMatrixAndVectorException() throws Exception {
        Double[][] matrix = new Double[][]{{1., 2., 3.}, {1., 2., 3.}};
        Double[] vector = new Double[]{-1., 0.};
        MultiplicationMethodContainer.multiplication(new MathLabMatrix(matrix), new MathLabVector(vector));
    }

    @Test
    public void multiplicationMatrixAndMatrix() throws Exception {
        Double[][] matrix1 = new Double[][]{{1., 2., 3.}, {-1., -2., -3.}, {1., 0., -1.}};
        Double[][] matrix2 = new Double[][]{{3., 2., 1.}, {-1., 0., 1.}, {-3., 2., -1.}};
        MathLabVariable testResult = MultiplicationMethodContainer.multiplication(new MathLabMatrix(matrix1), new MathLabMatrix(matrix2));
        Double[][] expectedResult = new Double[][]{{-8., 8., 0.}, {8., -8., 0.}, {6., 0., 2.}};
        assertEquals(new MathLabMatrix(expectedResult), testResult);

        matrix2 = new Double[][]{{3., 2.}, {-1., 0.}, {-3., 2.}};
        testResult = MultiplicationMethodContainer.multiplication(new MathLabMatrix(matrix1), new MathLabMatrix(matrix2));
        expectedResult = new Double[][]{{-8., 8.}, {8., -8.}, {6., 0.}};
        assertEquals(new MathLabMatrix(expectedResult), testResult);
    }

    @Test(expected = MathLabException.class)
    public void multiplicationMatrixAndMatrixException() throws Exception {
        Double[][] matrix1 = new Double[][]{{1., 2.}, {-1., -2.}, {1., 0.}};
        Double[][] matrix2 = new Double[][]{{3., 2., 1.}, {-1., 0., 1.}, {-3., 2., -1.}};
        MultiplicationMethodContainer.multiplication(new MathLabMatrix(matrix1), new MathLabMatrix(matrix2));
    }
}