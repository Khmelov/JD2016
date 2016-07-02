package by.it.kushel.jd02_04;

public class Variable implements IVariable {
    private Double value;

    public Variable() {
    }

    public Variable(String string) {
        this.value = Double.valueOf(string);
    }

    public Variable(Double value) {
        this.value = value;
    }

    @Override
    public Variable add(Variable varAdd) {
        Variable out = new Variable();
        out.value = this.value + varAdd.value;
        return out;
    }

    @Override
    public Variable sub(Variable varSub) {
        Variable out = new Variable();
        out.value = this.value - varSub.value;
        return out;
    }

    @Override
    public Variable mul(Variable varMul) {
        Variable out = new Variable();
        out.value = this.value * varMul.value;
        return out;
    }

    @Override
    public Variable div(Variable varDiv) {
        Variable out = new Variable();
        out.value = this.value / varDiv.value;
        return out;
    }

    public String toString() {
        return value.toString();
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }

        if (object == null) {
            return false;
        }
        if (getClass() != object.getClass()) {
            return false;
        }
        Variable other = (Variable) object;

        if (!other.value.equals(this.value)) {
            return false;
        }
        return true;
    }

}
