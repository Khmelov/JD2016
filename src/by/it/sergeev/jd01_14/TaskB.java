package by.it.sergeev.jd01_14;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB {

    public  static void main (String[] args) throws IOException {
        Pattern word = Pattern.compile("\\w+");
        Pattern mark = Pattern.compile("[.,!?]+");
        Matcher wordMatcher;
        Matcher marksMatcher;
        int words = 0;
        int marks = 0;


        File file = new File(System.getProperty("user.dir") + "/src/by/it/sergeev/jd01_15/out.txt"); //путь

        try (BufferedReader br = new BufferedReader(new FileReader(file))){
            String s;
            while ((s = br.readLine()) != null){
                int wCount = 0;
                int pCount = 0;
                wordMatcher = word.matcher(s);
                marksMatcher = mark.matcher(s);
                while (wordMatcher.find()){
                    wCount++;
                }

                while (marksMatcher.find()){
                    pCount++;
                }

                words += wCount;
                marks += pCount;
            }

            System.out.println("Количество слов: " + words);
            System.out.println("Количество знаков: " + marks);
        } catch (IOException e){
            System.err.println("Файл для проверки не найден. Проверьте путь");
        }
        finally {
            System.out.println("Путь к файлу: " + file.getCanonicalPath());
        }


    }
}

