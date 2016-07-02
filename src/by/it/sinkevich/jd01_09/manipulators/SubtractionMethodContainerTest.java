package by.it.sinkevich.jd01_09.manipulators;

import by.it.sinkevich.jd01_09.exceptions.MathLabException;
import by.it.sinkevich.jd01_09.variables.MathLabFloat;
import by.it.sinkevich.jd01_09.variables.MathLabMatrix;
import by.it.sinkevich.jd01_09.variables.MathLabVariable;
import by.it.sinkevich.jd01_09.variables.MathLabVector;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Класс, содержит набор тестов, которые проверяют все методы вычитания, содержащиеся в классе SubtractionMethodContainer
 *
 * @author Sinkevich Denis
 */
public class SubtractionMethodContainerTest {
    @Test
    public void subtractionFloatAndFloat() throws Exception {
        MathLabVariable testResult = SubtractionMethodContainer.subtraction(new MathLabFloat(1.1), new MathLabFloat(2.2));
        assertEquals(new MathLabFloat(-1.1), testResult);

        testResult = SubtractionMethodContainer.subtraction(new MathLabFloat(-1.1), new MathLabFloat(-2.2));
        assertEquals(new MathLabFloat(1.1), testResult);

        testResult = SubtractionMethodContainer.subtraction(new MathLabFloat(0.), new MathLabFloat(1000.));
        assertEquals(new MathLabFloat(-1000.), testResult);

        testResult = SubtractionMethodContainer.subtraction(new MathLabFloat(-0.), new MathLabFloat(0.));
        assertEquals(new MathLabFloat(0.), testResult);
    }

    @Test
    public void subtractionFloatAndVector() throws Exception {
        Double[] vector = {-1.1, 0., 1.1};
        MathLabVariable testResult = SubtractionMethodContainer.subtraction(new MathLabFloat(3.3), new MathLabVector(vector));
        Double[] expectedResult = {4.4, 3.3, 2.2};
        assertEquals(new MathLabVector(expectedResult), testResult);

        testResult = SubtractionMethodContainer.subtraction(new MathLabFloat(-3.3), new MathLabVector(vector));
        expectedResult = new Double[]{-2.2, -3.3, -4.4};
        assertEquals(new MathLabVector(expectedResult), testResult);

        testResult = SubtractionMethodContainer.subtraction(new MathLabFloat(0.), new MathLabVector(vector));
        expectedResult = new Double[]{1.1, 0., -1.1};
        assertEquals(new MathLabVector(expectedResult), testResult);
    }

    @Test
    public void subtractionFloatAndMatrix() throws Exception {
        Double[][] matrix = {{-1.1, 0., 1.1}, {-2., 2., 100.}};
        MathLabVariable testResult = SubtractionMethodContainer.subtraction(new MathLabFloat(3.3), new MathLabMatrix(matrix));
        Double[][] expectedResult = {{4.4, 3.3, 2.2}, {5.3, 1.3, -96.7}};
        assertEquals(new MathLabMatrix(expectedResult), testResult);

        testResult = SubtractionMethodContainer.subtraction(new MathLabFloat(-3.3), new MathLabMatrix(matrix));
        expectedResult = new Double[][]{{-2.2, -3.3, -4.4}, {-1.3, -5.3, -103.3}};
        assertEquals(new MathLabMatrix(expectedResult), testResult);

        testResult = SubtractionMethodContainer.subtraction(new MathLabFloat(0.), new MathLabMatrix(matrix));
        expectedResult = new Double[][]{{1.1, 0., -1.1}, {2., -2., -100.}};
        assertEquals(new MathLabMatrix(expectedResult), testResult);
    }

    @Test
    public void subtractionVectorAndFloat() throws Exception {
        Double[] vector = {-1.1, 0., 1.1};
        MathLabVariable testResult = SubtractionMethodContainer.subtraction(new MathLabVector(vector), new MathLabFloat(3.3));
        Double[] expectedResult = {-4.4, -3.3, -2.2};
        assertEquals(new MathLabVector(expectedResult), testResult);

        testResult = SubtractionMethodContainer.subtraction(new MathLabVector(vector), new MathLabFloat(-3.3));
        expectedResult = new Double[]{2.2, -3.3, 4.4};
        assertEquals(new MathLabVector(expectedResult), testResult);

        testResult = SubtractionMethodContainer.subtraction(new MathLabVector(vector), new MathLabFloat(0.));
        expectedResult = new Double[]{-1.1, 0., 1.1};
        assertEquals(new MathLabVector(expectedResult), testResult);
    }

