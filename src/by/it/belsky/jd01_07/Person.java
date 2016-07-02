package by.it.belsky.jd01_07;

/**
 * Created by misha on 21.05.2016.
 */
public class Person {
    protected String name = "noname";
    protected int age = 0;

    public void SetName(String n) {
        name = n;
    }

    public void GetAge(int a) {
        age = a;
    }

    public void DescriptionOfPerson() {
        System.out.println("-------------");
        System.out.println("My name is " + name);
        System.out.println("I am " + age + " years old");
    }
}
