package by.it.luksha.project.java.beans;

/**
 * Created by MMauz on 07.07.2016.
 */

/**
 * BEAN для сущности Car из таблицы cars
 */
public class Car {
    private int id;
    private String brand;
    private String model;
    private String category;
    private int cost;
    private double consumption;

    public Car() {
    }

    public Car(int id, String brand, String model, String category, int cost, double consumption) {
        this.id = id;
        this.brand = brand;
        this.model = model;
        this.category = category;
        this.cost = cost;
        this.consumption = consumption;
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", category='" + category + '\'' +
                ", cost=" + cost +
                ", consumption=" + consumption +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Car car = (Car) o;

        if (id != car.id) return false;
        if (cost != car.cost) return false;
        if (Double.compare(car.consumption, consumption) != 0) return false;
        if (brand != null ? !brand.equals(car.brand) : car.brand != null) return false;
        if (model != null ? !model.equals(car.model) : car.model != null) return false;
        return category != null ? category.equals(car.category) : car.category == null;

    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = id;
        result = 31 * result + (brand != null ? brand.hashCode() : 0);
        result = 31 * result + (model != null ? model.hashCode() : 0);
        result = 31 * result + (category != null ? category.hashCode() : 0);
        result = 31 * result + cost;
        temp = Double.doubleToLongBits(consumption);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    public int getId() {
        return id;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public String getCategory() {
        return category;
    }

    public int getCost() {
        return cost;
    }

    public double getConsumption() {
        return consumption;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public void setConsumption(double consumption) {
        this.consumption = consumption;
    }
}
