package by.it.vasilevich.jd02_05.demo.Resourses;


import java.util.Locale;
import java.util.ResourceBundle;

public class Res {
    public static final String PATH_RESOURSES = "by.it.vasilevich.jd02_05.demo.Resourses.Messages";
    private static Res res = new Res();
    private static Locale locale = new Locale("en","US");
    private static ResourceBundle resourceBundle=ResourceBundle.getBundle(PATH_RESOURSES, locale);

    private static void setLocale(Locale locale){
        Res.locale=locale;
    }

    public static Res getInstance(){
        if (res ==null)
            res =getInstance(locale);
        return res;
    }

    public static Res getInstance(Locale locale){
        changeLocal(locale);
        return res;
    }

    public static void changeLocal(Locale locale){
        setLocale(locale);
        resourceBundle=ResourceBundle.getBundle(PATH_RESOURSES, locale);
    }

    public String getString(String key){
        return resourceBundle.getString(key);
    }
}
