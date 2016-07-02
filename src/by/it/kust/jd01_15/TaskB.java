package by.it.kust.jd01_15;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by user_2 on 08.06.2016.
 */
public class TaskB {

    static final String OUT_CR = "OutCr";

    public static void main(String[] args) throws IOException {
        String src=System.getProperty("user.dir")+"/src/";
        String cl=TaskB.class.getName();

        String path = src.concat(cl.replaceAll("[.]", "/")).concat(".java");
        System.out.println(path);

        try {
            FileReader fileReader=new FileReader(path);
            BufferedReader in=new BufferedReader(fileReader);
            String line;
            StringBuilder code=new StringBuilder("");
            while ((line=in.readLine())!=null){
                int k=0; //комментарий 1
                /*комментарий*/
                line = line.replaceAll("//.*", "").concat(OUT_CR);
                code.append(line);
            }
            System.out.println(code.toString().replaceAll(OUT_CR,"\n"));
        } catch (IOException e) {
            System.out.println("ошибка работы " + path);
        }
    }
}
