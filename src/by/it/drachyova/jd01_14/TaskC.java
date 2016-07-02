package by.it.drachyova.jd01_14;

//Вывести список файлов и каталогов каталога проекта на диске.
// Файлы и каталоги должны быть распечатаны отдельно.

import java.io.File;

public class TaskC {
    static void printFilesAndDirectories(){
        String src = System.getProperty("user.dir");
        File dir = new File(src); //с объектом типа File ассоциируется корневой каталог проекта
        File[] filesAndDirs = dir.listFiles();
        System.out.println("Список файлов");            //вывод файлов в консоль
        for (File element : filesAndDirs) {
            if (element.isFile()) {                     //если файл
                System.out.println(element.getName());  //выводим в консоль его имя
            }
        }
        System.out.println("Список каталогов");         //вывод каталогов
        for (File element : filesAndDirs) {
            if (element.isDirectory()) {                //если каталог
                System.out.println(element.getName());  //выводим в консоль его имя
            }
        }
    }
}
