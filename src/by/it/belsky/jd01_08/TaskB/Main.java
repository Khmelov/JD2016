package by.it.belsky.jd01_08.TaskB;

/**
 * Created by misha on 26.05.2016.
 */
public class Main {
    public static void main (String[] args) {
      Student st = new Student();
        System.out.println("Имя студента: "+st.Name("Василий"));
        System.out.println("Фамилия студента: "+st.Sirname("Петечкин"));
        System.out.println("Возраст студента: "+st.Age(25)+" лет");
        System.out.println("Номер группы студента: "+st.Groupnumber(103526));
        extramuralStudent extra = new extramuralStudent();
        System.out.println("Номер группы студента изменился в следствие расформирования старой: "+extra.Groupnumber(103516));// полимрфизм
        System.out.println("Срок обучения студента-заочника: "+extra.Periodofstuding(3)+ " года");
        System.out.println("Возраст студента изменился пока шли вступительные экзамены: "+extra.Age(26)+ " лет");
    }
}
