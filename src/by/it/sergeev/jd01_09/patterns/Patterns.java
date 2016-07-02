package by.it.sergeev.jd01_09.patterns;

public class Patterns {
    static public String exVal = "((-?)([0-9.])+)";                       //числа
    static public String exVec = "\\{((-?([0-9.])+),?)+}";                //вектора
    static public String exMat = "\\{((\\{((-?([0-9.])+),?)+}),?)+}";     //матрицы
    static public String exAny = "(" + exMat + ")|(" + exVec + ")|(" + exVal + ")";   //одно из...
    static public String exOper = "[-+*/]";                               //операция
    static public String exFull = "(" + exAny + ")" +
            "(" + exOper + ")" +
            "(" + exAny + ")"; //выражение целиком
}
