package by.it.akhmelev.jd02_04.SimpleMatlab;

import java.util.regex.Matcher;

public class Parser {
    static int vNum=0;
    static String process(String in) {
        //на вход поступают некоторые выражения
        while (in.matches(Regex.sBrackets)) //Есть скобки. Заменим их на выражение и рекурсивно вызовем.
        {
            Matcher m=Regex.pBrackets.matcher(in);
            m.find();
            String expression=m.group();
            String tmpName="tmp"+(vNum++);
            in=in.replaceFirst(expression,tmpName);
            expression=tmpName+"="+expression.substring(1,expression.length()-1);
            //вычислим выражение в скобках
            process(expression);
        }
        //все, скобок не осталось.
        //сначала обработаем выражения на уровень А (т.е. без скобок)
        if (!in.matches(Regex.sBrackets))
        {
            //выясним возможно это выражение вида X=1+2
            //НА ДАННЫЙ МОМЕНТ НЕРЕАЛИЗОВАНО. ЭТО НАБРОСОК.
            //ОШИБКУ НУЖНО ИСКАТЬ ПО ТЕМЕ ЗАНЯТИЯ (т.е. некорректно работают регулярные выражения)
            //для поиска ошибки и проверки изменений в регулярных выражениях используйте тесты.
            if (in.matches(Regex.sVarAssignExpression)) {  //на входе присваивание (типа V=12+5, V=a*7, V=b/r)
                String arr[]=in.split(Regex.sAssign);
                String varName=arr[0];    //найдем имя переменной V
                String expression=arr[1]; //найдем выражение 12+5, a*7, b/r
                String values[]=expression.split(Regex.sOperation); //найдем части разделенные оператором
                String operations[]=expression.split(Regex.sValue); //найдем список оперторов
                //тут будет ошибка обработки выражений вида -3+7 или -10*-8
                //подумайте (!!!), что можно предпринять в этом случае
                int number=0;
                Variable start=new Variable(values[number]); //получаем значение первого операнда
                for (int i = 0; i < operations.length-1; i++) { //перебираем все операторы (тут резерв. второй вообще-то один)
                    Variable next=new Variable(values[++number]); //получаем второй (и возможно последующие операнды)
                    switch (operations[i].charAt(0)) {   //тут все возможные вычисления
                        case '+': start=start.add(next);
                        case '-': start=start.sub(next);
                        case '*': start=start.mul(next);
                        case '/': start=start.div(next);
                    }
                //вычисления завершены. Сохраним переменную в hashmap
                Vars.setVar(varName,start);
                //вернем итог вычислений
                return start.toString();
                }

            }
            //теперь выясним возможно это было просто прямое присваивание
            else if (in.matches(Regex.sVarAssignExpression)) {    //на входе присваивание (типа V=12 V=b)
                String s=in.replaceAll("=", "=1*");               //переделаем на выражение и рекурсивно вызовем
                return process(s);
            }
            //а теперь выясним, возможно это вычисление без привсаивания
            else if (in.matches(Regex.sExpression)) {  //на выражение 12/2
                String s="out="+in;                    //переделаем на выражение и рекурсивно вызовем
                return process(s);
            }
            else
                return "Ошибка! Неизвестное выражение "+in;
        }


        return "";
    }
}
