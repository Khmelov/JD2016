package by.it.sergeev.jd01_14;


import java.io.*;

public class TaskA {
    public static void main(String[ ] args) throws IOException {
        String src=System.getProperty("user.dir")+"/src/by/it/sergeev/";
        String filename = src+"jd01_14/binary.dat";
        File f=new File(filename);
        DataOutputStream dos = null;
        try {
            dos=new DataOutputStream(new FileOutputStream(f));
            for (int i = 0; i < 20; i++) {
                dos.writeInt((int)(Math.random()*100));
            }
        } catch (FileNotFoundException e) {
            System.out.println("Файла нет: " + filename);
        }
        finally {
            if (dos!=null) {dos.close();}
        }

        try (DataInputStream inp=new DataInputStream
                (new BufferedInputStream
                        (new FileInputStream(filename))
                )
        )
        {
            double sum=0;
            double count=0;
            while (inp.available()>0) {
                int i=inp.readInt();
                sum=sum+i;
                count++;
            }
            System.out.println("Average=" + sum / count);
        }
        catch (IOException e) {
            e.printStackTrace();
        }


    }
}

