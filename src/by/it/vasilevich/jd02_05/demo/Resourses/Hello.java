package by.it.vasilevich.jd02_05.demo.Resourses;


import java.util.Locale;

public class Hello {
    public static void main (String[] args){
        Res res;
        if(args.length==2){
            Locale locale=new Locale(args[0],args[1]);
            res=Res.getInstance(locale);
        }
        else
            res = Res.getInstance();
         System.out.println(res.getString("helloMessage"));
    }
}
