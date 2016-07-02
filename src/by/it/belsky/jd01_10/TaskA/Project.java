package by.it.belsky.jd01_10.TaskA;

import by.it.akhmelev.jd01_10.Demo.vars.Var;

/**
 * Created by misha on 29.05.2016.
 */
public class Project {
    public static void main(String[] args) {
        Variable one = new Variable("3.8");
        Variable two = new Variable("26.2");
        //результат сложения
        Variable res =one.add(two);
        System.out.println("Сложение: "+one+"+"+two+"="+res);
        Variable three = new Variable("87.4");
        Variable four = new Variable("23.1");
        Variable res1 = three.sub(four);
        System.out.println("Вычитание: "+three+"-"+four+"="+res1);
        Variable five = new Variable("1.04");
        Variable six = new Variable("5.9");
        Variable res2 = five.mul(six);
        System.out.println("Умножение: "+five+"*"+six+"="+res2);
        Variable seven = new Variable("12.7");
        Variable eight = new Variable("5");
        Variable res3 = seven.mul(eight);
        System.out.println("Умножение: "+seven+"*"+eight+"="+res3);
        Variable nine = new Variable("-6");
        Variable ten = new Variable("12");
        //результат сложения
        Variable res4 =nine.add(ten);
        System.out.println("Сложение: "+nine+"+"+ten+"="+res4);
        Variable eleven = new Variable("-7");
        Variable tvelve = new Variable("3.1");
        Variable res5 = eleven.mul(tvelve);
        System.out.println("Умножение: "+eleven+"*"+tvelve+"="+res5);
        Variable thirteen = new Variable("-4");
        Variable fourteen = new Variable("8");
        Variable res6 = thirteen.div(fourteen);
        System.out.println("Деление: "+thirteen+"/"+fourteen+"="+res6);
        Variable fiveteen = new Variable("9");
        Variable sixteen = new Variable("-0.9");
        Variable res7 = fiveteen.sub(sixteen);
        System.out.println("Вычитание: "+fiveteen+"-"+"("+sixteen+")"+"="+res7);

    }

}

