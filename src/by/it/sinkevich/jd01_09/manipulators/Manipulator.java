package by.it.sinkevich.jd01_09.manipulators;

import by.it.sinkevich.jd01_09.exceptions.MathLabException;
import by.it.sinkevich.jd01_09.logger.Logger;
import by.it.sinkevich.jd01_09.operations.IArithmeticOperation;
import by.it.sinkevich.jd01_09.variables.MathLabFloat;
import by.it.sinkevich.jd01_09.variables.MathLabMatrix;
import by.it.sinkevich.jd01_09.variables.MathLabVariable;
import by.it.sinkevich.jd01_09.variables.MathLabVector;

/**
 * Created by Computer on 17.05.2016.
 *
 * @author Sinkevich Denis
 */
class Manipulator implements IArithmeticOperation {

    @Override
    public MathLabVariable addition(MathLabVariable first, MathLabVariable second) {
        try {
            return castArgumentsAndChooseTypeOfOperation(first, second, "add");
        } catch (MathLabException e) {
            Logger logger = Logger.getLoggerInstance();
            logger.writeErrorMessage(e.getMessage());
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public MathLabVariable subtraction(MathLabVariable first, MathLabVariable second) {
        try {
            return castArgumentsAndChooseTypeOfOperation(first, second, "sub");
        } catch (MathLabException e) {
            Logger logger = Logger.getLoggerInstance();
            logger.writeErrorMessage(e.getMessage());
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public MathLabVariable multiplication(MathLabVariable first, MathLabVariable second) {
        try {
            return castArgumentsAndChooseTypeOfOperation(first, second, "mul");
        } catch (MathLabException e) {
            Logger logger = Logger.getLoggerInstance();
            logger.writeErrorMessage(e.getMessage());
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public MathLabVariable division(MathLabVariable first, MathLabVariable second) {
        try {
            return castArgumentsAndChooseTypeOfOperation(first, second, "div");
        } catch (MathLabException e) {
            Logger logger = Logger.getLoggerInstance();
            logger.writeErrorMessage(e.getMessage());
            System.out.println(e.getMessage());
        }
        return null;
    }

    private MathLabVariable castArgumentsAndChooseTypeOfOperation(MathLabVariable first, MathLabVariable second, String typeOfOperation) throws MathLabException {
        if (first instanceof MathLabFloat) {
            return castArgumentsAndChooseTypeOfOperation((MathLabFloat) first, second, typeOfOperation);
        } else if (first instanceof MathLabVector) {
            return castArgumentsAndChooseTypeOfOperation((MathLabVector) first, second, typeOfOperation);
        } else {
            return castArgumentsAndChooseTypeOfOperation((MathLabMatrix) first, second, typeOfOperation);
        }
    }

    private MathLabVariable castArgumentsAndChooseTypeOfOperation(MathLabFloat first, MathLabVariable second, String typeOfOperation) throws MathLabException {
        if (second instanceof MathLabFloat) {
            return chooseOperation(first, (MathLabFloat) second, typeOfOperation);
        } else if (second instanceof MathLabVector) {
            return chooseOperation(first, (MathLabVector) second, typeOfOperation);
        } else {
            return chooseOperation(first, (MathLabMatrix) second, typeOfOperation);
        }
    }

    private MathLabVariable castArgumentsAndChooseTypeOfOperation(MathLabVector first, MathLabVariable second, String typeOfOperation) throws MathLabException {
        if (second instanceof MathLabFloat) {
            return chooseOperation(first, (MathLabFloat) second, typeOfOperation);
        } else if (second instanceof MathLabVector) {
            return chooseOperation(first, (MathLabVector) second, typeOfOperation);
        } else {
            return chooseOperation(first, (MathLabMatrix) second, typeOfOperation);
        }
    }

    private MathLabVariable castArgumentsAndChooseTypeOfOperation(MathLabMatrix first, MathLabVariable second, String typeOfOperation) throws MathLabException {
        if (second instanceof MathLabFloat) {
            return chooseOperation(first, (MathLabFloat) second, typeOfOperation);
        } else if (second instanceof MathLabVector) {
            return chooseOperation(first, (MathLabVector) second, typeOfOperation);
        } else {
            return chooseOperation(first, (MathLabMatrix) second, typeOfOperation);
        }
    }

    private MathLabVariable chooseOperation(MathLabFloat first, MathLabFloat second, String typeOfOperation) {
        switch (typeOfOperation) {
            case "add":
                return AdditionMethodContainer.addition(first, second);
            case "sub":
                return SubtractionMethodContainer.subtraction(first, second);
            case "mul":
                return MultiplicationMethodContainer.multiplication(first, second);
            default:
                return DivisionMethodContainer.division(first, second);
        }
    }

    private MathLabVariable chooseOperation(MathLabFloat first, MathLabVector second, String typeOfOperation) throws MathLabException {
        switch (typeOfOperation) {
            case "add":
                return AdditionMethodContainer.addition(first, second);
            case "sub":
                return SubtractionMethodContainer.subtraction(first, second);
            case "mul":
                return MultiplicationMethodContainer.multiplication(first, second);
            default:
                return DivisionMethodContainer.division(first, second);
        }
    }

    private MathLabVariable chooseOperation(MathLabFloat first, MathLabMatrix second, String typeOfOperation) throws MathLabException {
        switch (typeOfOperation) {
            case "add":
                return AdditionMethodContainer.addition(first, second);
            case "sub":
                return SubtractionMethodContainer.subtraction(first, second);
            case "mul":
                return MultiplicationMethodContainer.multiplication(first, second);
            default:
                return DivisionMethodContainer.division(first, second);
        }
    }

    private MathLabVariable chooseOperation(MathLabVector first, MathLabFloat second, String typeOfOperation) {
        switch (typeOfOperation) {
            case "add":
                return AdditionMethodContainer.addition(first, second);
            case "sub":
                return SubtractionMethodContainer.subtraction(first, second);
            case "mul":
                return MultiplicationMethodContainer.multiplication(first, second);
            default:
                return DivisionMethodContainer.division(first, second);
        }
    }

    private MathLabVariable chooseOperation(MathLabVector first, MathLabVector second, String typeOfOperation) throws MathLabException {
        switch (typeOfOperation) {
            case "add":
                return AdditionMethodContainer.addition(first, second);
            case "sub":
                return SubtractionMethodContainer.subtraction(first, second);
            case "mul":
                return MultiplicationMethodContainer.multiplication(first, second);
            default:
                return DivisionMethodContainer.division(first, second);
        }
    }

    private MathLabVariable chooseOperation(MathLabVector first, MathLabMatrix second, String typeOfOperation) throws MathLabException {
        switch (typeOfOperation) {
            case "add":
                return AdditionMethodContainer.addition(first, second);
            case "sub":
                return SubtractionMethodContainer.subtraction(first, second);
            case "mul":
                return MultiplicationMethodContainer.multiplication(first, second);
            default:
                return DivisionMethodContainer.division(first, second);
        }
    }

    private MathLabVariable chooseOperation(MathLabMatrix first, MathLabFloat second, String typeOfOperation) {
        switch (typeOfOperation) {
            case "add":
                return AdditionMethodContainer.addition(first, second);
            case "sub":
                return SubtractionMethodContainer.subtraction(first, second);
            case "mul":
                return MultiplicationMethodContainer.multiplication(first, second);
            default:
                return DivisionMethodContainer.division(first, second);
        }
    }

    private MathLabVariable chooseOperation(MathLabMatrix first, MathLabVector second, String typeOfOperation) throws MathLabException {
        switch (typeOfOperation) {
            case "add":
                return AdditionMethodContainer.addition(first, second);
            case "sub":
                return SubtractionMethodContainer.subtraction(first, second);
            case "mul":
                return MultiplicationMethodContainer.multiplication(first, second);
            default:
                return DivisionMethodContainer.division(first, second);
        }
    }

    private MathLabVariable chooseOperation(MathLabMatrix first, MathLabMatrix second, String typeOfOperation) throws MathLabException {
        switch (typeOfOperation) {
            case "add":
                return AdditionMethodContainer.addition(first, second);
            case "sub":
                return SubtractionMethodContainer.subtraction(first, second);
            case "mul":
                return MultiplicationMethodContainer.multiplication(first, second);
            default:
                return DivisionMethodContainer.division(first, second);
        }
    }
}
