package by.it.novik.jd01_02.Tasks;

import by.it.novik.jd01_02.Utils.Util;
import java.io.IOException;
import java.util.*;

/**
 * Created by Kate Novik.
 */
public class TaskC {

    private int[][] array; //Массив
    private int sizeMas; //Размер массива

    public TaskC() {
        System.out.println("Введите n-размерность матрицы a [n][n]");
        String line5 = null;
        try {
            line5 = Util.getOneLine();
        } catch (IOException e) {
            System.out.println("Ошибка");
        }
        sizeMas = Integer.parseInt(line5);
        //Создаем пустой массив размером sizeMas
        array = new int[sizeMas][sizeMas];
        initArray();
        System.out.println("Выводим текущую матрицу");
        printArray(array);
    }

    public TaskC(int[][] array, int sizeMas) {
        this.array = array;
        this.sizeMas = sizeMas;
        System.out.println("Выводим текущую матрицу");
        printArray(array);
    }

    /**
     * 1.
     * Вывод суммы элементов матрицы, расположенных между первым и
     * вторым положительными элементами каждой строки.
     */
    public void task1() {
        System.out.println("\nЗадача 1:");
        System.out.println("Суммы элементов матрицы между 1-м и 2-м положительными элементами строки:");
        for (int[] line : array) {
            System.out.format("%4d", sumElements(line));
        }
        System.out.println("");
    }

    /**
     * 2.
     * Транспонировать матрицу
     */
    public void task2() {
        System.out.println("\nЗадача 2:");
        System.out.println("Выводим транспонированную матрицу");
        for (int[] x : trMatrix()) {
            for (int y : x) {
                System.out.format("%4d", y);
            }
            System.out.println("");
        }
    }

    /**
     * 3.Поворнуть матрицу на 90 градусов против часовой стрелки
     */
    public void task3() {
        System.out.println("\nЗадача 3:");
        System.out.println("Выводим матрицу, повернутую на 90 градусов против часовой стрелки");
        for (int[] x : turnMatrix()) {
            for (int y : x) {
                System.out.format("%4d", y);
            }
            System.out.println("");
        }
    }

    /**
     * 4.Построить матрицу, вычитая из элементов каждой строки матрицы ее среднее арифметическое.
     */
    public void task4() {
        double mean = meanMatrix();
        System.out.println("\nЗадача 4:");
        System.out.println("Выводим матрицу с вычтенным ср. арифм. mean= " + mean + " из её элементов");
        for (int[] x : array) {
            for (int y : x) {
                System.out.format("%7.1f", y - mean);
            }
            System.out.println("");
        }
    }

    /**
     * 5.Удалить из матрицы все строки и столбцы, содержащие максимальный элемент матрицы
     */
    public void task5() {

        System.out.println("\nЗадача 5:");
        List<int[]> max_ij = getMaxElementsCoords();
        Map<String, List> linesWithMax = getLineWithMax(max_ij);
        int[][] newArray = deleteLinesWithMax(linesWithMax);
        printArray(newArray);

    }


    /**
     *6.Найти в матрице минимальный элемент и переместить его на место [1,1] путем перестановки строк и столбцов
     */
    public void task6() {
        System.out.println("\nЗадача 6:");
        System.out.println("Матрица с минимальным элементом, перемещенным на место [1,1] путем перестановки строк и столбцов");
        int[] min_ij = getMinElementsCoords();
        int[][] newArray = transpositionLinesWithMin(min_ij);
        printArray(newArray);
    }

    /**
     *7.Преобразовать строки матрицы, чтобы элементы, равные 0, располагались в конце
     */
    public void task7() {
        System.out.println("\nЗадача 7:");
        System.out.println("Матрица, у которой элементы, равные 0, расположены в конце строки");
        for (int[] x : invZero()) {
            for (int y : x) {
                System.out.format("%4d", y);
            }
            System.out.println("");
        }
    }

