package by.it.kust.jd01_09.vars;

import by.it.kust.jd01_09.interfaces.IVariables;
import by.it.kust.jd01_09.patterns.Patterns;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Tanya Kust
 */
public class VarMatrix extends Variable implements IVariables {
    public double[][] matrix;
    public VarMatrix(String str) {setFromStr(str);}

    public VarMatrix(VarMatrix init) {
        this.matrix = new double[init.matrix.length][init.matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            System.arraycopy(init.matrix[i], 0, this.matrix[i], 0, this.matrix[i].length);
        }
    }

    /**
     * преобразование в строку
     * @return строку ввиде записи массива со скобками и запятыми
     */
    @Override
    public String toString() {  //дорабатывается
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
        return "";
    }

    /**
     * числа векторной записи из строки в массив
     * @param str
     */
    @Override
    public void setFromStr(String str) {  //дорабатывается
        String[] elem = str.split(Patterns.exVec);
        matrix = new double[elem.length][elem.length];
        for (int i = 0; i < elem.length; i++) {
            Matcher mat = Pattern.compile(Patterns.exMat).matcher(elem[i]);
            int j = 0;
            while (mat.find()) {
                matrix[i][j] = Double.parseDouble(mat.group());
                j++;
            }
        }
    }


}
