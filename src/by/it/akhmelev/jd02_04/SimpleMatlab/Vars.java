package by.it.akhmelev.jd02_04.SimpleMatlab;

import java.util.HashMap;
//класс для хранения и получения переменных
public class Vars {
     static private HashMap<String, Variable> hm=new HashMap<>();
    //сохранить переменную
    static void setVar(String name,Variable value) {
        hm.put(name,value);
    }
    //получить переменную
    static Variable getVar(String name) {
        return hm.get(name);
    }
}
