package by.it.sergeev.jd01_12;

import java.io.IOException;
import java.util.TreeMap;

public class Run {
    public static void main (String [] args) throws IOException {
        //A1.СоздатьсписокоценокучениковспомощьюArrayList,заполнитьслучайнымиоценками.Удалить неудовлетворительные оценки из списка. Вывести на консоль оба варианта.
        System.out.println("\n" + "---------------------------------------------------------------------------------------------------------");
        System.out.println("A1.");
        System.out.println("---------------------------------------------------------------------------------------------------------");
        TaskA.createArrayList();
        System.out.println("\n" + "---------------------------------------------------------------------------------------------------------");
        System.out.println("A2.");
        System.out.println("---------------------------------------------------------------------------------------------------------");
        TaskA.createArrayList2();
        System.out.println("\n" + "---------------------------------------------------------------------------------------------------------");
        System.out.println("A3.");
        System.out.println("---------------------------------------------------------------------------------------------------------");
        TaskA.createArrayList3();
        System.out.println("\n" + "---------------------------------------------------------------------------------------------------------");
        System.out.println("B1.");
        System.out.println("---------------------------------------------------------------------------------------------------------");
        TaskB.createHashMap();
        System.out.println("---------------------------------------------------------------------------------------------------------");
        System.out.println("B2. Run запускается в самой TaskB2");
        System.out.println("---------------------------------------------------------------------------------------------------------");
        System.out.println("С1.");
        System.out.println("---------------------------------------------------------------------------------------------------------");
        TreeMap<Integer, String> cypher = TaskC.createTreeMap(Text.getString());
        System.out.println("Шифрование: ");
        TaskC.printEncryption(cypher);
        cypher = TaskC.compressedEncryption(cypher);
        System.out.println("\nСжатое шифрование: ");
        TaskC.printEncryption(cypher);
        System.out.println("\n---------------------------------------------------------------------------------------------------------");
        System.out.println("C2.");
        System.out.println("---------------------------------------------------------------------------------------------------------");
        TaskC.createArrayListC2();
        System.out.println("\nC3.");
        System.out.println("---------------------------------------------------------------------------------------------------------");
        System.out.println("({e}((({ab}+c)[df])))\t"+ TaskC.brackets("({e}((({ab}+c)[df])))"));
        System.out.println("({e}((({ab}+c[)df])))\t" + TaskC.brackets("({e}((({ab}+c[)df])))"));
    }
}
