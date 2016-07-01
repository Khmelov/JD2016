package by.it.luksha.jd02_10.converter;

public abstract class AbstractConverter {
    protected CarRent bean;

    public AbstractConverter() {
        bean = null;
    }

    public AbstractConverter(CarRent bean) {
        this.bean = bean;
    }

    public CarRent getBean() {
        return bean;
    }

    public void setBean(CarRent bean) {
        this.bean = bean;
    }

    //методы переопределяемые для наследников
    public abstract void buildConverter(String filename);
    public abstract String getConvertResult();

}
