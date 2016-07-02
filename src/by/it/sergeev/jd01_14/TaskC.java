package by.it.sergeev.jd01_14;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TaskC {
        public  static void main (String[] args) throws IOException {
            File folder = new File(System.getProperty("user.dir") + "/src/by/it/sergeev/jd01_15/");
            SimpleDateFormat dateFormat =new SimpleDateFormat("dd.MM.yyyy HH:mm");
            String f ="<ФАЙЛ >";
            String p ="<ПАПКА>";
            if (folder.isDirectory()){
                File[] files = folder.listFiles();
                System.out.println("Содержимое папки: " + System.getProperty("user.dir") + "/src/by/it/sergeev/jd01_15/\n");
                System.out.print("ИМЯ                  ТИП      ДАТА                РАЗМЕР\n");
                int countFiles = 0;
                int countFolder = 0;
                for (File file: files){
                    if (file.isFile()){
                        System.out.printf("%-20s %-8s %-16s  %6d байт\n", file.getName(),f.toString(), dateFormat.format(new Date(file.lastModified())),file.length());
                        countFiles++;
                    }
                    else{
                        System.out.printf("%-20s %-8s %-16s  %6d байт\n", file.getName(),p.toString(), dateFormat.format(new Date(file.lastModified())), file.length());
                        countFolder++;
                    }
                }
                System.out.println("Количество каталогов: " + countFolder + "\nКоличество файлов: " + countFiles + "\nВсего объектов: " + (countFiles+countFolder));
            }
            else
                System.err.printf("Указан неверный путь");
        }
    }
