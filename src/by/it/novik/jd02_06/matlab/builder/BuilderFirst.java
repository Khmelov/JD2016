package by.it.novik.jd02_06.matlab.builder;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Created by Kate Novik.
 */
public class BuilderFirst extends ReportBuilder {

    @Override
    public void buildStartTime() {
        DateFormat start = DateFormat.getTimeInstance(DateFormat.LONG,new Locale("be","BY"));
        String startTime = start.format(new Date());
        System.out.println(startTime);
        String line = startTime + "\n";
            printWriter.println(line);
        printWriter.flush();
    }


}
