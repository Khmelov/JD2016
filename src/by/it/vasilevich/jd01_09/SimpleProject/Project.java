package by.it.vasilevich.jd01_09.SimpleProject;


public class Project {
    //оснойвной класс учебного проекта
    public static void main (String[] args){
        Variable one = new Variable("2.2");
        Variable two = new Variable("3.3");
        Variable res = one.add(two);
        System.out.print(one+" + "+two+" = "+res);

    }
}
