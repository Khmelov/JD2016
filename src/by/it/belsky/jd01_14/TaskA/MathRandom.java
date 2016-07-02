package by.it.belsky.jd01_14.TaskA;

import java.io.*;

/**
 * Created by misha on 06.06.2016.
 */
public class MathRandom {
    public static void main(String[] args) throws IOException {
        String src = System.getProperty("user.dir") + "/src/by/it/belsky/";
        String file = src + "jd01_14/TaskA/integer.dat";
        File f = new File(file);
        DataOutputStream dot = null;
        try {
            dot = new DataOutputStream(new FileOutputStream(file));
            for (int i = 0; i < 8; i++) {
                dot.writeInt((int) (Math.random()*10));
                //System.out.println("Случайные числа Int: "+file);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Ошибка: " + file);
        } finally  {
            if (dot!=null) {dot.close();}
        }

        try (
            FileInputStream x = new FileInputStream(file);
            BufferedInputStream y = new BufferedInputStream(x);
            DataInputStream inp = new DataInputStream(y))
        {
            double sum = 0;
            double count = 0;
            while (inp.available() > 0) {
                int i = inp.readInt();
                sum = sum + i;
                count++;
                System.out.println("Число N:"+count+"="+i);
            }
            System.out.println("Average=" + sum / count);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}