package by.it.sinkevich.jd01_14.TaskB;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Class for jd01_14 TaskB
 *
 * @author Sinkevich Denis
 */
class TaskB {

    public static void main(String[] args) {
        String src = System.getProperty("user.dir") + "\\src\\by\\it\\sinkevich\\";
        String fileName = src + "jd01_14\\TaskB\\EnglishText.txt";
        StringBuilder text = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                text.append(line);
            }
        } catch (IOException e) {
            System.out.println("Ошибка чтения файла " + fileName);
        }
        int wordsCount = findWordsCountInText(text.toString());
        int syntaxCount = findSyntaxCountInText(text.toString());
        System.out.println("В данном тексте " + wordsCount + " слов(а) и " + syntaxCount + " знака(ов) препинания!");
    }

    private static int findWordsCountInText(String text) {
        int result = 0;
        Pattern wordsPattern = Pattern.compile("\\b\\w+\\b");
        Matcher matcher = wordsPattern.matcher(text);
        while (matcher.find()) {
            result++;
        }
        return result;
    }

    private static int findSyntaxCountInText(String text) {
        int result = 0;
        Pattern wordsPattern = Pattern.compile("\\p{Punct}");
        Matcher matcher = wordsPattern.matcher(text);
        while (matcher.find()) {
            result++;
        }
        return result;
    }
}
