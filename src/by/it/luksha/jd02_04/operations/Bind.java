package by.it.luksha.jd02_04.operations;


import by.it.luksha.jd02_04.vars.Var;

import java.util.HashMap;

public final class Bind {
    private static HashMap<String, Var> variables = new HashMap<>();

    private Bind() {
    }

    /**
     * Присваивает переменной значение
     * @param key переменная
     * @param var значение
     */
    public static void bind(String key, Var var) {
        variables.put(key, var);
    }

    public static HashMap<String, Var> getVariables() {
        return variables;
    }

    /**
     * Печатает все значения переменных
     */
    public static void printVars() {
        for (HashMap.Entry<String, Var> pair: variables.entrySet()) {
            System.out.println(pair.getKey() + "=" + pair.getValue());
        }
    }
}
