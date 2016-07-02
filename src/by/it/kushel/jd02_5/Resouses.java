package by.it.kushel.jd02_5;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.ResourceBundle;


public class Resouses {


    //private Resouses resouses=null;
    Locale locale;

    public void greeting() {
        Locale locale = new Locale("en", "US");
        ResourceBundle resouceBundle = ResourceBundle.getBundle("by.it.kushel.jd02_5.Messages", locale);
        String computerButtonLabel = resouceBundle.getString("helloMessage");
        System.out.println(computerButtonLabel);
        DateFormat fmt = DateFormat.getDateInstance(DateFormat.MEDIUM, locale);
        Date date = new Date(System.currentTimeMillis());
        System.out.println(fmt.format(date));
    }

    public void greeting(Locale locale) {
        this.locale = locale;
        ResourceBundle resouceBundle = ResourceBundle.getBundle("by.it.kushel.jd02_5.Messages", locale);
        String computerButtonLabel = resouceBundle.getString("helloMessage");
        System.out.println(computerButtonLabel);
        DateFormat fmt = DateFormat.getDateInstance(DateFormat.MEDIUM, locale);
        Date date = new Date(System.currentTimeMillis());
        System.out.println(fmt.format(date));
    }

   /* public resourses Resouses getInstans(){
        if (resouses==null)
            resouses=new Resouses();
        return resouses;
    }
    private void   setLocale(Locale locale){
        this.locale=locale;
    }*/
/*    public resourses getInstans(Locale locale){
        this.locale=locale;
        System.out.println(resouceBundle.getString("helloMessage"));
        return resouses;
    }*/

}


