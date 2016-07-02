package by.it.sinkevich.jd01_14.TaskC;

import java.io.File;

/**
 * Class for jd01_14 TaskC
 *
 * @author Sinkevich Denis
 */
class TaskC {

    public static void main(String[] args) {
        String src = System.getProperty("user.dir");
        File file = new File(src);
        File[] listOfFiles = file.listFiles();
        System.out.println("Список директорий: ");
        for (File element : listOfFiles) {
            if (element.isDirectory()) {
                System.out.println(element.getName());
            }
        }
        System.out.println("\nСписок файлов: ");
        for (File element : listOfFiles) {
            if (element.isFile()) {
                System.out.println(element.getName());
            }
        }
    }
}
