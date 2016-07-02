package by.it.akhmelev.jd02_05.res_wthout_enum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Locale;

public class HelloI18N {

    static String getOneLine()  {
        BufferedReader stin = new BufferedReader(new InputStreamReader(System.in));
        String line = null;
        try {
            line = stin.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        //для файлов нужно закрывать: stin.close();
        return line;
    }

    public static void hello(Locale locale){
    }

    public static void main(String[] args) {
        Locale locale;
        if (args.length == 2) {
            locale = new Locale(args[0], args[1]);
        } else locale = Locale.ENGLISH; ;
        System.out.println(locale);
        Properties.setLocale(locale);
        String hello=Properties.getString("hello");
        System.out.print(hello);

        String in;
        while (!(in=getOneLine()).isEmpty()) {
            if (in.equals("ru")) {
                hello(new Locale("ru","RU"));
            }
            else if (in.equals("be")) {
                hello(new Locale("be","BY"));
            }
            else
                hello(new Locale("en","US"));

        }

    }
}
