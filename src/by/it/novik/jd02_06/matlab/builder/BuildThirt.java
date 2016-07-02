package by.it.novik.jd02_06.matlab.builder;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Created by Kate Novik.
 */
public class BuildThirt extends ReportBuilder {


    @Override
    void BuildEndTime() {
        DateFormat end = DateFormat.getTimeInstance(DateFormat.LONG,new Locale("be","BY"));
        String endTime = end.format(new Date());
        System.out.println(endTime);
            printWriter.println(endTime);
        printWriter.flush();
    }
}
