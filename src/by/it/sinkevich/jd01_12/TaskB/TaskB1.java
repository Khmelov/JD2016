package by.it.sinkevich.jd01_12.TaskB;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * TaskB1 class
 *
 * @author Sinkevich Denis
 */
class TaskB1 {

    private String text;
    private Map<String, Integer> words;

    TaskB1() {
        this(EnglishText.TEXT);
    }

    TaskB1(String text) {
        this.text = text;
        words = new HashMap<>();
    }

    void fillMapWithWords() {
        Pattern pattern = Pattern.compile("\\b[A-Za-z]+\\b");
        Matcher matcher = pattern.matcher(text);
        while (matcher.find()) {
            String word = matcher.group();
            if (words.containsKey(word)) {
                Integer quantity = words.get(word);
                words.put(word, ++quantity);
            } else {
                words.put(word, 1);
            }
        }
    }

    void printMap() {
        int counter = 1;
        for (String key : words.keySet()) {
            System.out.print(key + " = " + words.get(key));
            if (counter % 5 != 0) {
                System.out.print(", ");
            } else {
                System.out.println();
            }
            counter++;
        }
    }

    public Map<String, Integer> getWords() {
        return words;
    }
}
