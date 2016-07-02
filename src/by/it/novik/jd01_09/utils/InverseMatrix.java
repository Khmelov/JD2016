package by.it.novik.jd01_09.utils;

import by.it.novik.jd01_03.InOut;

/**
 * Created by Kate Novik.
 */
public class InverseMatrix {
    public static double[][] inverseMatrix (double[][] matrix) {
        int n = matrix.length;
        double[][] array = new double[n][2 * matrix[0].length];
        int m = n;
        //Добавление к матрице свободных членов и правых частей единичной матрицы
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 2 * n; j++) {
                if (j < n) {
                    array[i][j] = matrix[i][j];
                }  else if (j == m) {
                    array[i][m] = 1;

                } else array[i][j] = 0;
            }
            m++;
        }

        //System.out.println("Матрица свободных членов и правых частей c единичной матрицей");
        //Input.printArray2D(array);

        array = transformationMatrixOfGauss(array);

        //System.out.println("Матрица c единичной матрицей слева");
        //Input.printArray2D(array);

        //Создание массива для хранения обратной матрицы и его заполнение
        double[][] inverseMat = new double[matrix.length][matrix[0].length];
        int s = 0;
        for (int i = 0; i < n; i++) {
            for (int j = matrix[0].length; j < 2 * matrix[0].length; j++) {
                inverseMat[i][s] = array[i][j];
                System.out.print(inverseMat[i][s]);
                s++;
            }
            s = 0;
        }
        return inverseMat;
    }

    public static double[][] transformationMatrixOfGauss (double[][] array){
        int n=array.length; // Количество строк в переданном массиве
        int m=array[0].length; // Количество столбцов в переданном массиве
        //Прямой ход метода Гаусса с обнулением элементов под главной диагональю
        for (int diag=0;diag<n-1;diag++){
            for(int row=diag+1;row<n;row++){
                double k=array[row][diag]/array[diag][diag];
                for (int col=0;col<m;col++){
                    array[row][col]=array[row][col]-array[diag][col]*k;
                }
            }
        }
        //System.out.println("прямой ход");
        //Input.printArray2D(array);

        //Обратный ход метода Гаусса с обнулением элементов над главной диагональю
        for (int diag=n-1;diag>0;diag--){
            for(int row=0;row<diag;row++){
                double k=array[row][diag]/array[diag][diag];
                for (int col=0;col<m;col++){
                    array[row][col]=array[row][col]-array[diag][col]*k;
                }
            }
        }
        //System.out.println("обратный ход");
        //Input.printArray2D(array);
        return array;
    }
}
