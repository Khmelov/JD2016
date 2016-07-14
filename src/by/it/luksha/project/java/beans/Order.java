package by.it.luksha.project.java.beans;

/**
 * Created by MMauz on 07.07.2016.
 */

import java.sql.Timestamp;

/**
 * BEAN для сущности Order из таблицы orders
 */
public class Order {
    private int id;
    private int fk_user;
    private int fk_car;
    private Timestamp startRent;
    private Timestamp endRent;
    private int totalCost;

    public Order() {
    }

    public Order(int id, int fk_user, int fk_car, Timestamp startRent, Timestamp endRent, int totalCost) {
        this.id = id;
        this.fk_user = fk_user;
        this.fk_car = fk_car;
        this.startRent = startRent;
        this.endRent = endRent;
        this.totalCost = totalCost;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", fk_user=" + fk_user +
                ", fk_car=" + fk_car +
                ", startRent=" + startRent +
                ", endRent=" + endRent +
                ", totalCost=" + totalCost +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Order order = (Order) o;

        if (id != order.id) return false;
        if (fk_user != order.fk_user) return false;
        if (fk_car != order.fk_car) return false;
        if (totalCost != order.totalCost) return false;
        if (startRent != null ? !startRent.equals(order.startRent) : order.startRent != null) return false;
        return endRent != null ? endRent.equals(order.endRent) : order.endRent == null;

    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + fk_user;
        result = 31 * result + fk_car;
        result = 31 * result + (startRent != null ? startRent.hashCode() : 0);
        result = 31 * result + (endRent != null ? endRent.hashCode() : 0);
        result = 31 * result + totalCost;
        return result;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getFk_user() {
        return fk_user;
    }

    public void setFk_user(int fk_user) {
        this.fk_user = fk_user;
    }

    public int getFk_car() {
        return fk_car;
    }

    public void setFk_car(int fk_car) {
        this.fk_car = fk_car;
    }

    public Timestamp getStartRent() {
        return startRent;
    }

    public void setStartRent(Timestamp startRent) {
        this.startRent = startRent;
    }

    public Timestamp getEndRent() {
        return endRent;
    }

    public void setEndRent(Timestamp endRent) {
        this.endRent = endRent;
    }

    public int getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(int totalCost) {
        this.totalCost = totalCost;
    }
}
