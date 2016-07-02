package by.it.novik.jd01_13.taskC.Furniture;

import by.it.novik.jd01_13.taskC.Entity.Things;
import by.it.novik.jd01_13.taskC.Furniture.IFurniture;
import by.it.novik.jd01_13.taskC.exceptions.EmptyNameException;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Kate Novik.
 */
public abstract class Cupboards implements IFurniture {
    // Укажем состояние для всех шкафов по закрытию
    private boolean stateOpen;
    // Укажем состояние для всех шкафов по собранности
    private boolean stateAssemble;
    // Укажем координаты положения шкафа
    private double stateX;
    private double stateY;
    // Укажем список вещей
    protected List <Things> listOfThings;

    public Cupboards (){
        this.listOfThings = new ArrayList<>();
        this.stateX = 0;
        this.stateY = 0;
        this.stateOpen = false;
        this.stateAssemble = true;
    }

    @Override
    public boolean open (){
        stateOpen = true; // При открытии поле состояние открытия получает значение true
        return stateOpen;
    }

    @Override
    public boolean close (){
        stateOpen = false; // При закрытии поле состояние открытия получает значение false
        return stateOpen;
    }

    @Override
    public boolean put(Things thing){
        if (thing != null) { // Проверка на не пустой объект
            listOfThings.add(thing);
            return true;
        }
        return false;
    }

    @Override
    public Things getByName(String name) throws EmptyNameException {
        if (!name.isEmpty()) { // Проверка на не пустое название вещи
            for (Things thing : listOfThings) {
                if (thing.getName().equals(name)) {
                    listOfThings.remove(thing);
                }
                return thing;
            }
        }
        else throw new EmptyNameException();
        return null;
    }

    @Override
    public void move (double xNext, double yNext){
        this.stateX += xNext; // Перемещение по X шкафа
        this.stateY += yNext; // Перемещение по Y шкафа
    }

    @Override
    public boolean assemble (){
        stateAssemble = true;
        return stateAssemble;
    }

    @Override
    public boolean disassemble (){
        if (listOfThings.isEmpty()) {
            stateOpen = true;
            stateAssemble = false;
            stateX = 0;
            stateY = 0;
        }
        return stateAssemble;
    }

    @Override
    public boolean clean () {
        listOfThings.clear();
        return true;
    }

    /**
     * Абстрактный метод показать состояние мебели
     */
    public abstract void showState ();
    /**
     * Абстрактный метод сортировки вещей
     */
    public abstract boolean sortThings ();

    public List <Things> getListOfThings (){ return listOfThings; }
    public boolean getStateOpen () { return stateOpen; }
    public boolean getStateAssemble () { return stateAssemble; }
    public double getStateX () { return stateX; }
    public double getStateY () { return stateY; }
    public void setStateX (double stateX) { this.stateX = stateX; }
    public void setStateY (double stateY) { this.stateY = stateY; }
}
