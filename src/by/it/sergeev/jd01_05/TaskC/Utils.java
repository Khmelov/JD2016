package by.it.sergeev.jd01_05.TaskC;

public class Utils {
    public static double[] CreateArray() {
        double[] array = new double[32];
        for (int i = 0; i < 32; i++) {
            array[i] = (double) Math.round((Math.random() * 347 + 103) * 100) / 100;
        }
        return array;
    }

    public static double[] ArrayK(double[] arrayIn) {
        double[] array = new double[32];
        int n = 0;
        for (int i = 0; i < 32; i++) {
            if ((double) i / 10 < (double) Math.round((arrayIn[i] % 1) * 100) / 100) {
                array[n] = arrayIn[i];
                n++;
            }
        }

        double[] arrayOut = new double[n];
        for (int i = 0; i < n; i++) {
            arrayOut[i] = array[i];
        }

        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arrayOut[j] < arrayOut[j + 1]) {
                    double x = arrayOut[j];
                    arrayOut[j] = arrayOut[j + 1];
                    arrayOut[j + 1] = x;
                }
            }
        }
        return arrayOut;
    }

    public static void PrintArray(double[] array, String name) {
        int n = 1;
        for (int i = 0; i < array.length; i++) {
            System.out.printf(name + "[%-1d]=%-5.2f  ", i, array[i]);
            n++;
            if (n > 10) {
                System.out.println();
                n = 1;
            }
        }
        System.out.println();
    }

    public static void PrintHorizontal(double[] array, String name) {
        int n = 1;

        for (int i = 0; i < array.length; i++) {
            if (1 == n) {
                for (int j = 0; j < 5; j++) {
                }
            }
            System.out.printf(" %-1s(%02d)=%-1.2f ", name, i, array[i]);
            if (6 == n) {

                for (int j = 0; j < 5; j++) {
                }
                System.out.println();
                n = 0;
            }
            n++;
        }
    }

    public static void PrintVertical(double[] array, String name) {
        int n = array.length / 7;
        if (0 != array.length % 7)
            n++;
        for (int i = 0; i < n; i++) {

        }

        for (int i = 0; i < 7; i++) {

            for (int j = 0; j < n - 1; j++) {

            }

            for (int j = i; j < array.length; j += 7) {
                System.out.printf(" %-1s(%02d)=%-1.2f ", name, j, array[j]);
            }
            if (i + 7 * (n - 1) > array.length || i + 7 * (n - 1) == array.length) {
            } else

                for (int j = 0; j < n - 1; j++) {

                }
        }
        for (int i = 0; i < n; i++) {
        }
    }
}