    @Test
    public void subtractionVectorAndVector() throws Exception {
        Double[] vector1 = {-1.1, 0., 1.1};
        Double[] vector2 = {10., -10., 0.};
        MathLabVariable testResult = SubtractionMethodContainer.subtraction(new MathLabVector(vector1), new MathLabVector(vector2));
        Double[] expectedResult = {-11.1, 10., 1.1};
        assertEquals(new MathLabVector(expectedResult), testResult);
    }

    @Test(expected = MathLabException.class)
    public void subtractionVectorAndVectorException() throws Exception {
        Double[] vector1 = {-1.1, 0.};
        Double[] vector2 = {10., -10., 0.};
        SubtractionMethodContainer.subtraction(new MathLabVector(vector1), new MathLabVector(vector2));
    }

    @Test(expected = MathLabException.class)
    public void subtractionVectorAndMatrix() throws Exception {
        Double[] vector = {-1.1, 0., 1.1};
        Double[][] matrix = {{-1.1, 0., 1.1}, {-2., 2., 100.}};
        SubtractionMethodContainer.subtraction(new MathLabVector(vector), new MathLabMatrix(matrix));
    }

    @Test
    public void subtractionMatrixAndFloat() throws Exception {
        Double[][] matrix = {{-1.1, 0., 1.1}, {-2., 2., 100.}};
        MathLabVariable testResult = SubtractionMethodContainer.subtraction(new MathLabMatrix(matrix), new MathLabFloat(1.1));
        Double[][] expectedResult = {{-2.2, -1.1, 0.}, {-3.1, 0.9, 98.9}};
        assertEquals(new MathLabMatrix(expectedResult), testResult);

        testResult = SubtractionMethodContainer.subtraction(new MathLabMatrix(matrix), new MathLabFloat(-1.1));
        expectedResult = new Double[][]{{0., 1.1, 2.2}, {-0.9, 3.1, 101.1}};
        assertEquals(new MathLabMatrix(expectedResult), testResult);

        testResult = SubtractionMethodContainer.subtraction(new MathLabMatrix(matrix), new MathLabFloat(0.));
        expectedResult = new Double[][]{{-1.1, 0., 1.1}, {-2., 2., 100.}};
        assertEquals(new MathLabMatrix(expectedResult), testResult);
    }

    @Test(expected = MathLabException.class)
    public void subtractionMatrixAndVector() throws Exception {
        Double[][] matrix = {{-1.1, 0., 1.1}, {-2., 2., 100.}};
        Double[] vector = {-1.1, 0., 1.1};
        SubtractionMethodContainer.subtraction(new MathLabMatrix(matrix), new MathLabVector(vector));
    }

    @Test
    public void subtractionMatrixAndMatrix() throws Exception {
        Double[][] matrix1 = {{-1.1, 0., 1.1}, {-2., 2., 100.}};
        Double[][] matrix2 = {{-2., 2., 100.}, {-1.1, 0., 1.1}};
        MathLabVariable testResult = SubtractionMethodContainer.subtraction(new MathLabMatrix(matrix1), new MathLabMatrix(matrix2));
        Double[][] expectedResult = new Double[][]{{0.9, -2., -98.9}, {-0.9, 2., 98.9}};
        assertEquals(new MathLabMatrix(expectedResult), testResult);
    }

    @Test(expected = MathLabException.class)
    public void subtractionMatrixAndMatrixException() throws Exception {
        Double[][] matrix1 = {{-1.1, 0.}, {-2., 2.}};
        Double[][] matrix2 = {{-1.1, 0., 1.1}, {-2., 2., 100.}};
        SubtractionMethodContainer.subtraction(new MathLabMatrix(matrix1), new MathLabMatrix(matrix2));
    }
}