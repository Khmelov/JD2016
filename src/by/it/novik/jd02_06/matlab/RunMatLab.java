package by.it.novik.jd02_06.matlab;

import by.it.novik.jd02_06.matlab.builder.BuildThirt;
import by.it.novik.jd02_06.matlab.builder.BuilderFirst;
import by.it.novik.jd02_06.matlab.builder.Director;
import by.it.novik.jd02_06.matlab.exceptions.ErrorOperationsException;
import by.it.novik.jd02_06.matlab.io.InOutImpl;
import by.it.novik.jd02_06.matlab.io.WorkWithFile;
import by.it.novik.jd02_06.matlab.utils.Calculate;
import by.it.novik.jd02_06.matlab.utils.InputValidator;
import by.it.novik.jd02_06.matlab.utils.PrintValues;
import by.it.novik.jd02_06.matlab.log.Logger;

import java.io.IOException;

/**
 * Created by Kate Novik.
 */
public class RunMatLab {
    public static void main(String[] args) throws IOException, ErrorOperationsException {
        //Создаем директора на управление билдерами построения документа об операциях
        Director director = new Director();
        //Устанавливаем первого билдера
        director.setReportBuilder(new BuilderFirst());
        director.build("Отчет об операциях", " ");

        //Запускаем поток логирования ошибок
        Thread th = new Thread(Logger.getInstance());
        //th.setDaemon(true);
        th.start();

        InOutImpl inout = new InOutImpl();
        Calculate calculate = new Calculate();

        String vec = "{1,2,3}";
        String m = "{{1,2,3},{4,5,6},{7,8,9}}";
        String d = "26.2";

        //Читаем переменные с файла
        WorkWithFile.readVarsFromFile();
        //Выводим названия переменных и их значения в неотсортированном виде
        PrintValues.printVars();
        //Выводим названия переменных и их значения с сортировкой по названию
        PrintValues.sortVars();

        // Операции со скалярными величинами
        System.out.println("Операции со скаларной величиной");
        inout.output(calculate.calculateExp(d + " + " + d));
        inout.output(calculate.calculateExp(d + " + " + vec));
        inout.output(calculate.calculateExp(d + " + " + m));

        inout.output(calculate.calculateExp(d + " - " + "23.1"));
        inout.output(calculate.calculateExp(d + " - " + vec));
        inout.output(calculate.calculateExp(d + " - " + m));

        inout.output(calculate.calculateExp(d + " * " + "5.9"));
        inout.output(calculate.calculateExp(d + " * " + vec));
        inout.output(calculate.calculateExp(d + " * " + m));

        inout.output(calculate.calculateExp(d + " / " + "8.5"));
        inout.output(calculate.calculateExp(d + " / " + vec));
        inout.output(calculate.calculateExp(d + " / " + m));

        System.out.println("/n Операции с матрицой");
        inout.output(calculate.calculateExp(m + " + " + d));
        inout.output(calculate.calculateExp(m + " + " + vec));
        inout.output(calculate.calculateExp(m + " + " + m));

        inout.output(calculate.calculateExp(m + " - " + "23.1"));
        inout.output(calculate.calculateExp(m + " - " + vec));
        inout.output(calculate.calculateExp(m + " - " + m));

        inout.output(calculate.calculateExp(m + " * " + "5.9"));
        inout.output(calculate.calculateExp(m + " * " + vec));
        inout.output(calculate.calculateExp(m + " * " + m));

        inout.output(calculate.calculateExp(m + " / " + "8.5"));
        inout.output(calculate.calculateExp(m + " / " + vec));
        inout.output(calculate.calculateExp(m + " / " + m));

        System.out.println("/nОперации с вектором");
        inout.output(calculate.calculateExp(vec + " + " + d));
        inout.output(calculate.calculateExp(vec + " + " + vec));
        inout.output(calculate.calculateExp(vec + " + " + m));

        inout.output(calculate.calculateExp(vec + " - " + d));
        inout.output(calculate.calculateExp(vec + " - " + vec));
        inout.output(calculate.calculateExp(vec + " - " + m));

        inout.output(calculate.calculateExp(vec + " * " + d));
        inout.output(calculate.calculateExp(vec + " * " + vec));
        inout.output(calculate.calculateExp(vec + " * " + m));

        inout.output(calculate.calculateExp(vec + " / " + d));
        inout.output(calculate.calculateExp(vec + " / " + vec));
        inout.output(calculate.calculateExp(vec + " / " + m));

        //Операции присваивания
        System.out.println("/nОперации присваивания");
        inout.output(calculate.calculateExp("A = ((5 + 6) * (7 + 8)) + {1,2,3,4,5}"));
        inout.output(calculate.calculateExp("S = {1,2,3,4,5}"));
        inout.output(calculate.calculateExp("R = 2"));
        inout.output(calculate.calculateExp("N = R + 5"));
        inout.output(calculate.calculateExp("K = ((5 + R) * (7 + 8)) + {1,2,3,4,5}"));
        inout.output(calculate.calculateExp("O = [[1,2],[3,4]] * [[1,2],[3,4]]"));
        inout.output(calculate.calculateExp("D = ((5 - 2) / 6) * 5 + {{1,2},{3,4}}"));
        inout.output(calculate.calculateExp("B = ({1,2,3,4,5} + {1,2,3,4,5} - 5) * 2 + (3 - 5 * (3 + 7))"));
        //Выводим названия переменных и их значения в неотсортированном виде
        PrintValues.printVars();
        //Выводим названия переменных и их значения с сортировкой по названию
        PrintValues.sortVars();

//-----------------------------------------------------------------------------------------------

        //Ввод в консоль с валидацией
        boolean in;
        String line;
        try {
            do {
                    line = InputValidator.checkValidation();
                    //Создаем объект калькулятор
                    Calculate calc = new Calculate();
                    try {
                        //Вычисляем выражение, введенное с консоли
                        inout.output(calc.calculateExp(line));
                    }
                    catch (ErrorOperationsException e) {
                        System.err.println(e.getMessage());
                        Logger.getInstance().setException(e.getMessage());
                    }
                    in = InputValidator.checkRepeatInput(line);

                }
            while (in);
            //Записываем переменные в файл
            WorkWithFile.writeVarsInFile();
            //Выводим названия переменных и их значения в неотсортированном виде
            PrintValues.printVars();
            //Выводим названия переменных и их значения с сортировкой по названию
            PrintValues.sortVars();
        }
        catch (Exception e) {
            System.err.println("Общая ошибка" + e);
            Logger.getInstance().setException(e.getMessage());
        }
        //Передача флага на завершение работы потока логгера ошибок
        Logger.getInstance().isEnd = true;
        //Передача билдера на запись конца программы
        director.setReportBuilder(new BuildThirt());
        director.build("Отчет об операциях", " ");

    }


}
