package by.it.novik.jd02_03.utils;

import by.it.novik.jd02_03.entities.Good;
import by.it.novik.jd02_03.entities.Supermarket;

import java.io.*;
import java.util.Map;

/**
 * Created by Kate Novik.
 */
public class InOut {
    /**
     * Чтение товаров из файла в Hashmap
     * @param sm объект Supermarket
     */
    public static void inputRead (Supermarket sm) {
        BufferedReader buf = null;
        try {
        //Чтение товаров из файла
        buf = new BufferedReader(
                new FileReader(System.getProperty("user.dir") + "/src/by/it/novik/jd02_01/files/goods.txt"));
        String line;
            while ((line = buf.readLine()) != null) {
                String[] array = line.split("=");
                String[] fieldGood = array[0].split("-");
                sm.createGood(Integer.valueOf(fieldGood[0]),fieldGood[1],fieldGood[2],Integer.valueOf(array[1]));
            }
        } catch (IOException e) {
            System.out.println("Ошибка чтения" + e);
            e.printStackTrace();
        }
        try {
            if (buf != null) {
                buf.close();
            }
        } catch (IOException e) {
            System.out.println("Ошибка закрытия" + e);
        }
    }

    /**
     * Запись товаров из Hashmap в файл
     * @param sm объект Supermarket
     */
    public static void outputWrite (Supermarket sm) {
        BufferedWriter wr = null;
        try {
            //Запись товаров в файл
            wr = new BufferedWriter(
                    new FileWriter(System.getProperty("user.dir") + "/src/by/it/novik/jd01_02/files/goods.txt"));
            for (Map.Entry<Good, Integer> set : sm.getAllGoods().entrySet()) {

                wr.write(set.getKey().getIdGood() + set.getKey().getNameGood() + set.getKey().getProducer() + set.getValue());
            }
        } catch (IOException e) {
            System.out.println("Ошибка записи" + e);
            }
    try {
        if (wr != null) {
            wr.close();
        }
    } catch (IOException e) {
        System.out.println("Ошибка закрытия" + e);
    }
    }
}
