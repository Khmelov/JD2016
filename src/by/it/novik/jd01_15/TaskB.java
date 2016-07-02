package by.it.novik.jd01_15;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Kate Novik.
 */
public class TaskB {
    /**
     * Метод вывода кода
     * @param code код типа StringBuilder
     * @param out  Поток вывода
     */
    private static void writeCode(StringBuilder code, PrintStream out) {
        String[] codeLine = code.toString().split("\\n");
        for (int i = 0; i < codeLine.length; i++) {
            out.printf("%2d", i + 1);
            out.println(" " + codeLine[i]);
        }
    }

    public static void main(String[] args) {
        String src = System.getProperty("user.dir") + "/src/";
        String cl = TaskB.class.getName();
        System.out.println(cl);
        String path = src.concat(cl.replaceAll("\\.", "/").concat(".java"));
        System.out.println(path);
        try {
            BufferedReader in = new BufferedReader(new FileReader(path));
            String line;
            StringBuilder code = new StringBuilder("");
            //Убираем комментарии через //
            while ((line = in.readLine()) != null) {
                //коментарий 1
                /*коментарий2
                jjj
                jjj*/
                /*комментарий3*/
                line = line.replaceAll("//.*", "").concat("\n");
                code.append(line);
            }
            //Убираем многострочные комментарии
            Pattern pat = Pattern.compile("/\\*([^\\*/]*\\n?)?(\1)*(\1)?(\\*/)");
            Matcher mat = pat.matcher(code);
            while (mat.find()) {
                String s = mat.group();
                int start = mat.start();
                int end = mat.end();
                code.replace(start, end, "\n");
                mat.reset();
            }
            System.out.println(code.toString());
            //Вывод кода в консоль
            writeCode(code, System.out);
            //Вывод кода в файл
            PrintStream out = new PrintStream(new File(System.getProperty("user.dir") + "/src/by/it/novik/jd01_15/taskB.txt"));
            writeCode(code, out);
        } catch (IOException e) {
            System.err.println("Ошибка работы с " + path);
        }
    }
}
