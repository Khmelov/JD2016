package by.it.novik.jd01_14;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Kate Novik.
 */
public class TaskC {

    /**
     * Процедура вывода списка файлов и каталогов в каталоге проекта
     *
     */
    static void outputFilesAndDirectoriesInProject() {
        //Укажем директорию проекта
        String src = System.getProperty("user.dir");
        System.out.println("Каталог проекта " + src);
        File dir = new File(src);
        //Создаем лист для хранения имен файлов и лист для хранения имен каталогов
        List<String> listOfFiles = new ArrayList<>();
        List<String> listOfDirectories = new ArrayList<>();
        File[] listOfElem = dir.listFiles();
        if (listOfElem != null ) { //Проверка на null массива File[]
            for (File nameElem : listOfElem) { //Проходим по всем файлам и каталогам корневого каталога
                if (nameElem.isDirectory()) {
                    listOfDirectories.add(nameElem.getName());
                } else if (nameElem.isFile()) {
                    listOfFiles.add(nameElem.getName());
                }
            }
            //Печать директорий и файлов в каталоге проекта
            System.out.println("\nDirectories:");
            printList(listOfDirectories);
            System.out.println("\nFiles:");
            printList(listOfFiles);
        }
        else {
            System.out.println("Директорий и файлов нет!");
        }
    }

    /**
     * Процедура печати List
     * @param list List для вывода
     */
    private static void printList (List<String> list) {
        for (String name : list) {
            System.out.println(name);
        }
    }
}
