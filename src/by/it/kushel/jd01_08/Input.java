package by.it.kushel.jd01_08;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Diomn on 29.05.2016.
 */
public class Input {
    public  static  String input() {
        String str = "";
        Scanner cs = new Scanner(System.in);
        Double[] var = null;
        while (true) {
            try {
                System.out.print("Введите арифметическую операцию типа 1+1, 4-2, 5*3, 10/5  ");
                if (cs.hasNext()) {
                    str = cs.nextLine();
                }
            } catch (Exception e) {
                System.out.println("Input correct numbers");
            }
            return str;
        }
    }

    public static void activation(Double var1, String operator, Double var2){
        Calculator calculator = new Calculator();
        if(operator.equals("+")){
            calculator.add(new DoubleVariable(var1), new DoubleVariable(var2));
        }else  if(operator.equals("-")){
            calculator.sub(new DoubleVariable(var1), new DoubleVariable(var2));
        } else  if(operator.equals("*")){
            calculator.mul(new DoubleVariable(var1), new DoubleVariable(var2));
        } else  if(operator.equals("/")){
            calculator.dev(new DoubleVariable(var1), new DoubleVariable(var2));
        }
    }
}
