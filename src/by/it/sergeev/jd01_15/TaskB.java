package by.it.sergeev.jd01_15;

import java.io.*;

public class TaskB {

    public static final String OUT_CR = "Out" + "cr";

    public static void main(String[] arg) {
        String src = System.getProperty("user.dir") + "/src/";
        String cl = TaskB.class.getName();
        String path = src.concat(cl.replaceAll("[.]", "/")).concat(".java");
        String fileOutTxt = src + "by/it/sergeev/JD01_15/out.txt";
        System.out.println(path);

        try {
            FileReader fr = new FileReader(path);
            BufferedReader in = new BufferedReader(fr);
            String line;
            StringBuilder code = new StringBuilder("");
            while ((line = in.readLine()) != null) {
                //коммент
                    /*комментарий*/
                code.append(line.replaceAll("(//.*)|(//*.+)", "").concat(OUT_CR));
            }
            String liner = code.toString().replaceAll(OUT_CR, "\n");
            try (PrintWriter printer =
                         new PrintWriter(
                                 new FileWriter(fileOutTxt, false)))//false перезаписывает файл. true добавляет инфо в файл.
            {
                printer.println(liner);
                System.out.print(liner);
            }
        } catch (java.io.IOException e) {
            System.out.println("Ошибка работы с " + path);
        }
    }
}


