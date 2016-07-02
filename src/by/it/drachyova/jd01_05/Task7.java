package by.it.drachyova.jd01_05;

import static java.lang.Math.*;

public class Task7 {
    //формируем массив из 25 элементов, элементы округляем до тысячных
    public static double[] getArrayM(){
        int arrLength = 25;
        double[] arrayM = new double[arrLength];
        for (int i=0;i<arrayM.length;i++){
            arrayM[i] = 2*sin(PI*i/12);
               }
        return arrayM;
    }
    //форматный вывод массива M с заголовком и индексами (количество столбцов не более 3, индекс изменяется по строке)
    public static void printArrayM (double[] array){

        for (int i=0,columns=1;i<array.length;i++,columns++){
            System.out.format("  M(%-2d)=%-6.3f",i,array[i]);
            if(columns%3==0) {
                System.out.println();
            }
        }
        System.out.println("");
    }
    //формируем массив В из массива М
    public static double[] getArrayB(double[] array){
        int countSize=0;
        for (int i=0;i<array.length;i++){
            if((abs(array[i]))<sqrt(i)){//если модуль значения меньше квадратного корня из индекса
                    countSize++;//вычисляем размер для массива В
            }
        }
        double[] arrayB=new double[countSize];//создаем массив В
        for(int i=0, j=0;i<arrayB.length;i++){
            if((abs(array[i]))<sqrt(i)){
                arrayB[j]=array[i];
                j++;
            }
        }
        return arrayB;
    }
    public static void sortArray (double[] array) {
        for(int i=0;i<array.length-1;i++){
            for (int j=i+1;j<array.length;j++){
                if(array[i]<array[j]){
                    double temp=array[i];
                    array[i]=array[j];
                    array[j]=temp;
                }
            }
        }
    }
    //форматный вывод массива B с заголовком и индексами (количество столбцов не более 3, индекс изменяется по столбцу)
    public static void printArrayB (double[] array){

        for (int i=0; i < array.length;i++) {
            System.out.format("  В(%-2d)=%-6.3f", i, array[i]);
            System.out.format("  В(%-2d)=%-6.3f", i+array.length/3, array[i+array.length/3]);
            if(i+2*array.length/3>=array.length) break;//если доходим до границы массива прерываем вывод
            System.out.format("  В(%-2d)=%-6.3f", i+2*array.length/3, array[i+2*array.length/3]);
                    System.out.println();
        }

    }
}
