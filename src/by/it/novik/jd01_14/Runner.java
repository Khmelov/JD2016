package by.it.novik.jd01_14;

import java.io.IOException;

/**
 * Created by Kate Novik.
 */
public class Runner {
    public static void main(String[] args) {
        /**
         * А. Записать в двоичный файл 20 случайных чисел.
         * Прочитать записанный файл, распечатать числа и их среднее арифметическое.
         */
        System.out.println("TaskA");
        try {
            TaskA.readOutFile(TaskA.writeInFile());
        }
        catch (IOException e) {
            System.err.println("Ошибка ввода/вывода" + e);
        }

        /**
         * B. В файле с текстом подсчитать в тексте количество знаков препинания и слов
         */
        System.out.println("TaskB");
        TaskB.countWordsInText();
        TaskB.countPunctuationMarksInText();

        /**
         * C. Вывести список файлов и каталогов каталога проекта на диске.
         * Файлы и каталоги должны быть распечатаны отдельно.
         */
        System.out.println("TaskС");
        TaskC.outputFilesAndDirectoriesInProject();
    }
}
