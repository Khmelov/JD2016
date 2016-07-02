package by.it.sinkevich.jd02_05;

import by.it.sinkevich.jd02_05.resources.Resources;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Main class for task jd02_05
 *
 * @author Sinkevich Denis
 */
class Runner {

    public static void main(String[] args) {
        printArgsLocaleMessages(args);
        printMessagesFromConsole();
    }

    private static void printMessagesFromConsole() {
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            String line = bufferedReader.readLine();
            while (!line.equals("")) {
                Locale locale = getLocaleFromString(line);
                Resources resources = Resources.getInstance(locale);
                DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.FULL, DateFormat.FULL, locale);
                System.out.println(resources.getString("helloMessage"));
                System.out.println(dateFormat.format(new Date()));
                line = bufferedReader.readLine();

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void printArgsLocaleMessages(String args[]) {
        Resources resources;
        Locale argsLocale;
        if (args.length == 2) {
            argsLocale = new Locale(args[0], args[1]);
            resources = Resources.getInstance(argsLocale);
        } else {
            argsLocale = new Locale("en", "US");
            resources = Resources.getInstance();
        }
        DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.FULL, DateFormat.FULL, argsLocale);
        System.out.println(resources.getString("helloMessage"));
        System.out.println(dateFormat.format(new Date()));
    }

    private static Locale getLocaleFromString(String line) {
        switch (line) {
            case "ru": {
                return new Locale("ru", "RU");
            }
            case "be": {
                return new Locale("be", "BY");
            }
            case "en": {
                return new Locale("en", "US");
            }
            case "uk": {
                return new Locale("uk", "UA");
            }
            default: {
                System.out.println(Resources.getInstance().getString("errorMessage.LocaleNotFound"));
                break;
            }
        }
        return new Locale("en", "US");
    }
}
