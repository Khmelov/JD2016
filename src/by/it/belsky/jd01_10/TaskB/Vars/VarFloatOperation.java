package by.it.belsky.jd01_10.TaskB.Vars;

/**
 * Created by misha on 01.06.2016.
 */
public class VarFloatOperation extends VarFloat {

    public VarFloatOperation(String str) {
        super(str);
    }
    @Override
    public Var add(Var var)  {
        if (var instanceof VarFloat) //проверим, является ли аргумент скаляром
            return new VarFloat(this.value + ((VarFloat)var).value); //выводим итог
        //если аргумент не скаляр, то меняем местами операнды f2+f1
        return var.add(this);
    }
}
