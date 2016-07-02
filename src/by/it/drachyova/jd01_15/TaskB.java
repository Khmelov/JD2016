package by.it.drachyova.jd01_15;

import java.io.*;

public class TaskB {

    public static void main(String[] args) throws FileNotFoundException {
        String src = System.getProperty("user.dir") + "/src/";
        String cl = TaskB.class.getName();
        String path = src.concat(cl.replaceAll("[.]", "/").concat(".java"));
        System.out.println(path);
        try {
            FileReader e = new FileReader(path);
            BufferedReader in = new BufferedReader(e);
            StringBuilder code = new StringBuilder("");
            int numberLine = 0;
            String line;
            while ((line = in.readLine()) != null) {
                numberLine++; //комментарий
                /* комментарий*/
                line = line.replaceAll("(/\\*{1,2}.*)|(\\*{1}.*)|//.*", "");
                if (numberLine > 9) {
                    code.append(numberLine).append("  ").append(line + "\n");
                } else code.append("0").append(numberLine).append("  ").append(line + "\n");

            }
            System.out.println(code.toString());
        } catch (IOException e) {
            System.out.println("Ошибка работы с " + path);
        }

    }
}
