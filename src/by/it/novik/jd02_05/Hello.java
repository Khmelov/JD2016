package by.it.novik.jd02_05;

import by.it.novik.jd02_05.inout.Input;
import by.it.novik.jd02_05.inout.Print;
import by.it.novik.jd02_05.parsing.Parsing;
import by.it.novik.jd02_05.resources.Resources;

import java.io.IOException;
import java.util.Locale;

/**
 * Created by Kate Novik.
 */
public class Hello {
    public static void main(String[] args) {
        Resources resources;
        //При передаче двух аргументов создаем локаль и передаем её для создания объекта ресурсов
        if (args.length ==2){
            //Создаем сингелтон Resources с локалью по переданным аргументам
            resources = Resources.getInstance(new Locale(args[0],args[1]));

        }
        else { //Создаем объект ресурсов с локалью по умолчанию
            resources = Resources.getInstance();
        }
        //Печать сообщения и даты
        Print.printData(resources);

        //Для задания С - ввод языка с клавиатуры
        Locale locale;
        String line = null;
        do {
            try {
                line = Input.input();
            } catch (IOException e) {
                System.out.println("Ошибка ввода-вывода" + e);
            }
            locale = Parsing.parsingLocale(line);
            if (locale != null) {
                resources.changeLocal(locale);
                Print.printData(resources);
            }
            else {
                System.err.println("Введен неверный язык или пустая строка!");
                break;
            }
        }
        while (true);
    }
}
