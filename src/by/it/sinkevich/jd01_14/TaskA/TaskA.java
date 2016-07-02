package by.it.sinkevich.jd01_14.TaskA;


import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Class for jd01_15 TaskA
 *
 * @author Sinkevich Denis
 */
class TaskA {

    public static void main(String[] args) {
        List<Double> numbers = getRandomNumbers(20);
        String src = System.getProperty("user.dir") + "\\src\\by\\it\\sinkevich\\";
        String fileName = src + "jd01_14\\TaskA\\out.txt";
        writeDoublesToFile(fileName, numbers);
        printDoublesFromFile(fileName);
    }

    private static List<Double> getRandomNumbers(int count) {
        List<Double> result = new ArrayList<>(count);
        for (int i = 0; i < count; i++) {
            double number = Math.random() * 200 - 100;
            result.add(number);
        }
        return result;
    }

    private static void writeDoublesToFile(String fileName, List<Double> listOfDoubles) {
        try (DataOutputStream dataOutputStream = new DataOutputStream(new FileOutputStream(fileName))) {
            for (Double number : listOfDoubles) {
                dataOutputStream.writeDouble(number);
            }
        } catch (IOException e) {
            System.out.println("Ошибка записи в файл " + fileName);
        }
    }

    private static void printDoublesFromFile(String fileName) {
        try (DataInputStream dataInputStream = new DataInputStream(new FileInputStream(fileName))) {
            double sum = 0;
            int count = 0;
            while (dataInputStream.available() > 0) {
                double number = dataInputStream.readDouble();
                System.out.print(number + ", ");
                sum += number;
                count++;
                if (count % 5 == 0) {
                    System.out.println();
                }
            }
            System.out.println("Среднее арифметическое всех чисел равно: " + sum / count);
        } catch (IOException e) {
            System.out.println("Ошибка чтения из файла " + fileName);
        }
    }
}
