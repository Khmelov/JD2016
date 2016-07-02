package by.it.novik.jd02_06.matlab.builder;


/**
 * Created by Kate Novik.
 */
public class BuilderSecond extends ReportBuilder {


    @Override
    void buildOperation(String operation) {
            printWriter.println(operation);
        printWriter.flush();

    }

}
