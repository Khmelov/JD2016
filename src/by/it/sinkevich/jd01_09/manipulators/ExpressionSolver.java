package by.it.sinkevich.jd01_09.manipulators;

import by.it.sinkevich.jd01_09.parser.Patterns;
import by.it.sinkevich.jd01_09.variables.*;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * Created by Computer on 28.05.2016.
 *
 * @author Sinkevich Denis
 */
public class ExpressionSolver {

    private Manipulator manipulator = new Manipulator();
    private VariableFactory[] factories = new VariableFactory[]
            {new MathLabFloatFactory(), new MathLabVectorFactory(), new MathLabMatrixFactory()};

    public MathLabVariable solveExpression(List<String> parsedLine) {
        List<String> tempList = new ArrayList<>(parsedLine);
        String variableName = getVariableName(tempList);
        for (int index = 0; index < tempList.size(); index++) {
            if (!tempList.get(index).matches(Patterns.regexOperators)) {
                continue;
            }
            String operator = tempList.get(index);
            if (operator.equals("*") || operator.equals("/")) {
                MathLabVariable leftVariable = getVariableFromString(tempList.get(index - 1));
                MathLabVariable rightVariable;
                if (tempList.get(index + 1).equals("(")) {
                    int openBracketIndex = index + 1;
                    Deque<Integer> brackets = new ArrayDeque<>();
                    brackets.push(openBracketIndex);
                    int bracketIndex = openBracketIndex + 1;
                    while (!brackets.isEmpty()) {
                        if (tempList.get(bracketIndex).equals("(")) {
                            brackets.push(bracketIndex);
                        } else if (tempList.get(bracketIndex).equals(")")) {
                            brackets.pop();
                        }
                        bracketIndex++;
                    }
                    int closeBracketIndex = bracketIndex - 1;
                    List<String> expressionInsideBrackets = tempList.subList(openBracketIndex + 1, closeBracketIndex);
                    rightVariable = solveExpression(expressionInsideBrackets);
                    int countOfElementsInsideBrackets = closeBracketIndex - openBracketIndex;
                    for (int i = 0; i < countOfElementsInsideBrackets; i++) {
                        tempList.remove(openBracketIndex + 1);
                    }
                } else {
                    rightVariable = getVariableFromString(tempList.get(index + 1));
                }
                tempList.set(index - 1, "0");
                tempList.set(index, "+");
                if (operator.equals("*")) {
                    MathLabVariable temp = manipulator.multiplication(leftVariable, rightVariable);
                    tempList.set(index + 1, temp.toString());
                } else {
                    MathLabVariable temp = manipulator.division(leftVariable, rightVariable);
                    tempList.set(index + 1, temp.toString());
                }
            }
        }
        MathLabVariable result = factories[0].getVariable();
        for (int index = 0; index < tempList.size(); index++) {
            if (!tempList.get(index).matches(Patterns.regexOperators)) {
                continue;
            }
            MathLabVariable rightVariable;
            if (tempList.get(index + 1).equals("(")) {
                int openBracketIndex = index + 1;
                Deque<Integer> brackets = new ArrayDeque<>();
                brackets.push(openBracketIndex);
                int bracketIndex = openBracketIndex + 1;
                while (!brackets.isEmpty()) {
                    if (tempList.get(bracketIndex).equals("(")) {
                        brackets.push(bracketIndex);
                    } else if (tempList.get(bracketIndex).equals(")")) {
                        brackets.pop();
                    }
                    bracketIndex++;
                }
                int closeBracketIndex = bracketIndex - 1;
                List<String> expressionInsideBrackets = tempList.subList(openBracketIndex + 1, closeBracketIndex);
                rightVariable = solveExpression(expressionInsideBrackets);
                int countOfElementsInsideBrackets = closeBracketIndex - openBracketIndex;
                for (int i = 0; i < countOfElementsInsideBrackets; i++) {
                    tempList.remove(openBracketIndex + 1);
                }
            } else {
                rightVariable = getVariableFromString(tempList.get(index + 1));
            }
            if (tempList.get(index).equals("+")) {
                result = manipulator.addition(result, rightVariable);
            } else {
                result = manipulator.subtraction(result, rightVariable);
            }
        }
        if (variableName != null) {
            VariablesStorage.add(variableName, result);
        }
        return result;
    }

    private MathLabVariable getVariableFromString(String strValue) {
        MathLabVariable result;
        if (!strValue.contains("{")) {
            result = factories[0].getVariable(strValue);
        } else {
            int index = strValue.indexOf("{");
            if (strValue.indexOf("{", index + 1) == -1) {
                result = factories[1].getVariable(strValue);
            } else {
                result = factories[2].getVariable(strValue);
            }
        }
        return result;
    }

    private String getVariableName(List<String> parsedLine) {
        if (parsedLine.get(1).equals("=")) {
            String variableName = parsedLine.get(0);
            parsedLine.remove(0);
            parsedLine.remove(0);
            return variableName;
        }
        return null;
    }
}
