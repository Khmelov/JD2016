package by.it.sinkevich.jd01_09.variables;

import by.it.sinkevich.jd01_09.parser.Patterns;

import java.util.ArrayList;
import java.util.Formatter;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Этот класс описывает переменную Матлаб типа Матрица, представляется в виде списка векторов, разделённых запятой.
 * Соответствует математически матрице. Содержит поле для хранения матрицы, конструкторы,
 * методы для доступа к текущему значению и для перевода из текстового значение и обратно.
 *
 * @author Sinkevich Denis
 */
public class MathLabMatrix extends MathLabVariable {
    /**
     * Поле, в котором хранится текущее значение переменной, матрица представлена двумерным массивом типа {@code Double[][]}
     */
    private Double[][] value;

    /**
     * Конструкторы
     */
    public MathLabMatrix() {
        value = new Double[5][5];
    }

    public MathLabMatrix(int columns, int rows) {
        if (columns > 0 && rows > 0) {
            value = new Double[rows][columns];
        } else {
            System.out.println("Размерность матрицы меньше нуля!");
        }
    }

    public MathLabMatrix(Double[][] matrix) {
        value = new Double[matrix.length][matrix[0].length];
        for (int rows = 0; rows < matrix.length; rows++) {
            System.arraycopy(matrix[rows], 0, value[rows], 0, matrix[rows].length);
        }
    }

    /**
     * Конструктор вызывает метод {@code setValue}, так как перевод строки в матрицу достаточно трудоёмкий
     *
     * @param matrix текстовое представление матрицы
     */
    public MathLabMatrix(String matrix) {
        setValue(matrix);
    }

    public MathLabMatrix(MathLabMatrix matrix) {
        value = new Double[matrix.value.length][matrix.value[0].length];
        for (int i = 0; i < matrix.value.length; i++) {
            System.arraycopy(matrix.value[i], 0, value[i], 0, matrix.value[0].length);
        }
    }

    /**
     * Возвращает количество строк в текущей матрице
     *
     * @return количестов строк типа {@code int}
     */
    public int getRows() {
        return value.length;
    }

    /**
     * Возвращает количество столбцов в текущей матрице
     *
     * @return количество столбцов типа {@code int}
     */
    public int getColumns() {
        return value[0].length;
    }

    /**
     * Возвращает текущее значение матрицы
     *
     * @return значение матрица типа {@code Double[][]}
     */
    @Override
    public Double[][] getValue() {
        return value.clone();
    }

    /**
     * Устанавливает значение матрицы в заданную аргументом влеичину
     *
     * @param value значение типа{@code Object}, которое можно привести к типу {@code Double[][]}
     */
    public void setValue(Object value) {
        if (value instanceof Double[][]) {
            Double[][] temp = (Double[][]) value;
            this.value = new Double[temp.length][temp[0].length];
            for (int rows = 0; rows < temp.length; rows++) {
                System.arraycopy(temp[rows], 0, this.value[rows], 0, temp[rows].length);
            }
        } else {
            System.out.println("Запись значения невозможна!");
        }
    }

    /**
     * Устанавливает новое значение переменной, переводя её из текстового представления
     *
     * @param strFrom Текстовое представление переменной
     */
    @Override
    public void setValue(String strFrom) {
        if (!strFrom.trim().matches(Patterns.regexMatrix)) {
            System.out.println("Запись матрицы невозможна!");
        }
        Pattern pattern = Pattern.compile(Patterns.regexVector);
        Matcher matcher = pattern.matcher(strFrom);
        List<Double[]> vectors = new ArrayList<>();
        while (matcher.find()) {
            String vector = matcher.group();
            String replaced = vector.replaceAll("[\\}\\{,]", " ");
            String[] valuesStr = replaced.trim().split(" +");
            Double[] tempVector = new Double[valuesStr.length];
            for (int i = 0; i < valuesStr.length; i++) {
                tempVector[i] = Double.parseDouble(valuesStr[i]);
            }
            vectors.add(tempVector);
        }
        value = new Double[vectors.size()][vectors.get(0).length];
        for (int i = 0; i < vectors.size(); i++) {
            value[i] = vectors.get(i);
        }
    }

    /**
     * Метод возвращает текстовое представление вектора
     *
     * @return текстовое представление переменной типа {@code String}
     */
    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("{{");
        Formatter formatter = new Formatter(stringBuilder, Locale.US);
        for (int rows = 0; rows < value.length; rows++) {
            for (int cols = 0; cols < value[rows].length; cols++) {
                if (cols != value[rows].length - 1) {
                    formatter.format("% 9.2f,", value[rows][cols]);
                } else {
                    formatter.format("% 9.2f}", value[rows][cols]);
                }
            }
            if (rows != value.length - 1) {
                stringBuilder.append(",\n {");
            } else {
                stringBuilder.append("}");
            }
        }
        return stringBuilder.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MathLabMatrix that = (MathLabMatrix) o;

        if (getRows() != that.getRows() || getColumns() != that.getColumns()) return false;

        boolean isEqual = true;
        Double[][] thatValue = that.getValue();
        for (int i = 0; i < value.length; i++) {
            for (int j = 0; j < value[i].length; j++) {
                isEqual = value[i][j] - thatValue[i][j] < 0.00001;
                if (!isEqual) {
                    break;
                }
            }
        }

        return isEqual;
    }

    @Override
    public int hashCode() {
        return toString().hashCode();
    }
}
