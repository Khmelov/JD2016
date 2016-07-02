package by.it.sergeev.jd01_13.TaskC;

public abstract class DomesticFilm implements IFilm {

    private String name;
    public DomesticFilm(String name)
    {
        this.name = name;
    }
    public String getName()
    {
        return this.name;
    }

    @Override
    public void development() {
        System.out.println("screenplay is written");
    }

    @Override
    public void preproduction() {
        System.out.println("film crew");

    }

    @Override
    public void production() {
        System.out.println("movie recording");

    }

    @Override
    public void postproduction() {
        System.out.println("sound(patriotic voice)");

    }

    @Override
    public void distribution() {
        System.out.println("screens in the cinema");

    }
}
