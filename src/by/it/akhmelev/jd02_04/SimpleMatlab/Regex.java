package by.it.akhmelev.jd02_04.SimpleMatlab;

import java.util.regex.Pattern;

class Regex {
    //возможные регулярные выражения
    static String sBrackets="[(].+[)]"; //[(] - скобка открывается, .+ - какое-то выражение, [)] скобка закрывается
    static String sValue ="-?[0-9]+[.]?[0-9]+"; //-? - возможен минус, [.]? - точка [0-9]+ - числа подряд.
    static String sOperation="[+*-/]"; //возможные математические операции
    static String sAssign="="; //присваивание
    static String sExpression= sValue +sOperation+ sValue; //выражение
    static String sVar="[a-zA-Z][0-9a-zA-Z]*"; //переменная вида a или ab123 или a1b2
    static String sVarAssign=sVar+sAssign+sValue; //выражение вида A=9.7
    static String sVarAssignExpression=sVar+sAssign+sExpression; //выражение вида A=9.7+1.1

    //возможные паттерны для парсера
    static final Pattern pBrackets=Pattern.compile(sBrackets);
    static final Pattern pValue=Pattern.compile(sValue);
    static final Pattern pOperation=Pattern.compile(sOperation);
    static final Pattern pAssign=Pattern.compile(sAssign);
    static final Pattern pExpression=Pattern.compile(sExpression);
    static final Pattern pVar=Pattern.compile(sVar);
    static final Pattern pVarAssign=Pattern.compile(sVarAssign);
    static final Pattern pVarAssignExpression=Pattern.compile(sVarAssignExpression);

}
