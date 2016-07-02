package by.it.novik.jd01_04;

import by.it.novik.jd01_03.InOut;

import java.io.IOException;

/**
 * Created by Kate Novik.
 */
public class Run {

    public static void main(String[] args) throws IOException {
        //System.out.println("Введите количество уравнений СЛАУ");
        //String line1=Input.consoleStringLine();
        //int n=Integer.parseInt(line1);
        //double[] [] arrayM=new double[n] [n];
        //for(int i=0;i<n;i++){
        //System.out.println("Введите "+n+"коэффициентов свободных членов для "+i+1+" уравнения СЛАУ");
        //String line2=Input.consoleStringLine();
        //arrayM[i]= Util.StringLineToIntArray(line2);}


       //Квадратная матрица коэффициентов m СЛАУ
        double[] [] arrayM={
                {2, 5, 4, 1},
                {1, 3, 2, 1},
                {2, 10, 9, 7},
                {3, 8, 9, 2},

        };
        //Вектор правых частей уравнений СЛАУ
        //System.out.println("Введите элементы вектора правых частей СЛАУ через пробел");
        //String line=Input.consoleStringLine();
        //double[] Y= Util.StringLineToIntArray(line);
        double[] Y={20, 11, 40, 37};
        //Создание объекта класса СЛАУ
        SLAU slau=new SLAU(arrayM,Y);

        System.out.println("Квадратная матрица коэффициентов m СЛАУ");
        InOut.printArray2D(arrayM);
        System.out.println("Вектор правых частей уравнений СЛАУ");
        InOut.printArray(Y,"Y",1);
        System.out.println("");
        /**
        * Нахождение корней СЛАУ методом Жордана-Гаусса
        */
        System.out.println("A..Нахождение корней квадратного уравнения методом Жордана-Гаусса");
        double[] X=slau.findRoot(slau.initArrayMY());
        System.out.println("Массив корней квадратного уравнения X[]");
        InOut.printArray(X,"X",1);
        //Проверка корней квадратного уравнения
        if (slau.checkFindRoot()){
            System.out.println("Корни квадратного уравнения найдены верно");}
        else System.out.println("Корни квадратного уравнения найдены не верно");
        System.out.println("");

        /**
         * 2.Нахождение определителя матрицы
         */
        System.out.println("B.Нахождение определителя матрицы");
        System.out.println("Детерминанта матрицы D="+slau.findDeterminant());
        System.out.println("");

        /**
         * 3.Поиск обратной матрицы
         */
        System.out.println("C.Поиск обратной матрицы");
        double[][] inverseMat=slau.inverseMatrix();
        System.out.println("Обратная матрица");
        InOut.printArray2D(inverseMat);
        //Проверка корней квадратного уравнения
        if (slau.checkInverseMatrix(inverseMat)){
            System.out.println("Корни квадратного уравнения найдены верно");}
        else System.out.println("Корни квадратного уравнения найдены не верно");

    }
}
