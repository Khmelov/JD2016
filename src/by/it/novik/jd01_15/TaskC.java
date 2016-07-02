package by.it.novik.jd01_15;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Kate Novik.
 */
public class TaskC {

    public static void main(String[] args)  {
        try {
            readConsole();
        }
        catch (IOException e) {
            System.out.println("Ошибка ввода-вывода" + e);
        }
    }

    /**
     * Метод чтения консоли
     * @throws IOException
     */
    private static void readConsole () throws IOException {
        //Укажем стартовую директорию проекта
        String src = System.getProperty("user.dir");
        System.out.println("Continue before input \"N\"");
        System.out.print(src + " ");
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        boolean in = true; //Переменная для разрешения ввода
        File dirMain = new File(src); //Объект File стартовой директории
        File dir = new File(src); //Объект File текущей директории
        String line; //Строка ввода
        File [] listFiles; //Список объектов типа File
        int countF = 0; //Количество файлов в каталоге
        long sizeTotalF = 0; //Общий размер файлов в каталоге
        do {
            line = buf.readLine();
            if (line.equals("cd\\")) {
                dir = dirMain;
                System.out.print(dirMain.getPath() + " ");
            } else if (line.equals("cd..")) {
                if (dir.getParent() != null) {
                    dir = new File(dir.getParent());
                    System.out.print(dir.getPath() + " ");
                } else {
                    System.err.println("This path doesn't have parent's path!");
                    System.out.print(dir.getPath() + " ");
                }
            } else if (line.matches("cd\\s.+")) {
                File dirOld = dir;
                String srcNew = line.substring(3,line.length());
                dir = new File (srcNew);
                if (dir.exists()) {
                    System.out.print(dir.getPath() + " ");
                }
                else {
                    System.err.println("No exist this Path");
                    System.out.print(dirOld.getPath() + " ");
                }
            } else if (line.equals("dir")) {
                listFiles = dir.listFiles();
                if (listFiles != null) {
                    for (File f : listFiles) {
                        if (f.isDirectory()) {
                            System.out.printf("<DIR> %-15s %-10s", " ", f.getName());
                            System.out.println("");
                        } else if (f.isFile()) {
                            Long size = f.length();
                            System.out.printf("<File> %-14s %-10s", size.toString(), f.getName());
                            System.out.println("");
                            countF++;
                            sizeTotalF += size;
                        }
                    }
                    System.out.printf("%2d файлов %10d байт", countF, sizeTotalF);
                    System.out.println("");
                    System.out.print(dir.getPath() + " ");
                }
                else {
                    System.out.println("<DIR> 0\\n<File> 0");
                    System.out.print(dir.getPath() + " ");
                }
            }
            else if (line.matches("\\s*N$")) {
                in = false;
            } else {
                System.err.println("Error input!");
                System.out.print(dir.getPath() + " ");
            }
        }
        while (in);
    }
}
