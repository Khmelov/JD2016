package by.it.kushel.jd01_14;

import java.io.*;

/**
 * Created by Diomn on 07.06.2016.
 */
public class TaskACreateData {
    public static void main(String[] args) throws IOException {
        String src = System.getProperty("user.dir") + "/src/by/it/kushel/";
        String fin = src + "jd01_14/MyInteger.dat";

       // String fileName = System.getProperty("user.dir")+"/src/by/it/kushel"+"jd01_14/integer.dat";
        //File file = new File(fin);
        try(
        FileOutputStream fos= new FileOutputStream(fin)) {

            int[] mas = new int[20];
            for (int i = 0; i <= mas.length - 1; i++) {
                mas[i] = (int) (Math.random() * 10 + 1);
                fos.write(mas[i]);
            }
        }catch (FileNotFoundException e){
            System.out.println("Файл не найден");
        }
try(FileInputStream in = new FileInputStream(fin)){
    int sum=0;
    double average=0;
    System.out.print("numbers: ");

    int count=0;
   while (in.available()>0) {
       int number=in.read();
       System.out.printf("%3d ", number);
       sum = sum + number;
       count++;
   }
    average=sum/count;
    System.out.println();
    System.out.println("sum="+sum+"; average= "+average);
}catch (IOException e){
    e.printStackTrace();
}
    }
}