    /**
     * Инициализация массива случайными числами в диапазоне от -sizeMas до sizeMas
     */
    private void initArray() {
        for (int i = 0; i < sizeMas; i++) {
            for (int j = 0; j < sizeMas; j++) {   //Инициализация массива случайными числами в диапазоне от -sizeMas до sizeMas
                array[i][j] = (int) (Math.round(Math.random() * 2 * sizeMas) - sizeMas);
            }
        }
    }

    /**
     * Печать массива
     * @param array Массив
     */
    private void printArray(int[][]array) {
        for (int[] i : array) {
            for (int j : i) {
                System.out.format("%4d", j);
            }
            System.out.println("");
        }
    }

    /**
     * Нахождение суммы элементов матрицы, расположенных между первым и
     * вторым положительными элементами каждой строки.
     * @param arr Строка матрицы в виде одномерного массива
     * @return Сумма элементов матрицы
     */
    private int sumElements(int[] arr) {
        int firstElem = 0;
        int fPos = 0; //Позиция первого положительного элемента в строке
        int secondElem = 0;
        int sPos = 0;//Позиция второго положительного элемента в строке
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > 0) {
                if (firstElem == 0) {
                    fPos = i;
                    firstElem = arr[i];
                } else if (secondElem == 0) {
                    sPos = i;
                    secondElem = arr[i];
                } else break; // выход с цикла при не равных нулю firstPos и secondPos
            }
        }
        if (firstElem != 0 && secondElem != 0) {
            for (int j = fPos + 1; j < sPos; j++) {
                sum += arr[j];
            }
        }
        return sum;
    }

    /**
     * Транспонирование матрицы
     * @return Транспонированная матрица
     */
    private int[][] trMatrix() {
        int[][] tMatrix = new int[sizeMas][sizeMas];//создаем пустую матрицу для транспонирования
        for (int i = 0; i < sizeMas; i++) {
            //записываем строки текущей матрицы в столбцы матрицы tMatrix
            for (int j = 0; j < sizeMas; j++) {
                tMatrix[j][i] = array[i][j];
            }
        }
        return tMatrix;
    }

    /**
     * Поворот матрицы на 90 градусов против часовой стрелки
     * @return Массив
     */
    private int[][] turnMatrix() {
        int[][] turnMat = new int[sizeMas][sizeMas];//создаем пустую матрицу для поворота
        for (int i = 0; i < sizeMas; i++) {
            //Берем элементы строки i текущей матрицы  с конца и записываем в столбец матрицы turnMat
            for (int j = sizeMas - 1; j >= 0; j--) {
                turnMat[sizeMas - 1 - j][i] = array[i][j];
            }
        }
        return turnMat;
    }

    /**
     * Метод вычисления среднего арифметического матрицы
     * @return Значение среднего арифметического матрицы
     */
    private double meanMatrix() {
        double res = 0;
        //Цикл вычисления суммы чисел
        for (int[] i : array) {
            for (int j : i) {
                res += j;
            }
        }
        res /= sizeMas;
        return res;
    }

    /**
     * Поиск координат максимального элемента матрицы
     * @return Список List координат максимального значения матрицы
     */
    private List<int[]> getMaxElementsCoords() {
        //Определяем начальное минимальное число
        int max = Integer.MIN_VALUE;

        List<int[]> maxElemCoords = new ArrayList<int[]>();

        //поиск максимального значения в переданной матрице
        for (int i = 0; i < sizeMas; i++) {
            for (int j = 0; j < sizeMas; j++) {
                if (max < array[i][j]) {
                    max = array[i][j];
                    maxElemCoords.clear();
                    maxElemCoords.add(new int[]{i, j});
                } else if (max == array[i][j]) {
                    maxElemCoords.add(new int[]{i, j});
                }
            }
        }
        System.out.println("Максимальное значение в матрице: " + max);
        System.out.println("Количество максимальных элементов: " + maxElemCoords.size());
        return maxElemCoords;
    }

    /**
     * Формирование неповторяющихся значений строк и столбцов максимальных элементов массива
     * @param maxElemCoords Список координат максимальных элементов
     * @return MapValues неповторяющихся значений строк и столбцов максимальных элементов
     */
    private Map<String, List> getLineWithMax(List<int[]> maxElemCoords) {
        List rows = new ArrayList(); //Создаем список неповторяющихся строк максимальных элементов
        List columns = new ArrayList();//Создаем список неповторяющихся столбцов максимальных элементов
        for (int[] coord : maxElemCoords) {
            int column = coord[1];
            int row = coord[0];
            if (!columns.contains(column)) { //Если список не содержит такого элемента, то добавляем его в список
                columns.add(column);
            }
            if (!rows.contains(row)) {
                rows.add(row);
            }
        }
        Map<String, List> lineForDelete = new HashMap<String, List>();// Создаем MapValues
        lineForDelete.put("rows", rows);
        lineForDelete.put("columns", columns);
        return lineForDelete;
    }

    /**
     * Удаление строк и столбцов матрицы, содержащих максимальный элемент
     * @param linesWithMax MapValues неповторяющихся значений строк и столбцов максимальных элементов
     * @return Массив
     */
    private int[][] deleteLinesWithMax(Map<String, List> linesWithMax){
        List rows = linesWithMax.get("rows");
        List columns = linesWithMax.get("columns");
        int[][] arrWithoutMax = new int[sizeMas - rows.size()][sizeMas - columns.size()];
        int rowIndex = 0;
        for(int row = 0; row < array.length; row++) {
            if(!rows.contains(row)) {
                int columnIndex = 0;
                for(int column = 0; column < array.length; column++) {
                    if(!columns.contains(column)) {
                        arrWithoutMax[rowIndex][columnIndex++] = array[row][column];
                    }
                }
                rowIndex++;
            }
        }
        return arrWithoutMax;
    }

     /**
     * Поиск координат минимального элемента матрицы
     * @return Координаты минимального элемента матрицы
     */
    private int[] getMinElementsCoords() {
        //Определяем начальное максимальное число
        int min = Integer.MAX_VALUE;
        int[] min_ij = new int[2];//массив возврата значений i и j минимального элемента
        //поиск минимального значения в переданной матрице
        for (int i = 0; i < sizeMas; i++) {
            for (int j = 0; j < sizeMas; j++) {
                if (min > array[i][j]) {
                    min = array[i][j];
                    min_ij[0]=i;
                    min_ij[1]=j;
                }
            }
        }

        return min_ij;
    }

    /**
     * Метод перестановки минимального элемента на место [1,1] путем перестановки строк и столбцов
     * @param min_ij Координаты минимального элемента
     * @return Массив с переставленными строками и столбцами
     */

    private int[][] transpositionLinesWithMin(int[] min_ij) {
        List<Integer> rowMin = new ArrayList<Integer>(); //Список для хранения строки, содержащей минимальный элемент
        List<Integer> collMin = new ArrayList<Integer>();//Список для хранения столбца, содержащего минимальный элемент
        int min_i=min_ij[0];
        int min_j= min_ij[1];
        for (int j=0;j<array[0].length;j++){
            rowMin.add(array[min_i][j]);
            array[min_i][j]=array[1][j];
            array[1][j]=rowMin.get(j);
        }
        for (int i=0;i<array.length;i++){
            collMin.add(array[i][min_j]);
            array[i][min_j]=array[i][1];
            array[i][1]=collMin.get(i);
        }
     return array;
    }

    /**
     * Метод расстановки элементов равных 0 в конец строк матрицы
     * @return Массив
     */
    private int[][] invZero() {
        for (int i = 0; i < sizeMas; i++) {
            for (int j = 0; j < sizeMas; j++) {
                if (array[i][j] == 0) {
                    for (int x = sizeMas - 1; x > j; x--) {
                        if (array[i][x] != 0) {
                            array[i][j] = array[i][x];
                            array[i][x] = 0;
                            break;
                        }
                    }
                }
            }

        }
        return array;
    }
}
