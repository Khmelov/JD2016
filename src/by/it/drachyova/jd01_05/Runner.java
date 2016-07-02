package by.it.drachyova.jd01_05;

// 4 вариант
public class Runner {
    public static void main(String[] args) {

        // Задача 1
        System.out.println("Задача 1");
        double a = -3.45;
        double b = 349.1;
        System.out.println("y= "+Task1.method1(a, b));
        System.out.println("y= "+Task1.method2(a, b));
        System.out.println();
        //Задача 2
        System.out.println("Задача 2");
        System.out.println("z= "+Task2.calculate(3.24, 5.8));
        System.out.println();
        // Задача 3
        System.out.println("Задача 3");
        Task3.printTable();
        System.out.println();
        // Задача 4
        System.out.println("Задача 4");
        System.out.print("Произведение равно ");
        System.out.println(Task4.calculate());
        System.out.println();
        // Задача 5
        System.out.println("Задача 5");
        Task5.calculate();
        System.out.println();
        // Задача 6
        System.out.println("Задача 6");
        double[] array1=Task6.getArray();
        Task6.printArray(array1);
        double[] array2=Task6.getLessThenThreeAndOddIndex(array1);
        System.out.println("Массив из элементов, меньших 3, имеющих нечетные индексы ");
        Task6.printArray(array2);
        //Задача 7
        System.out.println("Задача 7");
        double[] arrayM=Task7.getArrayM();
        System.out.println("Массив M, индекс изменяется по строке");
        Task7.printArrayM(arrayM);
        double[] arrayB=Task7.getArrayB(arrayM);
        System.out.println("Массив B  отсортированный по убыванию, индекс изменяется по столбцу");
        Task7.sortArray(arrayB);
        Task7.printArrayB(arrayB);



    }
}
