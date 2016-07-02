package by.it.kushel.jd01_08;

import by.it.kushel.jd01_03.InOut;
import by.it.kushel.jd01_06.Data;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.lang.Math.*;
import static java.lang.Math.abs;

/**
 * Created by Diomn on 22.05.2016.
 */
public class Ran {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        calculator.add(new DoubleVariable(1.1), new DoubleVariable(2.2));
        calculator.sub(new DoubleVariable(1.1), new DoubleVariable(2.2));
        calculator.mul(new DoubleVariable(1.1), new DoubleVariable(2.2));
        calculator.dev(new DoubleVariable(1.1), new DoubleVariable(2.2));
        Double[] vec1 = {6.0, 5.0, 4.0};
        Double[] vec2 = {2.0, 10.0, 2.0};
        VectorVariable vector1 = new VectorVariable(vec1);
        VectorVariable vector2 = new VectorVariable(vec2);
        calculator.add(vector1, vector2);
        calculator.sub(vector1, vector2);
        calculator.mul(vector1, vector2);
        calculator.dev(vector1, vector2);


        Pattern pat;
        Matcher mat;
        String str = new String(Input.input());
        pat = Pattern.compile("([\\d]+)([\\+\\-\\*\\/])([\\d]+)");
        mat = pat.matcher(str);
        while (mat.find()) {
            Double var1 = Double.parseDouble(mat.group(1));
            String operator = mat.group(2);
            Double var2 = Double.parseDouble(mat.group(3));
            System.out.println(var1+operator+var2);


        Input.activation(var1, operator, var2);
    }
    }


}

