package by.it.sinkevich.jd01_15.TaskB;

import java.io.*;

/**
 * Class for jd01_15 taskB
 *
 * @author Sinkevich Denis
 */
class TaskB {

    public static void main(String[] args) {
        String src = System.getProperty("user.dir") + "/src/";
        String className = TaskB.class.getName();
        String path = src.concat(className.replaceAll("\\.", "/")).concat(".java");
        //Обычный комментарий// //
        /*
        Многострочный коммент */
        StringBuilder programCode = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            String line;
            int counter = 0;
            while ((line = reader.readLine()) != null) {
                programCode.append(String.format("%2d ", ++counter));
                programCode.append(line.replaceAll("//.*//", "").concat("\n"));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        int openIndex;
        while ((openIndex = programCode.indexOf("/*")) != -1) {
            int closeIndex = programCode.indexOf("*/", openIndex + 2) + 2;
            programCode.delete(openIndex, closeIndex);
        }

        System.out.println(programCode);

        String filePath = src.concat(className.replaceAll("\\.", "/")).concat(".txt");
        try (BufferedReader reader = new BufferedReader(new StringReader(programCode.toString()));
             PrintWriter writer = new PrintWriter(new FileWriter(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                writer.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
