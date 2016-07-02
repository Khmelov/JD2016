package by.it.sergeev.jd01_13.TaskC;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String namefilm = sc.nextLine();
        IFilm film = new Comedy("Название фильма :" + "\"" + namefilm.toUpperCase() + "\"");
        System.out.println(film.getName());
        IFilm filmmaking = new Comedy("");
        try {
            filmmaking.development();
            filmmaking.preproduction();
            filmmaking.production();
            filmmaking.postproduction();
            filmmaking.distribution();
        } catch (NameException e) {
            System.out.println(e.getMessage());
        }
    }
}
