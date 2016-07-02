package by.it.vasilevich.jd01_08;


public class Main {
    public static void main (String [] args) {
        Header header = new Header();
        System.out.println(header.showState());
        header.goToWork();
        System.out.println(header.showState());
        header.work();
        System.out.println(header.showState());
        header.goLunch();
        System.out.println(header.showState());
        header.outLunch();
        System.out.println(header.showState());
        header.work();
        System.out.println(header.showState());
        header.goOutWork();
        System.out.println(header.showState());
    }
}
