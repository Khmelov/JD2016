package by.it.luksha.jd02_06.operations;


import by.it.luksha.jd02_06.vars.Matrix;
import by.it.luksha.jd02_06.vars.Scalar;
import by.it.luksha.jd02_06.vars.Var;
import by.it.luksha.jd02_06.vars.Vector;

public class Operation {

    private Operation() {
    }

    /**
     * Суммирует две переменные
     * @param var1 1я переменная
     * @param var2 2я переменная
     * @return сумма
     */
    public static Var add(Var var1, Var var2) {
        if (var1 instanceof Scalar && var2 instanceof Scalar)
            return Add.add((Scalar) var1, (Scalar) var2);
        else if (var1 instanceof Scalar && var2 instanceof Vector)
            return Add.add((Scalar) var1, (Vector) var2);
        else if (var1 instanceof Scalar && var2 instanceof Matrix)
            return Add.add((Scalar) var1, (Matrix) var2);

        else if (var1 instanceof Vector && var2 instanceof Scalar)
            return Add.add((Vector) var1, (Scalar) var2);
        else if (var1 instanceof Vector && var2 instanceof Vector)
            return Add.add((Vector) var1, (Vector) var2);
        else if (var1 instanceof Vector && var2 instanceof Matrix)
            return Add.add((Vector) var1, (Matrix) var2);

        else if (var1 instanceof Matrix && var2 instanceof Scalar)
            return Add.add((Matrix) var1, (Scalar) var2);
        else if (var1 instanceof Matrix && var2 instanceof Vector)
            return Add.add((Matrix) var1, (Vector) var2);
        else if (var1 instanceof Matrix && var2 instanceof Matrix)
            return Add.add((Matrix) var1, (Matrix) var2);
        else
            return Add.add(var1, var2);
    }

    /**
     * Умножает две переменные
     * @param var1 1
     * @param var2 2
     * @return произведение
     */
    public static Var mult(Var var1, Var var2) {
        if (var1 instanceof Scalar && var2 instanceof Scalar)
            return Mult.mult((Scalar) var1, (Scalar) var2);
        else if (var1 instanceof Scalar && var2 instanceof Vector)
            return Mult.mult((Scalar) var1, (Vector) var2);
        else if (var1 instanceof Scalar && var2 instanceof Matrix)
            return Mult.mult((Scalar) var1, (Matrix) var2);

        else if (var1 instanceof Vector && var2 instanceof Scalar)
            return Mult.mult((Vector) var1, (Scalar) var2);
        else if (var1 instanceof Vector && var2 instanceof Vector)
            return Mult.mult((Vector) var1, (Vector) var2);
        else if (var1 instanceof Vector && var2 instanceof Matrix)
            return Mult.mult((Vector) var1, (Matrix) var2);

        else if (var1 instanceof Matrix && var2 instanceof Scalar)
            return Mult.mult((Matrix) var1, (Scalar) var2);
        else if (var1 instanceof Matrix && var2 instanceof Vector)
            return Mult.mult((Matrix) var1, (Vector) var2);
        else if (var1 instanceof Matrix && var2 instanceof Matrix)
            return Mult.mult((Matrix) var1, (Matrix) var2);
        else
            return Mult.mult(var1, var2);
    }

    /**
     * Находит частное двух переменнх
     * @param var1 1
     * @param var2 2
     * @return частное
     */
    public static Var div(Var var1, Var var2) {
        if (var1 instanceof Scalar && var2 instanceof Scalar)
            return Div.div((Scalar) var1, (Scalar) var2);
        else if (var1 instanceof Scalar && var2 instanceof Vector)
            return Div.div((Scalar) var1, (Vector) var2);
        else if (var1 instanceof Scalar && var2 instanceof Matrix)
            return Div.div((Scalar) var1, (Matrix) var2);

        else if (var1 instanceof Vector && var2 instanceof Scalar)
            return Div.div((Vector) var1, (Scalar) var2);
        else if (var1 instanceof Vector && var2 instanceof Vector)
            return Div.div((Vector) var1, (Vector) var2);
        else if (var1 instanceof Vector && var2 instanceof Matrix)
            return Div.div((Vector) var1, (Matrix) var2);

        else if (var1 instanceof Matrix && var2 instanceof Scalar)
            return Div.div((Matrix) var1, (Scalar) var2);
        else if (var1 instanceof Matrix && var2 instanceof Vector)
            return Div.div((Matrix) var1, (Vector) var2);
        else if (var1 instanceof Matrix && var2 instanceof Matrix)
            return Div.div((Matrix) var1, (Matrix) var2);
        else
            return Div.div(var1, var2);
    }

    /**
     * Вычитает переменные
     * @param var1 1
     * @param var2 2
     * @return разница
     */
    public static Var sub(Var var1, Var var2) {
        if (var1 instanceof Scalar && var2 instanceof Scalar)
            return Sub.sub((Scalar) var1, (Scalar) var2);
        else if (var1 instanceof Scalar && var2 instanceof Vector)
            return Sub.sub((Scalar) var1, (Vector) var2);
        else if (var1 instanceof Scalar && var2 instanceof Matrix)
            return Sub.sub((Scalar) var1, (Matrix) var2);

        else if (var1 instanceof Vector && var2 instanceof Scalar)
            return Sub.sub((Vector) var1, (Scalar) var2);
        else if (var1 instanceof Vector && var2 instanceof Vector)
            return Sub.sub((Vector) var1, (Vector) var2);
        else if (var1 instanceof Vector && var2 instanceof Matrix)
            return Sub.sub((Vector) var1, (Matrix) var2);

        else if (var1 instanceof Matrix && var2 instanceof Scalar)
            return Sub.sub((Matrix) var1, (Scalar) var2);
        else if (var1 instanceof Matrix && var2 instanceof Vector)
            return Sub.sub((Matrix) var1, (Vector) var2);
        else if (var1 instanceof Matrix && var2 instanceof Matrix)
            return Sub.sub((Matrix) var1, (Matrix) var2);
        else
            return Sub.sub(var1, var2);
    }

    /**
     * Присваивает переменной значение
     * @param key переменная
     * @param var значение
     */
    public static void bind(String key, Var var) {
        Bind.bind(key, var);
    }


}
