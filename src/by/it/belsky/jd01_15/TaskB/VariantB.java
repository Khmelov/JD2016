package by.it.belsky.jd01_15.TaskB;

import java.io.*;

/**
 * Created by misha on 08.06.2016.
 */
public class VariantB {

    public static final String OUT_CR = "OutCR";

    public static void main(String[] args) throws IOException {
        String src = System.getProperty("user.dir") + "/src/";
        String cl = VariantB.class.getName();//возвращает имя класса с точками
        System.out.println(cl);
        String path = src.concat(cl.replaceAll("[.]", "/")).concat(".java");
        System.out.println(path);
        //String filename = src + "jd01_15/matrix.txt";
        try {
            FileReader fileReader = new FileReader(path);
            BufferedReader in = new BufferedReader(fileReader);
            String line;
            StringBuilder code = new StringBuilder();
            while ((line = in.readLine()) != null) {
                int k = 0; //комментарий 1
                /*комментарий*/
                line = line.replaceAll("//.*", " ").concat(OUT_CR);
                //k++;
                code.append(line);
            }

            String forPrint=code.toString().replaceAll(OUT_CR, "\n");
            System.out.println(forPrint);

            File textFile=new File("D:\\here.txt");
            FileWriter writer = new FileWriter(textFile);
            BufferedWriter x = new BufferedWriter(writer);
            x.write(forPrint);
            x.flush();
            x.close();



        } catch (IOException e) {
            System.out.println("Ошибка работы с" + path);
        }

    }
}
