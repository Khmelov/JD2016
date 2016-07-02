package by.it.belsky.jd01_10.TaskB.Vars;

/**
 * Created by misha on 01.06.2016.
 */
public class VarVectorOperation extends VarVector {

    public VarVectorOperation(String str) {
        super(str);
    }
    @Override
    public Var add(Var var) {

        if (var instanceof VarVector) //проверим, является ли аргумент вектором
        // to do тут еще нужна проверка на одинаковый размер операндов this и v2
        {
            VarVector v1 = new VarVector(this);             //первый операнд
            VarVector v2 = (VarVector) var;                  //второй
            for (int i = 0; i < v1.vector.length; i++) {    //считаем
                v1.vector[i] = v1.vector[i] + v2.vector[i]; //основная операция
            }
            return v1;                                      //выводим итог
        }

        if (var instanceof VarFloat) //проверим, является ли аргумент скаляром
        {
            VarVector v1 = new VarVector(this);                 //первый операнд
            double v2 = ((VarFloat) var).getValue();   //второй
            for (int i = 0; i < v1.vector.length; i++) {    //считаем
                v1.vector[i] = v1.vector[i] + v2;           //основная операция
            }
            return v1;                                      //выводим итог
        }

        //если аргумент не скаляр и не вектор, то больше ничего не сделать, вызываем суперкласс
        return super.add(var);
    }

    @Override
    public Var div(Var var) {

        if (var instanceof VarFloat) {
            VarVector v1 = new VarVector(this);
            double v2 = ((VarFloat) var).getValue();
            for (int i = 0; i < v1.vector.length; i++) {
                v1.vector[i] = v1.vector[i] / v2;
            }
            return v1;
        }

        //если аргумент не скаляр, то больше ничего не сделать, вызываем суперкласс
        return super.div(var);
    }

    @Override
    public Var mul(Var var) {
        if (var instanceof VarVector) {

            double f = 0;
            VarVector v1 = new VarVector(this);
            VarVector v2 = (VarVector) var;
            for (int i = 0; i < v1.vector.length; i++) {
                f = f + (v1.vector[i] * v2.vector[i]);
            }
            return new VarFloat(f);
        }

        if (var instanceof VarFloat) {
            VarVector v1 = new VarVector(this);
            double v2 = ((VarFloat) var).getValue();
            for (int i = 0; i < v1.vector.length; i++) {
                v1.vector[i] = v1.vector[i] * v2;
            }
            return v1;
        }
        return super.sub(var);
    }

    @Override
    public Var sub(Var var) {

        if (var instanceof VarVector) {
            VarVector v1 = new VarVector(this);
            VarVector v2 = (VarVector) var;
            for (int i = 0; i < v1.vector.length; i++) {
                v1.vector[i] = v1.vector[i] - v2.vector[i];
            }
            return v1;
        }
        if (var instanceof VarFloat) {
            VarVector v1 = new VarVector(this);
            double v2 = ((VarFloat) var).getValue();
            for (int i = 0; i < v1.vector.length; i++) {
                v1.vector[i] = v1.vector[i] - v2;
            }
            return v1;
        }
        return super.sub(var);
    }

}
