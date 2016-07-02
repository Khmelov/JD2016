package by.it.novik.jd02_06.matlab.patterns;

/**
 * Created by Kate Novik.
 */
public class PatternsVar {
    public static String regxMat = "[\\{\\[](([\\{\\[](-?[0-9\\.,])+[\\}\\]]),?)+[\\}\\]]";
    public static String regxVec = "[\\{\\[](-?[0-9\\.,])+[\\}\\]]";
    public static String regxD = "-?[0-9]+(\\.[0-9]+)?";
    public static String regxSc = "[\\}\\]],[\\{\\[]";
    public static String regxOper = "\\s[\\+\\-/\\*]\\s";
    public static String regxEq = "\\s?=\\s?";
    public static String regxName = "[a-zA-Z]";
    public static String regxOr = "("+regxMat+")|("+regxVec+")|("+regxD+")|("+regxName+")";
    public static String regxPriorityMul = "("+regxOr+")\\s\\*\\s("+regxOr+")";
    public static String regxPriorityDiv = "("+regxOr+")\\s/\\s("+regxOr+")";
    public static String regxPriorityBrackets= "\\(\\(*("+regxOr+")(("+regxOper+")\\(?("+regxOr+")\\)?)+\\)";
    public static String regxPriorityFull = "("+regxPriorityMul+")|("+regxPriorityDiv+")|("+regxPriorityBrackets+")";
    public static String regxFull = "\\(?("+regxOr+")("+regxOper+")("+regxOr+")\\)?";
    public static String regxFullEq = "(\\w("+regxEq+"))?\\(*("+regxOr+")(("+regxOper+")\\(*("+regxOr+")\\)*)*";



}
