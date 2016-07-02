package by.it.kushel.jd01_14;

import java.io.*;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static javafx.scene.input.KeyCode.I;

/**
 * Created by Diomn on 07.06.2016.
 */
public class TaskBWorkWithText {
    public static void main(String[] args) throws FileNotFoundException {
        String src = System.getProperty("user.dir") + "/src/by/it/kushel/";
        String fin = src + "jd01_14/MyText.txt";


        try  (Scanner in = new Scanner(new File(fin)))
        {
            String str=" ";

            //FileReader reader = new FileReader(fin);
            while (in.hasNextLine()) {
                str = str + in.nextLine();
            }
            System.out.println(str);

            /*int c;
            while((c=reader.read())!=-1){

                System.out.print((char)c);
            }*/


            final String WORD = "[a-zA-Zа-яА-Я]+";
            final String PUNCTUATIONMARKS = "[.,?!;:]+";
            int i=0;
            int j=0;
            Pattern pattern1 = Pattern.compile(WORD);
            Pattern pattern2 = Pattern.compile(PUNCTUATIONMARKS);
            Matcher matcher1 = pattern1.matcher(str);
            Matcher matcher2 = pattern2.matcher(str);
            while (matcher1.find()) {
                i++;
            }
            while (matcher2.find()) {
                j++;
            }
            System.out.println("Количество слов в файле="+i);
            System.out.println("Количество знаков препинания файле="+j);


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        };
    }
}
