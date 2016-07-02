package by.it.sinkevich.jd01_12.TaskC;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * TaskC3 class
 *
 * @author Sinkevich Denis
 */
class TaskC3 {

    private String line;

    TaskC3(String line) {
        this.line = line;
    }

    TaskC3() {
        this("1+(21-4*2){[2-4]*(-1)(25(-17/44)){2}}");
    }

    boolean checkLine() {
        Deque<String> stack = new ArrayDeque<>();
        String regexAll = "[\\(\\{\\[\\)\\}\\]]";
        String regexOpening = "[\\(\\{\\[]";
        Pattern patternAll = Pattern.compile(regexAll);
        Matcher matcher = patternAll.matcher(line);
        while (matcher.find()) {
            String symbol = matcher.group();
            if (symbol.matches(regexOpening)) {
                stack.push(symbol);
                switch (symbol) {
                    case "(":
                        stack.push(")");
                        break;
                    case "[":
                        stack.push("]");
                        break;
                    default:
                        stack.push("}");
                        break;
                }
            } else {
                if (stack.isEmpty()) {
                    System.out.println("В заданной строке как минимум одна лишняя закрывающая скобка вида \"" + symbol + "\"!");
                    System.out.println("Ошибка в символе номер " + (matcher.start() + 1));
                    return false;
                }
                if (!stack.pop().equals(symbol)) {
                    System.out.println("В заданной строке неправильный порядок расстановки скобок!");
                    return false;
                }
                stack.pop();
            }
        }
        if (!stack.isEmpty()) {
            System.out.println("В заданной строке открывающих скобок на " + stack.size() / 2 + " больше, чем закрывающих!");
            return false;
        }
        return true;
    }
}
