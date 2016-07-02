package by.it.kust.jd01_14;

import java.io.IOException;

/**
 * Created by Tanya Kust.
 */
public class Runner {
    public static void main(String[] args) throws IOException {
        /**
         * Вариант А: Записать в двоичный файл 20 случайных чисел. Прочитать записанный
         * файл, распечатать числа и их среднее арифметическое.
         */
        System.out.println("TaskA.");
        TaskA.createFileWithNumbers();
        TaskA.readFileWithNumbers();

        /**
         * Вариант В: В файле с текстом подсчитать в тексте количество знаков препинания и слов.
         */
        System.out.println("\nTaskB.");
        TaskB.countWordsAndPunctuation();

        /**
         * Вывести список файлов и каталогов каталога проекта на диске.
         * Файлы и каталоги должны быть распечатаны отдельно
         */
        System.out.println("\nTaskC");
        TaskC.showDirectoriesAndFiles();
    }
}
