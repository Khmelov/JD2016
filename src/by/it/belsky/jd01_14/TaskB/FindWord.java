package by.it.belsky.jd01_14.TaskB;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Created by misha on 07.06.2016.
 */
public class FindWord {
    public static void main(String[] args) throws FileNotFoundException {

        String src = System.getProperty("user.dir") + "/src/by/it/belsky/";
        String file = src + "jd01_14/TaskB/text.txt";
        File f = new File(file);

            Scanner scanner = new Scanner(f);
            scanner.useDelimiter("[^a-яА-ЯёЁ]+");
            int count = 0;
            while (scanner.hasNext()) {
                scanner.next();
                count++;
            }
            scanner.close();
            System.out.println("Количество слов в тексте: " + count);
        }
        }

