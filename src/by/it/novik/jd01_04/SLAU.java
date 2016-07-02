package by.it.novik.jd01_04;

import by.it.novik.jd01_03.InOut;
import by.it.novik.jd01_03.Util;

/**
 * Created by Kate Novik.
 */
public class SLAU {
    private double determinant; //Определитель матрицы
    private double[][] arrayM; //Квадратная матрица коэффициентов m СЛАУ
    private double[] Y; //Вектор правых частей уравнений СЛАУ
    private double[] X; //Вектор корней уравнений СЛАУ
    private double[][] arrayMY; //Матрица коэффициентов и правых частей уравнений СЛАУ
    private double[][] array;//Матрица преобразований

    public SLAU (double[][] arrayM, double[] Y){
        this.arrayM=arrayM;
        this.Y=Y;
    }

    public SLAU (double[][] arrayM){
        this.arrayM=arrayM;
        this.Y=new double [arrayM.length];
    }

    /**
     * Создание и инициализация массива из коэффициентов свободных членов и правых частей СЛАУ
     * @return Массив СЛАУ
     */
    public double[][] initArrayMY() {
        int n=arrayM.length; // Длина массива
        arrayMY= new double[n][arrayM[0].length+1];
        for (int i=0;i<n;i++){
            for(int j=0;j<n+1;j++){
                if(j!=n){
                    arrayMY[i][j]=arrayM[i][j];}
                else arrayMY[i][j]=Y[i];
            }
        }
        return arrayMY;
    }

    /**
     * Нахождение корней СЛАУ методом Жордана-Гаусса
     * @param arr Массив СЛАУ
     * @return Вектор корней СЛАУ
     */
    public double[] findRoot (double[][] arr){
        determinant=1; //Начальное значение определителя матрицы
        int n=arr.length; // Количество строк в переданном массиве
        int m=arr[0].length; // Количество столбцов в переданном массиве
        array=arr;
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
        for (int i=0;i<n;i++) {
            double k=1/array[i][i];
            determinant*=array[i][i];
            for (int j=0;j<m;j++){
                array[i][j]=array[i][j]*k;

            }

        }
        //System.out.println("Единичная матрица слева, " + "d="+determinant);
        //Input.printArray2D(array);
        X=new double[n];
        for (int i=0;i<n;i++) {
            X[i]=array[i][n];
        }
        return X;
    }

    /**
     * Проверка найденных корней СЛАУ
     * @return true - корни СЛАУ найдены правильно, false-не правильно
     */
    public boolean checkFindRoot (){
        //Умножаем матрицу коэффициентов на вектор корней квадратного уравнения
        double[] checkY = Util.arrayMulVector(arrayM, X);
        System.out.println("Матрица коэффициентов, умноженная на вектор корней квадратного уравнения");
        InOut.printArray(checkY,"checkY",1);
        //Проверяем результат перемножения на равенство вектору правых частей СЛАУ
        for (int i=0; i<X.length;i++){
            if (checkY[i]!= Y[i]) {
                return false;
            }
        }
        return true;
    }

    /**
     * Нахождение определителя матрицы СЛАУ
     * @return Определитель матрицы
     */
    public double findDeterminant (){
        findRoot(initArrayMY());
        return determinant;
    }

    /**
     * Вычисление обратной матрицы
     * @return обратная матрица
     */
    public double[][] inverseMatrix () {
        int n = arrayM.length;
        arrayMY=initArrayMY();
        double[][] arrayMYI = new double[n][2 * arrayM[0].length + 1];
        int m = n + 1;
        //Добавление к матрице свободных членов и правых частей единичной матрицы
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 2 * n + 1; j++) {
                if (j <= n) {
                    arrayMYI[i][j] = arrayMY[i][j];
                }  else if (j == m) {
                    arrayMYI[i][m] = 1;

                } else arrayMYI[i][j] = 0;
            }
            m++;
        }
        System.out.println("Матрица свободных членов и правых частей c единичной матрицей");
        InOut.printArray2D(arrayMYI);
        //Преобразование Гаусса для матрицы свободных членов и правых частей c единичной матрицей
        findRoot(arrayMYI);
        System.out.println("Матрица c единичной матрицей слева");
        InOut.printArray2D(array);
        //Создание массива для хранения обратной матрицы и его заполнение
        double[][] inverseMat = new double[arrayM.length][arrayM[0].length];
        int s = 0;
        for (int i = 0; i < n; i++) {
            for (int j = arrayM[0].length + 1; j < 2 * arrayM[0].length + 1; j++) {
                inverseMat[i][s] = array[i][j];
                s++;
            }
            s = 0;
        }
        return inverseMat;
    }

    /**
     * Проверка корней СЛАУ с помощью обратной матрицы
     * @param inverseMat Обратная матрица
     * @return true - корни СЛАУ найдены правильно, false-не правильно
     */
    public boolean checkInverseMatrix (double [][] inverseMat){
    double[][] checkInverseMat=Util.arrayMulArray(arrayM,inverseMat);
        System.out.println("Результат перемножения матрицы свободных членов на обратную матрицу");
        InOut.printArray2D(checkInverseMat);
        boolean b=false;
        for (int i=0; i<arrayM.length;i++){
            for (int j=0;j<arrayM[0].length;j++){
                if ((j==i && checkInverseMat[i][j]==1) || (j!=i && checkInverseMat[i][j]==0))
                    b=true;
            }
        }
        return b;
    }
}
