package by.it.sergeev.jd01_09.vars;


import by.it.sergeev.jd01_09.interfaces.IVariable;
import by.it.sergeev.jd01_09.patterns.Patterns;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MatrixValue extends Variable implements IVariable {

    double[][] matrix;

    public double[][] getMatrix() {
        return this.matrix;
    }

    public MatrixValue(double[][] matrix) {
        this.matrix = matrix;
    }

    @Override
    public Variable add(Variable varAdd) {
        if (varAdd instanceof DoubleValue) {//матрица+число
            for (int i = 0; i < this.matrix.length; i++) {
                for (int j = 0; j < this.matrix[i].length; j++) {
                    this.matrix[i][j] += ((DoubleValue) varAdd).getValue();
                }
            }
            return this;
        }
        MatrixValue m1 = (MatrixValue) varAdd;
        if (varAdd instanceof MatrixValue) //матрица+матрица
        {
            for (int i = 0; i < this.matrix.length; i++) {
                for (int j = 0; j < this.matrix[i].length; j++) {
                    this.matrix[i][j] += ((MatrixValue) varAdd).matrix[i][j];
                }
            }
            return this;
        } else {
            return super.add(varAdd);
        }
    }

    @Override
    public Variable sub(Variable varSub) {
        if (varSub instanceof DoubleValue) {//матрица-число
            for (int i = 0; i < this.matrix.length; i++) {
                for (int j = 0; j < this.matrix[i].length; j++) {
                    this.matrix[i][j] -= ((DoubleValue) varSub).getValue();
                }
            }
            return this;
        }
        MatrixValue m1 = (MatrixValue) varSub;
        if (varSub instanceof MatrixValue) //матрица+матрица
        {
            for (int i = 0; i < this.matrix.length; i++) {//матрица-матрица
                for (int j = 0; j < this.matrix[i].length; j++) {
                    this.matrix[i][j] -= ((MatrixValue) varSub).matrix[i][j];
                }
            }
            return this;
        } else {
            return super.add(varSub);
        }
    }

    @Override
    public Variable mul(Variable varMul) {
        return super.mul(varMul);
    }

    @Override
    public Variable div(Variable varDiv) {
        return super.div(varDiv);
    }

    @Override
    public void setFromString(String str) throws IOException {
        String[] elem = str.split(Patterns.exVal);
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