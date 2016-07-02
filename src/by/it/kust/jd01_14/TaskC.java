package by.it.kust.jd01_14;

import java.io.File;

/**
 * Created by Tanya Kust on 12.06.2016.
 */
public class TaskC {
    /**
     *  Метод печатает названия каталогов и файлов указанного каталога
     */
    static void showDirectoriesAndFiles(){
        String src = System.getProperty("user.dir");
        File cur = new File(src);
        File[] dir = cur.listFiles();  //возвращает массив объектов - файлы и каталоги в указ.выше каталоге
        String[] list = cur.list();

        System.out.println("-------Список каталогов в каталоге " + src);
        for (File i: dir){
            if (i.isDirectory()) {    // если каталог
                System.out.println(i.getName());
            }
        }

        System.out.println("-------Список файлов в каталоге " + src);
        for (File i: dir){
            if (i.isFile()) {         // если файл
                System.out.println(i.getName());
            }
        }
    }
}
