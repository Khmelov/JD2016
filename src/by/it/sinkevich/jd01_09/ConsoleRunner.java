package by.it.sinkevich.jd01_09;

import by.it.sinkevich.jd01_09.manipulators.ExpressionSolver;
import by.it.sinkevich.jd01_09.parser.Parser;
import by.it.sinkevich.jd01_09.variables.MathLabVariable;
import by.it.sinkevich.jd01_09.variables.VariablesStorage;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Основной класс, из которого стартует прорамма
 *
 * @author Sinkevich Denis
 */
public class ConsoleRunner {

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String line = reader.readLine();
        ExpressionSolver solver = new ExpressionSolver();
        while (!(line.equals("-exit") || line.equals(""))) {
            if (line.equals("printvar")) {
                VariablesStorage.printVariables();
                line = reader.readLine();
                continue;
            }
            if (line.equals("sortvar")) {
                VariablesStorage.printSortedvariables();
                line = reader.readLine();
                continue;
            }
            MathLabVariable variable = solver.solveExpression(Parser.parseLine(line));
            System.out.println(variable);
            line = reader.readLine();
        }
    }
}
