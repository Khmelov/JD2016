package by.it.sereda.jd01_15.TaskB;

import java.io.*;

public class TaskB {

    public static final String OUT_CR = "OUT" + "CR";

    public static void main(String[] arg) {
        String src = System.getProperty("user.dir") + "/src/";
        String cl = TaskB.class.getName();
        System.out.println(cl);
        String path = src.concat(cl.replaceAll("\\.", "/").concat(".java"));
        System.out.println(path);
        String file_out = src + "/by/it/sereda/jd01_15/TaskB/matrix_file.txt";

        try {
            FileReader fileReader = new FileReader((path));
            BufferedReader in = new BufferedReader(fileReader);
            String line;
            StringBuilder code = new StringBuilder("");
            while ((line = in.readLine()) != null) {
                //комментарий 1
                /* комментарий */
                line = line.replaceAll("(/\\*{1,2}.*)|//.*", "").concat(OUT_CR);
                code.append(line);
            }
            String line_for_print = code.toString().replaceAll(OUT_CR, "\n");
            try (PrintWriter printer_for_file =
                         new PrintWriter(
                                 new FileWriter(file_out, false))) {
                printer_for_file.println(line_for_print);
                System.out.print(line_for_print);
            }
        } catch (java.io.IOException e) {
            System.out.println("Ошибка работы с " + path);
        }
    }
}
