package by.it.luksha.jd02_10.converter;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.*;

public class ConverteJSON2XMLBuilder extends AbstractConverter{
    @Override
    public void buildConverter(String filename) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(new File(filename)));
            String line;
            String json = "";
            while (!(line = reader.readLine()).isEmpty()) {
                json = json.concat(line);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Gson gson = new GsonBuilder().serializeNulls().setPrettyPrinting().create();
        gson.fromJson(filename, CarRent.class);

    }

    @Override
    public String getConvertResult() {
        return null;
    }
}
