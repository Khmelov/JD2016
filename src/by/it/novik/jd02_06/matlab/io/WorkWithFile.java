package by.it.novik.jd02_06.matlab.io;

import by.it.novik.jd02_06.matlab.entity.Variable;
import by.it.novik.jd02_06.matlab.log.Logger;
import by.it.novik.jd02_06.matlab.utils.MapValues;
import by.it.novik.jd02_06.matlab.utils.ParsingInput;

import java.io.*;
import java.util.List;
import java.util.Map;

/**
 * Created by Kate Novik.
 */
public class WorkWithFile {

    /**
     * Создание объекта File для работы с файлом с переменными
     * @return Объект File
     */
    private static File createFile () {
        //Задаем путь к файлу с переменными
        String src = System.getProperty("user.dir") + "/src/by/it/novik/jd02_06/matlab/";
        return new File(src + "files/vars.txt");
    }

    /**
     * Запись переменных в файл vars.txt
     */
    public static void writeVarsInFile () {
        //Получаем объект File
        File baseOfVars = createFile();
        Map<String,Variable> map = MapValues.getInstance();
        BufferedWriter buf = null;
        try {
            buf = new BufferedWriter(new FileWriter(baseOfVars));
            //Записываем с сингелтона Map в файл переменные с новой строки
            for (Map.Entry<String, Variable> entry : map.entrySet()) {
                buf.write(entry.toString() + System.getProperty("line.separator"));
                buf.flush();
            }
        }
        catch (IOException e) {
            System.err.println("Ошибка записи" + e);
            Logger.getInstance().setException("Ошибка записи переменных в файл.");
        }
        finally {
            if (buf != null) {
                try {
                    buf.close();
                } catch (IOException e) {
                    e.printStackTrace();
                    Logger.getInstance().setException("Ошибка закрытия файла.");
                }
            }
        }
    }

    /**
     * Чтение переменных из файла vars.txt
     */
    public static void readVarsFromFile () {
        //Получаем объект File
        File baseOfVars = createFile();
        Map<String,Variable> map = MapValues.getInstance();
        BufferedReader buf = null;
        try {
            buf = new BufferedReader (new FileReader(baseOfVars));
            String line;
            List<String> list;
            List<Variable> var;
            while ((line = buf.readLine()) != null) {
            list = ParsingInput.parsingEq(line); //Парсинг по операции
                var = ParsingInput.parsingVariables(list.get(1)); //Парсинг значения переменной
                map.put(list.get(0),var.get(0)); //Ложим переменную и ее значение в map
            }
        }
        catch (FileNotFoundException e) {
            System.err.println("Файл не найден" + e);
            Logger.getInstance().setException("Файл для чтения переменных не найден.");
        }
        catch (IOException e) {
            System.err.println("Ошибка чтения" + e);
            Logger.getInstance().setException("Ошибка чтения переменных из файла.");
        }
        finally {
            try {
                if (buf != null) {
                    buf.close();
                }
            }
            catch (IOException ex) {
                ex.printStackTrace();
                Logger.getInstance().setException("Ошибка закрытия файла.");
            }
        }
    }

}
