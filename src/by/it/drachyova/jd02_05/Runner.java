package by.it.drachyova.jd02_05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

// A
// Создать программу, которая может приветствовать пользователя на трех языках: английском, русском, белорусском.
// Требуемый язык и страна должны сообщаться программе в качестве входных параметров. Если входные параметры отсутствуют,
// программа должна выдавать сообщение на английском. В приветствии должно также быть Ваше имя.

// B
// Доработайте программу так, чтобы: Выводилась текущая дата в том же языковом стандарте, что и приветствие.

// C
// Доработайте программу так, чтобы: Язык можно было переключать с клавиатуры командами ru be en.
// Ресурсы нужно создать сначала как текстовые файлы в формате utf-8 и получить из них файлы .properties утилитой
// native2ascii. Приведите использованные при этом команды в текстовом файле команды.txt.

public class Runner {
    public static void main(String[] args) throws IOException {
        Resources resources = Resources.INSTANCE;
        DateFormat dateFormat;
        Date date = new Date();
        String language = "";
        System.out.println("Выберите язык be, ru или en");

        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            language = String.valueOf(bufferedReader.readLine());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        switch (language) {
            case "be":
                resources.changeResource(new Locale("be", "BY"));
                dateFormat = DateFormat.getDateInstance(DateFormat.LONG, new Locale("be", "BY"));
                break;
            case "ru":
                resources.changeResource(new Locale("ru", "RU"));
                dateFormat = DateFormat.getDateInstance(DateFormat.LONG, new Locale("ru", "RU"));
                break;
            case "en":
                resources.changeResource(new Locale("en", "EN"));
                dateFormat = DateFormat.getDateInstance(DateFormat.LONG, new Locale("en", "EN"));
                break;
            default:
                resources.changeResource(new Locale("en", "EN"));
                dateFormat = DateFormat.getDateInstance(DateFormat.LONG, new Locale("en", "EN"));
        }
        System.out.println(dateFormat.format(date));
        System.out.println(resources.getString("greetings"));
    }
}

